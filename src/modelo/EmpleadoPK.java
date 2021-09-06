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
public class EmpleadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idempleado")
    private String idempleado;
    @Basic(optional = false)
    @Column(name = "CedulaEmpleado")
    private long cedulaEmpleado;

    public EmpleadoPK() {
    }

    public EmpleadoPK(String idempleado, long cedulaEmpleado) {
        this.idempleado = idempleado;
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public long getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(long cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        hash += (int) cedulaEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoPK)) {
            return false;
        }
        EmpleadoPK other = (EmpleadoPK) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        if (this.cedulaEmpleado != other.cedulaEmpleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EmpleadoPK[ idempleado=" + idempleado + ", cedulaEmpleado=" + cedulaEmpleado + " ]";
    }
    
}
