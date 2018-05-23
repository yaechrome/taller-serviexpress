/**
 * 
 */
package cl.taller.serviexpress.domain;

import cl.taisachile.antaios.domain.support.DomainBaseImpl;

/**
 * @author ochandia
 *
 */
@SuppressWarnings("serial")
public class Servicio extends DomainBaseImpl<Long,Long>{

	private String estadoServicio;
	private Long valor;
	private String descripcionServicio;
	
	
	/**
	 * @return El estadoServicio
	 */
	public String getEstadoServicio() {
		return estadoServicio;
	}
	/**
	 * @param estadoServicio 
	 *			El estadoServicio a setear
	 */
	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}
	/**
	 * @return El valor
	 */
	public Long getValor() {
		return valor;
	}
	/**
	 * @param valor 
	 *			El valor a setear
	 */
	public void setValor(Long valor) {
		this.valor = valor;
	}
	/**
	 * @return El descripcionServicio
	 */
	public String getDescripcionServicio() {
		return descripcionServicio;
	}
	/**
	 * @param descripcionServicio 
	 *			El descripcionServicio a setear
	 */
	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}
	
	
}
