/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.services;

import cl.taller.serviexpress.domain.Reserva;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CETECOM
 */
public interface ReservaServices {
    boolean crearReseva(Reserva reserva);
    boolean modificarReserva(Reserva reserva);
    boolean eliminarReserva(long idReserva);
    List<Reserva> buscarPorIdCliente(long idCliente);
    List<Reserva> listarServicios();
    List<Reserva> buscarPorIdReserva(long idReserva);
    List<Reserva> buscarPorFecha(Date fechaInicio,Date fechaFin);
    
}
