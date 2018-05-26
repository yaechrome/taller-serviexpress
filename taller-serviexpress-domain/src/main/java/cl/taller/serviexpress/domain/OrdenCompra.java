/**
 * 
 */
package cl.taller.serviexpress.domain;

import java.util.Date;
import java.util.Set;

/**
 * @author ochandia
 *
 */

public class OrdenCompra{

	private Long id;
	private Usuario usuario;
	private Long idProveedor;
	private Date fechaEmision;
	private String estadoOrden;
	private String observacionOrden;
	private Set<OrdenProducto> ordenProducto;
	
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
	 * @return El idProveedor
	 */
	public Long getIdProveedor() {
		return idProveedor;
	}
	/**
	 * @param idProveedor 
	 *			El idProveedor a setear
	 */
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	/**
	 * @return El fechaEmision
	 */
	public Date getFechaEmision() {
		return fechaEmision;
	}
	/**
	 * @param fechaEmision 
	 *			El fechaEmision a setear
	 */
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	/**
	 * @return El estadoOrden
	 */
	public String getEstadoOrden() {
		return estadoOrden;
	}
	/**
	 * @param estadoOrden 
	 *			El estadoOrden a setear
	 */
	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}
	/**
	 * @return El observacionOrden
	 */
	public String getObservacionOrden() {
		return observacionOrden;
	}
	/**
	 * @param observacionOrden 
	 *			El observacionOrden a setear
	 */
	public void setObservacionOrden(String observacionOrden) {
		this.observacionOrden = observacionOrden;
	}
	/**
	 * @return El ordenProducto
	 */
	public Set<OrdenProducto> getOrdenProducto() {
		return ordenProducto;
	}
	/**
	 * @param ordenProducto 
	 *			El ordenProducto a setear
	 */
	public void setOrdenProducto(Set<OrdenProducto> ordenProducto) {
		this.ordenProducto = ordenProducto;
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
