package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.Reserva;
import java.util.Date;
import java.util.List;

public interface ReservaDao {

    Reserva findByIdReserva(long idReserva);

    List<Reserva> findAll();

    List<Reserva> findByCliente(long idCliente);

    List<Reserva> findByFecha(Date fecha);
    
    boolean createReserva(Reserva reserva);

    boolean updateReserva(Reserva reserva);
    
    boolean deleteReserva(Reserva reserva);
    
    
}
