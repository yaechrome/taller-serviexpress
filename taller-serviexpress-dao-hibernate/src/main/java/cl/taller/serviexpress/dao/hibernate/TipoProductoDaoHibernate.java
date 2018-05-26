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

import cl.taller.serviexpress.domain.TipoProducto;
import cl.taller.serviexpress.dao.TipoProductoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
public class TipoProductoDaoHibernate extends BaseHibernate implements TipoProductoDao{

    @Override
    public List<TipoProducto> findAllActive() {
        String sql = "from TIPOPRODUCTO";

	Query query = getSession().createQuery(sql);

	return query.list();
    }

    @Override
    public List<TipoProducto> findByFamilia(long idFamilia) {
        String sql = "from TIPOPRODUCTO  where FAMILIAPRODUCTO = :idFamilia";

	Query query = getSession().createQuery(sql);
        query.setParameter("idFamilia", idFamilia);
        
        return query.list();
    }
    
}
