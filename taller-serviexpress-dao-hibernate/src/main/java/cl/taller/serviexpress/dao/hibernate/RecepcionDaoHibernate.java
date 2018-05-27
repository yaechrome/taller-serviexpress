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

import cl.taller.serviexpress.domain.Recepcion;
import cl.taller.serviexpress.dao.RecepcionDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;

public class RecepcionDaoHibernate extends BaseHibernate implements RecepcionDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Recepcion findByIdRecepcion(long idRecepcion) {
        Recepcion recepcion = null;
        Session session = getSessionFactory().openSession();
        try {
            String sql = "from Recepcion where id = :idRecepcion";

            Query query = session.createQuery(sql);

            query.setLong("idRecepcion", idRecepcion);

            recepcion = (Recepcion) query.uniqueResult();
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return recepcion;

    }

    @Override
    public List<Recepcion> findAllActive() {
        List<Recepcion> lista = null;
        Session session = getSessionFactory().openSession();
        try {
            String sql = "from Recepcion";

            Query query = session.createQuery(sql);

            lista = query.list();
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return lista;

    }

    @Override
    public List<Recepcion> findByOrden(long idOrden) {
        List<Recepcion> lista = null;
        Session session = getSessionFactory().openSession();
        try {
            String sql = "from Recepcion where ordenCompra = :idOrden";

            Query query = session.createQuery(sql);

            query.setLong("idOrden", idOrden);

            return query.list();
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return lista;

    }

    @Override
    public boolean createRecepcion(Recepcion recepcion) {
        boolean creado = false;
        Session session = getSessionFactory().openSession();
        try {
            session.save(recepcion);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return creado;

    }

    @Override
    public boolean updateRecepcion(Recepcion recepcion) {
        boolean actualizado = false;
        Session session = getSessionFactory().openSession();
        try {
            String sql = "update from Recepcion set ordenCompra = :idOrden, "
                    + "idUsuario = :idUsuarioEmpleado, fechaRecepcion = :fechaRecepcion,"
                    + " valorTotal = :valorTotal, estadoRecepcion = :estadoRecepcion "
                    + "where id = :id";

            Query query = session.createQuery(sql);

            query.setLong("idOrden", recepcion.getOrdenCompra().getId());
            query.setParameter("idUsuarioEmpleado", recepcion.getIdUsuario());
            query.setParameter("fechaRecepcion", recepcion.getFechaRecepcion());
            query.setParameter("valorTotal", recepcion.getValorTotal());
            query.setParameter("estadoRecepcion", recepcion.getEstadoRecepcion());
            query.setLong("id", recepcion.getId());

            int count = query.executeUpdate();
            actualizado = true;
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return actualizado;

    }

}
