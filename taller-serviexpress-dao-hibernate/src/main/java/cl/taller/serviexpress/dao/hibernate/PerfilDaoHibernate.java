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

public class PerfilDaoHibernate extends BaseHibernate implements PerfilDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Perfil findByIdPerfil(Long idPerfil) {
        Session session = getSessionFactory().openSession();
        Perfil perfil = null;
        try {
            String sql = "from Perfil  where id = :idPerfil";

            Query query = session.createQuery(sql);
            query.setParameter("idPerfil", idPerfil);

            perfil = (Perfil) query.uniqueResult();
        } catch (Exception e) {

        }
        return perfil;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Perfil> findAll() {
        Session session = getSessionFactory().openSession();
        List<Perfil> lista = null;
        try {
            String sql = "from Perfil";

            Query query = session.createQuery(sql);

            lista = query.list();
        } catch (Exception e) {

        }
        return lista;
    }
}
