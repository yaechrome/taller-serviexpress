
package cl.taller.serviexpress.services;


import cl.taller.serviexpress.domain.Servicio;
import java.util.List;

public interface ServicioServices {
    
    boolean crearServicio(Servicio servicio);
    
    List<Servicio> listarServicios();
    
    boolean modificarServicio(Servicio servicio);
    
    Servicio buscarPorId(long id);
    
}
