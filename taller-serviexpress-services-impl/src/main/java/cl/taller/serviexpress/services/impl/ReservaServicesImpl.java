/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.ReservaDao;
import cl.taller.serviexpress.domain.Reserva;
import cl.taller.serviexpress.services.ReservaServices;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ReservaServicesImpl implements ReservaServices{

	@Autowired
	private ReservaDao reservaDao;

    /**
     * @param servicio the servicioDao to set
     */
    public void setReservaDao(ReservaDao reserva) {
        this.reservaDao = reserva;
    }

    @Transactional
	@Override
	public boolean crearReseva(Reserva reserva) {
    	return reservaDao.createReserva(reserva);
	}
    @Transactional
	@Override
	public boolean modificarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return false;
	}
    @Transactional
	@Override
	public boolean eliminarReserva(long idReserva) {
		// TODO Auto-generated method stub
		return false;
	}
    @Transactional
	@Override
	public List<Reserva> buscarPorIdCliente(long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}
    @Transactional
	@Override
	public List<Reserva> listarServicios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> buscarPorIdReserva(long idReserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> buscarPorFecha(Date fechaInicio, Date fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}
    

}
