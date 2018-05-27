
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.Credenciales;
import cl.taller.serviexpress.domain.DatosEmpleados;
import cl.taller.serviexpress.domain.Usuario;
import cl.taller.serviexpress.dao.hibernate.UsuarioDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.CredencialesDaoHibernate;
import cl.taller.serviexpress.services.UsuarioServices;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UsuarioServicesImpl implements UsuarioServices{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarUsuarios() {
        try {
            UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
            
            List<Usuario> lista = udao.findAllActive();
            return lista;
            
        } catch (Exception e) {
            
        }
        return null;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        try {
            
            CredencialesDaoHibernate cdao = new CredencialesDaoHibernate();
            
            if(cdao.createCredenciales(credenciales)) return true;
            
        } catch (Exception e) {
            
        }
        return false;
    }
    
}