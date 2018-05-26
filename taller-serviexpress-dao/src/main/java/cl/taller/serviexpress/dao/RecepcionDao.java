
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.Recepcion;
import java.util.List;


public interface RecepcionDao {

	Recepcion findByIdRecepcion(long idRecepcion);

	List<Recepcion> findAllActive();
        
        List<Recepcion> findByOrden(long idOrden);
        
        boolean createRecepcion(Recepcion recepcion);
        
        boolean updateRecepcion(Recepcion recepcion);
}
