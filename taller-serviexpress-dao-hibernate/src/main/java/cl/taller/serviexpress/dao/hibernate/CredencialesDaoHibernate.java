package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.Credenciales;
import cl.taller.serviexpress.dao.CredencialesDao;

public class CredencialesDaoHibernate implements CredencialesDao {

	
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		try {
			return this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return this.sessionFactory.openSession();
		}
	}

        @Override
	public Credenciales findByUsername(String userName) {
		String sql = "from Credenciales as u where u.nombreUsuario = :userName";

		Query query = getSession().createQuery(sql);

		query.setParameter("userName", userName);

		return (Credenciales) query.uniqueResult();
	}

        @Override
	public Credenciales findByUseNameAndPass(String userName, String password) {
		String sql = "from Credenciales as u where u.nombreUsuario = :userName and u.clave = :password";

		Query query = getSession().createQuery(sql);

		query.setParameter("userName", userName);
		query.setParameter("password", password);

		return (Credenciales) query.uniqueResult();

	}

	@SuppressWarnings("unchecked")
        @Override
	public List<Credenciales> findAllActive() {

		String sql = "from Credenciales as u inner join fetch u.perfil where u.estado = 1";

		Query query = getSession().createQuery(sql);

		return query.list();
	}

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCredenciales(Credenciales credencial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
