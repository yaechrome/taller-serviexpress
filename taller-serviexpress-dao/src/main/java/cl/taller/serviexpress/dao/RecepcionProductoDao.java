
package cl.taller.serviexpress.dao;
import cl.taller.serviexpress.domain.RecepcionProducto;
import java.util.List;


public interface RecepcionProductoDao {
        
    List<RecepcionProducto> findByRecepcion(long idRecepcion);
        
    boolean createRecepcionProducto(RecepcionProducto recepcionProducto);
        
    boolean updateRecepcionProducto(RecepcionProducto recepcionProducto);
}
