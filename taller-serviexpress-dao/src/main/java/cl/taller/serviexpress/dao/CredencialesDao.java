package cl.taller.serviexpress.dao;

import java.util.List;

import cl.taller.serviexpress.domain.Credenciales;

public interface CredencialesDao {

	/**
	 * Busca un usuario por medio de su nombre de usuario.
	 * 
	 * @param userName
	 *            El nombre de usuario
	 * @return
	 */
	Credenciales findByUsername(String userName);

	/**
	 * Busca usuario por medio de su nombre y clave
	 * 
	 * @param userName
	 *            El nombre de usuario
	 * @param password
	 *            La clave
	 * @return Retorna el usuario encontrado
	 */
	Credenciales findByUseNameAndPass(String userName, String password);

	/**
	 * Obtiene todos los usuario activos.
	 * 
	 * @return Una colección de usuario activos.
	 */
	List<Credenciales> findAllActive();
        
        boolean createCredenciales(Credenciales credencial);
        
        boolean updateCredenciales(Credenciales credencial);

}
