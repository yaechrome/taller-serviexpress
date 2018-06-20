/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.dao.hibernate;

import cl.taller.serviexpress.dao.FacturaProductoDao;
import cl.taller.serviexpress.domain.FacturaProducto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author CETECOM
 */
public class FacturaProductoDaoHibernate implements FacturaProductoDao{

	
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<FacturaProducto> findByFactura(long idFactura) {
        Session session = getSessionFactory().openSession();
        List<FacturaProducto> lista = null;
        try {

            String sql = "from FacturaProducto as o where o.id = :idFactura";

            Query query = session.createQuery(sql);
            query.setParameter("idFactura", idFactura);
            lista = query.list();
        } catch (Exception e) {

        }
        return lista;
    }

    @Override
    public boolean createFacturaProducto(FacturaProducto facturaProducto) {
        Session session = getSessionFactory().openSession();
        boolean creado = false;
        try {
            session.beginTransaction();
            session.save(facturaProducto);
            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {

        } 
        return creado;
    }

    @Override
    public boolean updateFacturaProducto(FacturaProducto facturaProducto) {
        boolean actualizado = false;
    	Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(facturaProducto);
            actualizado = true;
            session.getTransaction().commit();
        } catch (Exception e) {
            
        }
        return actualizado;    
    }
    
}
