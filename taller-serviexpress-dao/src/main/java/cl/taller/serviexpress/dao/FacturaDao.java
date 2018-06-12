package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.Factura;
import java.util.List;

public interface FacturaDao {

    Factura findByIdFactura(long idFactura);

    List<Factura> findAll();

    List<Factura> findByCliente(String rutCliente);

    boolean createFactura(Factura factura);

    boolean updateFactura(Factura factura);
}
