package cl.taller.serviexpress.services;

import cl.taller.serviexpress.domain.Reserva;
import java.util.Date;
import java.util.List;

public interface ReservaServices {

    boolean crearReseva(Reserva reserva);
    boolean modificarReserva(Reserva reserva);
    boolean eliminarReserva(long idReserva);
    List<Reserva> buscarPorIdCliente(long idCliente);
    List<Reserva> listarServicios();
    List<Reserva> buscarPorIdReserva(long idReserva);
    List<Reserva> buscarPorFecha(Date fechaInicio, Date fechaFin);
    
}
