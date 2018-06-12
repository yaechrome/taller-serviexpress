/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.FacturaServicio;
import java.util.List;

/**
 *
 * @author CETECOM
 */
public interface FacturaServicioDao {
    
    List<FacturaServicio> findByFactura(long idFactura);
        
    boolean createFacturaServicio(FacturaServicio facturaServicio);
        
    boolean updateFacturaServicio(FacturaServicio facturaServicio);
    
}
