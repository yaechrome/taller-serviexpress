
package cl.taller.serviexpress.services;

import cl.taller.serviexpress.domain.Factura;
import java.util.List;

public interface FacturaServices {
    
    
    boolean crearFactura(Factura factura);
    boolean modificarFactura(Factura factura);
    Factura buscarFacturaPorId(long idFactura);
    List<Factura> listarFactura();
    List<Factura> buscarFacturaPorCliente(String rut);
    
    
}
