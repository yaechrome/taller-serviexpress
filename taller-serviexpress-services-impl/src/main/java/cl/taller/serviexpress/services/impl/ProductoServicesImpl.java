package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.FamiliaProductoDao;
import cl.taller.serviexpress.dao.ProductoDao;
import cl.taller.serviexpress.dao.TipoProductoDao;
import cl.taller.serviexpress.domain.FamiliaProducto;
import cl.taller.serviexpress.domain.Producto;
import cl.taller.serviexpress.domain.TipoProducto;
import cl.taller.serviexpress.services.ProductoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class ProductoServicesImpl implements ProductoServices{

	@Autowired
	private ProductoDao productoDao;

    /**
     * @param producto the productoDao to set
     */
    public void setProductoDao(ProductoDao producto) {
        this.productoDao = producto;
    }
    
    @Autowired
    private TipoProductoDao tipoProductoDao;

    /**
     * @param tipoProducto  the tipoProductoDao to set
     */
    public void setTipoProductoDao(TipoProductoDao tipoProducto) {
        this.tipoProductoDao = tipoProducto;
    }
    
    @Autowired
    private FamiliaProductoDao familiaProductoDao;

   
    /**
     * @param ordenDao the userDao to set
     */
    public void setFamiliaProductoDao(FamiliaProductoDao familiaProducto) {
        this.familiaProductoDao = familiaProducto;
    }
    
    @Transactional
    @Override
    public boolean crearProducto(Producto producto) {
        return productoDao.createProducto(producto);
    }

    @Transactional
    @Override
    public boolean modificarProducto(Producto producto) {
        return productoDao.updateProducto(producto);
    }

    @Transactional
    @Override
    public Producto buscarProductoPorId(long idProducto) {
        return productoDao.findByIdProducto(idProducto);
    }

    @Transactional
    @Override
    public List<Producto> listarProductos() {
        return productoDao.findAll();

    }

    @Transactional
    @Override
    public List<TipoProducto> listarTiposProductosPorFamilia(long idFamilia) {
        return tipoProductoDao.findByFamilia(idFamilia);
    }

    @Transactional
    @Override
    public List<Producto> listarProductosPorTipo(long idTipo) {
        return productoDao.findByTipo(idTipo);
    }

    @Transactional
    @Override
    public List<TipoProducto> listarTiposProductos() {
        return tipoProductoDao.findAllActive();
    }

    @Transactional
    @Override
    public List<FamiliaProducto> listarFamiliasProductos() {
        return familiaProductoDao.findAll();
    }

    @Transactional
    @Override
    public TipoProducto buscarTipoProductoPorId(long id) {
        return tipoProductoDao.findById(id);
    }
    
}
