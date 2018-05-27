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

import cl.taller.serviexpress.domain.TipoProducto;
import cl.taller.serviexpress.dao.TipoProductoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
public class TipoProductoDaoHibernate extends BaseHibernate implements TipoProductoDao{
    
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;}
    
    public void setSessionFactory(SessionFactory sessionFactory) {
         this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<TipoProducto> findAllActive() {
        List<TipoProducto> lista = null;
        Session session = getSessionFactory().openSession();
        String sql = "from TipoProducto";
        try {
            Query query = session.createQuery(sql);
            lista = query.list();
        } catch (Exception e) {
            
        }finally{
            session.close();
        }
	
	return lista;
    }

    @Override
    public List<TipoProducto> findByFamilia(long idFamilia) {
        List<TipoProducto> lista = null;
        Session session = getSessionFactory().openSession();
        String sql = "from TipoProducto  where familiaProducto = :idFamilia";
        try {
            Query query = session.createQuery(sql);
            query.setLong("idFamilia", idFamilia);
            lista = query.list();
        } catch (Exception e) {
            
        }finally{
            session.close();
        }
        return lista;

    }
    
}
