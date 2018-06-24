/**
 * 
 */
package cl.taller.serviexpress.web.frontend.viewmodel;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ochandia
 *
 */
public class LoginViewModel {

	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
