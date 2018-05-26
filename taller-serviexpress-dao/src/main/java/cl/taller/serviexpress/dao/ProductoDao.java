
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.Producto;
import java.util.List;


public interface ProductoDao {
    
	Producto findByIdProducto(long idProducto);

	List<Producto> findAll();
        
        List<Producto> findByTipo(long idTipo);
        
        boolean createProducto(Producto producto);
        
        boolean updateProducto(Producto producto);
}
