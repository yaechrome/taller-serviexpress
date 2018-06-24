package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.DatosEmpleados;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.dao.DatosEmpleadoDao;
import cl.taller.serviexpress.dao.UsuarioDao;
import cl.taller.serviexpress.services.UsuarioServices;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class UsuarioServicesImpl implements UsuarioServices {

	@Autowired
    private UsuarioDao userDao;
    
	@Autowired
    private DatosEmpleadoDao datosEmpleadoDao;

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(UsuarioDao userDao) {
        this.userDao = userDao;
    }
    
    /**
     * @param DatosEmpleadoDao the datosEmpleado to set
     */
    public void setDatosEmpleadoDao(DatosEmpleadoDao datosEmpleado) {
            this.datosEmpleadoDao = datosEmpleado;
    }
    
	
    @Override
    public boolean crearUsuario(Usuario usuario) {
        Usuario usuario2 = userDao.createUsuario(usuario);

        if (usuario2 != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        return userDao.updateUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return userDao.findAllActive();
    }

    @Override
    public Usuario buscarPorID(long id) {
        return userDao.findByIdUsuario(id);
    }

    @Override
    public boolean crearDatosEmpleado(DatosEmpleados empleado) {
        return datosEmpleadoDao.createDatosEmpleados(empleado);
    }

    @Override
    public Usuario buscarPorRut(String rut) {
        return  userDao.findByRut(rut);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Usuario> listarUsuariosPorPerfil(long idPerfil) {
        return userDao.findByPerfil(idPerfil);
    }

	@Override
	public Usuario authentication(String username, String password) {
		Usuario usuario=null;
		try { 
			usuario = userDao.findByUsernameAndPassword(username, password);
		}catch(Exception e){
			
		}
		return usuario; 
	}

}
