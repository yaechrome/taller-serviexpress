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
public class FamiliaProducto extends DomainBaseImpl<Long,Long>{
	
	private String descripcionFamilia;

	/**
	 * @return El descripcionFamilia
	 */
	public String getDescripcionFamilia() {
		return descripcionFamilia;
	}

	/**
	 * @param descripcionFamilia 
	 *			El descripcionFamilia a setear
	 */
	public void setDescripcionFamilia(String descripcionFamilia) {
		this.descripcionFamilia = descripcionFamilia;
	}
	
	

}
