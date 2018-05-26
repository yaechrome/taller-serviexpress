/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.RecepcionProducto;
import cl.taller.serviexpress.dao.RecepcionProductoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
import cl.taller.serviexpress.domain.Producto;

public class RecepcionProductoDaoHibernate extends BaseHibernate implements RecepcionProductoDao{

    @Override
    public List<RecepcionProducto> findByRecepcion(long idRecepcion) {
        String sql = "from RECEPCION_PRODUCTO where ID = :idRecepcion";

	Query query = getSession().createQuery(sql);
        query.setParameter("idRecepcion", idRecepcion);
        
        return query.list();
    }

    @Override
    public boolean createRecepcionProducto(RecepcionProducto recepcionProducto) {
        try {
            getSession().save(recepcionProducto);
            getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean updateRecepcionProducto(RecepcionProducto recepcionProducto) {
        try {
            
            String sql = "update from RECEPCION_PRODUCTO set CODIGOPRODUCTO = :codigo, "
                    + "CANTIDAD = :cantidad, FECHAVENCIMIENTO = :fecha, "
                    + "ID = :id_recepcion, PRODUCTO = :id_producto";
	
            Query query = getSession().createQuery(sql);

            query.setParameter("codigo", recepcionProducto.getCodigoProducto());
            query.setParameter("cantidad", recepcionProducto.getCantidad());
            query.setDate("fecha", recepcionProducto.getFechaVencimiento());
            query.setLong("id_recepcion", recepcionProducto.getRecepcion().getId());
            query.setLong("id_producto", recepcionProducto.getProducto().getId());
            
            int count = query.executeUpdate();

            return true;   
        } catch (Exception e) {
            
        }
        return false;
    }
    
}
