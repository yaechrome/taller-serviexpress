
package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.DatosEmpleados;
import cl.taller.serviexpress.dao.DatosEmpleadoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;

public class DatosEmpleadoDaoHibernate extends BaseHibernate implements DatosEmpleadoDao{

    @Override
    public DatosEmpleados findByID(long idUsuario) {
        String sql = "from DATOS_EMPLEADOS as d where d.USUARIO = :idUsuario";

		Query query = getSession().createQuery(sql);

		query.setParameter("idUsuario", idUsuario);

		return (DatosEmpleados) query.uniqueResult();
    }

    @Override
    public boolean createDatosEmpleados(DatosEmpleados empleado) {
        try {
            getSession().save(empleado);
            getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean updateDatosEmpleados(DatosEmpleados empleado) {
        try {
        String sql = "update  DATOS_EMPLEADOS set FECHACONTRATACION = :fechaContratacion, "
                + "SUELDO = :sueldo, CARGO = :cargo, OBSADMINISTRATIVAS = :obsAdministrativas"
                + " where usuario = :idUsuario";

		Query query = getSession().createQuery(sql);

		query.setParameter("idUsuario", empleado.getUsuario().getId());
                query.setParameter("fechaContratacion",empleado.getFechaContratacion());
                query.setParameter("sueldo", empleado.getSueldo());
                query.setParameter("cargo", empleado.getCargo());
                query.setParameter("obs_administrativas", empleado.getObsAdministrativas());
                
                int result = query.executeUpdate();
                return true;
        } catch (Exception e) {
            
        }
	return false;	
    }
    
}
