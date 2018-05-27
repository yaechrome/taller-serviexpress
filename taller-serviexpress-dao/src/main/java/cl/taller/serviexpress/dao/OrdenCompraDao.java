
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.OrdenCompra;
import java.util.List;


public interface OrdenCompraDao {
   
	OrdenCompra findByIdOrden(long idOrden);
	
	List<OrdenCompra> findAll();
        
        List<OrdenCompra> findByProveedor(long idProveedor);
        
        boolean createOrdenCompra(OrdenCompra ordenCompra);
        
        boolean updateOrdenCompra(OrdenCompra ordenCompra);
}
