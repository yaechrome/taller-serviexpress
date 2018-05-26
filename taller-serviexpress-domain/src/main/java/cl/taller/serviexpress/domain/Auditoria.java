/**
 * 
 */
package cl.taller.serviexpress.domain;

/**
 * @author ochandia
 *
 */
public class Auditoria{
    
	private Long id;
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
