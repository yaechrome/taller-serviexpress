
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
        String sql = "from Usuario where id_usuario = :idUsuario";

		Query query = getSession().createQuery(sql);

		query.setParameter("idUsuario", idUsuario);

		return (Usuario) query.uniqueResult();
    }

    @Override
    public List<Usuario> findAllActive() {
        String sql = "from Servicio";

		Query query = getSession().createQuery(sql);

		return query.list();
    }

    @Override
    public List<Usuario> findByPerfil(long idPerfil) {
        String sql = "from Usuario where id_perfil = :idPerfil";

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
            String sql = "update from Usuario set id_perfil = :idPerfil, rut = :rut, nombre = :nombre, direccion = :direccion, contacto_telefono = :contactoTelefono where id_usuario = :id";
	
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
