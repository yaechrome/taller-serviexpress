package cl.taller.serviexpress.dao.hibernate;

import cl.taller.serviexpress.dao.ReservaDao;
import cl.taller.serviexpress.domain.Reserva;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReservaDaoHibernate implements ReservaDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Reserva findByIdReserva(long idReserva) {
        Reserva reserva = null;
        Session session = getSessionFactory().openSession();
        
        String sql = "from Reserva where id = :idReserva";
        try {
            
            Query query = session.createQuery(sql);

            query.setLong("idReserva", idReserva);

            reserva = (Reserva) query.uniqueResult();
            
        } catch (Exception e) {
            
        }finally{
            session.close();
        }
        return reserva;
    }

    @Override
    public List<Reserva> findAll() {
        Session session = getSessionFactory().openSession();
    	List<Reserva> lista = null;
        
    	try {
            String sql = "select b from Reserva b";
    	
            Query query = session.createQuery(sql);
    	
            lista = query.list();
        } catch (Exception e) {
        }
        
        return lista;
    }

    @Override
    public List<Reserva> findByCliente(long idCliente) {
        List<Reserva> lista = null;
        
    	Session session = getSessionFactory().openSession();
        String sql = "from Reserva where usuario = :idCliente";
        try {
            Query query = session.createQuery(sql);

            query.setLong("idCliente", idCliente);

            lista = query.list();
        } catch (Exception e) {
            
        }finally{
            session.close();
        }
        
        return lista;
    }

    @Override
    public boolean createReserva(Reserva reserva) {
        Session session = getSessionFactory().openSession();
        boolean creado = false;
        try {
            session.beginTransaction();

            session.save(reserva);

            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
            
        }
        return creado;
    }

    @Override
    public boolean updateReserva(Reserva reserva) {
        Session session = getSessionFactory().openSession();
        boolean actualizado = false;
        try {
            session.beginTransaction();
            session.saveOrUpdate(reserva);
            actualizado = true;
            session.getTransaction().commit();
        } catch (Exception e) {

        } 

        return actualizado;
    }

    @Override
    public boolean deleteReserva(Reserva reserva) {
        Session session = getSessionFactory().openSession();
        boolean actualizado = false;
        try {
            session.beginTransaction();
            session.delete(reserva);
            actualizado = true;
            session.getTransaction().commit();
        } catch (Exception e) {

        } 
        return actualizado;
    }

    @Override
    public List<Reserva> findByFecha(Date fecha) {
        List<Reserva> lista = null;
        
    	Session session = getSessionFactory().openSession();
        String sql = "from Reserva where fechaReserva = :fecha";
        try {
            Query query = session.createQuery(sql);

            query.setDate("fecha", fecha);

            lista = query.list();
        } catch (Exception e) {
                
        }finally{
            session.close();
        }
        
        return lista;
    }

}
