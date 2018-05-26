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

import cl.taller.serviexpress.domain.Recepcion;
import cl.taller.serviexpress.dao.RecepcionDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;
public class RecepcionDaoHibernate extends BaseHibernate implements RecepcionDao{

    @Override
    public Recepcion findByIdRecepcion(long idRecepcion) {
        String sql = "from RECEPCION where ID = :idRecepcion";

		Query query = getSession().createQuery(sql);

		query.setParameter("idRecepcion", idRecepcion);

		return (Recepcion) query.uniqueResult();
    }

    @Override
    public List<Recepcion> findAllActive() {
        String sql = "from RECEPCION";

		Query query = getSession().createQuery(sql);

		return query.list();
    }

    @Override
    public List<Recepcion> findByOrden(long idOrden) {
        String sql = "from RECEPCION where ORDENCOMPRA = :idOrden";

		Query query = getSession().createQuery(sql);

		query.setParameter("idOrden", idOrden);

		return query.list();
    }

    @Override
    public boolean createRecepcion(Recepcion recepcion) {
        try {
            getSession().save(recepcion);
            getSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            
        }
        return false;
    }

    @Override
    public boolean updateRecepcion(Recepcion recepcion) {
        try {
            String sql = "update from RECEPCION set ORDENCOMPRA = :idOrden, "
                    + "IDUSUARIO = :idUsuarioEmpleado, FECHARECEPCION = :fechaRecepcion,"
                    + " VALORTOTAL = :valorTotal, ESTADORECEPCION = :estadoRecepcion "
                    + "where ID = :id";
	
            Query query = getSession().createQuery(sql);

            query.setParameter("idOrden", recepcion.getOrdenCompra().getId());
            query.setParameter("idUsuarioEmpleado", recepcion.getIdUsuario());
            query.setParameter("fechaRecepcion", recepcion.getFechaRecepcion());
            query.setParameter("valorTotal", recepcion.getValorTotal());
            query.setParameter("estadoRecepcion", recepcion.getEstadoRecepcion());
            query.setLong("id", recepcion.getId());

            int count = query.executeUpdate();

            return true;   
        } catch (Exception e) {
            
        }
        return false;
    }
    
}
