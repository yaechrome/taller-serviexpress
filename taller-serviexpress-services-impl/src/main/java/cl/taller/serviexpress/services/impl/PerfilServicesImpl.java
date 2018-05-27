
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.domain.Perfil;
import cl.taller.serviexpress.dao.hibernate.PerfilDaoHibernate;
import cl.taller.serviexpress.dao.PerfilDao;
import cl.taller.serviexpress.services.PerfilServices;
import java.util.List;
public class PerfilServicesImpl implements PerfilServices{

    @Override
    public List<Perfil> listarPerfiles() {
        PerfilDaoHibernate dao = new PerfilDaoHibernate();
        return dao.findAll();
    }

    @Override
    public Perfil buscarPorPerfil(Long idPerfil) {
        PerfilDaoHibernate dao = new PerfilDaoHibernate();
        return dao.findByIdPerfil(idPerfil);
    }
    
}
