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
public class TurnosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "autobus_idautobus")
    private int autobusIdautobus;
    @Basic(optional = false)
    @Column(name = "empleado_idempleado")
    private String empleadoIdempleado;
    @Basic(optional = false)
    @Column(name = "empleado_CedulaEmpleado")
    private long empleadoCedulaEmpleado;

    public TurnosPK() {
    }

    public TurnosPK(int autobusIdautobus, String empleadoIdempleado, long empleadoCedulaEmpleado) {
        this.autobusIdautobus = autobusIdautobus;
        this.empleadoIdempleado = empleadoIdempleado;
        this.empleadoCedulaEmpleado = empleadoCedulaEmpleado;
    }

    public int getAutobusIdautobus() {
        return autobusIdautobus;
    }

    public void setAutobusIdautobus(int autobusIdautobus) {
        this.autobusIdautobus = autobusIdautobus;
    }

    public String getEmpleadoIdempleado() {
        return empleadoIdempleado;
    }

    public void setEmpleadoIdempleado(String empleadoIdempleado) {
        this.empleadoIdempleado = empleadoIdempleado;
    }

    public long getEmpleadoCedulaEmpleado() {
        return empleadoCedulaEmpleado;
    }

    public void setEmpleadoCedulaEmpleado(long empleadoCedulaEmpleado) {
        this.empleadoCedulaEmpleado = empleadoCedulaEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) autobusIdautobus;
        hash += (empleadoIdempleado != null ? empleadoIdempleado.hashCode() : 0);
        hash += (int) empleadoCedulaEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosPK)) {
            return false;
        }
        TurnosPK other = (TurnosPK) object;
        if (this.autobusIdautobus != other.autobusIdautobus) {
            return false;
        }
        if ((this.empleadoIdempleado == null && other.empleadoIdempleado != null) || (this.empleadoIdempleado != null && !this.empleadoIdempleado.equals(other.empleadoIdempleado))) {
            return false;
        }
        if (this.empleadoCedulaEmpleado != other.empleadoCedulaEmpleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TurnosPK[ autobusIdautobus=" + autobusIdautobus + ", empleadoIdempleado=" + empleadoIdempleado + ", empleadoCedulaEmpleado=" + empleadoCedulaEmpleado + " ]";
    }
    
}
