package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.Producto;
import cl.taller.serviexpress.dao.ProductoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
import cl.taller.serviexpress.domain.Perfil;

public class ProductoDaoHibernate extends BaseHibernate implements ProductoDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Producto findByIdProducto(long idProducto) {
        Session session = getSessionFactory().openSession();
        Producto producto = null;

        try {
            String sql = "from Producto  where id = :idProducto";

            Query query = session.createQuery(sql);
            query.setParameter("idProducto", idProducto);

            producto = (Producto) query.uniqueResult();
        } catch (Exception e) {

        } 
        return producto;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Producto> findAll() {
        Session session = getSessionFactory().openSession();
        List<Producto> lista = null;
        try {
            String sql = "from Producto";

            Query query = session.createQuery(sql);

            lista = query.list();
        } catch (Exception e) {

        } 
        return lista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Producto> findByTipo(long idTipo) {
        Session session = getSessionFactory().openSession();
        List<Producto> lista = null;
        try {
            String sql = "from Producto  where tipoProducto = :idTipo";

            Query query = session.createQuery(sql);
            query.setParameter("idTipo", idTipo);

            lista = query.list();
        } catch (Exception e) {

        } 
        return lista;
    }

    @Override
    public boolean createProducto(Producto producto) {
        Session session = getSessionFactory().openSession();
        boolean creado = false;
        try {
            session.beginTransaction();

            session.save(producto);

            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {

        }
        return creado;
    }

    @Override
    public boolean updateProducto(Producto producto) {
        Session session = getSessionFactory().openSession();
        boolean actualizado = false;
        try {
            session.beginTransaction();
            session.saveOrUpdate(producto);
            actualizado = true;
            session.getTransaction().commit();

        } catch (Exception e) {

        }
        return actualizado;
    }

}
