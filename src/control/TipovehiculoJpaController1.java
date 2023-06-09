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
import modelo.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Tipovehiculo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TipovehiculoJpaController1 implements Serializable {

    public TipovehiculoJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipovehiculo tipovehiculo) {
        if (tipovehiculo.getVehiculoList() == null) {
            tipovehiculo.setVehiculoList(new ArrayList<Vehiculo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Vehiculo> attachedVehiculoList = new ArrayList<Vehiculo>();
            for (Vehiculo vehiculoListVehiculoToAttach : tipovehiculo.getVehiculoList()) {
                vehiculoListVehiculoToAttach = em.getReference(vehiculoListVehiculoToAttach.getClass(), vehiculoListVehiculoToAttach.getIdve());
                attachedVehiculoList.add(vehiculoListVehiculoToAttach);
            }
            tipovehiculo.setVehiculoList(attachedVehiculoList);
            em.persist(tipovehiculo);
            for (Vehiculo vehiculoListVehiculo : tipovehiculo.getVehiculoList()) {
                Tipovehiculo oldTipoOfVehiculoListVehiculo = vehiculoListVehiculo.getTipo();
                vehiculoListVehiculo.setTipo(tipovehiculo);
                vehiculoListVehiculo = em.merge(vehiculoListVehiculo);
                if (oldTipoOfVehiculoListVehiculo != null) {
                    oldTipoOfVehiculoListVehiculo.getVehiculoList().remove(vehiculoListVehiculo);
                    oldTipoOfVehiculoListVehiculo = em.merge(oldTipoOfVehiculoListVehiculo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipovehiculo tipovehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipovehiculo persistentTipovehiculo = em.find(Tipovehiculo.class, tipovehiculo.getIdtipo());
            List<Vehiculo> vehiculoListOld = persistentTipovehiculo.getVehiculoList();
            List<Vehiculo> vehiculoListNew = tipovehiculo.getVehiculoList();
            List<Vehiculo> attachedVehiculoListNew = new ArrayList<Vehiculo>();
            for (Vehiculo vehiculoListNewVehiculoToAttach : vehiculoListNew) {
                vehiculoListNewVehiculoToAttach = em.getReference(vehiculoListNewVehiculoToAttach.getClass(), vehiculoListNewVehiculoToAttach.getIdve());
                attachedVehiculoListNew.add(vehiculoListNewVehiculoToAttach);
            }
            vehiculoListNew = attachedVehiculoListNew;
            tipovehiculo.setVehiculoList(vehiculoListNew);
            tipovehiculo = em.merge(tipovehiculo);
            for (Vehiculo vehiculoListOldVehiculo : vehiculoListOld) {
                if (!vehiculoListNew.contains(vehiculoListOldVehiculo)) {
                    vehiculoListOldVehiculo.setTipo(null);
                    vehiculoListOldVehiculo = em.merge(vehiculoListOldVehiculo);
                }
            }
            for (Vehiculo vehiculoListNewVehiculo : vehiculoListNew) {
                if (!vehiculoListOld.contains(vehiculoListNewVehiculo)) {
                    Tipovehiculo oldTipoOfVehiculoListNewVehiculo = vehiculoListNewVehiculo.getTipo();
                    vehiculoListNewVehiculo.setTipo(tipovehiculo);
                    vehiculoListNewVehiculo = em.merge(vehiculoListNewVehiculo);
                    if (oldTipoOfVehiculoListNewVehiculo != null && !oldTipoOfVehiculoListNewVehiculo.equals(tipovehiculo)) {
                        oldTipoOfVehiculoListNewVehiculo.getVehiculoList().remove(vehiculoListNewVehiculo);
                        oldTipoOfVehiculoListNewVehiculo = em.merge(oldTipoOfVehiculoListNewVehiculo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipovehiculo.getIdtipo();
                if (findTipovehiculo(id) == null) {
                    throw new NonexistentEntityException("The tipovehiculo with id " + id + " no longer exists.");
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
            Tipovehiculo tipovehiculo;
            try {
                tipovehiculo = em.getReference(Tipovehiculo.class, id);
                tipovehiculo.getIdtipo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipovehiculo with id " + id + " no longer exists.", enfe);
            }
            List<Vehiculo> vehiculoList = tipovehiculo.getVehiculoList();
            for (Vehiculo vehiculoListVehiculo : vehiculoList) {
                vehiculoListVehiculo.setTipo(null);
                vehiculoListVehiculo = em.merge(vehiculoListVehiculo);
            }
            em.remove(tipovehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipovehiculo> findTipovehiculoEntities() {
        return findTipovehiculoEntities(true, -1, -1);
    }

    public List<Tipovehiculo> findTipovehiculoEntities(int maxResults, int firstResult) {
        return findTipovehiculoEntities(false, maxResults, firstResult);
    }

    private List<Tipovehiculo> findTipovehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipovehiculo.class));
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

    public Tipovehiculo findTipovehiculo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipovehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipovehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipovehiculo> rt = cq.from(Tipovehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
