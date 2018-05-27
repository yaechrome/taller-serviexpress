
package cl.taller.serviexpress.services;

import cl.taller.serviexpress.domain.Producto;
import cl.taller.serviexpress.domain.TipoProducto;
import cl.taller.serviexpress.domain.FamiliaProducto;
import java.util.List;

public interface ProductoServices {
    
    boolean crearProducto(Producto producto);
    
    boolean modificarProducto(Producto producto);
    
    Producto buscarProductoPorId(long idProducto);
    
    List<Producto> listarProductos();
    
    List<TipoProducto> listarTiposProductosPorFamilia(long idFamilia);
    
    List<Producto> listarProductosPorTipo(long idTipo);
    
    List<TipoProducto> listarTiposProductos();
    
    List<FamiliaProducto> listarFamiliasProductos();
    
    
}
