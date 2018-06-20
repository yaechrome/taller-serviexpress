/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.dao.hibernate;


import cl.taller.serviexpress.dao.FacturaServicioDao;
import cl.taller.serviexpress.domain.FacturaServicio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author CETECOM
 */
public class FacturaServicioDaoHibernate implements FacturaServicioDao{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<FacturaServicio> findByFactura(long idfactura) {
        Session session = getSessionFactory().openSession();
        List<FacturaServicio> lista = null;
        try {

            String sql = "from FacturaServicio as o where o.id = :idfactura";

            Query query = session.createQuery(sql);
            query.setParameter("idfactura", idfactura);
            lista = query.list();
        } catch (Exception e) {

        }
        return lista;
    }

    @Override
    public boolean createFacturaServicio(FacturaServicio facturaServicio) {
        Session session = getSessionFactory().openSession();
        boolean creado = false;
        try {
            session.beginTransaction();
            session.save(facturaServicio);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {

        } 
        return creado;
    }

    @Override
    public boolean updateFacturaServicio(FacturaServicio facturaServicio) {
        boolean actualizado = false;
    	Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(facturaServicio);
            actualizado = true;
            session.getTransaction().commit();
        } catch (Exception e) {
            
        }finally{
            session.close();
        }
        return actualizado;
    }
    
 
}
