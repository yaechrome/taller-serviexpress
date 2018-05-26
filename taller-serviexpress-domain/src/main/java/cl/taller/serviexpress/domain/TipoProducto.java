/**
 * 
 */
package cl.taller.serviexpress.domain;

/**
 * @author ochandia
 *
 */

public class TipoProducto{
	
	private Long id;
	private FamiliaProducto familiaProducto;
	private String descripcionTipo;
	
	/**
	 * @return El familiaProducto
	 */
	public FamiliaProducto getFamiliaProducto() {
		return familiaProducto;
	}
	/**
	 * @param familiaProducto 
	 *			El familiaProducto a setear
	 */
	public void setFamiliaProducto(FamiliaProducto familiaProducto) {
		this.familiaProducto = familiaProducto;
	}
	/**
	 * @return El descripcionTipo
	 */
	public String getDescripcionTipo() {
		return descripcionTipo;
	}
	/**
	 * @param descripcionTipo 
	 *			El descripcionTipo a setear
	 */
	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
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
