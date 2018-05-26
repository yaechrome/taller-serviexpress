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

import cl.taller.serviexpress.domain.OrdenProducto;
import cl.taller.serviexpress.dao.OrdenProductoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
public class OrdenProductoDaoHibernate extends BaseHibernate implements OrdenProductoDao{

    @Override
    public List<OrdenProducto> findByOrden(long idOrden) {
        String sql = "from ORDEN_PRODUCTO as o where o.ID = :idOrden";

	Query query = getSession().createQuery(sql);
        query.setParameter("idOrden", idOrden);
	return query.list();
    }

    @Override
    public boolean createOrdenProducto(OrdenProducto ordenProducto) {
        try {
            getSession().save(ordenProducto);
            getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean updateOrdenProducto(OrdenProducto ordenProducto) {
        try {
            String sql = "update from ORDEN_PRODUCTO set CANTIDAD = :cantidad, "
                    + "PRECIOCOMPRA = :precio_compra where PRODUCTO = :id_producto "
                    + "and ID = :id_orden_compra";
	
            Query query = getSession().createQuery(sql);

            query.setParameter("cantidad", ordenProducto.getCantidad());
            query.setParameter("precio_compra", ordenProducto.getPrecioCompra());
            query.setLong("id_producto", ordenProducto.getProducto().getId());
            query.setLong("id_orden_compra", ordenProducto.getOrdenCompra().getId());

            int count = query.executeUpdate();

            return true;   
        } catch (Exception e) {
            
        }
        return false;
    }
    
}
