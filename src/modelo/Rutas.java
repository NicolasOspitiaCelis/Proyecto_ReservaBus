/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nicolas Ospitia
 */
@Entity
@Table(name = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r")
    , @NamedQuery(name = "Rutas.findByIdrutas", query = "SELECT r FROM Rutas r WHERE r.rutasPK.idrutas = :idrutas")
    , @NamedQuery(name = "Rutas.findByCiudadOrigen", query = "SELECT r FROM Rutas r WHERE r.rutasPK.ciudadOrigen = :ciudadOrigen")
    , @NamedQuery(name = "Rutas.findByCiudadDestino", query = "SELECT r FROM Rutas r WHERE r.rutasPK.ciudadDestino = :ciudadDestino")
    , @NamedQuery(name = "Rutas.findByAutobusidautobus", query = "SELECT r FROM Rutas r WHERE r.rutasPK.autobusidautobus = :autobusidautobus")
    , @NamedQuery(name = "Rutas.findByFechaViaje", query = "SELECT r FROM Rutas r WHERE r.fechaViaje = :fechaViaje")
    , @NamedQuery(name = "Rutas.findByHoraViaje", query = "SELECT r FROM Rutas r WHERE r.horaViaje = :horaViaje")
    , @NamedQuery(name = "Rutas.findByPrecio", query = "SELECT r FROM Rutas r WHERE r.precio = :precio")
    , @NamedQuery(name = "Rutas.findBySillasDisponibles", query = "SELECT r FROM Rutas r WHERE r.sillasDisponibles = :sillasDisponibles")})
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RutasPK rutasPK;
    @Basic(optional = false)
    @Column(name = "FechaViaje")
    @Temporal(TemporalType.DATE)
    private Date fechaViaje;
    @Basic(optional = false)
    @Column(name = "HoraViaje")
    @Temporal(TemporalType.TIME)
    private Date horaViaje;
    @Basic(optional = false)
    @Column(name = "Precio")
    private int precio;
    @Basic(optional = false)
    @Column(name = "SillasDisponibles")
    private int sillasDisponibles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutas")
    private Collection<Reserva> reservaCollection;
    @JoinColumn(name = "Autobus_idautobus", referencedColumnName = "idautobus", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autobus autobus;
    @JoinColumn(name = "CiudadOrigen", referencedColumnName = "NombreCiudad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @JoinColumn(name = "CiudadDestino", referencedColumnName = "NombreCiudad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudad ciudad1;

    public Rutas() {
    }

    public Rutas(RutasPK rutasPK) {
        this.rutasPK = rutasPK;
    }

    public Rutas(RutasPK rutasPK, Date fechaViaje, Date horaViaje, int precio, int sillasDisponibles) {
        this.rutasPK = rutasPK;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.precio = precio;
        this.sillasDisponibles = sillasDisponibles;
    }

    public Rutas(int idrutas, String ciudadOrigen, String ciudadDestino, int autobusidautobus) {
        this.rutasPK = new RutasPK(idrutas, ciudadOrigen, ciudadDestino, autobusidautobus);
    }

    public RutasPK getRutasPK() {
        return rutasPK;
    }

    public void setRutasPK(RutasPK rutasPK) {
        this.rutasPK = rutasPK;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public Date getHoraViaje() {
        return horaViaje;
    }

    public void setHoraViaje(Date horaViaje) {
        this.horaViaje = horaViaje;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getSillasDisponibles() {
        return sillasDisponibles;
    }

    public void setSillasDisponibles(int sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad1() {
        return ciudad1;
    }

    public void setCiudad1(Ciudad ciudad1) {
        this.ciudad1 = ciudad1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutasPK != null ? rutasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.rutasPK == null && other.rutasPK != null) || (this.rutasPK != null && !this.rutasPK.equals(other.rutasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Rutas[ rutasPK=" + rutasPK + " ]";
    }
    
}
