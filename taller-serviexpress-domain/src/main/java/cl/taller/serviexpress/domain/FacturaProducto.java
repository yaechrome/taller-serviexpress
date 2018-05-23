/**
 * 
 */
package cl.taller.serviexpress.domain;

/**
 * @author ochandia
 *
 */
public class FacturaProducto {

	
	private Factura factura;
	private Producto producto;
	private Long cantidad;
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
	
	
}
