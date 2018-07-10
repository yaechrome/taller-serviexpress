package cl.taller.serviexpress.web.frontend.viewmodel;


public class ReservaViewModel {

    private String idUsuario;
    private Long idMecanico;
    private String fecha;
    private String hora;
    private String descripcion;

	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the idMecanico
	 */
	public Long getIdMecanico() {
		return idMecanico;
	}
	/**
	 * @param idMecanico the idMecanico to set
	 */
	public void setIdMecanico(Long idMecanico) {
		this.idMecanico = idMecanico;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}
	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


    
    
}
