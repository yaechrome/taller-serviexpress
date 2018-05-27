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

public class OrdenProductoDaoHibernate extends BaseHibernate implements OrdenProductoDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<OrdenProducto> findByOrden(long idOrden) {
        Session session = getSessionFactory().openSession();
        List<OrdenProducto> lista = null;
        try {

            String sql = "from OrdenProducto as o where o.id = :idOrden";

            Query query = session.createQuery(sql);
            query.setParameter("idOrden", idOrden);
            lista = query.list();
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return lista;
    }

    @Override
    public boolean createOrdenProducto(OrdenProducto ordenProducto) {
        Session session = getSessionFactory().openSession();
        try {
            session.save(ordenProducto);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateOrdenProducto(OrdenProducto ordenProducto) {
        Session session = getSessionFactory().openSession();
        try {
            String sql = "update from OrdenProducto set cantidad = :cantidad, "
                    + "precioCompra = :precio_compra where producto = :id_producto "
                    + "and ID = :id_orden_compra";

            Query query = session.createQuery(sql);

            query.setParameter("cantidad", ordenProducto.getCantidad());
            query.setParameter("precio_compra", ordenProducto.getPrecioCompra());
            query.setLong("id_producto", ordenProducto.getProducto().getId());
            query.setLong("id_orden_compra", ordenProducto.getOrdenCompra().getId());

            int count = query.executeUpdate();

            return true;
        } catch (Exception e) {

        } finally {
            session.close();
        }

        return false;
    }

}
