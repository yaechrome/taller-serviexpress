/**
 * 
 */
package cl.taller.serviexpress.web.frontend.viewmodel;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.domain.RecepcionProducto;

/**
 * @author ochandia
 *
 */

public class RecepcionFormatedViewModel{
	
	private Long id;
	private OrdenCompra ordenCompra;
	private String idUsuario;
	private String fechaRecepcion;
	private Long valorTotal;
	private String estadoRecepcion;
	private Set<RecepcionProducto> recepcionProducto = new HashSet<RecepcionProducto>();
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the ordenCompra
	 */
	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}
	/**
	 * @param ordenCompra the ordenCompra to set
	 */
	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the fechaRecepcion
	 */
	public String getFechaRecepcion() {
		return fechaRecepcion;
	}
	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	/**
	 * @return the valorTotal
	 */
	public Long getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(Long valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the estadoRecepcion
	 */
	public String getEstadoRecepcion() {
		return estadoRecepcion;
	}
	/**
	 * @param estadoRecepcion the estadoRecepcion to set
	 */
	public void setEstadoRecepcion(String estadoRecepcion) {
		this.estadoRecepcion = estadoRecepcion;
	}
	/**
	 * @return the recepcionProducto
	 */
	public Set<RecepcionProducto> getRecepcionProducto() {
		return recepcionProducto;
	}
	/**
	 * @param recepcionProducto the recepcionProducto to set
	 */
	public void setRecepcionProducto(Set<RecepcionProducto> recepcionProducto) {
		this.recepcionProducto = recepcionProducto;
	}
	

	

}
