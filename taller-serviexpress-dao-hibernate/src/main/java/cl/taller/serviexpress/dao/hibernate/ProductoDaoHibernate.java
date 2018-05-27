package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.Producto;
import cl.taller.serviexpress.dao.ProductoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
import cl.taller.serviexpress.domain.Perfil;
public class ProductoDaoHibernate extends BaseHibernate implements ProductoDao{

    @Override
    public Producto findByIdProducto(long idProducto) {
        String sql = "from PRODUCTO  where ID = :idProducto";

	Query query = getSession().createQuery(sql);
        query.setParameter("idProducto", idProducto);
        
	return (Producto)query.uniqueResult();
    }

    @Override
    public List<Producto> findAll() {
        String sql = "from PRODUCTO";

	Query query = getSession().createQuery(sql);

	return query.list();
    }

    @Override
    public List<Producto> findByTipo(long idTipo) {
        String sql = "from PRODUCTO  where TIPOPRODUCTO = :idTipo";

	Query query = getSession().createQuery(sql);
        query.setParameter("idTipo", idTipo);
        
        return query.list();
    }

    @Override
    public boolean createProducto(Producto producto) {
        try {
            getSession().save(producto);
            getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean updateProducto(Producto producto) {
        try {
            String sql = "update from PRODUCTO set TIPOPRODUCTO = :tipo, "
                    + "NOMBREPRODUCTO = :nombre, PRECIOVENTA = :precio, "
                    + "STOCK = :stock, STOCKCRITICO = :stock_critico"
                    + "where ID = :id_producto";
	
            Query query = getSession().createQuery(sql);

            query.setParameter("tipo", producto.getTipoProducto().getId());
            query.setParameter("nombre", producto.getNombreProducto());
            query.setLong("precio", producto.getPrecioVenta());
            query.setLong("stock", producto.getStock());
            query.setLong("stock_critico", producto.getStockCritico());
            query.setLong("id_producto", producto.getId());
            
            int count = query.executeUpdate();

            return true;   
        } catch (Exception e) {
            
        }
        return false;
    }
    
}
