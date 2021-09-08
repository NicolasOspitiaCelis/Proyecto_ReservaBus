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
@Table(name = "pasajero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasajero.findAll", query = "SELECT p FROM Pasajero p")
    , @NamedQuery(name = "Pasajero.findByCedula", query = "SELECT p FROM Pasajero p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Pasajero.findByNombre", query = "SELECT p FROM Pasajero p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pasajero.findByTipoDeDocumento", query = "SELECT p FROM Pasajero p WHERE p.tipoDeDocumento = :tipoDeDocumento")})
public class Pasajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cedula")
    private Long cedula;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "TipoDeDocumento")
    private String tipoDeDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pasajero")
    private Collection<Reserva> reservaCollection;

    public Pasajero() {
    }

    public Pasajero(Long cedula) {
        this.cedula = cedula;
    }

    public Pasajero(Long cedula, String nombre, String tipoDeDocumento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasajero)) {
            return false;
        }
        Pasajero other = (Pasajero) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }
    
    public boolean equals2(Pasajero pasajero){
        if(this.cedula == pasajero.getCedula() && this.nombre.equals(pasajero.getNombre()) && this.tipoDeDocumento.equals(pasajero.getTipoDeDocumento())) return true;
        else{return false;}
    }

    @Override
    public String toString() {
        return "modelo.Pasajero[ cedula=" + cedula + " ]";
    }
    
}
