/**
 * 
 */
package cl.taller.serviexpress.dao;

import java.util.List;

import cl.taisachile.antaios.dao.ng.DomainBaseCrudDataAccessObject;
import cl.taller.serviexpress.domain.Perfil;
/**
 * @author ochandia
 *
 */
public interface PerfilDao extends DomainBaseCrudDataAccessObject<Perfil,Long,Long> {

	/**
	 * Busca un perfil por medio de su identificador.
	 * 
	 * @param idPerfil
	 *            El identificador del perfil
	 * @return retorna el perfil correspondiente al identificador
	 */
	Perfil findByIdPerfil(Long idPerfil);

	/**
	 * Busca todos los perfiles disponibles.
	 * 
	 * @return retorna la lista de perfiles
	 */
	List<Perfil> findAll();

}
