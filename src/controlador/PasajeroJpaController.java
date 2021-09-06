/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Reserva;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Pasajero;

/**
 *
 * @author Nicolas Ospitia
 */
public class PasajeroJpaController implements Serializable {

    public PasajeroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pasajero pasajero) throws PreexistingEntityException, Exception {
        if (pasajero.getReservaCollection() == null) {
            pasajero.setReservaCollection(new ArrayList<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Reserva> attachedReservaCollection = new ArrayList<Reserva>();
            for (Reserva reservaCollectionReservaToAttach : pasajero.getReservaCollection()) {
                reservaCollectionReservaToAttach = em.getReference(reservaCollectionReservaToAttach.getClass(), reservaCollectionReservaToAttach.getReservaPK());
                attachedReservaCollection.add(reservaCollectionReservaToAttach);
            }
            pasajero.setReservaCollection(attachedReservaCollection);
            em.persist(pasajero);
            for (Reserva reservaCollectionReserva : pasajero.getReservaCollection()) {
                Pasajero oldPasajeroOfReservaCollectionReserva = reservaCollectionReserva.getPasajero();
                reservaCollectionReserva.setPasajero(pasajero);
                reservaCollectionReserva = em.merge(reservaCollectionReserva);
                if (oldPasajeroOfReservaCollectionReserva != null) {
                    oldPasajeroOfReservaCollectionReserva.getReservaCollection().remove(reservaCollectionReserva);
                    oldPasajeroOfReservaCollectionReserva = em.merge(oldPasajeroOfReservaCollectionReserva);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPasajero(pasajero.getCedula()) != null) {
                throw new PreexistingEntityException("Pasajero " + pasajero + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pasajero pasajero) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pasajero persistentPasajero = em.find(Pasajero.class, pasajero.getCedula());
            Collection<Reserva> reservaCollectionOld = persistentPasajero.getReservaCollection();
            Collection<Reserva> reservaCollectionNew = pasajero.getReservaCollection();
            List<String> illegalOrphanMessages = null;
            for (Reserva reservaCollectionOldReserva : reservaCollectionOld) {
                if (!reservaCollectionNew.contains(reservaCollectionOldReserva)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reserva " + reservaCollectionOldReserva + " since its pasajero field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Reserva> attachedReservaCollectionNew = new ArrayList<Reserva>();
            for (Reserva reservaCollectionNewReservaToAttach : reservaCollectionNew) {
                reservaCollectionNewReservaToAttach = em.getReference(reservaCollectionNewReservaToAttach.getClass(), reservaCollectionNewReservaToAttach.getReservaPK());
                attachedReservaCollectionNew.add(reservaCollectionNewReservaToAttach);
            }
            reservaCollectionNew = attachedReservaCollectionNew;
            pasajero.setReservaCollection(reservaCollectionNew);
            pasajero = em.merge(pasajero);
            for (Reserva reservaCollectionNewReserva : reservaCollectionNew) {
                if (!reservaCollectionOld.contains(reservaCollectionNewReserva)) {
                    Pasajero oldPasajeroOfReservaCollectionNewReserva = reservaCollectionNewReserva.getPasajero();
                    reservaCollectionNewReserva.setPasajero(pasajero);
                    reservaCollectionNewReserva = em.merge(reservaCollectionNewReserva);
                    if (oldPasajeroOfReservaCollectionNewReserva != null && !oldPasajeroOfReservaCollectionNewReserva.equals(pasajero)) {
                        oldPasajeroOfReservaCollectionNewReserva.getReservaCollection().remove(reservaCollectionNewReserva);
                        oldPasajeroOfReservaCollectionNewReserva = em.merge(oldPasajeroOfReservaCollectionNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pasajero.getCedula();
                if (findPasajero(id) == null) {
                    throw new NonexistentEntityException("The pasajero with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pasajero pasajero;
            try {
                pasajero = em.getReference(Pasajero.class, id);
                pasajero.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pasajero with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Reserva> reservaCollectionOrphanCheck = pasajero.getReservaCollection();
            for (Reserva reservaCollectionOrphanCheckReserva : reservaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pasajero (" + pasajero + ") cannot be destroyed since the Reserva " + reservaCollectionOrphanCheckReserva + " in its reservaCollection field has a non-nullable pasajero field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(pasajero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pasajero> findPasajeroEntities() {
        return findPasajeroEntities(true, -1, -1);
    }

    public List<Pasajero> findPasajeroEntities(int maxResults, int firstResult) {
        return findPasajeroEntities(false, maxResults, firstResult);
    }

    private List<Pasajero> findPasajeroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pasajero.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pasajero findPasajero(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pasajero.class, id);
        } finally {
            em.close();
        }
    }

    public int getPasajeroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pasajero> rt = cq.from(Pasajero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
