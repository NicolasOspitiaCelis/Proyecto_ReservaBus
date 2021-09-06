package vista;

import java.util.Date;
import java.util.List;
import modelo.Autobus;
import modelo.Reserva;
import modelo.ReservaPK;
import modelo.Rutas;
import static vista.PrincipalFrame.reservas;

public class Reservador {
    
    private String idreserva;
    private long pasajeroCedula;
    private String ciudadOrigen;
    private String ciudadDestino;
    private int autobusidautobus;
    private int idrutas;
    private String tipoDePago;
    private int puesto;
    private Date fechaViaje;
    private Date horaSalida;
    private int precio;
    private Reserva reserva;
    private ReservaPK reservaPK;
    
    public Reservador(String idreserva, long cedula, String ciudadOrigen, String ciudadDestino, String tipoDePago, Date fechaViaje, Date horaViaje, int idautobus){
        this.tipoDePago = tipoDePago;
        this. fechaViaje = fechaViaje;
        this.horaSalida = horaViaje;
        this.idreserva = idreserva;
        pasajeroCedula = cedula;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.tipoDePago = tipoDePago;
        this.fechaViaje = fechaViaje;
        this.horaSalida = horaViaje;
        autobusidautobus = idautobus;
    }
    public void setPuesto(List <Reserva> reservas, List <Autobus> autobuses){
        int contador = 0;
        int sillas = 0;
        for(Reserva r : reservas){
            if(r.getReservaPK().getCiudadOrigen().equals(ciudadOrigen) && r.getReservaPK().getCiudadDestino().equals(ciudadDestino) && r.getReservaPK().getAutobusidautobus() == autobusidautobus && r.getFechaViaje().toString().equals(fechaViaje.toString()) && r.getHoraSalida().toString().equals(horaSalida.toString())){
                contador++;
            }
        }
        for(Autobus a : autobuses){
            if(autobusidautobus == a.getIdautobus()) sillas = a.getNumeroDeSillas();
        }
        this.puesto = sillas - (sillas - contador) + 1;
    }
    public void setPrecioAndIdruta(List <Rutas> rutas){
        for(Rutas r : rutas){
            if(r.getRutasPK().getCiudadOrigen().equals(ciudadOrigen) && r.getRutasPK().getCiudadDestino().equals(ciudadDestino)) precio = r.getPrecio();
            if(r.getRutasPK().getCiudadOrigen().equals(ciudadOrigen) && r.getRutasPK().getCiudadDestino().equals(ciudadDestino) && r.getRutasPK().getAutobusidautobus() == autobusidautobus && r.getFechaViaje().toString().equals(fechaViaje.toString()) && r.getHoraViaje().toString().equals(horaSalida.toString())) idrutas = r.getRutasPK().getIdrutas();
        }
    }
    public Reserva getReserva(){
        reservaPK = new ReservaPK(idreserva, pasajeroCedula, ciudadOrigen, ciudadDestino, autobusidautobus, idrutas);
        reserva = new Reserva(reservaPK, tipoDePago, puesto, fechaViaje, horaSalida, precio);
        return reserva;
    }
    
}
