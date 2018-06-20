package cl.taller.serviexpress.services.impl;

import cl.taller.serviexpress.dao.FacturaDao;
import cl.taller.serviexpress.domain.Factura;
import cl.taller.serviexpress.services.FacturaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class FacturaServicesImpl implements FacturaServices {

	@Autowired
    private FacturaDao facturaDao;

    public void setFacturaDao(FacturaDao factura) {
        this.facturaDao = factura;
    }

    @Transactional
    @Override
    public boolean crearFactura(Factura factura) {
        return facturaDao.createFactura(factura);
    }

    @Transactional
    @Override
    public boolean modificarFactura(Factura factura) {
        return facturaDao.updateFactura(factura);
    }

    @Transactional
    @Override
    public Factura buscarFacturaPorId(long idFactura) {
        return facturaDao.findByIdFactura(idFactura);
    }

    @Transactional
    @Override
    public List<Factura> listarFactura() {
        return facturaDao.findAll();
    }

    @Transactional
    @Override
    public List<Factura> buscarFacturaPorCliente(String rutCliente) {
        return facturaDao.findByCliente(rutCliente);
    }
}
