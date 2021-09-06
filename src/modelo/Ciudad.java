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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NombreCiudad")
    private String nombreCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private Collection<Rutas> rutasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad1")
    private Collection<Rutas> rutasCollection1;

    public Ciudad() {
    }

    public Ciudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public Collection<Rutas> getRutasCollection() {
        return rutasCollection;
    }

    public void setRutasCollection(Collection<Rutas> rutasCollection) {
        this.rutasCollection = rutasCollection;
    }

    @XmlTransient
    public Collection<Rutas> getRutasCollection1() {
        return rutasCollection1;
    }

    public void setRutasCollection1(Collection<Rutas> rutasCollection1) {
        this.rutasCollection1 = rutasCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreCiudad != null ? nombreCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.nombreCiudad == null && other.nombreCiudad != null) || (this.nombreCiudad != null && !this.nombreCiudad.equals(other.nombreCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ciudad[ nombreCiudad=" + nombreCiudad + " ]";
    }
    
}
