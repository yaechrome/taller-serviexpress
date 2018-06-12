package cl.taller.serviexpress.dao.hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.Credenciales;
import cl.taller.serviexpress.dao.CredencialesDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;

public class CredencialesDaoHibernate extends BaseHibernate implements CredencialesDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Credenciales findByUsername(String userName) {
        Session session = getSessionFactory().openSession();
        Credenciales credenciales = null;
        try {
            String sql = "from Credenciales as u where u.username = :userName";

            Query query = session.createQuery(sql);

            query.setParameter("userName", userName);

            credenciales = (Credenciales) query.uniqueResult();
        } catch (Exception e) {

        }
        return credenciales;

    }

    //Se compara con password encriptada
    @Override
    public Credenciales findByUseNameAndPass(String userName, String password) {

        Session session = getSessionFactory().openSession();
        Credenciales credenciales = null;
        try {
            String sql = "from Credenciales as u where u.username = :userName and u.password = :password";

            Query query = session.createQuery(sql);

            query.setParameter("userName", userName);
            query.setParameter("password", password);

            credenciales = (Credenciales) query.uniqueResult();
        } catch (Exception e) {

        } 
        return credenciales;

    }

//	@SuppressWarnings("unchecked")
//        @Override
//	public List<Credenciales> findAllActive() {
//
//		String sql = "from Credenciales as u inner join fetch u.perfil where u.estado = 1";
//
//		Query query = getSession().createQuery(sql);
//
//		return query.list();
//	}
    // @SuppressWarnings("unchecked")
    // @Override
    // public Usuario update(Usuario usuario) {
    //
    // String sql = "update from Usuario set perfil = :perfil where id = :id";
    //
    // Query query = getSession().createQuery(sql);
    //
    // query.setParameter("perfil", usuario.getPerfil());
    // query.setLong("id", usuario.getId());
    //
    // int count = query.executeUpdate();
    //
    // return usuario;
    // }
    @Override
    public boolean createCredenciales(Credenciales credencial) {
        Session session = getSessionFactory().openSession();
        boolean creado = false;
        try {
            session.beginTransaction();
            session.save(credencial);
            session.getTransaction().commit();
            creado = true; 
        } catch (Exception e) {

        }
        return creado;
    }

    @Override
    public boolean updateCredenciales(Credenciales credencial) {
        Session session = getSessionFactory().openSession();
        boolean actualizado = false;
        try {
//            String sql = "update from Credenciales set username = :username, password = :password where id = :id";
//
//            Query query = session.createQuery(sql);
//
//            query.setParameter("username", credencial.getUsername());
//            query.setParameter("password", credencial.getPassword());
//            query.setLong("id", credencial.getId());
//
//            int count = query.executeUpdate();
//
//            return true;

            session.beginTransaction();
            session.saveOrUpdate(credencial);
            actualizado = true;
            session.getTransaction().commit();
        } catch (Exception e) {

        } 
        return actualizado;
    }

}
