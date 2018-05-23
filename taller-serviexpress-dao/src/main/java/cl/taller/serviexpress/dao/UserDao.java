package cl.taller.serviexpress.dao;

import java.util.List;

import cl.taisachile.antaios.dao.ng.DomainBaseCrudDataAccessObject;
import cl.taller.serviexpress.domain.Usuario;

public interface UserDao extends DomainBaseCrudDataAccessObject<Usuario, Long, Long> {

	/**
	 * Busca un usuario por medio de su nombre de usuario.
	 * 
	 * @param userName
	 *            El nombre de usuario
	 * @return
	 */
	Usuario findByUsername(String userName);

	/**
	 * Busca usuario por medio de su nombre y clave
	 * 
	 * @param userName
	 *            El nombre de usuario
	 * @param password
	 *            La clave
	 * @return Retorna el usuario encontrado
	 */
	Usuario findByUseNameAndPass(String userName, String password);

	/**
	 * Obtiene todos los usuario activos.
	 * 
	 * @return Una colección de usuario activos.
	 */
	List<Usuario> findAllActive();

}
