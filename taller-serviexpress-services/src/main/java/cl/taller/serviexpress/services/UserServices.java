package cl.taller.serviexpress.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import cl.taller.serviexpress.domain.Usuario;

public interface UserServices extends UserDetailsService {

	/**
	 * Obtiene todos los usuarios.
	 * 
	 * @return
	 */
	List<Usuario> getUsers();

	/**
	 * Autentica al usuario por medio de su nombre de usuario y clave.
	 * 
	 * @param userName
	 *            El nombre de usuario.
	 * @param password
	 *            La clave.
	 * @return Retorna token de autorización.
	 */
	String signin(String userName, String password);

	/**
	 * Obtiene un usuario por medio de su nombre de usuario
	 * 
	 * @param username
	 *            El nombre de usuario
	 * @return
	 */
	Usuario search(String username);

	/**
	 * Obtiene todos los usuario activos.
	 * 
	 * @return Retorna una colección de usuarios activos.
	 */
	List<Usuario> findAllActiveUsers();

	/**
	 * Elimina usuarios mediante su identificador (eliminación logica).
	 * 
	 * @param id
	 *            El identificador del usuario.
	 */
	void deleteById(Long id);

	/**
	 * Obtiene un usuario mediante su identificador.
	 * 
	 * @param id
	 *            El identificador del usuario.
	 * @return Retorna una usuario.
	 */
	Usuario findById(Long id);
	
	/**
	 * Obtiene usuario a traves de validaciones de perfil
	 * 
	 * @param username
	 *            El nombre de usuario
	 * @return Retorna usuario.
	 */
	
	Usuario webAuth(String userName);

	/**
	 * Crea o actualiza un usuario.
	 * 
	 * @param usuario
	 *            El usuario a crear o actualizar.
	 * @param isUpdate
	 *            Determina si es una actualización o creación (true = update,
	 *            false = save)
	 * @return Retorna el usuario creado o actualizado.
	 */
	Usuario saveOrUpdate(Usuario usuario, Boolean isUpdate);
}
