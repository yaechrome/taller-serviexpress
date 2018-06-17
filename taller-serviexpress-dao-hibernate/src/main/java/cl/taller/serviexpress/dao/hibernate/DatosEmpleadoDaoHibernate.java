package cl.taller.serviexpress.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.taller.serviexpress.domain.DatosEmpleados;
import cl.taller.serviexpress.dao.DatosEmpleadoDao;
import cl.taller.serviexpress.dao.hibernate.base.BaseHibernate;

public class DatosEmpleadoDaoHibernate extends BaseHibernate implements DatosEmpleadoDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public DatosEmpleados findByID(long idUsuario) {
        Session session = getSessionFactory().openSession();
        DatosEmpleados empleado = null;
        try {
            String sql = "from DatosEmpleados as d where d.usuario = :idUsuario";

            Query query = session.createQuery(sql);

            query.setParameter("idUsuario", idUsuario);

            empleado = (DatosEmpleados) query.uniqueResult();
        } catch (Exception e) {
        } 
        return empleado;
    }

    @Override
    public boolean createDatosEmpleados(DatosEmpleados empleado) {
        Session session = getSessionFactory().openSession();
        boolean creado = false;
        try {
            session.beginTransaction();

            session.save(empleado);

            session.getTransaction().commit();
            creado = true;
        } catch (Exception e) {
        } 
        return creado;

    }

    @Override
    public boolean updateDatosEmpleados(DatosEmpleados empleado) {
        Session session = getSessionFactory().openSession();
        boolean actualizado = false;
        try {
//            String sql = "update  DatosEmpleados set fechaContratacion = :fechaContratacion, "
//                    + "sueldo = :sueldo, cargo = :cargo, obsAdministrativas = :obsAdministrativas"
//                    + " where usuario = :idUsuario";
//
//            Query query = session.createQuery(sql);
//
//            query.setParameter("idUsuario", empleado.getUsuario().getId());
//            query.setParameter("fechaContratacion", empleado.getFechaContratacion());
//            query.setParameter("sueldo", empleado.getSueldo());
//            query.setParameter("cargo", empleado.getCargo());
//            query.setParameter("obs_administrativas", empleado.getObsAdministrativas());
//
//            int result = query.executeUpdate();
            session.beginTransaction();
            session.saveOrUpdate(empleado);
            actualizado = true;
            session.getTransaction().commit();
        } catch (Exception e) {

        }
        return actualizado;
    }

}
