package cl.taller.serviexpress.domain;

public class Perfil{

	private Long id;
	private String detallePerfil;

	/**
	 * @return El detallePerfil
	 */
	public String getDetallePerfil() {
		return detallePerfil;
	}

	/**
	 * @param detallePerfil 
	 * 			El detallePerfil a setear
	 */
	public void setDetallePerfil(String detallePerfil) {
		this.detallePerfil = detallePerfil;
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
