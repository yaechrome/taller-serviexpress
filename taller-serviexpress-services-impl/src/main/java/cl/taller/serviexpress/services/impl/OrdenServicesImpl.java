
package cl.taller.serviexpress.services.impl;
import cl.taller.serviexpress.dao.OrdenCompraDao;
import cl.taller.serviexpress.dao.OrdenProductoDao;
import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.services.OrdenCompraServices;
import cl.taller.serviexpress.dao.hibernate.OrdenCompraDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.OrdenProductoDaoHibernate;
import cl.taller.serviexpress.domain.OrdenProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
public class OrdenServicesImpl implements OrdenCompraServices{

    private OrdenCompraDao ordenCompraDao;

    @Autowired
    private OrdenCompraServices ordenServices;

    /**
     * @param ordenDao the userDao to set
     */
    public void setOrdenCompraDao(OrdenCompraDao ordenCompraDao) {
        this.ordenCompraDao = ordenCompraDao;
    }
    
    private OrdenProductoDao ordenProductoDao;

   
    /**
     * @param ordenDao the userDao to set
     */
    public void setOrdenProductoDao(OrdenProductoDao ordenProductoDao) {
        this.ordenProductoDao = ordenProductoDao;
    }
    
    
    @Override
    public boolean crearOrdenCompra(OrdenCompra ordenCompra) {
        return ordenCompraDao.createOrdenCompra(ordenCompra);
    }

    @Override
    public boolean modificarOrdenCompra(OrdenCompra ordenCompra) {
        return ordenCompraDao.updateOrdenCompra(ordenCompra);
    }

    @Override
    public OrdenCompra buscarOrdenCompraPorId(long idOrdenCompra) {
        return ordenCompraDao.findByIdOrden(idOrdenCompra);
    }

    @Override
    public List<OrdenCompra> listarOrdenCompra() {
        return ordenCompraDao.findAll();
    }

    @Override
    public List<OrdenCompra> listarOrdenCompraPorProveedor(long idProveedor) {
        return ordenCompraDao.findByProveedor(idProveedor);
    }

    @Override
    public boolean crearOrdenProducto(OrdenProducto OrdenProducto) {
        return ordenProductoDao.createOrdenProducto(OrdenProducto);
    }

    @Override
    public boolean modificarOrdenProducto(OrdenProducto OrdenProducto) {
        return ordenProductoDao.updateOrdenProducto(OrdenProducto);
    }

    @Override
    public List<OrdenProducto> buscarOrdenProductoPorIdOrden(long idOrden) {
        return ordenProductoDao.findByOrden(idOrden);
    }
    
}
