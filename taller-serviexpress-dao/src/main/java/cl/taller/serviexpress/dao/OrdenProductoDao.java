
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.OrdenProducto;
import java.util.List;


public interface OrdenProductoDao {
        
        List<OrdenProducto> findByOrden(long idOrden);
        
        boolean createOrdenProducto(OrdenProducto ordenProducto);
        
        boolean updateOrdenProducto(OrdenProducto ordenProducto);
}
