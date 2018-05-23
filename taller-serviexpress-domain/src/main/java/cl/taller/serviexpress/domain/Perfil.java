package cl.taller.serviexpress.domain;

import cl.taisachile.antaios.domain.support.DomainBaseImpl;

@SuppressWarnings("serial")
public class Perfil extends DomainBaseImpl<Long, Long> {

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
	
	
}
