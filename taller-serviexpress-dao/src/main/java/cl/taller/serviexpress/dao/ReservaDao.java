package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.Reserva;
import java.util.List;

public interface ReservaDao {

    Reserva findByIdReserva(long idReserva);

    List<Reserva> findAll();

    List<Reserva> findByCliente(long idCliente);

    boolean createReserva(Reserva reserva);

    boolean updateReserva(Reserva reserva);
}
