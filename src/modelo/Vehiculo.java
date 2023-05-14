/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hector
 */
@Entity
@Table(name = "VEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdve", query = "SELECT v FROM Vehiculo v WHERE v.idve = :idve"),
    @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculo.findByAnio", query = "SELECT v FROM Vehiculo v WHERE v.anio = :anio"),
    @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVE")
    private Integer idve;
    @Basic(optional = false)
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "MARCA")
    private String marca;
    @JoinColumn(name = "TIPO", referencedColumnName = "IDTIPO")
    @ManyToOne
    private Tipovehiculo tipo;

    public Vehiculo() {
    }

    public Vehiculo(Integer idve) {
        this.idve = idve;
    }

    public Vehiculo(Integer idve, String placa) {
        this.idve = idve;
        this.placa = placa;
    }

    public Integer getIdve() {
        return idve;
    }

    public void setIdve(Integer idve) {
        this.idve = idve;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Tipovehiculo getTipo() {
        return tipo;
    }

    public void setTipo(Tipovehiculo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idve != null ? idve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idve == null && other.idve != null) || (this.idve != null && !this.idve.equals(other.idve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vehiculo[ idve=" + idve + " ]";
    }
    
}
