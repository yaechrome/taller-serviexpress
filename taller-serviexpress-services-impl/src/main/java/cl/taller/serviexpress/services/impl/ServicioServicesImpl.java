/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.ServicioDao;
import cl.taller.serviexpress.domain.Servicio;
import cl.taller.serviexpress.dao.hibernate.ServicioDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.UsuarioDaoHibernate;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.services.ServicioServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicioServicesImpl implements ServicioServices{

    private ServicioDao servicioDao;

    @Autowired
    private ServicioServices servicioServices;

    /**
     * @param servicio the servicioDao to set
     */
    public void setServicioDao(ServicioDao servicio) {
        this.servicioDao = servicio;
    }
    
    @Override
    public boolean crearServicio(Servicio servicio) {
        return servicioDao.createServicio(servicio);
    }

    @Override
    public List<Servicio> listarServicios() {
        return servicioDao.findAllActive();
    }

    @Override
    public boolean modificarServicio(Servicio servicio) {
        return servicioDao.updateServicio(servicio);
    }

    @Override
    public Servicio buscarPorId(long id) {
        return servicioDao.findByIdServicio(id);
    }
}
