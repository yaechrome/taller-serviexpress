
package cl.taller.serviexpress.services.impl;
import cl.taller.serviexpress.dao.OrdenCompraDao;
import cl.taller.serviexpress.dao.OrdenProductoDao;
import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.services.OrdenCompraServices;
import cl.taller.serviexpress.domain.OrdenProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
public class OrdenServicesImpl implements OrdenCompraServices{

	@Autowired
    private OrdenCompraDao ordenCompraDao;

	@Autowired
    private OrdenProductoDao ordenProductoDao;

    /**
     * @param ordenDao the userDao to set
     */
    public void setOrdenCompraDao(OrdenCompraDao ordenCompraDao) {
        this.ordenCompraDao = ordenCompraDao;
    }
    
    /**
     * @param ordenDao the userDao to set
     */
    public void setOrdenProductoDao(OrdenProductoDao ordenProductoDao) {
        this.ordenProductoDao = ordenProductoDao;
    }
    
    @Transactional
    @Override
    public boolean crearOrdenCompra(OrdenCompra ordenCompra) {
        return ordenCompraDao.createOrdenCompra(ordenCompra);
    }

    @Transactional
    @Override
    public boolean modificarOrdenCompra(OrdenCompra ordenCompra) {
        return ordenCompraDao.updateOrdenCompra(ordenCompra);
    }

    @Transactional
    @Override
    public OrdenCompra buscarOrdenCompraPorId(long idOrdenCompra) {
        return ordenCompraDao.findByIdOrden(idOrdenCompra);
    }

    @Transactional
    @Override
    public List<OrdenCompra> listarOrdenCompra() {
        return ordenCompraDao.findAll();
    }

    @Transactional
    @Override
    public List<OrdenCompra> listarOrdenCompraPorProveedor(long idProveedor) {
        return ordenCompraDao.findByProveedor(idProveedor);
    }

    @Transactional
    @Override
    public boolean crearOrdenProducto(OrdenProducto OrdenProducto) {
        return ordenProductoDao.createOrdenProducto(OrdenProducto);
    }

    @Transactional
    @Override
    public boolean modificarOrdenProducto(OrdenProducto OrdenProducto) {
        return ordenProductoDao.updateOrdenProducto(OrdenProducto);
    }

    @Transactional
    @Override
    public List<OrdenProducto> buscarOrdenProductoPorIdOrden(long idOrden) {
        return ordenProductoDao.findByOrden(idOrden);
    }
    
}
