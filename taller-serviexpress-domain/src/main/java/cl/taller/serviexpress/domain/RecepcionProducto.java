/**
 * 
 */
package cl.taller.serviexpress.domain;

import java.util.Date;

/**
 * @author ochandia
 *
 */
public class RecepcionProducto {

	private Recepcion recepcion;
	private Producto producto;
	private String codigoProducto;
	private Long cantidad;
	private Date fechaVencimiento;
	/**
	 * @return El recepcion
	 */
	public Recepcion getRecepcion() {
		return recepcion;
	}
	/**
	 * @param recepcion 
	 *			El recepcion a setear
	 */
	public void setRecepcion(Recepcion recepcion) {
		this.recepcion = recepcion;
	}
	/**
	 * @return El producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param producto 
	 *			El producto a setear
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	/**
	 * @return El codigoProducto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}
	/**
	 * @param codigoProducto 
	 *			El codigoProducto a setear
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	/**
	 * @return El cantidad
	 */
	public Long getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad 
	 *			El cantidad a setear
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return El fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	/**
	 * @param fechaVencimiento 
	 *			El fechaVencimiento a setear
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
}
