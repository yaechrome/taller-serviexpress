/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.Perfil;
import cl.taller.serviexpress.dao.PerfilDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
public class PerfilDaoHibernate extends BaseHibernate implements PerfilDao{

    @Override
    public Perfil findByIdPerfil(Long idPerfil) {
        String sql = "from PERFIL  where ID = :idPerfil";

	Query query = getSession().createQuery(sql);
        query.setParameter("idPerfil", idPerfil);
        
	return (Perfil)query.uniqueResult();
    }

    @Override
    public List<Perfil> findAll() {
        String sql = "from PERFIL";

	Query query = getSession().createQuery(sql);

	return query.list();
    }
    
}
