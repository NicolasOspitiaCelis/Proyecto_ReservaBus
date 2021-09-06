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
import modelo.Turnos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Empleado;
import modelo.EmpleadoPK;

/**
 *
 * @author Nicolas Ospitia
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) throws PreexistingEntityException, Exception {
        if (empleado.getEmpleadoPK() == null) {
            empleado.setEmpleadoPK(new EmpleadoPK());
        }
        if (empleado.getTurnosCollection() == null) {
            empleado.setTurnosCollection(new ArrayList<Turnos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Turnos> attachedTurnosCollection = new ArrayList<Turnos>();
            for (Turnos turnosCollectionTurnosToAttach : empleado.getTurnosCollection()) {
                turnosCollectionTurnosToAttach = em.getReference(turnosCollectionTurnosToAttach.getClass(), turnosCollectionTurnosToAttach.getTurnosPK());
                attachedTurnosCollection.add(turnosCollectionTurnosToAttach);
            }
            empleado.setTurnosCollection(attachedTurnosCollection);
            em.persist(empleado);
            for (Turnos turnosCollectionTurnos : empleado.getTurnosCollection()) {
                Empleado oldEmpleadoOfTurnosCollectionTurnos = turnosCollectionTurnos.getEmpleado();
                turnosCollectionTurnos.setEmpleado(empleado);
                turnosCollectionTurnos = em.merge(turnosCollectionTurnos);
                if (oldEmpleadoOfTurnosCollectionTurnos != null) {
                    oldEmpleadoOfTurnosCollectionTurnos.getTurnosCollection().remove(turnosCollectionTurnos);
                    oldEmpleadoOfTurnosCollectionTurnos = em.merge(oldEmpleadoOfTurnosCollectionTurnos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleado(empleado.getEmpleadoPK()) != null) {
                throw new PreexistingEntityException("Empleado " + empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getEmpleadoPK());
            Collection<Turnos> turnosCollectionOld = persistentEmpleado.getTurnosCollection();
            Collection<Turnos> turnosCollectionNew = empleado.getTurnosCollection();
            List<String> illegalOrphanMessages = null;
            for (Turnos turnosCollectionOldTurnos : turnosCollectionOld) {
                if (!turnosCollectionNew.contains(turnosCollectionOldTurnos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Turnos " + turnosCollectionOldTurnos + " since its empleado field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Turnos> attachedTurnosCollectionNew = new ArrayList<Turnos>();
            for (Turnos turnosCollectionNewTurnosToAttach : turnosCollectionNew) {
                turnosCollectionNewTurnosToAttach = em.getReference(turnosCollectionNewTurnosToAttach.getClass(), turnosCollectionNewTurnosToAttach.getTurnosPK());
                attachedTurnosCollectionNew.add(turnosCollectionNewTurnosToAttach);
            }
            turnosCollectionNew = attachedTurnosCollectionNew;
            empleado.setTurnosCollection(turnosCollectionNew);
            empleado = em.merge(empleado);
            for (Turnos turnosCollectionNewTurnos : turnosCollectionNew) {
                if (!turnosCollectionOld.contains(turnosCollectionNewTurnos)) {
                    Empleado oldEmpleadoOfTurnosCollectionNewTurnos = turnosCollectionNewTurnos.getEmpleado();
                    turnosCollectionNewTurnos.setEmpleado(empleado);
                    turnosCollectionNewTurnos = em.merge(turnosCollectionNewTurnos);
                    if (oldEmpleadoOfTurnosCollectionNewTurnos != null && !oldEmpleadoOfTurnosCollectionNewTurnos.equals(empleado)) {
                        oldEmpleadoOfTurnosCollectionNewTurnos.getTurnosCollection().remove(turnosCollectionNewTurnos);
                        oldEmpleadoOfTurnosCollectionNewTurnos = em.merge(oldEmpleadoOfTurnosCollectionNewTurnos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EmpleadoPK id = empleado.getEmpleadoPK();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EmpleadoPK id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getEmpleadoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Turnos> turnosCollectionOrphanCheck = empleado.getTurnosCollection();
            for (Turnos turnosCollectionOrphanCheckTurnos : turnosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleado (" + empleado + ") cannot be destroyed since the Turnos " + turnosCollectionOrphanCheckTurnos + " in its turnosCollection field has a non-nullable empleado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(EmpleadoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
