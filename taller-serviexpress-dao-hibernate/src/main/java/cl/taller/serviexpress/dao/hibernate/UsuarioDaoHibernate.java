
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
        String sql = "from USUARIOS where ID = :idUsuario";

        Query query = getSession().createQuery(sql);

        query.setParameter("idUsuario", idUsuario);

        return (Usuario) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Usuario> findAllActive() {
    	Session session = getSessionFactory().openSession();
    	
    	String sql = "select b from Usuario b";

        Query query = session.createQuery(sql);
        
        return query.list();
        
    }

    @Override
    public List<Usuario> findByPerfil(long idPerfil) {
        String sql = "from USUARIOS where PERFIL = :idPerfil";

        Query query = getSession().createQuery(sql);

        query.setParameter("idPerfil", idPerfil);

        return query.list();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        try {
            getSession().save(usuario);
            getSession().getTransaction().commit();
            
            return findByRut(usuario.getRut());
            
        } catch (Exception e) {
            
        }
        return null;
    }

    @Override
    public boolean updateUsuario(Usuario usuario) {
        try {
            String sql = "update from USUARIOS set PERFIL = :idPerfil, "
                    + "RUT = :rut, NOMBRE = :nombre, DIRECCION = :direccion,"
                    + " CONTACTOTELEFONO = :contactoTelefono where ID = :id";
	
            Query query = getSession().createQuery(sql);

            query.setParameter("id_perfil", usuario.getId());
            query.setParameter("rut", usuario.getRut());
            query.setParameter("direccion", usuario.getDireccion());
            query.setParameter("contacto_telefono", usuario.getContactoTelefonico());
            query.setLong("id", usuario.getId());

            int count = query.executeUpdate();

            return true;   
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public Usuario findByRut(String rut) {
        try {
            String sql = "from USUARIOS where RUT = :rut";

            Query query = getSession().createQuery(sql);

            query.setParameter("rut", rut);

            return (Usuario) query.uniqueResult();
            
        } catch (Exception e) {
            
        }
        return null;
    }
    
}
