/**
 * 
 */
package cl.taller.serviexpress.domain;

import java.util.Date;

/**
 * @author ochandia
 *
 */


public class DatosEmpleados {

	private Long id;
	private Usuario usuario;
	private Date fechaContratacion;
	private Long Sueldo;
	private String cargo;
	private String obsAdministrativas;
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
	 * @return El fechaContratacion
	 */
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	/**
	 * @param fechaContratacion 
	 *			El fechaContratacion a setear
	 */
	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	/**
	 * @return El sueldo
	 */
	public Long getSueldo() {
		return Sueldo;
	}
	/**
	 * @param sueldo 
	 *			El sueldo a setear
	 */
	public void setSueldo(Long sueldo) {
		Sueldo = sueldo;
	}
	/**
	 * @return El cargo
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * @param cargo 
	 *			El cargo a setear
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return El obsAdministrativas
	 */
	public String getObsAdministrativas() {
		return obsAdministrativas;
	}
	/**
	 * @param obsAdministrativas 
	 *			El obsAdministrativas a setear
	 */
	public void setObsAdministrativas(String obsAdministrativas) {
		this.obsAdministrativas = obsAdministrativas;
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
