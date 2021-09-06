/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Nicolas Ospitia
 */
@Entity
@Table(name = "autobus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autobus.findAll", query = "SELECT a FROM Autobus a")
    , @NamedQuery(name = "Autobus.findByIdautobus", query = "SELECT a FROM Autobus a WHERE a.idautobus = :idautobus")
    , @NamedQuery(name = "Autobus.findByPlaca", query = "SELECT a FROM Autobus a WHERE a.placa = :placa")
    , @NamedQuery(name = "Autobus.findByTipoDeBus", query = "SELECT a FROM Autobus a WHERE a.tipoDeBus = :tipoDeBus")
    , @NamedQuery(name = "Autobus.findByNumeroDeSillas", query = "SELECT a FROM Autobus a WHERE a.numeroDeSillas = :numeroDeSillas")})
public class Autobus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idautobus")
    private Integer idautobus;
    @Basic(optional = false)
    @Column(name = "Placa")
    private String placa;
    @Basic(optional = false)
    @Column(name = "TipoDeBus")
    private String tipoDeBus;
    @Basic(optional = false)
    @Column(name = "NumeroDeSillas")
    private int numeroDeSillas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autobus")
    private Collection<Turnos> turnosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autobus")
    private Collection<Rutas> rutasCollection;

    public Autobus() {
    }

    public Autobus(Integer idautobus) {
        this.idautobus = idautobus;
    }

    public Autobus(Integer idautobus, String placa, String tipoDeBus, int numeroDeSillas, Collection<Turnos> turnosCollection, Collection<Rutas> rutasCollection) {
        this.idautobus = idautobus;
        this.placa = placa;
        this.tipoDeBus = tipoDeBus;
        this.numeroDeSillas = numeroDeSillas;
        this.turnosCollection = turnosCollection;
        this.rutasCollection = rutasCollection;
    }

    public Autobus(Integer idautobus, String placa, String tipoDeBus, int numeroDeSillas) {
        this.idautobus = idautobus;
        this.placa = placa;
        this.tipoDeBus = tipoDeBus;
        this.numeroDeSillas = numeroDeSillas;
    }

    public Integer getIdautobus() {
        return idautobus;
    }

    public void setIdautobus(Integer idautobus) {
        this.idautobus = idautobus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoDeBus() {
        return tipoDeBus;
    }

    public void setTipoDeBus(String tipoDeBus) {
        this.tipoDeBus = tipoDeBus;
    }

    public int getNumeroDeSillas() {
        return numeroDeSillas;
    }

    public void setNumeroDeSillas(int numeroDeSillas) {
        this.numeroDeSillas = numeroDeSillas;
    }

    @XmlTransient
    public Collection<Turnos> getTurnosCollection() {
        return turnosCollection;
    }

    public void setTurnosCollection(Collection<Turnos> turnosCollection) {
        this.turnosCollection = turnosCollection;
    }

    @XmlTransient
    public Collection<Rutas> getRutasCollection() {
        return rutasCollection;
    }

    public void setRutasCollection(Collection<Rutas> rutasCollection) {
        this.rutasCollection = rutasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idautobus != null ? idautobus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autobus)) {
            return false;
        }
        Autobus other = (Autobus) object;
        if ((this.idautobus == null && other.idautobus != null) || (this.idautobus != null && !this.idautobus.equals(other.idautobus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Autobus[ idautobus=" + idautobus + " ]";
    }
    
}
