/**
 * 
 */
package cl.taller.serviexpress.domain;

import cl.taller.serviexpress.domain.TipoProducto;

/**
 * @author ochandia
 *
 */

public class Producto{
	
	private Long id;
	private TipoProducto tipoProducto;
	private String nombreProducto;
	private Long precioVenta;
	private Long stock;
	private Long stockCritico;
	/**
	 * @return El tipoProducto
	 */
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	/**
	 * @param tipoProducto 
	 *			El tipoProducto a setear
	 */
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	/**
	 * @return El nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto 
	 *			El nombreProducto a setear
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return El precioVenta
	 */
	public Long getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * @param precioVenta 
	 *			El precioVenta a setear
	 */
	public void setPrecioVenta(Long precioVenta) {
		this.precioVenta = precioVenta;
	}
	/**
	 * @return El stock
	 */
	public Long getStock() {
		return stock;
	}
	/**
	 * @param stock 
	 *			El stock a setear
	 */
	public void setStock(Long stock) {
		this.stock = stock;
	}
	/**
	 * @return El stockCritico
	 */
	public Long getStockCritico() {
		return stockCritico;
	}
	/**
	 * @param stockCritico 
	 *			El stockCritico a setear
	 */
	public void setStockCritico(Long stockCritico) {
		this.stockCritico = stockCritico;
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
