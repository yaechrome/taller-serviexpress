package cl.taller.serviexpress.dao.hibernate;

import cl.taller.serviexpress.dao.FacturaDao;
import cl.taller.serviexpress.domain.Factura;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FacturaDaoHibernate implements FacturaDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Factura findByIdFactura(long idFactura) {
        Session session = getSessionFactory().openSession();
        Factura factura = null;
        try {
            String sql = "from Factura as f where f.id = :idFactura";

            Query query = session.createQuery(sql);

            query.setParameter("idFactura", idFactura);

            factura = (Factura) query.uniqueResult();
        } catch (Exception e) {

        } 
        return factura;
    }

    @Override
    public List<Factura> findAll() {
        Session session = getSessionFactory().openSession();
        List<Factura> lista = null;
        try {
            String sql = "from Factura";

            Query query = session.createQuery(sql);

            lista = query.list();
        } catch (Exception e) {

        } 
        return lista;    
    }

    @Override
    public List<Factura> findByCliente(String rutCliente) {
        Session session = getSessionFactory().openSession();
        List<Factura> lista = null;
        try {
            String sql = "from Factura where rutCliente = :rutCliente";
            Query query = session.createQuery(sql);
            query.setParameter("rutCliente", rutCliente);

            lista = query.list();
        } catch (Exception e) {

        }
        return lista;
    }

    @Override
    public boolean createFactura(Factura factura) {
        Session session = getSessionFactory().openSession();
        boolean creado = false;
        try {
            session.beginTransaction();
            session.save(factura);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {

        } 
        return creado;
    }

    @Override
    public boolean updateFactura(Factura factura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
