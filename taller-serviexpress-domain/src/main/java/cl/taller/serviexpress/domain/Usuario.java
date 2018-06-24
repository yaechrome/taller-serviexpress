package cl.taller.serviexpress.domain;

/**
 * Representa al usuario
 * 
 * @author ochandia
 *
 */

public class Usuario {

	private Long id;
	private Perfil perfil;
	private String nombre;
	private String apellidoPaterno;
	private String rut;
	private String direccion;
	private String contactoTelefonico;
	private String username;
	private String password;

	/**
	 * @return El nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            El nombre a setear
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return El apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            El apellidoPaterno a setear
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}



	public String getRut() {
		return rut;
	}
	
	

	public void setRut(String rut) {
		this.rut = rut;
	}
	
	

	/**
	 * @return El perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil
	 *            El perfil a setear
	 */
	public void setPerfil(Perfil rol) {
		this.perfil = rol;
	}

	/**
	 * @return El direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion 
	 *			El direccion a setear
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return El contactoTelefonico
	 */
	public String getContactoTelefonico() {
		return contactoTelefonico;
	}

	/**
	 * @param contactoTelefonico 
	 *			El contactoTelefonico a setear
	 */
	public void setContactoTelefonico(String contactoTelefonico) {
		this.contactoTelefonico = contactoTelefonico;
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
