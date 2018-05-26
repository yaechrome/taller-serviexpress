
package cl.taller.serviexpress.dao.hibernate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.FamiliaProducto;
import cl.taller.serviexpress.dao.FamiliaProductoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;

public class FamiliaProductoDaoHibernate extends BaseHibernate implements FamiliaProductoDao{

    @Override
    public List<FamiliaProducto> findAll() {
        String sql = "from CREDENCIALES";

	Query query = getSession().createQuery(sql);

	return query.list();

    }
    
}
