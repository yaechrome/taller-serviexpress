/**
 * 
 */
package cl.taller.serviexpress.domain;

import java.util.Date;

/**
 * @author ochandia
 *
 */

public class Reserva{
	
	private Long id;
	private Usuario usuario;
	private Date fechaReserva;
	private String descripcionReserva;
	
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
	 * @return El fechaReserva
	 */
	public Date getFechaReserva() {
		return fechaReserva;
	}
	/**
	 * @param fechaReserva 
	 *			El fechaReserva a setear
	 */
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	/**
	 * @return El descripcionReserva
	 */
	public String getDescripcionReserva() {
		return descripcionReserva;
	}
	/**
	 * @param descripcionReserva 
	 *			El descripcionReserva a setear
	 */
	public void setDescripcionReserva(String descripcionReserva) {
		this.descripcionReserva = descripcionReserva;
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
