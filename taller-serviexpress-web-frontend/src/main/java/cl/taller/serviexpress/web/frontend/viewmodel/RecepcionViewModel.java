
package cl.taller.serviexpress.web.frontend.viewmodel;

import cl.taller.serviexpress.domain.OrdenCompra;
import cl.taller.serviexpress.domain.RecepcionProducto;
import java.util.Date;
import java.util.Set;


public class RecepcionViewModel {
    	private OrdenCompra ordenCompra;
	private String idUsuario;
	private Date fechaRecepcion;
	private Date fechaFiltroHasta;
	private Long valorTotal;
	private String estadoRecepcion;
	private Set<RecepcionProducto> recepcionProducto;

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

	public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEstadoRecepcion() {
        return estadoRecepcion;
    }

    public void setEstadoRecepcion(String estadoRecepcion) {
        this.estadoRecepcion = estadoRecepcion;
    }

    public Set<RecepcionProducto> getRecepcionProducto() {
        return recepcionProducto;
    }

    public void setRecepcionProducto(Set<RecepcionProducto> recepcionProducto) {
        this.recepcionProducto = recepcionProducto;
    }
        
        
}
