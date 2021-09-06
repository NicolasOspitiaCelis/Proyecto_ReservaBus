/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nicolas Ospitia
 */
@Entity
@Table(name = "turnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turnos.findAll", query = "SELECT t FROM Turnos t")
    , @NamedQuery(name = "Turnos.findByAutobusIdautobus", query = "SELECT t FROM Turnos t WHERE t.turnosPK.autobusIdautobus = :autobusIdautobus")
    , @NamedQuery(name = "Turnos.findByEmpleadoIdempleado", query = "SELECT t FROM Turnos t WHERE t.turnosPK.empleadoIdempleado = :empleadoIdempleado")
    , @NamedQuery(name = "Turnos.findByEmpleadoCedulaEmpleado", query = "SELECT t FROM Turnos t WHERE t.turnosPK.empleadoCedulaEmpleado = :empleadoCedulaEmpleado")
    , @NamedQuery(name = "Turnos.findByFechaTurno", query = "SELECT t FROM Turnos t WHERE t.fechaTurno = :fechaTurno")})
public class Turnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnosPK turnosPK;
    @Basic(optional = false)
    @Column(name = "FechaTurno")
    @Temporal(TemporalType.DATE)
    private Date fechaTurno;
    @JoinColumn(name = "autobus_idautobus", referencedColumnName = "idautobus", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autobus autobus;
    @JoinColumns({
        @JoinColumn(name = "empleado_idempleado", referencedColumnName = "idempleado", insertable = false, updatable = false)
        , @JoinColumn(name = "empleado_CedulaEmpleado", referencedColumnName = "CedulaEmpleado", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Turnos() {
    }

    public Turnos(TurnosPK turnosPK) {
        this.turnosPK = turnosPK;
    }

    public Turnos(TurnosPK turnosPK, Date fechaTurno) {
        this.turnosPK = turnosPK;
        this.fechaTurno = fechaTurno;
    }

    public Turnos(int autobusIdautobus, String empleadoIdempleado, long empleadoCedulaEmpleado) {
        this.turnosPK = new TurnosPK(autobusIdautobus, empleadoIdempleado, empleadoCedulaEmpleado);
    }

    public TurnosPK getTurnosPK() {
        return turnosPK;
    }

    public void setTurnosPK(TurnosPK turnosPK) {
        this.turnosPK = turnosPK;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turnosPK != null ? turnosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnos)) {
            return false;
        }
        Turnos other = (Turnos) object;
        if ((this.turnosPK == null && other.turnosPK != null) || (this.turnosPK != null && !this.turnosPK.equals(other.turnosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Turnos[ turnosPK=" + turnosPK + " ]";
    }
    
}
