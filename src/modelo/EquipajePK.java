/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Nicolas Ospitia
 */
@Embeddable
public class EquipajePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idequipaje")
    private String idequipaje;
    @Basic(optional = false)
    @Column(name = "Reserva_idreserva")
    private String reservaidreserva;
    @Basic(optional = false)
    @Column(name = "Reserva_Pasajero_Cedula")
    private long reservaPasajeroCedula;
    @Basic(optional = false)
    @Column(name = "Reserva_CiudadOrigen")
    private String reservaCiudadOrigen;
    @Basic(optional = false)
    @Column(name = "Reserva_CiudadDestino")
    private String reservaCiudadDestino;
    @Basic(optional = false)
    @Column(name = "Reserva_Autobus_idautobus")
    private int reservaAutobusidautobus;
    @Basic(optional = false)
    @Column(name = "Reserva_idrutas")
    private int reservaidrutas;

    public EquipajePK() {
    }

    public EquipajePK(String idequipaje, String reservaidreserva, long reservaPasajeroCedula, String reservaCiudadOrigen, String reservaCiudadDestino, int reservaAutobusidautobus, int reservaidrutas) {
        this.idequipaje = idequipaje;
        this.reservaidreserva = reservaidreserva;
        this.reservaPasajeroCedula = reservaPasajeroCedula;
        this.reservaCiudadOrigen = reservaCiudadOrigen;
        this.reservaCiudadDestino = reservaCiudadDestino;
        this.reservaAutobusidautobus = reservaAutobusidautobus;
        this.reservaidrutas = reservaidrutas;
    }

    public String getIdequipaje() {
        return idequipaje;
    }

    public void setIdequipaje(String idequipaje) {
        this.idequipaje = idequipaje;
    }

    public String getReservaidreserva() {
        return reservaidreserva;
    }

    public void setReservaidreserva(String reservaidreserva) {
        this.reservaidreserva = reservaidreserva;
    }

    public long getReservaPasajeroCedula() {
        return reservaPasajeroCedula;
    }

    public void setReservaPasajeroCedula(long reservaPasajeroCedula) {
        this.reservaPasajeroCedula = reservaPasajeroCedula;
    }

    public String getReservaCiudadOrigen() {
        return reservaCiudadOrigen;
    }

    public void setReservaCiudadOrigen(String reservaCiudadOrigen) {
        this.reservaCiudadOrigen = reservaCiudadOrigen;
    }

    public String getReservaCiudadDestino() {
        return reservaCiudadDestino;
    }

    public void setReservaCiudadDestino(String reservaCiudadDestino) {
        this.reservaCiudadDestino = reservaCiudadDestino;
    }

    public int getReservaAutobusidautobus() {
        return reservaAutobusidautobus;
    }

    public void setReservaAutobusidautobus(int reservaAutobusidautobus) {
        this.reservaAutobusidautobus = reservaAutobusidautobus;
    }

    public int getReservaidrutas() {
        return reservaidrutas;
    }

    public void setReservaidrutas(int reservaidrutas) {
        this.reservaidrutas = reservaidrutas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipaje != null ? idequipaje.hashCode() : 0);
        hash += (reservaidreserva != null ? reservaidreserva.hashCode() : 0);
        hash += (int) reservaPasajeroCedula;
        hash += (reservaCiudadOrigen != null ? reservaCiudadOrigen.hashCode() : 0);
        hash += (reservaCiudadDestino != null ? reservaCiudadDestino.hashCode() : 0);
        hash += (int) reservaAutobusidautobus;
        hash += (int) reservaidrutas;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipajePK)) {
            return false;
        }
        EquipajePK other = (EquipajePK) object;
        if ((this.idequipaje == null && other.idequipaje != null) || (this.idequipaje != null && !this.idequipaje.equals(other.idequipaje))) {
            return false;
        }
        if ((this.reservaidreserva == null && other.reservaidreserva != null) || (this.reservaidreserva != null && !this.reservaidreserva.equals(other.reservaidreserva))) {
            return false;
        }
        if (this.reservaPasajeroCedula != other.reservaPasajeroCedula) {
            return false;
        }
        if ((this.reservaCiudadOrigen == null && other.reservaCiudadOrigen != null) || (this.reservaCiudadOrigen != null && !this.reservaCiudadOrigen.equals(other.reservaCiudadOrigen))) {
            return false;
        }
        if ((this.reservaCiudadDestino == null && other.reservaCiudadDestino != null) || (this.reservaCiudadDestino != null && !this.reservaCiudadDestino.equals(other.reservaCiudadDestino))) {
            return false;
        }
        if (this.reservaAutobusidautobus != other.reservaAutobusidautobus) {
            return false;
        }
        if (this.reservaidrutas != other.reservaidrutas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EquipajePK[ idequipaje=" + idequipaje + ", reservaidreserva=" + reservaidreserva + ", reservaPasajeroCedula=" + reservaPasajeroCedula + ", reservaCiudadOrigen=" + reservaCiudadOrigen + ", reservaCiudadDestino=" + reservaCiudadDestino + ", reservaAutobusidautobus=" + reservaAutobusidautobus + ", reservaidrutas=" + reservaidrutas + " ]";
    }
    
}
