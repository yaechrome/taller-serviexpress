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
public class Auditoria extends DomainBaseImpl<Long,Long> {

	private String descripcionLog;

	/**
	 * @return El descripcionLog
	 */
	public String getDescripcionLog() {
		return descripcionLog;
	}

	/**
	 * @param descripcionLog 
	 *			El descripcionLog a setear
	 */
	public void setDescripcionLog(String descripcionLog) {
		this.descripcionLog = descripcionLog;
	}
	
	
	
}
