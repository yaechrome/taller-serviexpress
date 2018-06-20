
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.Perfil;
import cl.taller.serviexpress.dao.PerfilDao;
import cl.taller.serviexpress.services.PerfilServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
public class PerfilServicesImpl implements PerfilServices{

	@Autowired
	private PerfilDao perfilDao;

    /**
     * @param perfilDao the perfilDao to set
     */
    public void setPerfilDao(PerfilDao perfilDao) {
            this.perfilDao = perfilDao;
    }

    @Transactional
	@Override
    public List<Perfil> listarPerfiles() {
        return perfilDao.findAll();
    }

    @Transactional
    @Override
    public Perfil buscarPorPerfil(Long idPerfil) {
        return perfilDao.findByIdPerfil(idPerfil);
    }
    
}
