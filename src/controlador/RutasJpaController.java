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
import modelo.Autobus;
import modelo.Ciudad;
import modelo.Reserva;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Rutas;
import modelo.RutasPK;

/**
 *
 * @author Nicolas Ospitia
 */
public class RutasJpaController implements Serializable {

    public RutasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rutas rutas) throws PreexistingEntityException, Exception {
        if (rutas.getRutasPK() == null) {
            rutas.setRutasPK(new RutasPK());
        }
        if (rutas.getReservaCollection() == null) {
            rutas.setReservaCollection(new ArrayList<Reserva>());
        }
        rutas.getRutasPK().setAutobusidautobus(rutas.getAutobus().getIdautobus());
        rutas.getRutasPK().setCiudadDestino(rutas.getCiudad1().getNombreCiudad());
        rutas.getRutasPK().setCiudadOrigen(rutas.getCiudad().getNombreCiudad());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autobus autobus = rutas.getAutobus();
            if (autobus != null) {
                autobus = em.getReference(autobus.getClass(), autobus.getIdautobus());
                rutas.setAutobus(autobus);
            }
            Ciudad ciudad = rutas.getCiudad();
            if (ciudad != null) {
                ciudad = em.getReference(ciudad.getClass(), ciudad.getNombreCiudad());
                rutas.setCiudad(ciudad);
            }
            Ciudad ciudad1 = rutas.getCiudad1();
            if (ciudad1 != null) {
                ciudad1 = em.getReference(ciudad1.getClass(), ciudad1.getNombreCiudad());
                rutas.setCiudad1(ciudad1);
            }
            Collection<Reserva> attachedReservaCollection = new ArrayList<Reserva>();
            for (Reserva reservaCollectionReservaToAttach : rutas.getReservaCollection()) {
                reservaCollectionReservaToAttach = em.getReference(reservaCollectionReservaToAttach.getClass(), reservaCollectionReservaToAttach.getReservaPK());
                attachedReservaCollection.add(reservaCollectionReservaToAttach);
            }
            rutas.setReservaCollection(attachedReservaCollection);
            em.persist(rutas);
            if (autobus != null) {
                autobus.getRutasCollection().add(rutas);
                autobus = em.merge(autobus);
            }
            if (ciudad != null) {
                ciudad.getRutasCollection().add(rutas);
                ciudad = em.merge(ciudad);
            }
            if (ciudad1 != null) {
                ciudad1.getRutasCollection().add(rutas);
                ciudad1 = em.merge(ciudad1);
            }
            for (Reserva reservaCollectionReserva : rutas.getReservaCollection()) {
                Rutas oldRutasOfReservaCollectionReserva = reservaCollectionReserva.getRutas();
                reservaCollectionReserva.setRutas(rutas);
                reservaCollectionReserva = em.merge(reservaCollectionReserva);
                if (oldRutasOfReservaCollectionReserva != null) {
                    oldRutasOfReservaCollectionReserva.getReservaCollection().remove(reservaCollectionReserva);
                    oldRutasOfReservaCollectionReserva = em.merge(oldRutasOfReservaCollectionReserva);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRutas(rutas.getRutasPK()) != null) {
                throw new PreexistingEntityException("Rutas " + rutas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rutas rutas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        rutas.getRutasPK().setAutobusidautobus(rutas.getAutobus().getIdautobus());
        rutas.getRutasPK().setCiudadDestino(rutas.getCiudad1().getNombreCiudad());
        rutas.getRutasPK().setCiudadOrigen(rutas.getCiudad().getNombreCiudad());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rutas persistentRutas = em.find(Rutas.class, rutas.getRutasPK());
            Autobus autobusOld = persistentRutas.getAutobus();
            Autobus autobusNew = rutas.getAutobus();
            Ciudad ciudadOld = persistentRutas.getCiudad();
            Ciudad ciudadNew = rutas.getCiudad();
            Ciudad ciudad1Old = persistentRutas.getCiudad1();
            Ciudad ciudad1New = rutas.getCiudad1();
            Collection<Reserva> reservaCollectionOld = persistentRutas.getReservaCollection();
            Collection<Reserva> reservaCollectionNew = rutas.getReservaCollection();
            List<String> illegalOrphanMessages = null;
            for (Reserva reservaCollectionOldReserva : reservaCollectionOld) {
                if (!reservaCollectionNew.contains(reservaCollectionOldReserva)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reserva " + reservaCollectionOldReserva + " since its rutas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (autobusNew != null) {
                autobusNew = em.getReference(autobusNew.getClass(), autobusNew.getIdautobus());
                rutas.setAutobus(autobusNew);
            }
            if (ciudadNew != null) {
                ciudadNew = em.getReference(ciudadNew.getClass(), ciudadNew.getNombreCiudad());
                rutas.setCiudad(ciudadNew);
            }
            if (ciudad1New != null) {
                ciudad1New = em.getReference(ciudad1New.getClass(), ciudad1New.getNombreCiudad());
                rutas.setCiudad1(ciudad1New);
            }
            Collection<Reserva> attachedReservaCollectionNew = new ArrayList<Reserva>();
            for (Reserva reservaCollectionNewReservaToAttach : reservaCollectionNew) {
                reservaCollectionNewReservaToAttach = em.getReference(reservaCollectionNewReservaToAttach.getClass(), reservaCollectionNewReservaToAttach.getReservaPK());
                attachedReservaCollectionNew.add(reservaCollectionNewReservaToAttach);
            }
            reservaCollectionNew = attachedReservaCollectionNew;
            rutas.setReservaCollection(reservaCollectionNew);
            rutas = em.merge(rutas);
            if (autobusOld != null && !autobusOld.equals(autobusNew)) {
                autobusOld.getRutasCollection().remove(rutas);
                autobusOld = em.merge(autobusOld);
            }
            if (autobusNew != null && !autobusNew.equals(autobusOld)) {
                autobusNew.getRutasCollection().add(rutas);
                autobusNew = em.merge(autobusNew);
            }
            if (ciudadOld != null && !ciudadOld.equals(ciudadNew)) {
                ciudadOld.getRutasCollection().remove(rutas);
                ciudadOld = em.merge(ciudadOld);
            }
            if (ciudadNew != null && !ciudadNew.equals(ciudadOld)) {
                ciudadNew.getRutasCollection().add(rutas);
                ciudadNew = em.merge(ciudadNew);
            }
            if (ciudad1Old != null && !ciudad1Old.equals(ciudad1New)) {
                ciudad1Old.getRutasCollection().remove(rutas);
                ciudad1Old = em.merge(ciudad1Old);
            }
            if (ciudad1New != null && !ciudad1New.equals(ciudad1Old)) {
                ciudad1New.getRutasCollection().add(rutas);
                ciudad1New = em.merge(ciudad1New);
            }
            for (Reserva reservaCollectionNewReserva : reservaCollectionNew) {
                if (!reservaCollectionOld.contains(reservaCollectionNewReserva)) {
                    Rutas oldRutasOfReservaCollectionNewReserva = reservaCollectionNewReserva.getRutas();
                    reservaCollectionNewReserva.setRutas(rutas);
                    reservaCollectionNewReserva = em.merge(reservaCollectionNewReserva);
                    if (oldRutasOfReservaCollectionNewReserva != null && !oldRutasOfReservaCollectionNewReserva.equals(rutas)) {
                        oldRutasOfReservaCollectionNewReserva.getReservaCollection().remove(reservaCollectionNewReserva);
                        oldRutasOfReservaCollectionNewReserva = em.merge(oldRutasOfReservaCollectionNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RutasPK id = rutas.getRutasPK();
                if (findRutas(id) == null) {
                    throw new NonexistentEntityException("The rutas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RutasPK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rutas rutas;
            try {
                rutas = em.getReference(Rutas.class, id);
                rutas.getRutasPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rutas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Reserva> reservaCollectionOrphanCheck = rutas.getReservaCollection();
            for (Reserva reservaCollectionOrphanCheckReserva : reservaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rutas (" + rutas + ") cannot be destroyed since the Reserva " + reservaCollectionOrphanCheckReserva + " in its reservaCollection field has a non-nullable rutas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Autobus autobus = rutas.getAutobus();
            if (autobus != null) {
                autobus.getRutasCollection().remove(rutas);
                autobus = em.merge(autobus);
            }
            Ciudad ciudad = rutas.getCiudad();
            if (ciudad != null) {
                ciudad.getRutasCollection().remove(rutas);
                ciudad = em.merge(ciudad);
            }
            Ciudad ciudad1 = rutas.getCiudad1();
            if (ciudad1 != null) {
                ciudad1.getRutasCollection().remove(rutas);
                ciudad1 = em.merge(ciudad1);
            }
            em.remove(rutas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rutas> findRutasEntities() {
        return findRutasEntities(true, -1, -1);
    }

    public List<Rutas> findRutasEntities(int maxResults, int firstResult) {
        return findRutasEntities(false, maxResults, firstResult);
    }

    private List<Rutas> findRutasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rutas.class));
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

    public Rutas findRutas(RutasPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rutas.class, id);
        } finally {
            em.close();
        }
    }

    public int getRutasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rutas> rt = cq.from(Rutas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
