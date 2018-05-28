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

public class RecepcionProductoDaoHibernate extends BaseHibernate implements RecepcionProductoDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<RecepcionProducto> findByRecepcion(long idRecepcion) {

        List<RecepcionProducto> lista = null;
        Session session = getSessionFactory().openSession();
        try {
            String sql = "from RecepcionProducto where id = :idRecepcion";
            Query query = session.createQuery(sql);
            query.setLong("idRecepcion", idRecepcion);
            
            lista = query.list();
        } catch (Exception e) {

        }
        return lista;

    }

    @Override
    public boolean createRecepcionProducto(RecepcionProducto recepcionProducto) {

        boolean creado = false;
        Session session = getSessionFactory().openSession();
        try {
            
            session.beginTransaction();
            session.save(recepcionProducto);
            session.getTransaction().commit();
        } catch (Exception e) {

        }
        return creado;

    }

    @Override
    public boolean updateRecepcionProducto(RecepcionProducto recepcionProducto) {

        boolean actualizado = false;
        Session session = getSessionFactory().openSession();
        try {
            String sql = "update from RecepcionProducto set codigoProducto = :codigo, "
                    + "cantidad = :cantidad, fechaVencimiento = :fecha, "
                    + "id = :id_recepcion, producto = :id_producto";

            Query query = session.createQuery(sql);

            query.setParameter("codigo", recepcionProducto.getCodigoProducto());
            query.setParameter("cantidad", recepcionProducto.getCantidad());
            query.setDate("fecha", recepcionProducto.getFechaVencimiento());
            query.setLong("id_recepcion", recepcionProducto.getRecepcion().getId());
            query.setLong("id_producto", recepcionProducto.getProducto().getId());

            int count = query.executeUpdate();
            actualizado = true;
        } catch (Exception e) {

        }
        return actualizado;
    }

}
