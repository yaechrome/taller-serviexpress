
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.FamiliaProducto;
import java.util.List;


public interface FamiliaProductoDao {


	/**
	 * Obtiene todas las familias de productos activos.
	 * 
	 * @return Una colección de familias de productos activos.
	 */
	List<FamiliaProducto> findAllActive();
        
}
