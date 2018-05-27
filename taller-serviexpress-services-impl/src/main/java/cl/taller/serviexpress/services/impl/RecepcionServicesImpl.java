/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.Recepcion;
import cl.taller.serviexpress.domain.RecepcionProducto;
import cl.taller.serviexpress.services.RecepcionServices;
import cl.taller.serviexpress.dao.hibernate.RecepcionDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.RecepcionProductoDaoHibernate;
import java.util.List;

public class RecepcionServicesImpl implements RecepcionServices{

    @Override
    public boolean crearRecepcion(Recepcion recepcion) {
        RecepcionDaoHibernate dao = new RecepcionDaoHibernate();
        return dao.createRecepcion(recepcion);
        
    }

    @Override
    public boolean modificarRecepcion(Recepcion recepcion) {
       RecepcionDaoHibernate dao = new RecepcionDaoHibernate();
        return dao.updateRecepcion(recepcion);

    }

    @Override
    public Recepcion buscarRecepcionPorId(long idRecepcion) {
        RecepcionDaoHibernate dao = new RecepcionDaoHibernate();
        return dao.findByIdRecepcion(idRecepcion);
    }

    @Override
    public List<Recepcion> listarRecepciones() {
        RecepcionDaoHibernate dao = new RecepcionDaoHibernate();
        return dao.findAllActive();
    }

    @Override
    public List<Recepcion> listarRecepcionPorOrden(long idOrden) {
        RecepcionDaoHibernate dao = new RecepcionDaoHibernate();
        return dao.findByOrden(idOrden);
    }

    @Override
    public boolean crearRecepcionProducto(RecepcionProducto recepcionProducto) {
        RecepcionProductoDaoHibernate dao = new RecepcionProductoDaoHibernate();
        return dao.createRecepcionProducto(recepcionProducto);
    }

    @Override
    public boolean modificarRecepcionProducto(RecepcionProducto recepcionProducto) {
        RecepcionProductoDaoHibernate dao = new RecepcionProductoDaoHibernate();
        return dao.updateRecepcionProducto(recepcionProducto);
    }

    @Override
    public List<RecepcionProducto> buscarRecepcionesProductosPorIdRecepcion(long idRecepcion) {
        RecepcionProductoDaoHibernate dao = new RecepcionProductoDaoHibernate();
        return dao.findByRecepcion(idRecepcion);
    }
    
}
