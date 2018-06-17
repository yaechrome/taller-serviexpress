package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.FamiliaProductoDao;
import cl.taller.serviexpress.dao.ProductoDao;
import cl.taller.serviexpress.dao.TipoProductoDao;
import cl.taller.serviexpress.dao.hibernate.FamiliaProductoDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.ProductoDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.TipoProductoDaoHibernate;
import cl.taller.serviexpress.domain.FamiliaProducto;
import cl.taller.serviexpress.domain.Producto;
import cl.taller.serviexpress.domain.TipoProducto;
import cl.taller.serviexpress.services.ProductoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductoServicesImpl implements ProductoServices{

    private ProductoDao productoDao;

    @Autowired
    private ProductoServices productoServices;

    /**
     * @param producto the productoDao to set
     */
    public void setProductoDao(ProductoDao producto) {
        this.productoDao = producto;
    }
    
    private TipoProductoDao tipoProductoDao;

   
    /**
     * @param tipoProducto  the tipoProductoDao to set
     */
    public void setTipoProductoDao(TipoProductoDao tipoProducto) {
        this.tipoProductoDao = tipoProducto;
    }
    
    private FamiliaProductoDao familiaProductoDao;

   
    /**
     * @param ordenDao the userDao to set
     */
    public void setFamiliaProductoDao(FamiliaProductoDao familiaProducto) {
        this.familiaProductoDao = familiaProducto;
    }
    
    @Override
    public boolean crearProducto(Producto producto) {
        return productoDao.createProducto(producto);
    }

    @Override
    public boolean modificarProducto(Producto producto) {
        return productoDao.updateProducto(producto);
    }

    @Override
    public Producto buscarProductoPorId(long idProducto) {
        return productoDao.findByIdProducto(idProducto);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoDao.findAll();

    }

    @Override
    public List<TipoProducto> listarTiposProductosPorFamilia(long idFamilia) {
        return tipoProductoDao.findByFamilia(idFamilia);
    }

    @Override
    public List<Producto> listarProductosPorTipo(long idTipo) {
        return productoDao.findByTipo(idTipo);
    }

    @Override
    public List<TipoProducto> listarTiposProductos() {
        return tipoProductoDao.findAllActive();
    }

    @Override
    public List<FamiliaProducto> listarFamiliasProductos() {
        return familiaProductoDao.findAll();
    }

    @Override
    public TipoProducto buscarTipoProductoPorId(long id) {
        return tipoProductoDao.findById(id);
    }
    
}
