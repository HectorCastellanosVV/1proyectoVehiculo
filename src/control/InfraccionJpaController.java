/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Infracciones;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Infraccion;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class InfraccionJpaController implements Serializable {

    public InfraccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Infraccion infraccion) {
        if (infraccion.getInfraccionesList() == null) {
            infraccion.setInfraccionesList(new ArrayList<Infracciones>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Infracciones> attachedInfraccionesList = new ArrayList<Infracciones>();
            for (Infracciones infraccionesListInfraccionesToAttach : infraccion.getInfraccionesList()) {
                infraccionesListInfraccionesToAttach = em.getReference(infraccionesListInfraccionesToAttach.getClass(), infraccionesListInfraccionesToAttach.getIdfolioinf());
                attachedInfraccionesList.add(infraccionesListInfraccionesToAttach);
            }
            infraccion.setInfraccionesList(attachedInfraccionesList);
            em.persist(infraccion);
            for (Infracciones infraccionesListInfracciones : infraccion.getInfraccionesList()) {
                Infraccion oldInfraccionOfInfraccionesListInfracciones = infraccionesListInfracciones.getInfraccion();
                infraccionesListInfracciones.setInfraccion(infraccion);
                infraccionesListInfracciones = em.merge(infraccionesListInfracciones);
                if (oldInfraccionOfInfraccionesListInfracciones != null) {
                    oldInfraccionOfInfraccionesListInfracciones.getInfraccionesList().remove(infraccionesListInfracciones);
                    oldInfraccionOfInfraccionesListInfracciones = em.merge(oldInfraccionOfInfraccionesListInfracciones);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Infraccion infraccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Infraccion persistentInfraccion = em.find(Infraccion.class, infraccion.getIdinfraccion());
            List<Infracciones> infraccionesListOld = persistentInfraccion.getInfraccionesList();
            List<Infracciones> infraccionesListNew = infraccion.getInfraccionesList();
            List<Infracciones> attachedInfraccionesListNew = new ArrayList<Infracciones>();
            for (Infracciones infraccionesListNewInfraccionesToAttach : infraccionesListNew) {
                infraccionesListNewInfraccionesToAttach = em.getReference(infraccionesListNewInfraccionesToAttach.getClass(), infraccionesListNewInfraccionesToAttach.getIdfolioinf());
                attachedInfraccionesListNew.add(infraccionesListNewInfraccionesToAttach);
            }
            infraccionesListNew = attachedInfraccionesListNew;
            infraccion.setInfraccionesList(infraccionesListNew);
            infraccion = em.merge(infraccion);
            for (Infracciones infraccionesListOldInfracciones : infraccionesListOld) {
                if (!infraccionesListNew.contains(infraccionesListOldInfracciones)) {
                    infraccionesListOldInfracciones.setInfraccion(null);
                    infraccionesListOldInfracciones = em.merge(infraccionesListOldInfracciones);
                }
            }
            for (Infracciones infraccionesListNewInfracciones : infraccionesListNew) {
                if (!infraccionesListOld.contains(infraccionesListNewInfracciones)) {
                    Infraccion oldInfraccionOfInfraccionesListNewInfracciones = infraccionesListNewInfracciones.getInfraccion();
                    infraccionesListNewInfracciones.setInfraccion(infraccion);
                    infraccionesListNewInfracciones = em.merge(infraccionesListNewInfracciones);
                    if (oldInfraccionOfInfraccionesListNewInfracciones != null && !oldInfraccionOfInfraccionesListNewInfracciones.equals(infraccion)) {
                        oldInfraccionOfInfraccionesListNewInfracciones.getInfraccionesList().remove(infraccionesListNewInfracciones);
                        oldInfraccionOfInfraccionesListNewInfracciones = em.merge(oldInfraccionOfInfraccionesListNewInfracciones);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = infraccion.getIdinfraccion();
                if (findInfraccion(id) == null) {
                    throw new NonexistentEntityException("The infraccion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Infraccion infraccion;
            try {
                infraccion = em.getReference(Infraccion.class, id);
                infraccion.getIdinfraccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infraccion with id " + id + " no longer exists.", enfe);
            }
            List<Infracciones> infraccionesList = infraccion.getInfraccionesList();
            for (Infracciones infraccionesListInfracciones : infraccionesList) {
                infraccionesListInfracciones.setInfraccion(null);
                infraccionesListInfracciones = em.merge(infraccionesListInfracciones);
            }
            em.remove(infraccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Infraccion> findInfraccionEntities() {
        return findInfraccionEntities(true, -1, -1);
    }

    public List<Infraccion> findInfraccionEntities(int maxResults, int firstResult) {
        return findInfraccionEntities(false, maxResults, firstResult);
    }

    private List<Infraccion> findInfraccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Infraccion.class));
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

    public Infraccion findInfraccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Infraccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfraccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Infraccion> rt = cq.from(Infraccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
