
package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.dao.OrdenCompraDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;

public class OrdenCompraDaoHibernate extends BaseHibernate implements OrdenCompraDao{

    @Override
    public OrdenCompra findByIdOrden(long idOrden) {
        String sql = "from ORDENCOMPRA as o where o.ID = :idOrden";

		Query query = getSession().createQuery(sql);

		query.setParameter("idOrden", idOrden);

		return (OrdenCompra) query.uniqueResult();
    }

    @Override
    public List<OrdenCompra> findAll() {
        String sql = "from ORDENCOMPRA";

		Query query = getSession().createQuery(sql);

		return query.list();
    }

    @Override
    public List<OrdenCompra> findByProveedor(long idProveedor) {
        String sql = "from ORDENCOMPRA where IDPROVEEDOR = :idProveedor";
            

		Query query = getSession().createQuery(sql);
                query.setParameter("idProveedor", idProveedor);

		return query.list();
    }

    @Override
    public boolean createOrdenCompra(OrdenCompra ordenCompra) {
        try {
            getSession().save(ordenCompra);
            getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean updateOrdenCompra(OrdenCompra ordenCompra) {
        try {
            String sql = "update from ORDENCOMPRA set USUARIO = :idUsuarioEmpleado,"
                    + " IDPROVEEDOR = :idProveedor, FECHAEMISION = :fechaEmision,"
                    + " ESTADOORDEN = :estadoOrden, OBSERVACIONORDEN = :observacionOrden"
                    + " where ID = :id";
	
            Query query = getSession().createQuery(sql);

            query.setParameter("idUsuarioEmpleado", ordenCompra.getUsuario().getId());
            query.setParameter("idProveedor", ordenCompra.getIdProveedor());
            query.setParameter("fechaEmision", ordenCompra.getFechaEmision());
            query.setParameter("estadoOrden", ordenCompra.getEstadoOrden());
            query.setParameter("observacionOrden", ordenCompra.getObservacionOrden());
            query.setLong("id", ordenCompra.getId());

            int count = query.executeUpdate();

            return true;   
        } catch (Exception e) {
            
        }
        return false;
    }
    
}
