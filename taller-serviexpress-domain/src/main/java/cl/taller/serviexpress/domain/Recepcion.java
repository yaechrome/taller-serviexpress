/**
 * 
 */
package cl.taller.serviexpress.domain;


import java.util.Date;
import java.util.Set;

import cl.taisachile.antaios.domain.support.DomainBaseImpl;
/**
 * @author ochandia
 *
 */
@SuppressWarnings("serial")
public class Recepcion extends DomainBaseImpl<Long,Long>{
	
	private OrdenCompra ordenCompra;
	private String idUsuario;
	private Date fechaRecepcion;
	private Long valorTotal;
	private String estadoRecepcion;
	private Set<RecepcionProducto> recepcionProducto;
	
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
	 * @return El idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario 
	 *			El idUsuario a setear
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return El fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	/**
	 * @param fechaRecepcion 
	 *			El fechaRecepcion a setear
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	/**
	 * @return El valorTotal
	 */
	public Long getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal 
	 *			El valorTotal a setear
	 */
	public void setValorTotal(Long valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return El estadoRecepcion
	 */
	public String getEstadoRecepcion() {
		return estadoRecepcion;
	}
	/**
	 * @param estadoRecepcion 
	 *			El estadoRecepcion a setear
	 */
	public void setEstadoRecepcion(String estadoRecepcion) {
		this.estadoRecepcion = estadoRecepcion;
	}
	/**
	 * @return El recepcionProdcuto
	 */
	public Set<RecepcionProducto> getRecepcionProducto() {
		return recepcionProducto;
	}
	/**
	 * @param recepcionProdcuto 
	 *			El recepcionProdcuto a setear
	 */
	public void setRecepcionProducto(Set<RecepcionProducto> recepcionProducto) {
		this.recepcionProducto = recepcionProducto;
	}
	
	

}
