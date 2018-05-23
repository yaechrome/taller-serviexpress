/**
 * 
 */
package cl.taller.serviexpress.domain;

/**
 * @author ochandia
 *
 */
public class FacturaServicio {

	private Factura factura;
	private Servicio servicio;
	private String idMecanico;
	
	
	/**
	 * @return El factura
	 */
	public Factura getFactura() {
		return factura;
	}
	/**
	 * @param factura 
	 *			El factura a setear
	 */
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	/**
	 * @return El servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}
	/**
	 * @param servicio 
	 *			El servicio a setear
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	/**
	 * @return El idMecanico
	 */
	public String getIdMecanico() {
		return idMecanico;
	}
	/**
	 * @param idMecanico 
	 *			El idMecanico a setear
	 */
	public void setIdMecanico(String idMecanico) {
		this.idMecanico = idMecanico;
	}
	
	
	
}
