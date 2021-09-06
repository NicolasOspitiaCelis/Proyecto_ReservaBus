/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Equipaje;
import modelo.EquipajePK;
import modelo.Reserva;

/**
 *
 * @author Nicolas Ospitia
 */
public class EquipajeJpaController implements Serializable {

    public EquipajeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Equipaje equipaje) throws PreexistingEntityException, Exception {
        if (equipaje.getEquipajePK() == null) {
            equipaje.setEquipajePK(new EquipajePK());
        }
        equipaje.getEquipajePK().setReservaAutobusidautobus(equipaje.getReserva().getReservaPK().getAutobusidautobus());
        equipaje.getEquipajePK().setReservaidreserva(equipaje.getReserva().getReservaPK().getIdreserva());
        equipaje.getEquipajePK().setReservaCiudadDestino(equipaje.getReserva().getReservaPK().getCiudadDestino());
        equipaje.getEquipajePK().setReservaidrutas(equipaje.getReserva().getReservaPK().getIdrutas());
        equipaje.getEquipajePK().setReservaPasajeroCedula(equipaje.getReserva().getReservaPK().getPasajeroCedula());
        equipaje.getEquipajePK().setReservaCiudadOrigen(equipaje.getReserva().getReservaPK().getCiudadOrigen());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reserva = equipaje.getReserva();
            if (reserva != null) {
                reserva = em.getReference(reserva.getClass(), reserva.getReservaPK());
                equipaje.setReserva(reserva);
            }
            em.persist(equipaje);
            if (reserva != null) {
                reserva.getEquipajeCollection().add(equipaje);
                reserva = em.merge(reserva);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEquipaje(equipaje.getEquipajePK()) != null) {
                throw new PreexistingEntityException("Equipaje " + equipaje + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Equipaje equipaje) throws NonexistentEntityException, Exception {
        equipaje.getEquipajePK().setReservaAutobusidautobus(equipaje.getReserva().getReservaPK().getAutobusidautobus());
        equipaje.getEquipajePK().setReservaidreserva(equipaje.getReserva().getReservaPK().getIdreserva());
        equipaje.getEquipajePK().setReservaCiudadDestino(equipaje.getReserva().getReservaPK().getCiudadDestino());
        equipaje.getEquipajePK().setReservaidrutas(equipaje.getReserva().getReservaPK().getIdrutas());
        equipaje.getEquipajePK().setReservaPasajeroCedula(equipaje.getReserva().getReservaPK().getPasajeroCedula());
        equipaje.getEquipajePK().setReservaCiudadOrigen(equipaje.getReserva().getReservaPK().getCiudadOrigen());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipaje persistentEquipaje = em.find(Equipaje.class, equipaje.getEquipajePK());
            Reserva reservaOld = persistentEquipaje.getReserva();
            Reserva reservaNew = equipaje.getReserva();
            if (reservaNew != null) {
                reservaNew = em.getReference(reservaNew.getClass(), reservaNew.getReservaPK());
                equipaje.setReserva(reservaNew);
            }
            equipaje = em.merge(equipaje);
            if (reservaOld != null && !reservaOld.equals(reservaNew)) {
                reservaOld.getEquipajeCollection().remove(equipaje);
                reservaOld = em.merge(reservaOld);
            }
            if (reservaNew != null && !reservaNew.equals(reservaOld)) {
                reservaNew.getEquipajeCollection().add(equipaje);
                reservaNew = em.merge(reservaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EquipajePK id = equipaje.getEquipajePK();
                if (findEquipaje(id) == null) {
                    throw new NonexistentEntityException("The equipaje with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EquipajePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipaje equipaje;
            try {
                equipaje = em.getReference(Equipaje.class, id);
                equipaje.getEquipajePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipaje with id " + id + " no longer exists.", enfe);
            }
            Reserva reserva = equipaje.getReserva();
            if (reserva != null) {
                reserva.getEquipajeCollection().remove(equipaje);
                reserva = em.merge(reserva);
            }
            em.remove(equipaje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Equipaje> findEquipajeEntities() {
        return findEquipajeEntities(true, -1, -1);
    }

    public List<Equipaje> findEquipajeEntities(int maxResults, int firstResult) {
        return findEquipajeEntities(false, maxResults, firstResult);
    }

    private List<Equipaje> findEquipajeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipaje.class));
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

    public Equipaje findEquipaje(EquipajePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipaje.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipajeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipaje> rt = cq.from(Equipaje.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
