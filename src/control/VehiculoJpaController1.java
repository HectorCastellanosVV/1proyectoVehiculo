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
import modelo.Tipovehiculo;
import modelo.Infracciones;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Vehiculo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VehiculoJpaController1 implements Serializable {

    public VehiculoJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehiculo vehiculo) {
        if (vehiculo.getInfraccionesList() == null) {
            vehiculo.setInfraccionesList(new ArrayList<Infracciones>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipovehiculo tipo = vehiculo.getTipo();
            if (tipo != null) {
                tipo = em.getReference(tipo.getClass(), tipo.getIdtipo());
                vehiculo.setTipo(tipo);
            }
            List<Infracciones> attachedInfraccionesList = new ArrayList<Infracciones>();
            for (Infracciones infraccionesListInfraccionesToAttach : vehiculo.getInfraccionesList()) {
                infraccionesListInfraccionesToAttach = em.getReference(infraccionesListInfraccionesToAttach.getClass(), infraccionesListInfraccionesToAttach.getIdfolioinf());
                attachedInfraccionesList.add(infraccionesListInfraccionesToAttach);
            }
            vehiculo.setInfraccionesList(attachedInfraccionesList);
            em.persist(vehiculo);
            if (tipo != null) {
                tipo.getVehiculoList().add(vehiculo);
                tipo = em.merge(tipo);
            }
            for (Infracciones infraccionesListInfracciones : vehiculo.getInfraccionesList()) {
                Vehiculo oldVehiculoOfInfraccionesListInfracciones = infraccionesListInfracciones.getVehiculo();
                infraccionesListInfracciones.setVehiculo(vehiculo);
                infraccionesListInfracciones = em.merge(infraccionesListInfracciones);
                if (oldVehiculoOfInfraccionesListInfracciones != null) {
                    oldVehiculoOfInfraccionesListInfracciones.getInfraccionesList().remove(infraccionesListInfracciones);
                    oldVehiculoOfInfraccionesListInfracciones = em.merge(oldVehiculoOfInfraccionesListInfracciones);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehiculo vehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehiculo persistentVehiculo = em.find(Vehiculo.class, vehiculo.getIdve());
            Tipovehiculo tipoOld = persistentVehiculo.getTipo();
            Tipovehiculo tipoNew = vehiculo.getTipo();
            List<Infracciones> infraccionesListOld = persistentVehiculo.getInfraccionesList();
            List<Infracciones> infraccionesListNew = vehiculo.getInfraccionesList();
            if (tipoNew != null) {
                tipoNew = em.getReference(tipoNew.getClass(), tipoNew.getIdtipo());
                vehiculo.setTipo(tipoNew);
            }
            List<Infracciones> attachedInfraccionesListNew = new ArrayList<Infracciones>();
            for (Infracciones infraccionesListNewInfraccionesToAttach : infraccionesListNew) {
                infraccionesListNewInfraccionesToAttach = em.getReference(infraccionesListNewInfraccionesToAttach.getClass(), infraccionesListNewInfraccionesToAttach.getIdfolioinf());
                attachedInfraccionesListNew.add(infraccionesListNewInfraccionesToAttach);
            }
            infraccionesListNew = attachedInfraccionesListNew;
            vehiculo.setInfraccionesList(infraccionesListNew);
            vehiculo = em.merge(vehiculo);
            if (tipoOld != null && !tipoOld.equals(tipoNew)) {
                tipoOld.getVehiculoList().remove(vehiculo);
                tipoOld = em.merge(tipoOld);
            }
            if (tipoNew != null && !tipoNew.equals(tipoOld)) {
                tipoNew.getVehiculoList().add(vehiculo);
                tipoNew = em.merge(tipoNew);
            }
            for (Infracciones infraccionesListOldInfracciones : infraccionesListOld) {
                if (!infraccionesListNew.contains(infraccionesListOldInfracciones)) {
                    infraccionesListOldInfracciones.setVehiculo(null);
                    infraccionesListOldInfracciones = em.merge(infraccionesListOldInfracciones);
                }
            }
            for (Infracciones infraccionesListNewInfracciones : infraccionesListNew) {
                if (!infraccionesListOld.contains(infraccionesListNewInfracciones)) {
                    Vehiculo oldVehiculoOfInfraccionesListNewInfracciones = infraccionesListNewInfracciones.getVehiculo();
                    infraccionesListNewInfracciones.setVehiculo(vehiculo);
                    infraccionesListNewInfracciones = em.merge(infraccionesListNewInfracciones);
                    if (oldVehiculoOfInfraccionesListNewInfracciones != null && !oldVehiculoOfInfraccionesListNewInfracciones.equals(vehiculo)) {
                        oldVehiculoOfInfraccionesListNewInfracciones.getInfraccionesList().remove(infraccionesListNewInfracciones);
                        oldVehiculoOfInfraccionesListNewInfracciones = em.merge(oldVehiculoOfInfraccionesListNewInfracciones);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vehiculo.getIdve();
                if (findVehiculo(id) == null) {
                    throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.");
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
            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);
                vehiculo.getIdve();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.", enfe);
            }
            Tipovehiculo tipo = vehiculo.getTipo();
            if (tipo != null) {
                tipo.getVehiculoList().remove(vehiculo);
                tipo = em.merge(tipo);
            }
            List<Infracciones> infraccionesList = vehiculo.getInfraccionesList();
            for (Infracciones infraccionesListInfracciones : infraccionesList) {
                infraccionesListInfracciones.setVehiculo(null);
                infraccionesListInfracciones = em.merge(infraccionesListInfracciones);
            }
            em.remove(vehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);
    }

    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);
    }

    private List<Vehiculo> findVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehiculo.class));
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

    public Vehiculo findVehiculo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
