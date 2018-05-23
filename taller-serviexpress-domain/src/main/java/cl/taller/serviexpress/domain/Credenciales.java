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
public class Credenciales extends DomainBaseImpl<Long,Long>{

	private Usuario usuario;
	private String username;
	private String password;
	
	
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
	 * @return El username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username 
	 *			El username a setear
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return El password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password 
	 *			El password a setear
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
