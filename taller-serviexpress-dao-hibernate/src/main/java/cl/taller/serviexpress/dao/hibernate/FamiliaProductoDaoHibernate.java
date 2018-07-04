
package cl.taller.serviexpress.dao.hibernate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.FamiliaProducto;
import cl.taller.serviexpress.dao.FamiliaProductoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;

public class FamiliaProductoDaoHibernate extends BaseHibernate implements FamiliaProductoDao{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
            return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<FamiliaProducto> findAll() {
        Session session = getSessionFactory().openSession();
        List<FamiliaProducto> lista = null;
        try {
            String sql = "from FamiliaProducto";

            Query query = session.createQuery(sql);

            lista=  query.list();
        } catch (Exception e) {
        }
        return lista;
    }
    
}
