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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "INFRACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infraccion.findAll", query = "SELECT i FROM Infraccion i"),
    @NamedQuery(name = "Infraccion.findByIdinfraccion", query = "SELECT i FROM Infraccion i WHERE i.idinfraccion = :idinfraccion"),
    @NamedQuery(name = "Infraccion.findByDescripcion", query = "SELECT i FROM Infraccion i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Infraccion.findByMulta", query = "SELECT i FROM Infraccion i WHERE i.multa = :multa")})
public class Infraccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDINFRACCION")
    private Integer idinfraccion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "MULTA")
    private String multa;
    @OneToMany(mappedBy = "infraccion")
    private List<Infracciones> infraccionesList;

    public Infraccion() {
    }

    public Infraccion(Integer idinfraccion) {
        this.idinfraccion = idinfraccion;
    }

    public Integer getIdinfraccion() {
        return idinfraccion;
    }

    public void setIdinfraccion(Integer idinfraccion) {
        this.idinfraccion = idinfraccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    @XmlTransient
    public List<Infracciones> getInfraccionesList() {
        return infraccionesList;
    }

    public void setInfraccionesList(List<Infracciones> infraccionesList) {
        this.infraccionesList = infraccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinfraccion != null ? idinfraccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infraccion)) {
            return false;
        }
        Infraccion other = (Infraccion) object;
        if ((this.idinfraccion == null && other.idinfraccion != null) || (this.idinfraccion != null && !this.idinfraccion.equals(other.idinfraccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Infraccion[ idinfraccion=" + idinfraccion + " ]";
    }

}
