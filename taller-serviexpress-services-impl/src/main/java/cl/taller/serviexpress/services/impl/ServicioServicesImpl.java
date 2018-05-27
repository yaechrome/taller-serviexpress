/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.Servicio;
import cl.taller.serviexpress.dao.hibernate.ServicioDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.UsuarioDaoHibernate;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.services.ServicioServices;
import java.util.List;

public class ServicioServicesImpl implements ServicioServices{

    @Override
    public boolean crearServicio(Servicio servicio) {
        ServicioDaoHibernate udao = new ServicioDaoHibernate();
         
        return udao.createServicio(servicio);
    }

    @Override
    public List<Servicio> listarServicios() {
        ServicioDaoHibernate udao = new ServicioDaoHibernate();
        List<Servicio> lista = udao.findAllActive();
        return lista;
    }

    @Override
    public boolean modificarServicio(Servicio servicio) {
        ServicioDaoHibernate udao = new ServicioDaoHibernate();
         
        return udao.updateServicio(servicio);
    }

    @Override
    public Servicio buscarPorId(long id) {
        try {
            ServicioDaoHibernate udao = new ServicioDaoHibernate();
            Servicio servicio = new Servicio();

            servicio = udao.findByIdServicio(id);
            if(servicio!=null)
                return servicio;
            
        } catch (Exception e) {
            
        }
        return null; 
    }
    
}
