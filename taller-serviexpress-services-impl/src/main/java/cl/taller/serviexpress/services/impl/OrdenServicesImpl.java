
package cl.taller.serviexpress.services.impl;
import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.services.OrdenCompraServices;
import cl.taller.serviexpress.dao.hibernate.OrdenCompraDaoHibernate;
import cl.taller.serviexpress.dao.hibernate.OrdenProductoDaoHibernate;
import cl.taller.serviexpress.domain.OrdenProducto;
import java.util.List;
public class OrdenServicesImpl implements OrdenCompraServices{

    @Override
    public boolean crearOrdenCompra(OrdenCompra ordenCompra) {
        OrdenCompraDaoHibernate dao = new OrdenCompraDaoHibernate();
        return dao.createOrdenCompra(ordenCompra);
    }

    @Override
    public boolean modificarOrdenCompra(OrdenCompra ordenCompra) {
        OrdenCompraDaoHibernate dao = new OrdenCompraDaoHibernate();
        return dao.updateOrdenCompra(ordenCompra);
    }

    @Override
    public OrdenCompra buscarOrdenCompraPorId(long idOrdenCompra) {
        OrdenCompraDaoHibernate dao = new OrdenCompraDaoHibernate();
        return dao.findByIdOrden(idOrdenCompra);
    }

    @Override
    public List<OrdenCompra> listarOrdenCompra() {
        OrdenCompraDaoHibernate dao = new OrdenCompraDaoHibernate();
        return dao.findAll();
    }

    @Override
    public List<OrdenCompra> listarOrdenCompraPorProveedor(long idProveedor) {
        OrdenCompraDaoHibernate dao = new OrdenCompraDaoHibernate();
        return dao.findByProveedor(idProveedor);
    }

    @Override
    public boolean crearOrdenProducto(OrdenProducto OrdenProducto) {
        OrdenProductoDaoHibernate dao = new OrdenProductoDaoHibernate();
        return dao.createOrdenProducto(OrdenProducto);
    }

    @Override
    public boolean modificarOrdenProducto(OrdenProducto OrdenProducto) {
        OrdenProductoDaoHibernate dao = new OrdenProductoDaoHibernate();
        return dao.updateOrdenProducto(OrdenProducto);
    }

    @Override
    public List<OrdenProducto> buscarOrdenProductoPorIdOrden(long idOrden) {
        OrdenProductoDaoHibernate dao = new OrdenProductoDaoHibernate();
        return dao.findByOrden(idOrden);
    }
    
}
