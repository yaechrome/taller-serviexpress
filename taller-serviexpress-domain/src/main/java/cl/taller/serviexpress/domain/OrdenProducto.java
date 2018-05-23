/**
 * 
 */
package cl.taller.serviexpress.domain;

/**
 * @author ochandia
 *
 */
public class OrdenProducto {
	
	private OrdenCompra ordenCompra;
	private Producto producto;
	private Long cantidad;
	private Long precioCompra;
	
	/**
	 * @return El ordenCompra
	 */
	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}
	/**
	 * @param ordenCompra 
	 *			El ordenCompra a setear
	 */
	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
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
	/**
	 * @return El precioCompra
	 */
	public Long getPrecioCompra() {
		return precioCompra;
	}
	/**
	 * @param precioCompra 
	 *			El precioCompra a setear
	 */
	public void setPrecioCompra(Long precioCompra) {
		this.precioCompra = precioCompra;
	}
	
	

}
