/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.web.frontend.viewmodel;

import cl.taller.serviexpress.domain.TipoProducto;

/**
 *
 * @author yaechrome
 */
public class ProductoViewModel {
	
	private Long id;
	private TipoProducto tipoProducto;
	private String nombreProducto;
	private Long precioVenta;
	private Long stock;
	private Long stockCritico;
	private Long idTipo;
	
	

    /**
	 * @return the idTipo
	 */
	public Long getIdTipo() {
		return idTipo;
	}

	/**
	 * @param idTipo the idTipo to set
	 */
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

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

	public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Long precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(Long stockCritico) {
        this.stockCritico = stockCritico;
    }
        
        
}
