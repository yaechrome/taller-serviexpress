/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.FacturaProducto;
import java.util.List;

/**
 *
 * @author CETECOM
 */
public interface FacturaProductoDao {
    
    List<FacturaProducto> findByFactura(long idFactura);
        
    boolean createFacturaProducto(FacturaProducto facturaProducto);
        
    boolean updateFacturaProducto(FacturaProducto facturaProducto);
}
