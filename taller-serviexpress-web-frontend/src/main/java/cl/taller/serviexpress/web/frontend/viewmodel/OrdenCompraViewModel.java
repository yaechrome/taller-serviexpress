package cl.taller.serviexpress.web.frontend.viewmodel;

import cl.taller.serviexpress.domain.OrdenProducto;
import cl.taller.serviexpress.domain.Usuario;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class OrdenCompraViewModel {
    private Usuario usuario;
    private Long idProveedor;
    private Date fechaEmision;
    private Date fechaFiltroHasta;
    private String estadoOrden;
    private String observacionOrden;
    private Set<OrdenProducto> ordenProducto = new HashSet<OrdenProducto>();
    private Long precioUnitario;
    private Long cantidad;
    private Long idProducto;

    
    
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

	public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(String estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public String getObservacionOrden() {
        return observacionOrden;
    }

    public void setObservacionOrden(String observacionOrden) {
        this.observacionOrden = observacionOrden;
    }

    public Set<OrdenProducto> getOrdenProducto() {
        return ordenProducto;
    }

    public void setOrdenProducto(Set<OrdenProducto> ordenProducto) {
        this.ordenProducto = ordenProducto;
    }

	/**
	 * @return the fechaFiltroHasta
	 */
	public Date getFechaFiltroHasta() {
		return fechaFiltroHasta;
	}

	/**
	 * @param fechaFiltroHasta the fechaFiltroHasta to set
	 */
	public void setFechaFiltroHasta(Date fechaFiltroHasta) {
		this.fechaFiltroHasta = fechaFiltroHasta;
	}
    
    
}
