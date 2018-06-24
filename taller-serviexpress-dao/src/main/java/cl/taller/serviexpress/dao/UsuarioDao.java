
package cl.taller.serviexpress.dao;

import java.util.List;
import cl.taller.serviexpress.domain.Usuario;

public interface UsuarioDao {
    
    /**
	 * Busca un usuario por medio de su nombre de usuario.
	 * 
	 * @param idUsuario
	 *            El nombre de usuario
	 * @return
	 */
	Usuario findByIdUsuario(long idUsuario);
	
    /**
	 * Busca un usuario por de su usuario y contraseña
	 * 
	 * @param username, password
	 *            Las credenciales del usuario
	 * @return
	 */
	Usuario findByUsernameAndPassword(String username, String Password);

	/**
	 * Obtiene todos los usuario activos.
	 * 
	 * @return Una colección de usuario activos.
	 */
	List<Usuario> findAllActive();
        
        List<Usuario> findByPerfil(long idPerfil);
        
        Usuario createUsuario(Usuario usuario);
        
        boolean updateUsuario(Usuario usuario);
        
        Usuario findByRut(String rut);
}
