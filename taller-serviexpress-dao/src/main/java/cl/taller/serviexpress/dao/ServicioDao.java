
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.Servicio;
import java.util.List;


public interface ServicioDao {
    
    /**
	 * Busca un usuario por medio de su nombre de usuario.
	 * 
	 * @param idServicio
	 *            El id de servicio
	 * @return
	 */
	Servicio findByIdServicio(long idServicio);

	/**
	 * Obtiene todos los usuario activos.
	 * 
	 * @return Una colección de usuario activos.
	 */
	List<Servicio> findAllActive();
        
        boolean createCredenciales(Servicio servicio);
        
        boolean updateCredenciales(Servicio servicio);
}
