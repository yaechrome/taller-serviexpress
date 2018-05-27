
package cl.taller.serviexpress.services;

import cl.taller.serviexpress.domain.Recepcion;
import cl.taller.serviexpress.domain.RecepcionProducto;
import java.util.List;

public interface RecepcionServices {
    boolean crearRecepcion(Recepcion recepcion);
    
    boolean modificarRecepcion(Recepcion recepcion);
    
    Recepcion buscarRecepcionPorId(long idRecepcion);
    
    List<Recepcion> listarRecepciones();
    
    List<Recepcion> listarRecepcionPorOrden(long idOrden);
    
    boolean crearRecepcionProducto(RecepcionProducto recepcionProducto);
    
    boolean modificarRecepcionProducto(RecepcionProducto recepcionProducto);
    
    List<RecepcionProducto> buscarRecepcionesProductosPorIdRecepcion(long idRecepcion);
    
    
}
