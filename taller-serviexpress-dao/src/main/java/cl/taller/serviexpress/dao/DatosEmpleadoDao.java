
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.DatosEmpleados;

public interface DatosEmpleadoDao {
    
    /**
	 * Busca un usuario por medio de su id de usuario.
	 * 
	 * @param idUsuario
	 *            El id de usuario
	 * @return
	 */
	DatosEmpleados findByID(long idUsuario);
        
        boolean createDatosEmpleados(DatosEmpleados empleado);
        
        boolean updateDatosEmpleados(DatosEmpleados empleado);
}
