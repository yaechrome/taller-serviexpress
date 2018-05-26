/**
 * 
 */
package cl.taller.serviexpress.domain;

import java.util.Set;

/**
 * @author ochandia
 *
 */

public class Factura{
	
	private Long id;
	private Usuario usuario;
	private String rutCliente;
	private String patenteVehiculo;
	private Long valorNeto;
	private Long iva;
	private Long totalFactura;
	private String estadoFactura;
	private String estadoPago;
	private Set<FacturaServicio> facturaServicio;
	private Set<FacturaProducto> facturaProducto;
	
	
	/**
	 * @return El usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario 
	 *			El usuario a setear
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return El rutCliente
	 */
	public String getRutCliente() {
		return rutCliente;
	}
	/**
	 * @param rutCliente 
	 *			El rutCliente a setear
	 */
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	/**
	 * @return El patenteVehiculo
	 */
	public String getPatenteVehiculo() {
		return patenteVehiculo;
	}
	/**
	 * @param patenteVehiculo 
	 *			El patenteVehiculo a setear
	 */
	public void setPatenteVehiculo(String patenteVehiculo) {
		this.patenteVehiculo = patenteVehiculo;
	}
	/**
	 * @return El valorNeto
	 */
	public Long getValorNeto() {
		return valorNeto;
	}
	/**
	 * @param valorNeto 
	 *			El valorNeto a setear
	 */
	public void setValorNeto(Long valorNeto) {
		this.valorNeto = valorNeto;
	}
	/**
	 * @return El iva
	 */
	public Long getIva() {
		return iva;
	}
	/**
	 * @param iva 
	 *			El iva a setear
	 */
	public void setIva(Long iva) {
		this.iva = iva;
	}
	/**
	 * @return El totalFactura
	 */
	public Long getTotalFactura() {
		return totalFactura;
	}
	/**
	 * @param totalFactura 
	 *			El totalFactura a setear
	 */
	public void setTotalFactura(Long totalFactura) {
		this.totalFactura = totalFactura;
	}
	/**
	 * @return El estadoFactura
	 */
	public String getEstadoFactura() {
		return estadoFactura;
	}
	/**
	 * @param estadoFactura 
	 *			El estadoFactura a setear
	 */
	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}
	/**
	 * @return El estadoPago
	 */
	public String getEstadoPago() {
		return estadoPago;
	}
	/**
	 * @param estadoPago 
	 *			El estadoPago a setear
	 */
	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}
	/**
	 * @return El facturaServicio
	 */
	public Set<FacturaServicio> getFacturaServicio() {
		return facturaServicio;
	}
	/**
	 * @param facturaServicio 
	 *			El facturaServicio a setear
	 */
	public void setFacturaServicio(Set<FacturaServicio> facturaServicio) {
		this.facturaServicio = facturaServicio;
	}
	/**
	 * @return El facturaProducto
	 */
	public Set<FacturaProducto> getFacturaProducto() {
		return facturaProducto;
	}
	/**
	 * @param facturaProducto 
	 *			El facturaProducto a setear
	 */
	public void setFacturaProducto(Set<FacturaProducto> facturaProducto) {
		this.facturaProducto = facturaProducto;
	}
	/**
	 * @return El id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id 
	 *			El id a setear
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
