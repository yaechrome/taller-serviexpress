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
public class TipoProducto extends DomainBaseImpl<Long,Long>{
	
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
	
	

}
