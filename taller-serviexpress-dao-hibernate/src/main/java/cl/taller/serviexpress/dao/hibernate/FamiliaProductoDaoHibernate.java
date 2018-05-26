
package cl.taller.serviexpress.dao.hibernate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.FamiliaProducto;
import cl.taller.serviexpress.dao.FamiliaProductoDao;

public class FamiliaProductoDaoHibernate implements FamiliaProductoDao{

    @Override
    public List<FamiliaProducto> findAllActive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
