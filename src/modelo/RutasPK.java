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
public class RutasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idrutas")
    private int idrutas;
    @Basic(optional = false)
    @Column(name = "CiudadOrigen")
    private String ciudadOrigen;
    @Basic(optional = false)
    @Column(name = "CiudadDestino")
    private String ciudadDestino;
    @Basic(optional = false)
    @Column(name = "Autobus_idautobus")
    private int autobusidautobus;

    public RutasPK() {
    }

    public RutasPK(int idrutas, String ciudadOrigen, String ciudadDestino, int autobusidautobus) {
        this.idrutas = idrutas;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.autobusidautobus = autobusidautobus;
    }

    public int getIdrutas() {
        return idrutas;
    }

    public void setIdrutas(int idrutas) {
        this.idrutas = idrutas;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idrutas;
        hash += (ciudadOrigen != null ? ciudadOrigen.hashCode() : 0);
        hash += (ciudadDestino != null ? ciudadDestino.hashCode() : 0);
        hash += (int) autobusidautobus;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutasPK)) {
            return false;
        }
        RutasPK other = (RutasPK) object;
        if (this.idrutas != other.idrutas) {
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
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RutasPK[ idrutas=" + idrutas + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + ", autobusidautobus=" + autobusidautobus + " ]";
    }
    
}
