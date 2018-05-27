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
import java.util.List;

public class RecepcionServicesImpl implements RecepcionServices{

    @Override
    public boolean crearRecepcion(Recepcion recepcion) {
        RecepcionDaoHibernate dao = new RecepcionDaoHibernate();
        return true;
    }

    @Override
    public boolean modificarRecepcion(Recepcion recepcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recepcion buscarRecepcionPorId(long idRecepcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Recepcion> listarRecepciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Recepcion> listarRecepcionPorOrden(long idOrden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crearRecepcionProducto(RecepcionProducto recepcionProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarRecepcionProducto(RecepcionProducto recepcionProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RecepcionProducto> buscarRecepcionesProductosPorIdRecepcion(long idRecepcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
