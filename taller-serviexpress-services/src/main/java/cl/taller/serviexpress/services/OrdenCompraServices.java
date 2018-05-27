
package cl.taller.serviexpress.services;

import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.domain.OrdenProducto;
import java.util.List;

public interface OrdenCompraServices {
    boolean crearOrdenCompra(OrdenCompra ordenCompra);
    
    boolean modificarOrdenCompra(OrdenCompra ordenCompra);
    
    OrdenCompra buscarOrdenCompraPorId(long idOrdenCompra);
    
    List<OrdenCompra> listarOrdenCompra();
    
    List<OrdenCompra> listarOrdenCompraPorProveedor(long idProveedor);
    
    boolean crearOrdenProducto(OrdenProducto OrdenProducto);
    
    boolean modificarOrdenProducto(OrdenProducto OrdenProducto);
    
    List<OrdenProducto> buscarOrdenProductoPorIdOrden(long idOrden);
}
