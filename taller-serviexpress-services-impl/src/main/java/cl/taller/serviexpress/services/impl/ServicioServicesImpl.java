/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.ServicioDao;
import cl.taller.serviexpress.domain.Servicio;
import cl.taller.serviexpress.services.ServicioServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ServicioServicesImpl implements ServicioServices{

	@Autowired
	private ServicioDao servicioDao;

    /**
     * @param servicio the servicioDao to set
     */
    public void setServicioDao(ServicioDao servicio) {
        this.servicioDao = servicio;
    }
    
    @Transactional
    @Override
    public boolean crearServicio(Servicio servicio) {
        return servicioDao.createServicio(servicio);
    }

    @Transactional
    @Override
    public List<Servicio> listarServicios() {
        return servicioDao.findAllActive();
    }

    @Transactional
    @Override
    public boolean modificarServicio(Servicio servicio) {
        return servicioDao.updateServicio(servicio);
    }
    
    @Transactional
    @Override
    public Servicio buscarPorId(long id) {
        return servicioDao.findByIdServicio(id);
    }
}
