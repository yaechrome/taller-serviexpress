package cl.taller.serviexpress.web.frontend.viewmodel;

import cl.taller.serviexpress.domain.OrdenProducto;
import cl.taller.serviexpress.domain.Usuario;
import java.util.Date;
import java.util.Set;


public class OrdenCompraViewModel {
    private Usuario usuario;
    private Long idProveedor;
    private Date fechaEmision;
    private String estadoOrden;
    private String observacionOrden;
    private Set<OrdenProducto> ordenProducto;

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
    
    
}
