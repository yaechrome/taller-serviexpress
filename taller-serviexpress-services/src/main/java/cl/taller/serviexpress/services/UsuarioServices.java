
package cl.taller.serviexpress.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.domain.Credenciales;
import cl.taller.serviexpress.domain.DatosEmpleados;
import java.util.List;

public interface UsuarioServices extends UserDetailsService {
    
    boolean crearUsuario(Usuario usuario);
    
    boolean modificarUsuario(Usuario usuario);
    
    List<Usuario> listarUsuarios();
    
    List<Usuario> listarUsuariosPorPerfil(long idPerfil);
    
    Usuario buscarPorID(long id);
    
    boolean crearDatosEmpleado(DatosEmpleados empleado);
    
    Usuario buscarPorRut(String rut);
    
    boolean crearCredenciales(Credenciales credenciales);
    
    boolean modificarCredenciales(Credenciales credenciales);
     
}
