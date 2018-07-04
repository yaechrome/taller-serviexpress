package cl.taller.serviexpress.web.frontend.viewmodel;

import cl.taller.serviexpress.domain.OrdenProducto;
import cl.taller.serviexpress.domain.Usuario;
import java.util.HashSet;
import java.util.Set;


public class OrdenCompraFormatedViewModel {

	private Long id;
	private Usuario usuario;
	private Long idProveedor;
	private String fechaEmision;
	private String estadoOrden;
	private String observacionOrden;
    private Set<OrdenProducto> ordenProducto = new HashSet<OrdenProducto>();
    private Long precioUnitario;
    private Long cantidad;
    private Long idProducto;
	
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
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the idProveedor
	 */
	public Long getIdProveedor() {
		return idProveedor;
	}
	/**
	 * @param idProveedor the idProveedor to set
	 */
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	/**
	 * @return the fechaEmision
	 */
	public String getFechaEmision() {
		return fechaEmision;
	}
	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	/**
	 * @return the estadoOrden
	 */
	public String getEstadoOrden() {
		return estadoOrden;
	}
	/**
	 * @param estadoOrden the estadoOrden to set
	 */
	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}
	/**
	 * @return the observacionOrden
	 */
	public String getObservacionOrden() {
		return observacionOrden;
	}
	/**
	 * @param observacionOrden the observacionOrden to set
	 */
	public void setObservacionOrden(String observacionOrden) {
		this.observacionOrden = observacionOrden;
	}
	/**
	 * @return the ordenProducto
	 */
	public Set<OrdenProducto> getOrdenProducto() {
		return ordenProducto;
	}
	/**
	 * @param ordenProducto the ordenProducto to set
	 */
	public void setOrdenProducto(Set<OrdenProducto> ordenProducto) {
		this.ordenProducto = ordenProducto;
	}
	/**
	 * @return the precioUnitario
	 */
	public Long getPrecioUnitario() {
		return precioUnitario;
	}
	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(Long precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	/**
	 * @return the cantidad
	 */
	public Long getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the idProducto
	 */
	public Long getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}



    
}
