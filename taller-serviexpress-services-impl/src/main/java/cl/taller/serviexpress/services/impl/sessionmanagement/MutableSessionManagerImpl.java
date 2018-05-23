package cl.taller.serviexpress.services.impl.sessionmanagement;

import cl.taisachile.antaios.security.sessionmanagement.MutableSessionManager;
import cl.taller.serviexpress.domain.Usuario;

/**
 * Implementa un decorador sobre MutableSessionManager.
 * 
 * El decorador permite aplicar reglas de negocio sobre usuarios autenticados.
 */
public class MutableSessionManagerImpl implements MutableSessionManager<Usuario> {

	private MutableSessionManager<Usuario> mutableSessionManager;

	/**
	 * Obtiene el administrador subyacente.
	 */
	public MutableSessionManager<Usuario> getMutableSessionManager() {
		return mutableSessionManager;
	}

	/**
	 * Establece el administrador subyacente.
	 */
	public void setMutableSessionManager(MutableSessionManager<Usuario> mutableSessionManager) {
		this.mutableSessionManager = mutableSessionManager;
	}

	@Override
	public Usuario getCurrentUser() {
		return mutableSessionManager.getCurrentUser();
	}

	@Override
	public void setCurrentUser(Usuario user) {
		mutableSessionManager.setCurrentUser(user);
	}

}
