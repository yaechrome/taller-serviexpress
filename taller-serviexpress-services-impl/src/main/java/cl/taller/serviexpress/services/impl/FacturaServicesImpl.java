package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.FacturaDao;
import cl.taller.serviexpress.domain.Factura;
import cl.taller.serviexpress.services.FacturaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class FacturaServicesImpl implements FacturaServices {

    private FacturaDao facturaDao;
    @Autowired
    private FacturaServices facturaServices;

    public void setFacturaDao(FacturaDao factura) {
        this.facturaDao = factura;
    }

    @Override
    public boolean crearFactura(Factura factura) {
        return facturaDao.createFactura(factura);
    }

    @Override
    public boolean modificarFactura(Factura factura) {
        return facturaDao.updateFactura(factura);
    }

    @Override
    public Factura buscarFacturaPorId(long idFactura) {
        return facturaDao.findByIdFactura(idFactura);
    }

    @Override
    public List<Factura> listarFactura() {
        return facturaDao.findAll();
    }

    @Override
    public List<Factura> buscarFacturaPorCliente(String rutCliente) {
        return facturaDao.findByCliente(rutCliente);
    }
}
