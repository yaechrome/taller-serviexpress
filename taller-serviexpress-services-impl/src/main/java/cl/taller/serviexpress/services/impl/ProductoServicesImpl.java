
package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.hibernate.FamiliaProductoDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.ProductoDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.TipoProductoDaoHibernate;
import cl.taller.serviexpress.domain.FamiliaProducto;
import cl.taller.serviexpress.domain.Producto;
import cl.taller.serviexpress.domain.TipoProducto;
import cl.taller.serviexpress.services.ProductoServices;
import java.util.List;


public class ProductoServicesImpl implements ProductoServices{

    @Override
    public boolean crearProducto(Producto producto) {
        ProductoDaoHibernate dao = new ProductoDaoHibernate();
         
        return dao.createProducto(producto);
    }

    @Override
    public boolean modificarProducto(Producto producto) {
        ProductoDaoHibernate dao = new ProductoDaoHibernate();
         
        return dao.updateProducto(producto);
    }

    @Override
    public Producto buscarProductoPorId(long idProducto) {
        try {
            ProductoDaoHibernate dao = new ProductoDaoHibernate();
            Producto producto = new Producto();

            producto = dao.findByIdProducto(idProducto);
            if(producto!=null)
                return producto;
            
        } catch (Exception e) {
            
        }
        return null; 
    }

    @Override
    public List<Producto> listarProductos() {
        ProductoDaoHibernate udao = new ProductoDaoHibernate();
        List<Producto> lista = udao.findAll();
        return lista;
    }

    @Override
    public List<TipoProducto> listarTiposProductosPorFamilia(long idFamilia) {
        TipoProductoDaoHibernate udao = new TipoProductoDaoHibernate();
        List<TipoProducto> lista = udao.findByFamilia(idFamilia);
        return lista;
    }

    @Override
    public List<Producto> listarProductosPorTipo(long idTipo) {
        ProductoDaoHibernate udao = new ProductoDaoHibernate();
        List<Producto> lista = udao.findByTipo(idTipo);
        return lista;
    }

    @Override
    public List<TipoProducto> listarTiposProductos() {
        TipoProductoDaoHibernate udao = new TipoProductoDaoHibernate();
        List<TipoProducto> lista = udao.findAllActive();
        return lista;
    }

    @Override
    public List<FamiliaProducto> listarFamiliasProductos() {
        FamiliaProductoDaoHibernate udao = new FamiliaProductoDaoHibernate();
        List<FamiliaProducto> lista = udao.findAll();
        return lista;
    }
    
}
