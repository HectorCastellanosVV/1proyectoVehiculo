/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hector
 */
@Entity
@Table(name = "TIPOVEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipovehiculo.findAll", query = "SELECT t FROM Tipovehiculo t"),
    @NamedQuery(name = "Tipovehiculo.findByIdtipo", query = "SELECT t FROM Tipovehiculo t WHERE t.idtipo = :idtipo"),
    @NamedQuery(name = "Tipovehiculo.findByNombre", query = "SELECT t FROM Tipovehiculo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tipovehiculo.findByCaracteristicas", query = "SELECT t FROM Tipovehiculo t WHERE t.caracteristicas = :caracteristicas")})
public class Tipovehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPO")
    private Integer idtipo;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @OneToMany(mappedBy = "tipo")
    private List<Vehiculo> vehiculoList;

    public Tipovehiculo() {
    }

    public Tipovehiculo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipovehiculo)) {
            return false;
        }
        Tipovehiculo other = (Tipovehiculo) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "modelo.Tipovehiculo[ idtipo=" + idtipo + " ]";
    }
    
}
