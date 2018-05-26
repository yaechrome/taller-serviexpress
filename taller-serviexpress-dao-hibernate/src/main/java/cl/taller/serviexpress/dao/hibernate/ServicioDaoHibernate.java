/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.Servicio;
import cl.taller.serviexpress.dao.ServicioDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
public class ServicioDaoHibernate extends BaseHibernate implements ServicioDao{

    @Override
    public Servicio findByIdServicio(long idServicio) {
        String sql = "from SERVICIO where ID = :idServicio";

		Query query = getSession().createQuery(sql);

		query.setParameter("idServicio", idServicio);

		return (Servicio) query.uniqueResult();
    }

    @Override
    public List<Servicio> findAllActive() {
        String sql = "from SERVICIO";

		Query query = getSession().createQuery(sql);

		return query.list();
    }

    @Override
    public boolean createCredenciales(Servicio servicio) {
        try {
            getSession().save(servicio);
            getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean updateCredenciales(Servicio servicio) {
        try {
            String sql = "update from SERVICIO set ESTADOSERVICIO = :estadoServicio, "
                    + "VALOR = :valor, DESCRIPCIONSERVICIO = :descripcionServicio "
                    + "where ID = :id";
	
            Query query = getSession().createQuery(sql);

            query.setParameter("estado_servicio", servicio.getEstadoServicio());
            query.setParameter("valor", servicio.getValor());
            query.setParameter("descripcion_servicio", servicio.getDescripcionServicio());
            query.setLong("id", servicio.getId());

            int count = query.executeUpdate();

            return true;   
        } catch (Exception e) {
            
        }
        return false;
    }
    
}
