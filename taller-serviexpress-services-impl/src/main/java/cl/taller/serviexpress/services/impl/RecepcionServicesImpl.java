/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.RecepcionDao;
import cl.taller.serviexpress.dao.RecepcionProductoDao;
import cl.taller.serviexpress.domain.Recepcion;
import cl.taller.serviexpress.domain.RecepcionProducto;
import cl.taller.serviexpress.services.RecepcionServices;
import cl.taller.serviexpress.dao.hibernate.RecepcionDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.RecepcionProductoDaoHibernate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class RecepcionServicesImpl implements RecepcionServices{
    private RecepcionDao recepcionDao;

    @Autowired
    private RecepcionServices recepcionServices;

    /**
     * @param ordenDao the userDao to set
     */
    public void setRecepcionDao(RecepcionDao recepcion) {
        this.recepcionDao = recepcion;
    }
    
    private RecepcionProductoDao recepcionProductoDao;

   
    /**
     * @param ordenDao the userDao to set
     */
    public void setRecepcionProductoDao(RecepcionProductoDao recepcionProducto) {
        this.recepcionProductoDao = recepcionProducto;
    }

    @Override
    public boolean crearRecepcion(Recepcion recepcion) {
        return recepcionDao.createRecepcion(recepcion);
        
    }

    @Override
    public boolean modificarRecepcion(Recepcion recepcion) {
        return recepcionDao.updateRecepcion(recepcion);

    }

    @Override
    public Recepcion buscarRecepcionPorId(long idRecepcion) {
        return recepcionDao.findByIdRecepcion(idRecepcion);
    }

    @Override
    public List<Recepcion> listarRecepciones() {
        return recepcionDao.findAllActive();
    }

    @Override
    public List<Recepcion> listarRecepcionPorOrden(long idOrden) {
        return recepcionDao.findByOrden(idOrden);
    }

    @Override
    public boolean crearRecepcionProducto(RecepcionProducto recepcionProducto) {
        return recepcionProductoDao.createRecepcionProducto(recepcionProducto);
    }

    @Override
    public boolean modificarRecepcionProducto(RecepcionProducto recepcionProducto) {
        return recepcionProductoDao.updateRecepcionProducto(recepcionProducto);
    }

    @Override
    public List<RecepcionProducto> buscarRecepcionesProductosPorIdRecepcion(long idRecepcion) {
        return recepcionProductoDao.findByRecepcion(idRecepcion);
    }
    
}
