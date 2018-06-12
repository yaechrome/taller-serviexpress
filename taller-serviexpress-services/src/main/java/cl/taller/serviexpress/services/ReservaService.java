/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.services;

import cl.taller.serviexpress.domain.Reserva;

/**
 *
 * @author CETECOM
 */
public interface ReservaService {
    boolean crearReseva(Reserva reserva);
    boolean modificarReserva(Reserva reserva);
    boolean eliminarReserva(long idReserva);
    List<Reserva> buscarPorCliente(long idCliente);
}
