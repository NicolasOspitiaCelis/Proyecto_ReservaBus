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
import modelo.Autobus;
import modelo.Empleado;
import modelo.Turnos;
import modelo.TurnosPK;

/**
 *
 * @author Nicolas Ospitia
 */
public class TurnosJpaController implements Serializable {

    public TurnosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turnos turnos) throws PreexistingEntityException, Exception {
        if (turnos.getTurnosPK() == null) {
            turnos.setTurnosPK(new TurnosPK());
        }
        turnos.getTurnosPK().setAutobusIdautobus(turnos.getAutobus().getIdautobus());
        turnos.getTurnosPK().setEmpleadoIdempleado(turnos.getEmpleado().getEmpleadoPK().getIdempleado());
        turnos.getTurnosPK().setEmpleadoCedulaEmpleado(turnos.getEmpleado().getEmpleadoPK().getCedulaEmpleado());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autobus autobus = turnos.getAutobus();
            if (autobus != null) {
                autobus = em.getReference(autobus.getClass(), autobus.getIdautobus());
                turnos.setAutobus(autobus);
            }
            Empleado empleado = turnos.getEmpleado();
            if (empleado != null) {
                empleado = em.getReference(empleado.getClass(), empleado.getEmpleadoPK());
                turnos.setEmpleado(empleado);
            }
            em.persist(turnos);
            if (autobus != null) {
                autobus.getTurnosCollection().add(turnos);
                autobus = em.merge(autobus);
            }
            if (empleado != null) {
                empleado.getTurnosCollection().add(turnos);
                empleado = em.merge(empleado);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTurnos(turnos.getTurnosPK()) != null) {
                throw new PreexistingEntityException("Turnos " + turnos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turnos turnos) throws NonexistentEntityException, Exception {
        turnos.getTurnosPK().setAutobusIdautobus(turnos.getAutobus().getIdautobus());
        turnos.getTurnosPK().setEmpleadoIdempleado(turnos.getEmpleado().getEmpleadoPK().getIdempleado());
        turnos.getTurnosPK().setEmpleadoCedulaEmpleado(turnos.getEmpleado().getEmpleadoPK().getCedulaEmpleado());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turnos persistentTurnos = em.find(Turnos.class, turnos.getTurnosPK());
            Autobus autobusOld = persistentTurnos.getAutobus();
            Autobus autobusNew = turnos.getAutobus();
            Empleado empleadoOld = persistentTurnos.getEmpleado();
            Empleado empleadoNew = turnos.getEmpleado();
            if (autobusNew != null) {
                autobusNew = em.getReference(autobusNew.getClass(), autobusNew.getIdautobus());
                turnos.setAutobus(autobusNew);
            }
            if (empleadoNew != null) {
                empleadoNew = em.getReference(empleadoNew.getClass(), empleadoNew.getEmpleadoPK());
                turnos.setEmpleado(empleadoNew);
            }
            turnos = em.merge(turnos);
            if (autobusOld != null && !autobusOld.equals(autobusNew)) {
                autobusOld.getTurnosCollection().remove(turnos);
                autobusOld = em.merge(autobusOld);
            }
            if (autobusNew != null && !autobusNew.equals(autobusOld)) {
                autobusNew.getTurnosCollection().add(turnos);
                autobusNew = em.merge(autobusNew);
            }
            if (empleadoOld != null && !empleadoOld.equals(empleadoNew)) {
                empleadoOld.getTurnosCollection().remove(turnos);
                empleadoOld = em.merge(empleadoOld);
            }
            if (empleadoNew != null && !empleadoNew.equals(empleadoOld)) {
                empleadoNew.getTurnosCollection().add(turnos);
                empleadoNew = em.merge(empleadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TurnosPK id = turnos.getTurnosPK();
                if (findTurnos(id) == null) {
                    throw new NonexistentEntityException("The turnos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TurnosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turnos turnos;
            try {
                turnos = em.getReference(Turnos.class, id);
                turnos.getTurnosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turnos with id " + id + " no longer exists.", enfe);
            }
            Autobus autobus = turnos.getAutobus();
            if (autobus != null) {
                autobus.getTurnosCollection().remove(turnos);
                autobus = em.merge(autobus);
            }
            Empleado empleado = turnos.getEmpleado();
            if (empleado != null) {
                empleado.getTurnosCollection().remove(turnos);
                empleado = em.merge(empleado);
            }
            em.remove(turnos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turnos> findTurnosEntities() {
        return findTurnosEntities(true, -1, -1);
    }

    public List<Turnos> findTurnosEntities(int maxResults, int firstResult) {
        return findTurnosEntities(false, maxResults, firstResult);
    }

    private List<Turnos> findTurnosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turnos.class));
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

    public Turnos findTurnos(TurnosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turnos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turnos> rt = cq.from(Turnos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
