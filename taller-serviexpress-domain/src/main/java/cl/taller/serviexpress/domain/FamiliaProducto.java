/**
 * 
 */
package cl.taller.serviexpress.domain;

/**
 * @author ochandia
 *
 */

public class FamiliaProducto{
	
	private Long id;
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
