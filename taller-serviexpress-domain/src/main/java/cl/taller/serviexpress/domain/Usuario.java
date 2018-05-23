package cl.taller.serviexpress.domain;

import cl.taisachile.antaios.security.domain.support.UserImpl;

/**
 * Representa al usuario
 * 
 * @author ochandia
 *
 */
@SuppressWarnings("serial")
public class Usuario extends UserImpl<Long, Long> {

	private Perfil perfil;
	private String nombre;
	private String apellidoPaterno;
	private String rut;
	private String direccion;
	private String contactoTelefonico;

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


	
}
