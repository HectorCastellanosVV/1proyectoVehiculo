/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "INFRACCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infracciones.findAll", query = "SELECT i FROM Infracciones i"),
    @NamedQuery(name = "Infracciones.findByIdfolioinf", query = "SELECT i FROM Infracciones i WHERE i.idfolioinf = :idfolioinf"),
    @NamedQuery(name = "Infracciones.findByFecha", query = "SELECT i FROM Infracciones i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Infracciones.findByFechapago", query = "SELECT i FROM Infracciones i WHERE i.fechapago = :fechapago")})
public class Infracciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFOLIOINF")
    private Integer idfolioinf;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @JoinColumn(name = "INFRACCION", referencedColumnName = "IDINFRACCION")
    @ManyToOne
    private Infraccion infraccion;
    @JoinColumn(name = "VEHICULO", referencedColumnName = "IDVE")
    @ManyToOne
    private Vehiculo vehiculo;

    public Infracciones() {
    }

    public Infracciones(Integer idfolioinf) {
        this.idfolioinf = idfolioinf;
    }

    public Integer getIdfolioinf() {
        return idfolioinf;
    }

    public void setIdfolioinf(Integer idfolioinf) {
        this.idfolioinf = idfolioinf;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Infraccion getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(Infraccion infraccion) {
        this.infraccion = infraccion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfolioinf != null ? idfolioinf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infracciones)) {
            return false;
        }
        Infracciones other = (Infracciones) object;
        if ((this.idfolioinf == null && other.idfolioinf != null) || (this.idfolioinf != null && !this.idfolioinf.equals(other.idfolioinf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Infracciones[ idfolioinf=" + idfolioinf + " ]";
    }

}
