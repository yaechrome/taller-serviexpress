package cl.taller.serviexpress.web.frontend.viewmodel;

import cl.taller.serviexpress.domain.FacturaProducto;
import cl.taller.serviexpress.domain.FacturaServicio;
import cl.taller.serviexpress.domain.Usuario;
import java.util.Set;

public class FacturaViewModel {

    private Usuario usuario;
    private String rutCliente;
    private String patenteVehiculo;
    private Long valorNeto;
    private Long iva;
    private Long totalFactura;
    private String estadoFactura;
    private String estadoPago;
    private Set<FacturaServicio> facturaServicio;
    private Set<FacturaProducto> facturaProducto;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }

    public Long getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(Long valorNeto) {
        this.valorNeto = valorNeto;
    }

    public Long getIva() {
        return iva;
    }

    public void setIva(Long iva) {
        this.iva = iva;
    }

    public Long getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Long totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Set<FacturaServicio> getFacturaServicio() {
        return facturaServicio;
    }

    public void setFacturaServicio(Set<FacturaServicio> facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    public Set<FacturaProducto> getFacturaProducto() {
        return facturaProducto;
    }

    public void setFacturaProducto(Set<FacturaProducto> facturaProducto) {
        this.facturaProducto = facturaProducto;
    }

}
