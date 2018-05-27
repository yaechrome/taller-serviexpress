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
public class UsuarioServicesImpl implements UsuarioServices {

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
        Usuario usuario2 = userDao.createUsuario(usuario);

        if (usuario2 != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {
        UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
        return udao.updateUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return userDao.findAllActive();
    }

    @Override
    public Usuario buscarPorID(long id) {
        UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
        return udao.findByIdUsuario(id);
    }

    @Override
    public boolean crearDatosEmpleado(DatosEmpleados empleado) {
        DatosEmpleadoDaoHibernate cdao = new DatosEmpleadoDaoHibernate();
        return cdao.createDatosEmpleados(empleado);
    }

    @Override
    public Usuario buscarPorRut(String rut) {
        UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
        return udao.findByRut(rut);
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

    @Override
    public boolean modificarCredenciales(Credenciales credenciales) {
        CredencialesDaoHibernate cdao = new CredencialesDaoHibernate();
        return cdao.updateCredenciales(credenciales);
    }

    @Override
    public List<Usuario> listarUsuariosPorPerfil(long idPerfil) {
        UsuarioDaoHibernate udao = new UsuarioDaoHibernate();
        return udao.findByPerfil(idPerfil);
    }

}
