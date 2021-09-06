/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
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
import modelo.Autobus;
import modelo.Rutas;

/**
 *
 * @author Nicolas Ospitia
 */
public class AutobusJpaController implements Serializable {

    public AutobusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Autobus autobus) {
        if (autobus.getTurnosCollection() == null) {
            autobus.setTurnosCollection(new ArrayList<Turnos>());
        }
        if (autobus.getRutasCollection() == null) {
            autobus.setRutasCollection(new ArrayList<Rutas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Turnos> attachedTurnosCollection = new ArrayList<Turnos>();
            for (Turnos turnosCollectionTurnosToAttach : autobus.getTurnosCollection()) {
                turnosCollectionTurnosToAttach = em.getReference(turnosCollectionTurnosToAttach.getClass(), turnosCollectionTurnosToAttach.getTurnosPK());
                attachedTurnosCollection.add(turnosCollectionTurnosToAttach);
            }
            autobus.setTurnosCollection(attachedTurnosCollection);
            Collection<Rutas> attachedRutasCollection = new ArrayList<Rutas>();
            for (Rutas rutasCollectionRutasToAttach : autobus.getRutasCollection()) {
                rutasCollectionRutasToAttach = em.getReference(rutasCollectionRutasToAttach.getClass(), rutasCollectionRutasToAttach.getRutasPK());
                attachedRutasCollection.add(rutasCollectionRutasToAttach);
            }
            autobus.setRutasCollection(attachedRutasCollection);
            em.persist(autobus);
            for (Turnos turnosCollectionTurnos : autobus.getTurnosCollection()) {
                Autobus oldAutobusOfTurnosCollectionTurnos = turnosCollectionTurnos.getAutobus();
                turnosCollectionTurnos.setAutobus(autobus);
                turnosCollectionTurnos = em.merge(turnosCollectionTurnos);
                if (oldAutobusOfTurnosCollectionTurnos != null) {
                    oldAutobusOfTurnosCollectionTurnos.getTurnosCollection().remove(turnosCollectionTurnos);
                    oldAutobusOfTurnosCollectionTurnos = em.merge(oldAutobusOfTurnosCollectionTurnos);
                }
            }
            for (Rutas rutasCollectionRutas : autobus.getRutasCollection()) {
                Autobus oldAutobusOfRutasCollectionRutas = rutasCollectionRutas.getAutobus();
                rutasCollectionRutas.setAutobus(autobus);
                rutasCollectionRutas = em.merge(rutasCollectionRutas);
                if (oldAutobusOfRutasCollectionRutas != null) {
                    oldAutobusOfRutasCollectionRutas.getRutasCollection().remove(rutasCollectionRutas);
                    oldAutobusOfRutasCollectionRutas = em.merge(oldAutobusOfRutasCollectionRutas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Autobus autobus) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autobus persistentAutobus = em.find(Autobus.class, autobus.getIdautobus());
            Collection<Turnos> turnosCollectionOld = persistentAutobus.getTurnosCollection();
            Collection<Turnos> turnosCollectionNew = autobus.getTurnosCollection();
            Collection<Rutas> rutasCollectionOld = persistentAutobus.getRutasCollection();
            Collection<Rutas> rutasCollectionNew = autobus.getRutasCollection();
            List<String> illegalOrphanMessages = null;
            for (Turnos turnosCollectionOldTurnos : turnosCollectionOld) {
                if (!turnosCollectionNew.contains(turnosCollectionOldTurnos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Turnos " + turnosCollectionOldTurnos + " since its autobus field is not nullable.");
                }
            }
            for (Rutas rutasCollectionOldRutas : rutasCollectionOld) {
                if (!rutasCollectionNew.contains(rutasCollectionOldRutas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rutas " + rutasCollectionOldRutas + " since its autobus field is not nullable.");
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
            autobus.setTurnosCollection(turnosCollectionNew);
            Collection<Rutas> attachedRutasCollectionNew = new ArrayList<Rutas>();
            for (Rutas rutasCollectionNewRutasToAttach : rutasCollectionNew) {
                rutasCollectionNewRutasToAttach = em.getReference(rutasCollectionNewRutasToAttach.getClass(), rutasCollectionNewRutasToAttach.getRutasPK());
                attachedRutasCollectionNew.add(rutasCollectionNewRutasToAttach);
            }
            rutasCollectionNew = attachedRutasCollectionNew;
            autobus.setRutasCollection(rutasCollectionNew);
            autobus = em.merge(autobus);
            for (Turnos turnosCollectionNewTurnos : turnosCollectionNew) {
                if (!turnosCollectionOld.contains(turnosCollectionNewTurnos)) {
                    Autobus oldAutobusOfTurnosCollectionNewTurnos = turnosCollectionNewTurnos.getAutobus();
                    turnosCollectionNewTurnos.setAutobus(autobus);
                    turnosCollectionNewTurnos = em.merge(turnosCollectionNewTurnos);
                    if (oldAutobusOfTurnosCollectionNewTurnos != null && !oldAutobusOfTurnosCollectionNewTurnos.equals(autobus)) {
                        oldAutobusOfTurnosCollectionNewTurnos.getTurnosCollection().remove(turnosCollectionNewTurnos);
                        oldAutobusOfTurnosCollectionNewTurnos = em.merge(oldAutobusOfTurnosCollectionNewTurnos);
                    }
                }
            }
            for (Rutas rutasCollectionNewRutas : rutasCollectionNew) {
                if (!rutasCollectionOld.contains(rutasCollectionNewRutas)) {
                    Autobus oldAutobusOfRutasCollectionNewRutas = rutasCollectionNewRutas.getAutobus();
                    rutasCollectionNewRutas.setAutobus(autobus);
                    rutasCollectionNewRutas = em.merge(rutasCollectionNewRutas);
                    if (oldAutobusOfRutasCollectionNewRutas != null && !oldAutobusOfRutasCollectionNewRutas.equals(autobus)) {
                        oldAutobusOfRutasCollectionNewRutas.getRutasCollection().remove(rutasCollectionNewRutas);
                        oldAutobusOfRutasCollectionNewRutas = em.merge(oldAutobusOfRutasCollectionNewRutas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = autobus.getIdautobus();
                if (findAutobus(id) == null) {
                    throw new NonexistentEntityException("The autobus with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autobus autobus;
            try {
                autobus = em.getReference(Autobus.class, id);
                autobus.getIdautobus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The autobus with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Turnos> turnosCollectionOrphanCheck = autobus.getTurnosCollection();
            for (Turnos turnosCollectionOrphanCheckTurnos : turnosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Autobus (" + autobus + ") cannot be destroyed since the Turnos " + turnosCollectionOrphanCheckTurnos + " in its turnosCollection field has a non-nullable autobus field.");
            }
            Collection<Rutas> rutasCollectionOrphanCheck = autobus.getRutasCollection();
            for (Rutas rutasCollectionOrphanCheckRutas : rutasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Autobus (" + autobus + ") cannot be destroyed since the Rutas " + rutasCollectionOrphanCheckRutas + " in its rutasCollection field has a non-nullable autobus field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(autobus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Autobus> findAutobusEntities() {
        return findAutobusEntities(true, -1, -1);
    }

    public List<Autobus> findAutobusEntities(int maxResults, int firstResult) {
        return findAutobusEntities(false, maxResults, firstResult);
    }

    private List<Autobus> findAutobusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Autobus.class));
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

    public Autobus findAutobus(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Autobus.class, id);
        } finally {
            em.close();
        }
    }

    public int getAutobusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Autobus> rt = cq.from(Autobus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
