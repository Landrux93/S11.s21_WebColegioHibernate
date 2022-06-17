
package modelo.dao;

import modelo.entity.Profesor;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.*;

public class ProfesorDAO implements IProfesorDAO
{
    @Override
    public void grabarProfesor(Profesor objProfesor) 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            // operation 1
            Object object = session.save(objProfesor);

            // operation 2
            session.get(Profesor.class, (Serializable) object);

            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) 
        {
                if (transaction != null) 
                {
                        transaction.rollback();
                }
                e.printStackTrace();
        }
    }
    @Override
    public void insertarProfesor() 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            String hql = "INSERT INTO Profesor (idtbDocente, nombreDocente, apellidoDocente, especialidadDocente, fecha) "
                            + "SELECT idtbDocente, nombreDocente, apellidoDocente, especialidadDocente, fecha FROM Profesor";


            Query query = session.createQuery(hql);


            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            // commit transaction
            transaction.commit();
        } 
        catch (HibernateException e) 
        {
                if (transaction != null) 
                {
                        transaction.rollback();
                }
                e.printStackTrace();
        }
    }
    @Override
    public void actualizarProfesor(Profesor objProfesor) 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            // save the student object
            String hql = "UPDATE Profesor SET nombreDocente = :nombreDocente " 
                                    + " , apellidoDocente = :apellidoDocente "
                                    + " , especialidadDocente = :especialidadDocente "
                                    + " , fecha = :fecha "
                                    + "WHERE idtbDocente = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("nombreDocente", objProfesor.getNombreDocente());
            query.setParameter("apellidoDocente", objProfesor.getApellidoDocente());
            query.setParameter("especialidadDocente", objProfesor.getEspecialidadDocente());
            query.setParameter("fecha", objProfesor.getFechaDocente());
            query.setParameter("ID", objProfesor.getIdDocente());
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
            {
                    transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void eliminarProfesor(int id) 
    {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a student object
            Profesor objProfesor = session.get(Profesor.class, id);
            if (objProfesor != null) 
            {
                    String hql = "DELETE FROM Profesor " + "WHERE idtbDocente = :ID";
                    Query query = session.createQuery(hql);
                    query.setParameter("ID", id);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
            }

            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) 
        {
            if (transaction != null) 
            {
                    transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public Profesor obtenerProfesor(int id) 
    {

        Transaction transaction = null;
        Profesor objProfesor = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            // get an student object
            String hql = " FROM Profesor P WHERE P.id = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("ID", id);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) 
            {
                    objProfesor = (Profesor) results.get(0);
            }
            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) 
        {
                if (transaction != null) 
                {
                        transaction.rollback();
                }
                e.printStackTrace();
        }
        return objProfesor;
    }
    @Override
    public List<Profesor> obtenerProfesor() 
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            return session.createQuery("from Profesor", Profesor.class).list();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
}
