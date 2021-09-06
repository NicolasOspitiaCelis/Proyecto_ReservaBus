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
import modelo.Rutas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Ciudad;

/**
 *
 * @author Nicolas Ospitia
 */
public class CiudadJpaController implements Serializable {

    public CiudadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ciudad ciudad) throws PreexistingEntityException, Exception {
        if (ciudad.getRutasCollection() == null) {
            ciudad.setRutasCollection(new ArrayList<Rutas>());
        }
        if (ciudad.getRutasCollection1() == null) {
            ciudad.setRutasCollection1(new ArrayList<Rutas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Rutas> attachedRutasCollection = new ArrayList<Rutas>();
            for (Rutas rutasCollectionRutasToAttach : ciudad.getRutasCollection()) {
                rutasCollectionRutasToAttach = em.getReference(rutasCollectionRutasToAttach.getClass(), rutasCollectionRutasToAttach.getRutasPK());
                attachedRutasCollection.add(rutasCollectionRutasToAttach);
            }
            ciudad.setRutasCollection(attachedRutasCollection);
            Collection<Rutas> attachedRutasCollection1 = new ArrayList<Rutas>();
            for (Rutas rutasCollection1RutasToAttach : ciudad.getRutasCollection1()) {
                rutasCollection1RutasToAttach = em.getReference(rutasCollection1RutasToAttach.getClass(), rutasCollection1RutasToAttach.getRutasPK());
                attachedRutasCollection1.add(rutasCollection1RutasToAttach);
            }
            ciudad.setRutasCollection1(attachedRutasCollection1);
            em.persist(ciudad);
            for (Rutas rutasCollectionRutas : ciudad.getRutasCollection()) {
                Ciudad oldCiudadOfRutasCollectionRutas = rutasCollectionRutas.getCiudad();
                rutasCollectionRutas.setCiudad(ciudad);
                rutasCollectionRutas = em.merge(rutasCollectionRutas);
                if (oldCiudadOfRutasCollectionRutas != null) {
                    oldCiudadOfRutasCollectionRutas.getRutasCollection().remove(rutasCollectionRutas);
                    oldCiudadOfRutasCollectionRutas = em.merge(oldCiudadOfRutasCollectionRutas);
                }
            }
            for (Rutas rutasCollection1Rutas : ciudad.getRutasCollection1()) {
                Ciudad oldCiudad1OfRutasCollection1Rutas = rutasCollection1Rutas.getCiudad1();
                rutasCollection1Rutas.setCiudad1(ciudad);
                rutasCollection1Rutas = em.merge(rutasCollection1Rutas);
                if (oldCiudad1OfRutasCollection1Rutas != null) {
                    oldCiudad1OfRutasCollection1Rutas.getRutasCollection1().remove(rutasCollection1Rutas);
                    oldCiudad1OfRutasCollection1Rutas = em.merge(oldCiudad1OfRutasCollection1Rutas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCiudad(ciudad.getNombreCiudad()) != null) {
                throw new PreexistingEntityException("Ciudad " + ciudad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ciudad ciudad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad persistentCiudad = em.find(Ciudad.class, ciudad.getNombreCiudad());
            Collection<Rutas> rutasCollectionOld = persistentCiudad.getRutasCollection();
            Collection<Rutas> rutasCollectionNew = ciudad.getRutasCollection();
            Collection<Rutas> rutasCollection1Old = persistentCiudad.getRutasCollection1();
            Collection<Rutas> rutasCollection1New = ciudad.getRutasCollection1();
            List<String> illegalOrphanMessages = null;
            for (Rutas rutasCollectionOldRutas : rutasCollectionOld) {
                if (!rutasCollectionNew.contains(rutasCollectionOldRutas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rutas " + rutasCollectionOldRutas + " since its ciudad field is not nullable.");
                }
            }
            for (Rutas rutasCollection1OldRutas : rutasCollection1Old) {
                if (!rutasCollection1New.contains(rutasCollection1OldRutas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rutas " + rutasCollection1OldRutas + " since its ciudad1 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Rutas> attachedRutasCollectionNew = new ArrayList<Rutas>();
            for (Rutas rutasCollectionNewRutasToAttach : rutasCollectionNew) {
                rutasCollectionNewRutasToAttach = em.getReference(rutasCollectionNewRutasToAttach.getClass(), rutasCollectionNewRutasToAttach.getRutasPK());
                attachedRutasCollectionNew.add(rutasCollectionNewRutasToAttach);
            }
            rutasCollectionNew = attachedRutasCollectionNew;
            ciudad.setRutasCollection(rutasCollectionNew);
            Collection<Rutas> attachedRutasCollection1New = new ArrayList<Rutas>();
            for (Rutas rutasCollection1NewRutasToAttach : rutasCollection1New) {
                rutasCollection1NewRutasToAttach = em.getReference(rutasCollection1NewRutasToAttach.getClass(), rutasCollection1NewRutasToAttach.getRutasPK());
                attachedRutasCollection1New.add(rutasCollection1NewRutasToAttach);
            }
            rutasCollection1New = attachedRutasCollection1New;
            ciudad.setRutasCollection1(rutasCollection1New);
            ciudad = em.merge(ciudad);
            for (Rutas rutasCollectionNewRutas : rutasCollectionNew) {
                if (!rutasCollectionOld.contains(rutasCollectionNewRutas)) {
                    Ciudad oldCiudadOfRutasCollectionNewRutas = rutasCollectionNewRutas.getCiudad();
                    rutasCollectionNewRutas.setCiudad(ciudad);
                    rutasCollectionNewRutas = em.merge(rutasCollectionNewRutas);
                    if (oldCiudadOfRutasCollectionNewRutas != null && !oldCiudadOfRutasCollectionNewRutas.equals(ciudad)) {
                        oldCiudadOfRutasCollectionNewRutas.getRutasCollection().remove(rutasCollectionNewRutas);
                        oldCiudadOfRutasCollectionNewRutas = em.merge(oldCiudadOfRutasCollectionNewRutas);
                    }
                }
            }
            for (Rutas rutasCollection1NewRutas : rutasCollection1New) {
                if (!rutasCollection1Old.contains(rutasCollection1NewRutas)) {
                    Ciudad oldCiudad1OfRutasCollection1NewRutas = rutasCollection1NewRutas.getCiudad1();
                    rutasCollection1NewRutas.setCiudad1(ciudad);
                    rutasCollection1NewRutas = em.merge(rutasCollection1NewRutas);
                    if (oldCiudad1OfRutasCollection1NewRutas != null && !oldCiudad1OfRutasCollection1NewRutas.equals(ciudad)) {
                        oldCiudad1OfRutasCollection1NewRutas.getRutasCollection1().remove(rutasCollection1NewRutas);
                        oldCiudad1OfRutasCollection1NewRutas = em.merge(oldCiudad1OfRutasCollection1NewRutas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ciudad.getNombreCiudad();
                if (findCiudad(id) == null) {
                    throw new NonexistentEntityException("The ciudad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudad ciudad;
            try {
                ciudad = em.getReference(Ciudad.class, id);
                ciudad.getNombreCiudad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciudad with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Rutas> rutasCollectionOrphanCheck = ciudad.getRutasCollection();
            for (Rutas rutasCollectionOrphanCheckRutas : rutasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ciudad (" + ciudad + ") cannot be destroyed since the Rutas " + rutasCollectionOrphanCheckRutas + " in its rutasCollection field has a non-nullable ciudad field.");
            }
            Collection<Rutas> rutasCollection1OrphanCheck = ciudad.getRutasCollection1();
            for (Rutas rutasCollection1OrphanCheckRutas : rutasCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ciudad (" + ciudad + ") cannot be destroyed since the Rutas " + rutasCollection1OrphanCheckRutas + " in its rutasCollection1 field has a non-nullable ciudad1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ciudad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ciudad> findCiudadEntities() {
        return findCiudadEntities(true, -1, -1);
    }

    public List<Ciudad> findCiudadEntities(int maxResults, int firstResult) {
        return findCiudadEntities(false, maxResults, firstResult);
    }

    private List<Ciudad> findCiudadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ciudad.class));
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

    public Ciudad findCiudad(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ciudad.class, id);
        } finally {
            em.close();
        }
    }

    public int getCiudadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ciudad> rt = cq.from(Ciudad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
