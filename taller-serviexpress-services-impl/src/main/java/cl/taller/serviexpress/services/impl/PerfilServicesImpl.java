
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.Perfil;
import cl.taller.serviexpress.dao.hibernate.PerfilDaoHibernate;
import cl.taller.serviexpress.dao.PerfilDao;
import cl.taller.serviexpress.dao.UsuarioDao;
import cl.taller.serviexpress.services.PerfilServices;
import cl.taller.serviexpress.services.UsuarioServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
public class PerfilServicesImpl implements PerfilServices{

    private PerfilDao perfilDao;

    @Autowired
    private PerfilServices perfilServices;

	/**
	 * @param perfilDao the perfilDao to set
	 */
	public void setPerfilDao(PerfilDao perfilDao) {
		this.perfilDao = perfilDao;
	}

	@Override
    public List<Perfil> listarPerfiles() {
        return perfilDao.findAll();
    }

    @Override
    public Perfil buscarPorPerfil(Long idPerfil) {
        return perfilDao.findByIdPerfil(idPerfil);
    }
    
}
