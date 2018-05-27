
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.Credenciales;
import cl.taller.serviexpress.domain.DatosEmpleados;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.dao.hibernate.UsuarioDaoHibernate;
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
public class UsuarioServicesImpl implements UsuarioServices{

	private UsuarioDao userDao;
	
	@Autowired
	private UsuarioServices userServices;
	
    /**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UsuarioDao userDao) {
		this.userDao = userDao;
	}

	@Override
    public boolean crearUsuario(Usuario usuario) {
        try {
            UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
            Usuario usuario2 = udao.createUsuario(usuario);
            
            if(usuario2!=null) return true;
            
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        
        UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
                   
        return userDao.updateUsuario(usuario);    
    }

    @Override
    public List<Usuario> listarUsuarios() {

            List<Usuario> lista = userDao.findAllActive();
            return lista;
    }

    @Override
    public Usuario buscarPorID(long id) {
        try {
            UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
            Usuario usuario = new Usuario();

            usuario = udao.findByIdUsuario(id);
            if(usuario!=null)
                return usuario;
            
        } catch (Exception e) {
            
        }
        return null;    }

    @Override
    public boolean crearDatosEmpleado(DatosEmpleados empleado) {
        DatosEmpleadoDaoHibernate cdao = new DatosEmpleadoDaoHibernate();

        return cdao.createDatosEmpleados(empleado);
    }

    @Override
    public Usuario buscarPorRut(String rut) {
        try {
            UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
            Usuario usuario = new Usuario();

            usuario = udao.findByRut(rut);
            if(usuario!=null)
                return usuario;
            
        } catch (Exception e) {
            
        }
        
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crearCredenciales(Credenciales credenciales) {

        CredencialesDaoHibernate cdao = new CredencialesDaoHibernate();

        return cdao.createCredenciales(credenciales);

    }
    
}
