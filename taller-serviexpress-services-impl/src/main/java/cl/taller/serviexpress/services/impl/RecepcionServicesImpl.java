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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class RecepcionServicesImpl implements RecepcionServices{
    
	@Autowired
	private RecepcionDao recepcionDao;

    /**
     * @param ordenDao the userDao to set
     */
    public void setRecepcionDao(RecepcionDao recepcion) {
        this.recepcionDao = recepcion;
    }
    
    @Autowired
    private RecepcionProductoDao recepcionProductoDao;
   
    /**
     * @param ordenDao the userDao to set
     */
    public void setRecepcionProductoDao(RecepcionProductoDao recepcionProducto) {
        this.recepcionProductoDao = recepcionProducto;
    }
    
    @Transactional
    @Override
    public boolean crearRecepcion(Recepcion recepcion) {
        return recepcionDao.createRecepcion(recepcion);
        
    }

    @Transactional
    @Override
    public boolean modificarRecepcion(Recepcion recepcion) {
        return recepcionDao.updateRecepcion(recepcion);

    }

    @Transactional
    @Override
    public Recepcion buscarRecepcionPorId(long idRecepcion) {
        return recepcionDao.findByIdRecepcion(idRecepcion);
    }

    @Transactional
    @Override
    public List<Recepcion> listarRecepciones() {
        return recepcionDao.findAllActive();
    }

    @Transactional
    @Override
    public List<Recepcion> listarRecepcionPorOrden(long idOrden) {
        return recepcionDao.findByOrden(idOrden);
    }

    @Transactional
    @Override
    public boolean crearRecepcionProducto(RecepcionProducto recepcionProducto) {
        return recepcionProductoDao.createRecepcionProducto(recepcionProducto);
    }

    @Transactional
    @Override
    public boolean modificarRecepcionProducto(RecepcionProducto recepcionProducto) {
        return recepcionProductoDao.updateRecepcionProducto(recepcionProducto);
    }

    @Transactional
    @Override
    public List<RecepcionProducto> buscarRecepcionesProductosPorIdRecepcion(long idRecepcion) {
        return recepcionProductoDao.findByRecepcion(idRecepcion);
    }
    
}
