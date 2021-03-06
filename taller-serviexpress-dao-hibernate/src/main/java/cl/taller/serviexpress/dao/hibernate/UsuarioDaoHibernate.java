
package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.dao.UsuarioDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;


public class UsuarioDaoHibernate extends BaseHibernate implements UsuarioDao{

    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;}
    
    public void setSessionFactory(SessionFactory sessionFactory) {
         this.sessionFactory = sessionFactory;
    }

	
    @Override
    public Usuario findByIdUsuario(long idUsuario) {
        Usuario usuario = null;
        Session session = getSessionFactory().openSession();
        
        String sql = "from Usuario where id = :idUsuario";
        try {
            
            Query query = session.createQuery(sql);

            query.setLong("idUsuario", idUsuario);

            usuario = (Usuario) query.uniqueResult();
            
        } catch (Exception e) {
            
        }finally{
            session.close();
        }
        return usuario;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Usuario> findAllActive() {
        
    	Session session = getSessionFactory().openSession();
    	List<Usuario> lista = null;
        
    	try {
            String sql = "select b from Usuario b inner join fetch b.perfil";
    	
            Query query = session.createQuery(sql);
    	
            lista = query.list();
        } catch (Exception e) {
        }
        
        return lista;
     
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Usuario> findByPerfil(long idPerfil) {
        List<Usuario> lista = null;
        
    	Session session = getSessionFactory().openSession();
        String sql = "from Usuario where perfil = :idPerfil";
        try {
            Query query = session.createQuery(sql);

            query.setLong("idPerfil", idPerfil);

            lista = query.list();
        } catch (Exception e) {
            
        }finally{
            session.close();
        }
        
        return lista;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) { 
    	Session session = getSessionFactory().openSession();
        
        try {
            session.beginTransaction();

            session.save(usuario);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            
        }
        return usuario;
    }

    @Override
    public boolean updateUsuario(Usuario usuario) {
        boolean actualizado = false;
    	Session session = getSessionFactory().openSession();
        try {
            /**
            String sql = "update from Usuario set perfil = :idPerfil, "
                    + "rut = :rut, nombre = :nombre, direccion = :direccion,"
                    + " contactoTelefonico = :contactoTelefono where id = :id";
	
            Query query = session.createQuery(sql);

            query.setLong("idPerfil", usuario.getId());
            query.setParameter("rut", usuario.getRut());
            query.setParameter("nombre", usuario.getNombre());
            query.setParameter("direccion", usuario.getDireccion());
            query.setParameter("contactoTelefono", usuario.getContactoTelefonico());
            query.setLong("id", usuario.getId());

            int count = query.executeUpdate();

*           */
            session.beginTransaction();
            session.saveOrUpdate(usuario);
            actualizado = true;
            session.getTransaction().commit();
        } catch (Exception e) {
            
        }finally{
            session.close();
        }
        return actualizado;
    }

    @Override
    public Usuario findByRut(String rut) {
        Usuario usuario = null;
        
    	Session session = getSessionFactory().openSession();
        String sql = "from Usuario where rut = :rut";
        try {
            Query query = session.createQuery(sql);

            query.setParameter("rut", rut);

            usuario = (Usuario) query.uniqueResult();
            
        } catch (Exception e) {
            
        }
        return usuario;
    }

	@Override
	public Usuario findByUsernameAndPassword(String username, String Password) {
		
        Usuario usuario = null;
        
    	Session session = getSessionFactory().openSession();
    	
        String sql = "from Usuario where username = :username and password = :password";
        try {
            Query query = session.createQuery(sql);

            query.setParameter("username", username);
            query.setParameter("password", Password);

            usuario = (Usuario) query.uniqueResult();
            
        } catch (Exception e) {
            
        }
        return usuario;
	}
    
}
