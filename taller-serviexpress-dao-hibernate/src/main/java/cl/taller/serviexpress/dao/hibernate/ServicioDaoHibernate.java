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

import cl.taller.serviexpress.domain.Servicio;
import cl.taller.serviexpress.dao.ServicioDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
public class ServicioDaoHibernate extends BaseHibernate implements ServicioDao{

    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;}
    
    public void setSessionFactory(SessionFactory sessionFactory) {
         this.sessionFactory = sessionFactory;
    }
    
    @Override
    public Servicio findByIdServicio(long idServicio) {
        Servicio servicio = null;
        Session session = getSessionFactory().openSession();
        String sql = "from Servicio where id = :idServicio";
        try {
            Query query = session.createQuery(sql);

            query.setLong("idServicio", idServicio);
            servicio = (Servicio) query.uniqueResult();
        } catch (Exception e) {
            
        }
        return servicio;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Servicio> findAllActive() {
        List<Servicio> lista = null;
        Session session = getSessionFactory().openSession();
        String sql = "from Servicio";
        try {
            Query query = session.createQuery(sql);

            lista = query.list();
        } catch (Exception e) {
            
        }
        return lista;
        

		
    }

    @Override
    public boolean createServicio(Servicio servicio) {
        boolean creado = false;
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();

            session.save(servicio);

            session.getTransaction().commit();
            
            creado = true;
        } catch (Exception e) {
            
        }
        return creado;
    }

    @Override
    public boolean updateServicio(Servicio servicio) {
        boolean creado = false;
        Session session = getSessionFactory().openSession();
        try {
            String sql = "update from Servicio set estadoServicio = :estadoServicio, "
                    + "valor = :valor, descripcionServicio = :descripcionServicio "
                    + "where id = :id";
	
            Query query = session.createQuery(sql);

            query.setParameter("estadoServicio", servicio.getEstadoServicio());
            query.setParameter("valor", servicio.getValor());
            query.setParameter("descripcionServicio", servicio.getDescripcionServicio());
            query.setLong("id", servicio.getId());

            int count = query.executeUpdate();
            creado = true;
        } catch (Exception e) {
            
        }
        return creado;

    }
    
}
