
package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.dao.UsuarioDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
public class UsuarioDaoHibernate extends BaseHibernate implements UsuarioDao{

    @Override
    public Usuario findByIdUsuario(long idUsuario) {
        String sql = "from USUARIOS where ID = :idUsuario";

		Query query = getSession().createQuery(sql);

		query.setParameter("idUsuario", idUsuario);

		return (Usuario) query.uniqueResult();
    }

    @Override
    public List<Usuario> findAllActive() {
        String sql = "from USUARIOS";

		Query query = getSession().createQuery(sql);

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
    public boolean createCredenciales(Usuario usuario) {
        try {
            getSession().save(usuario);
            getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean updateCredenciales(Usuario usuario) {
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
    
}
