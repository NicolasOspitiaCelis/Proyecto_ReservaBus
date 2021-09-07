/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.reservaPK.idreserva = :idreserva")
    , @NamedQuery(name = "Reserva.findByTipoDePago", query = "SELECT r FROM Reserva r WHERE r.tipoDePago = :tipoDePago")
    , @NamedQuery(name = "Reserva.findByPuesto", query = "SELECT r FROM Reserva r WHERE r.puesto = :puesto")
    , @NamedQuery(name = "Reserva.findByFechaViaje", query = "SELECT r FROM Reserva r WHERE r.fechaViaje = :fechaViaje")
    , @NamedQuery(name = "Reserva.findByHoraSalida", query = "SELECT r FROM Reserva r WHERE r.horaSalida = :horaSalida")
    , @NamedQuery(name = "Reserva.findByPrecio", query = "SELECT r FROM Reserva r WHERE r.precio = :precio")
    , @NamedQuery(name = "Reserva.findByPasajeroCedula", query = "SELECT r FROM Reserva r WHERE r.reservaPK.pasajeroCedula = :pasajeroCedula")
    , @NamedQuery(name = "Reserva.findByCiudadOrigen", query = "SELECT r FROM Reserva r WHERE r.reservaPK.ciudadOrigen = :ciudadOrigen")
    , @NamedQuery(name = "Reserva.findByCiudadDestino", query = "SELECT r FROM Reserva r WHERE r.reservaPK.ciudadDestino = :ciudadDestino")
    , @NamedQuery(name = "Reserva.findByAutobusidautobus", query = "SELECT r FROM Reserva r WHERE r.reservaPK.autobusidautobus = :autobusidautobus")
    , @NamedQuery(name = "Reserva.findByIdrutas", query = "SELECT r FROM Reserva r WHERE r.reservaPK.idrutas = :idrutas")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservaPK reservaPK;
    @Basic(optional = false)
    @Column(name = "TipoDePago")
    private String tipoDePago;
    @Basic(optional = false)
    @Column(name = "Puesto")
    private int puesto;
    @Basic(optional = false)
    @Column(name = "FechaViaje")
    @Temporal(TemporalType.DATE)
    private Date fechaViaje;
    @Basic(optional = false)
    @Column(name = "HoraSalida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Basic(optional = false)
    @Column(name = "Precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<Equipaje> equipajeCollection;
    @JoinColumn(name = "Pasajero_Cedula", referencedColumnName = "Cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pasajero pasajero;
    @JoinColumns({
        @JoinColumn(name = "idrutas", referencedColumnName = "idrutas", insertable = false, updatable = false)
        , @JoinColumn(name = "CiudadOrigen", referencedColumnName = "CiudadOrigen", insertable = false, updatable = false)
        , @JoinColumn(name = "CiudadDestino", referencedColumnName = "CiudadDestino", insertable = false, updatable = false)
        , @JoinColumn(name = "Autobus_idautobus", referencedColumnName = "Autobus_idautobus", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Rutas rutas;

    public Reserva() {
    }

    public Reserva(ReservaPK reservaPK) {
        this.reservaPK = reservaPK;
    }

    public Reserva(ReservaPK reservaPK, String tipoDePago, int puesto, Date fechaViaje, Date horaSalida, int precio) {
        this.reservaPK = reservaPK;
        this.tipoDePago = tipoDePago;
        this.puesto = puesto;
        this.fechaViaje = fechaViaje;
        this.horaSalida = horaSalida;
        this.precio = precio;
    }

    public Reserva(String idreserva, long pasajeroCedula, String ciudadOrigen, String ciudadDestino, int autobusidautobus, int idrutas) {
        this.reservaPK = new ReservaPK(idreserva, pasajeroCedula, ciudadOrigen, ciudadDestino, autobusidautobus, idrutas);
    }

    public ReservaPK getReservaPK() {
        return reservaPK;
    }

    public void setReservaPK(ReservaPK reservaPK) {
        this.reservaPK = reservaPK;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Equipaje> getEquipajeCollection() {
        return equipajeCollection;
    }

    public void setEquipajeCollection(Collection<Equipaje> equipajeCollection) {
        this.equipajeCollection = equipajeCollection;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Rutas getRutas() {
        return rutas;
    }

    public void setRutas(Rutas rutas) {
        this.rutas = rutas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservaPK != null ? reservaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.reservaPK == null && other.reservaPK != null) || (this.reservaPK != null && !this.reservaPK.equals(other.reservaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Reserva[ reservaPK=" + reservaPK + " ]";
    }
    public void setPuesto(List <Reserva> reservas, List <Autobus> autobuses){
        int contador = 0;
        int sillas = 0;
        for(Reserva r : reservas){
            if(r.getReservaPK().getCiudadOrigen().equals(this.getReservaPK().getCiudadOrigen()) && r.getReservaPK().getCiudadDestino().equals(this.getReservaPK().getCiudadDestino()) && r.getReservaPK().getAutobusidautobus() == this.getReservaPK().getAutobusidautobus() && r.getFechaViaje().toString().equals(this.getFechaViaje().toString()) && r.getHoraSalida().toString().equals(this.getHoraSalida().toString())){
                contador++;
            }
        }
        for(Autobus a : autobuses){
            if(this.getReservaPK().getAutobusidautobus() == a.getIdautobus()) sillas = a.getNumeroDeSillas();
        }
        this.setPuesto(sillas - (sillas - contador) + 1);
    }
    public void setPrecioAndIdruta(List <Rutas> rutas){
        for(Rutas r : rutas){
            if(r.getRutasPK().getCiudadOrigen().equals(this.getReservaPK().getCiudadOrigen()) && r.getRutasPK().getCiudadDestino().equals(this.getReservaPK().getCiudadDestino())) this.setPrecio(r.getPrecio());
            if(r.getRutasPK().getCiudadOrigen().equals(this.getReservaPK().getCiudadOrigen()) && r.getRutasPK().getCiudadDestino().equals(this.getReservaPK().getCiudadDestino()) && r.getRutasPK().getAutobusidautobus() == this.getReservaPK().getAutobusidautobus() && r.getFechaViaje().toString().equals(this.getFechaViaje().toString()) && r.getHoraViaje().toString().equals(this.getHoraSalida().toString())) this.getReservaPK().setIdrutas(r.getRutasPK().getIdrutas());
        }
    }
}
