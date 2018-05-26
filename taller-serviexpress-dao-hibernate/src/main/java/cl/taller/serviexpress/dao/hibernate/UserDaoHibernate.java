package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.dao.UserDao;
import cl.taller.serviexpress.domain.Usuario;

public class UserDaoHibernate implements UserDao {

	
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		try {
			return this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return this.sessionFactory.openSession();
		}
	}

	public Usuario findByUsername(String userName) {
		String sql = "from Usuario as u where u.nombreUsuario = :userName";

		Query query = getSession().createQuery(sql);

		query.setParameter("userName", userName);

		return (Usuario) query.uniqueResult();
	}

	public Usuario findByUseNameAndPass(String userName, String password) {
		String sql = "from Usuario as u where u.nombreUsuario = :userName and u.clave = :password";

		Query query = getSession().createQuery(sql);

		query.setParameter("userName", userName);
		query.setParameter("password", password);

		return (Usuario) query.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAllActive() {

		String sql = "from Usuario as u inner join fetch u.perfil where u.estado = 1";

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

}
