package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.dao.OrdenCompraDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;

public class OrdenCompraDaoHibernate extends BaseHibernate implements OrdenCompraDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public OrdenCompra findByIdOrden(long idOrden) {
        Session session = getSessionFactory().openSession();
        OrdenCompra ordenCompra = null;
        try {
            String sql = "from OrdenCompra as o where o.id = :idOrden";

            Query query = session.createQuery(sql);

            query.setParameter("idOrden", idOrden);

            ordenCompra = (OrdenCompra) query.uniqueResult();
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return ordenCompra;
    }

    @Override
    public List<OrdenCompra> findAll() {
        Session session = getSessionFactory().openSession();
        List<OrdenCompra> lista = null;
        try {
            String sql = "from OrdenCompra";

            Query query = session.createQuery(sql);

            lista = query.list();
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return lista;
    }

    @Override
    public List<OrdenCompra> findByProveedor(long idProveedor) {
        Session session = getSessionFactory().openSession();
        List<OrdenCompra> lista = null;
        try {
            String sql = "from OrdenCompra where idProveedor = :idProveedor";
            Query query = session.createQuery(sql);
            query.setParameter("idProveedor", idProveedor);

            lista = query.list();
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return lista;
    }

    @Override
    public boolean createOrdenCompra(OrdenCompra ordenCompra) {
        Session session = getSessionFactory().openSession();
        try {
            session.save(ordenCompra);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateOrdenCompra(OrdenCompra ordenCompra) {
        Session session = getSessionFactory().openSession();
        try {
            String sql = "update from OrdenCompra set usuario = :idUsuarioEmpleado,"
                    + " idProveedor = :idProveedor, fechaEmision = :fechaEmision,"
                    + " estadoOrden = :estadoOrden, observacionOrden = :observacionOrden"
                    + " where id = :id";

            Query query = session.createQuery(sql);

            query.setParameter("idUsuarioEmpleado", ordenCompra.getUsuario().getId());
            query.setParameter("idProveedor", ordenCompra.getIdProveedor());
            query.setParameter("fechaEmision", ordenCompra.getFechaEmision());
            query.setParameter("estadoOrden", ordenCompra.getEstadoOrden());
            query.setParameter("observacionOrden", ordenCompra.getObservacionOrden());
            query.setLong("id", ordenCompra.getId());

            int count = query.executeUpdate();

            return true;
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return false;
    }

}
