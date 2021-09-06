/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nicolas Ospitia
 */
@Entity
@Table(name = "equipaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipaje.findAll", query = "SELECT e FROM Equipaje e")
    , @NamedQuery(name = "Equipaje.findByIdequipaje", query = "SELECT e FROM Equipaje e WHERE e.equipajePK.idequipaje = :idequipaje")
    , @NamedQuery(name = "Equipaje.findByPeso", query = "SELECT e FROM Equipaje e WHERE e.peso = :peso")
    , @NamedQuery(name = "Equipaje.findByTipoDeEquipaje", query = "SELECT e FROM Equipaje e WHERE e.tipoDeEquipaje = :tipoDeEquipaje")
    , @NamedQuery(name = "Equipaje.findByEstado", query = "SELECT e FROM Equipaje e WHERE e.estado = :estado")
    , @NamedQuery(name = "Equipaje.findByReservaidreserva", query = "SELECT e FROM Equipaje e WHERE e.equipajePK.reservaidreserva = :reservaidreserva")
    , @NamedQuery(name = "Equipaje.findByReservaPasajeroCedula", query = "SELECT e FROM Equipaje e WHERE e.equipajePK.reservaPasajeroCedula = :reservaPasajeroCedula")
    , @NamedQuery(name = "Equipaje.findByReservaCiudadOrigen", query = "SELECT e FROM Equipaje e WHERE e.equipajePK.reservaCiudadOrigen = :reservaCiudadOrigen")
    , @NamedQuery(name = "Equipaje.findByReservaCiudadDestino", query = "SELECT e FROM Equipaje e WHERE e.equipajePK.reservaCiudadDestino = :reservaCiudadDestino")
    , @NamedQuery(name = "Equipaje.findByReservaAutobusidautobus", query = "SELECT e FROM Equipaje e WHERE e.equipajePK.reservaAutobusidautobus = :reservaAutobusidautobus")
    , @NamedQuery(name = "Equipaje.findByReservaidrutas", query = "SELECT e FROM Equipaje e WHERE e.equipajePK.reservaidrutas = :reservaidrutas")})
public class Equipaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipajePK equipajePK;
    @Basic(optional = false)
    @Column(name = "Peso")
    private int peso;
    @Basic(optional = false)
    @Column(name = "TipoDeEquipaje")
    private String tipoDeEquipaje;
    @Basic(optional = false)
    @Column(name = "Estado")
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "Reserva_idreserva", referencedColumnName = "idreserva", insertable = false, updatable = false)
        , @JoinColumn(name = "Reserva_Pasajero_Cedula", referencedColumnName = "Pasajero_Cedula", insertable = false, updatable = false)
        , @JoinColumn(name = "Reserva_CiudadOrigen", referencedColumnName = "CiudadOrigen", insertable = false, updatable = false)
        , @JoinColumn(name = "Reserva_CiudadDestino", referencedColumnName = "CiudadDestino", insertable = false, updatable = false)
        , @JoinColumn(name = "Reserva_Autobus_idautobus", referencedColumnName = "Autobus_idautobus", insertable = false, updatable = false)
        , @JoinColumn(name = "Reserva_idrutas", referencedColumnName = "idrutas", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Reserva reserva;

    public Equipaje() {
    }

    public Equipaje(EquipajePK equipajePK) {
        this.equipajePK = equipajePK;
    }

    public Equipaje(EquipajePK equipajePK, int peso, String tipoDeEquipaje, String estado) {
        this.equipajePK = equipajePK;
        this.peso = peso;
        this.tipoDeEquipaje = tipoDeEquipaje;
        this.estado = estado;
    }

    public Equipaje(String idequipaje, String reservaidreserva, long reservaPasajeroCedula, String reservaCiudadOrigen, String reservaCiudadDestino, int reservaAutobusidautobus, int reservaidrutas) {
        this.equipajePK = new EquipajePK(idequipaje, reservaidreserva, reservaPasajeroCedula, reservaCiudadOrigen, reservaCiudadDestino, reservaAutobusidautobus, reservaidrutas);
    }

    public EquipajePK getEquipajePK() {
        return equipajePK;
    }

    public void setEquipajePK(EquipajePK equipajePK) {
        this.equipajePK = equipajePK;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTipoDeEquipaje() {
        return tipoDeEquipaje;
    }

    public void setTipoDeEquipaje(String tipoDeEquipaje) {
        this.tipoDeEquipaje = tipoDeEquipaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipajePK != null ? equipajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipaje)) {
            return false;
        }
        Equipaje other = (Equipaje) object;
        if ((this.equipajePK == null && other.equipajePK != null) || (this.equipajePK != null && !this.equipajePK.equals(other.equipajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Equipaje[ equipajePK=" + equipajePK + " ]";
    }
    
}
