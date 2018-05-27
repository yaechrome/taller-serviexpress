
package cl.taller.serviexpress.services.impl;
import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.services.OrdenCompraServices;
import cl.taller.serviexpress.dao.hibernate.OrdenCompraDaoHibernate;
import cl.taller.serviexpress.domain.OrdenProducto;
import java.util.List;
public class OrdenServicesImpl implements OrdenCompraServices{

    @Override
    public boolean crearOrdenCompra(OrdenCompra ordenCompra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarOrdenCompra(OrdenCompra ordenCompra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrdenCompra buscarOrdenCompraPorId(long idOrdenCompra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdenCompra> listarOrdenCompra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdenCompra> listarOrdenCompraPorProveedor(long idProveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crearOrdenProducto(OrdenProducto OrdenProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarOrdenProducto(OrdenProducto OrdenProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdenProducto> buscarOrdenProductoPorIdOrden(long idOrden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
