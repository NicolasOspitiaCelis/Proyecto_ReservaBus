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
public class ReservaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idreserva")
    private String idreserva;
    @Basic(optional = false)
    @Column(name = "Pasajero_Cedula")
    private long pasajeroCedula;
    @Basic(optional = false)
    @Column(name = "CiudadOrigen")
    private String ciudadOrigen;
    @Basic(optional = false)
    @Column(name = "CiudadDestino")
    private String ciudadDestino;
    @Basic(optional = false)
    @Column(name = "Autobus_idautobus")
    private int autobusidautobus;
    @Basic(optional = false)
    @Column(name = "idrutas")
    private int idrutas;

    public ReservaPK() {
    }

    public ReservaPK(String idreserva, long pasajeroCedula, String ciudadOrigen, String ciudadDestino, int autobusidautobus, int idrutas) {
        this.idreserva = idreserva;
        this.pasajeroCedula = pasajeroCedula;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.autobusidautobus = autobusidautobus;
        this.idrutas = idrutas;
    }

    public String getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(String idreserva) {
        this.idreserva = idreserva;
    }

    public long getPasajeroCedula() {
        return pasajeroCedula;
    }

    public void setPasajeroCedula(long pasajeroCedula) {
        this.pasajeroCedula = pasajeroCedula;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public int getAutobusidautobus() {
        return autobusidautobus;
    }

    public void setAutobusidautobus(int autobusidautobus) {
        this.autobusidautobus = autobusidautobus;
    }

    public int getIdrutas() {
        return idrutas;
    }

    public void setIdrutas(int idrutas) {
        this.idrutas = idrutas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        hash += (int) pasajeroCedula;
        hash += (ciudadOrigen != null ? ciudadOrigen.hashCode() : 0);
        hash += (ciudadDestino != null ? ciudadDestino.hashCode() : 0);
        hash += (int) autobusidautobus;
        hash += (int) idrutas;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaPK)) {
            return false;
        }
        ReservaPK other = (ReservaPK) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        if (this.pasajeroCedula != other.pasajeroCedula) {
            return false;
        }
        if ((this.ciudadOrigen == null && other.ciudadOrigen != null) || (this.ciudadOrigen != null && !this.ciudadOrigen.equals(other.ciudadOrigen))) {
            return false;
        }
        if ((this.ciudadDestino == null && other.ciudadDestino != null) || (this.ciudadDestino != null && !this.ciudadDestino.equals(other.ciudadDestino))) {
            return false;
        }
        if (this.autobusidautobus != other.autobusidautobus) {
            return false;
        }
        if (this.idrutas != other.idrutas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ReservaPK[ idreserva=" + idreserva + ", pasajeroCedula=" + pasajeroCedula + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + ", autobusidautobus=" + autobusidautobus + ", idrutas=" + idrutas + " ]";
    }
    
}
