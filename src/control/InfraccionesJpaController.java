/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Infraccion;
import modelo.Infracciones;
import modelo.Vehiculo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class InfraccionesJpaController implements Serializable {

    public InfraccionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Infracciones infracciones) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Infraccion infraccion = infracciones.getInfraccion();
            if (infraccion != null) {
                infraccion = em.getReference(infraccion.getClass(), infraccion.getIdinfraccion());
                infracciones.setInfraccion(infraccion);
            }
            Vehiculo vehiculo = infracciones.getVehiculo();
            if (vehiculo != null) {
                vehiculo = em.getReference(vehiculo.getClass(), vehiculo.getIdve());
                infracciones.setVehiculo(vehiculo);
            }
            em.persist(infracciones);
            if (infraccion != null) {
                infraccion.getInfraccionesList().add(infracciones);
                infraccion = em.merge(infraccion);
            }
            if (vehiculo != null) {
                vehiculo.getInfraccionesList().add(infracciones);
                vehiculo = em.merge(vehiculo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Infracciones infracciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Infracciones persistentInfracciones = em.find(Infracciones.class, infracciones.getIdfolioinf());
            Infraccion infraccionOld = persistentInfracciones.getInfraccion();
            Infraccion infraccionNew = infracciones.getInfraccion();
            Vehiculo vehiculoOld = persistentInfracciones.getVehiculo();
            Vehiculo vehiculoNew = infracciones.getVehiculo();
            if (infraccionNew != null) {
                infraccionNew = em.getReference(infraccionNew.getClass(), infraccionNew.getIdinfraccion());
                infracciones.setInfraccion(infraccionNew);
            }
            if (vehiculoNew != null) {
                vehiculoNew = em.getReference(vehiculoNew.getClass(), vehiculoNew.getIdve());
                infracciones.setVehiculo(vehiculoNew);
            }
            infracciones = em.merge(infracciones);
            if (infraccionOld != null && !infraccionOld.equals(infraccionNew)) {
                infraccionOld.getInfraccionesList().remove(infracciones);
                infraccionOld = em.merge(infraccionOld);
            }
            if (infraccionNew != null && !infraccionNew.equals(infraccionOld)) {
                infraccionNew.getInfraccionesList().add(infracciones);
                infraccionNew = em.merge(infraccionNew);
            }
            if (vehiculoOld != null && !vehiculoOld.equals(vehiculoNew)) {
                vehiculoOld.getInfraccionesList().remove(infracciones);
                vehiculoOld = em.merge(vehiculoOld);
            }
            if (vehiculoNew != null && !vehiculoNew.equals(vehiculoOld)) {
                vehiculoNew.getInfraccionesList().add(infracciones);
                vehiculoNew = em.merge(vehiculoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = infracciones.getIdfolioinf();
                if (findInfracciones(id) == null) {
                    throw new NonexistentEntityException("The infracciones with id " + id + " no longer exists.");
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
            Infracciones infracciones;
            try {
                infracciones = em.getReference(Infracciones.class, id);
                infracciones.getIdfolioinf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infracciones with id " + id + " no longer exists.", enfe);
            }
            Infraccion infraccion = infracciones.getInfraccion();
            if (infraccion != null) {
                infraccion.getInfraccionesList().remove(infracciones);
                infraccion = em.merge(infraccion);
            }
            Vehiculo vehiculo = infracciones.getVehiculo();
            if (vehiculo != null) {
                vehiculo.getInfraccionesList().remove(infracciones);
                vehiculo = em.merge(vehiculo);
            }
            em.remove(infracciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Infracciones> findInfraccionesEntities() {
        return findInfraccionesEntities(true, -1, -1);
    }

    public List<Infracciones> findInfraccionesEntities(int maxResults, int firstResult) {
        return findInfraccionesEntities(false, maxResults, firstResult);
    }

    private List<Infracciones> findInfraccionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Infracciones.class));
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

    public Infracciones findInfracciones(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Infracciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfraccionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Infracciones> rt = cq.from(Infracciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
