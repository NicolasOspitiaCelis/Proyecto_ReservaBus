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
import modelo.Pasajero;
import modelo.Rutas;
import modelo.Equipaje;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Reserva;
import modelo.ReservaPK;

/**
 *
 * @author Nicolas Ospitia
 */
public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) throws PreexistingEntityException, Exception {
        if (reserva.getReservaPK() == null) {
            reserva.setReservaPK(new ReservaPK());
        }
        if (reserva.getEquipajeCollection() == null) {
            reserva.setEquipajeCollection(new ArrayList<Equipaje>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pasajero pasajero = reserva.getPasajero();
            if (pasajero != null) {
                pasajero = em.getReference(pasajero.getClass(), pasajero.getCedula());
                reserva.setPasajero(pasajero);
            }
            Rutas rutas = reserva.getRutas();
            if (rutas != null) {
                rutas = em.getReference(rutas.getClass(), rutas.getRutasPK());
                reserva.setRutas(rutas);
            }
            Collection<Equipaje> attachedEquipajeCollection = new ArrayList<Equipaje>();
            for (Equipaje equipajeCollectionEquipajeToAttach : reserva.getEquipajeCollection()) {
                equipajeCollectionEquipajeToAttach = em.getReference(equipajeCollectionEquipajeToAttach.getClass(), equipajeCollectionEquipajeToAttach.getEquipajePK());
                attachedEquipajeCollection.add(equipajeCollectionEquipajeToAttach);
            }
            reserva.setEquipajeCollection(attachedEquipajeCollection);
            em.persist(reserva);
            if (pasajero != null) {
                pasajero.getReservaCollection().add(reserva);
                pasajero = em.merge(pasajero);
            }
            if (rutas != null) {
                rutas.getReservaCollection().add(reserva);
                rutas = em.merge(rutas);
            }
            for (Equipaje equipajeCollectionEquipaje : reserva.getEquipajeCollection()) {
                Reserva oldReservaOfEquipajeCollectionEquipaje = equipajeCollectionEquipaje.getReserva();
                equipajeCollectionEquipaje.setReserva(reserva);
                equipajeCollectionEquipaje = em.merge(equipajeCollectionEquipaje);
                if (oldReservaOfEquipajeCollectionEquipaje != null) {
                    oldReservaOfEquipajeCollectionEquipaje.getEquipajeCollection().remove(equipajeCollectionEquipaje);
                    oldReservaOfEquipajeCollectionEquipaje = em.merge(oldReservaOfEquipajeCollectionEquipaje);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReserva(reserva.getReservaPK()) != null) {
                throw new PreexistingEntityException("Reserva " + reserva + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws IllegalOrphanException, NonexistentEntityException, Exception {
        reserva.getReservaPK().setCiudadDestino(reserva.getRutas().getRutasPK().getCiudadDestino());
        reserva.getReservaPK().setAutobusidautobus(reserva.getRutas().getRutasPK().getAutobusidautobus());
        reserva.getReservaPK().setCiudadOrigen(reserva.getRutas().getRutasPK().getCiudadOrigen());
        reserva.getReservaPK().setIdrutas(reserva.getRutas().getRutasPK().getIdrutas());
        reserva.getReservaPK().setPasajeroCedula(reserva.getPasajero().getCedula());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getReservaPK());
            Pasajero pasajeroOld = persistentReserva.getPasajero();
            Pasajero pasajeroNew = reserva.getPasajero();
            Rutas rutasOld = persistentReserva.getRutas();
            Rutas rutasNew = reserva.getRutas();
            Collection<Equipaje> equipajeCollectionOld = persistentReserva.getEquipajeCollection();
            Collection<Equipaje> equipajeCollectionNew = reserva.getEquipajeCollection();
            List<String> illegalOrphanMessages = null;
            for (Equipaje equipajeCollectionOldEquipaje : equipajeCollectionOld) {
                if (!equipajeCollectionNew.contains(equipajeCollectionOldEquipaje)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Equipaje " + equipajeCollectionOldEquipaje + " since its reserva field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (pasajeroNew != null) {
                pasajeroNew = em.getReference(pasajeroNew.getClass(), pasajeroNew.getCedula());
                reserva.setPasajero(pasajeroNew);
            }
            if (rutasNew != null) {
                rutasNew = em.getReference(rutasNew.getClass(), rutasNew.getRutasPK());
                reserva.setRutas(rutasNew);
            }
            Collection<Equipaje> attachedEquipajeCollectionNew = new ArrayList<Equipaje>();
            for (Equipaje equipajeCollectionNewEquipajeToAttach : equipajeCollectionNew) {
                equipajeCollectionNewEquipajeToAttach = em.getReference(equipajeCollectionNewEquipajeToAttach.getClass(), equipajeCollectionNewEquipajeToAttach.getEquipajePK());
                attachedEquipajeCollectionNew.add(equipajeCollectionNewEquipajeToAttach);
            }
            equipajeCollectionNew = attachedEquipajeCollectionNew;
            reserva.setEquipajeCollection(equipajeCollectionNew);
            reserva = em.merge(reserva);
            if (pasajeroOld != null && !pasajeroOld.equals(pasajeroNew)) {
                pasajeroOld.getReservaCollection().remove(reserva);
                pasajeroOld = em.merge(pasajeroOld);
            }
            if (pasajeroNew != null && !pasajeroNew.equals(pasajeroOld)) {
                pasajeroNew.getReservaCollection().add(reserva);
                pasajeroNew = em.merge(pasajeroNew);
            }
            if (rutasOld != null && !rutasOld.equals(rutasNew)) {
                rutasOld.getReservaCollection().remove(reserva);
                rutasOld = em.merge(rutasOld);
            }
            if (rutasNew != null && !rutasNew.equals(rutasOld)) {
                rutasNew.getReservaCollection().add(reserva);
                rutasNew = em.merge(rutasNew);
            }
            for (Equipaje equipajeCollectionNewEquipaje : equipajeCollectionNew) {
                if (!equipajeCollectionOld.contains(equipajeCollectionNewEquipaje)) {
                    Reserva oldReservaOfEquipajeCollectionNewEquipaje = equipajeCollectionNewEquipaje.getReserva();
                    equipajeCollectionNewEquipaje.setReserva(reserva);
                    equipajeCollectionNewEquipaje = em.merge(equipajeCollectionNewEquipaje);
                    if (oldReservaOfEquipajeCollectionNewEquipaje != null && !oldReservaOfEquipajeCollectionNewEquipaje.equals(reserva)) {
                        oldReservaOfEquipajeCollectionNewEquipaje.getEquipajeCollection().remove(equipajeCollectionNewEquipaje);
                        oldReservaOfEquipajeCollectionNewEquipaje = em.merge(oldReservaOfEquipajeCollectionNewEquipaje);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ReservaPK id = reserva.getReservaPK();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ReservaPK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getReservaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Equipaje> equipajeCollectionOrphanCheck = reserva.getEquipajeCollection();
            for (Equipaje equipajeCollectionOrphanCheckEquipaje : equipajeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Reserva (" + reserva + ") cannot be destroyed since the Equipaje " + equipajeCollectionOrphanCheckEquipaje + " in its equipajeCollection field has a non-nullable reserva field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Pasajero pasajero = reserva.getPasajero();
            if (pasajero != null) {
                pasajero.getReservaCollection().remove(reserva);
                pasajero = em.merge(pasajero);
            }
            Rutas rutas = reserva.getRutas();
            if (rutas != null) {
                rutas.getReservaCollection().remove(reserva);
                rutas = em.merge(rutas);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
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

    public Reserva findReserva(ReservaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
