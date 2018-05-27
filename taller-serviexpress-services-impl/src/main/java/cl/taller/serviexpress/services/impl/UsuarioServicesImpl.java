package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.Credenciales;
import cl.taller.serviexpress.domain.DatosEmpleados;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.dao.hibernate.UsuarioDaoHibernate;
import cl.taller.serviexpress.dao.CredencialesDao;
import cl.taller.serviexpress.dao.DatosEmpleadoDao;
import cl.taller.serviexpress.dao.UsuarioDao;
import cl.taller.serviexpress.dao.hibernate.CredencialesDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.DatosEmpleadoDaoHibernate;
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

    private UsuarioDao userDao;

    private CredencialesDao credencialesDao;
    
    private DatosEmpleadoDao datosEmpleadoDao;
    

    @Autowired
    private UsuarioServices userServices;

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(UsuarioDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @param credencialesDao the credencialesDao to set
     */
    public void setCredencialesDao(CredencialesDao credencialesDao) {
            this.credencialesDao = credencialesDao;
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
    public boolean crearCredenciales(Credenciales credenciales) {
        return credencialesDao.createCredenciales(credenciales);
    }

    @Override
    public boolean modificarCredenciales(Credenciales credenciales) {
        return credencialesDao.updateCredenciales(credenciales);
    }

    @Override
    public List<Usuario> listarUsuariosPorPerfil(long idPerfil) {
        return userDao.findByPerfil(idPerfil);
    }

}
