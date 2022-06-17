
package modelo.dao;

import modelo.entity.Curso;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.*;

public class CursoDAO implements ICursoDAO
{
    @Override
    public void grabarCurso(Curso objCurso) 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            System.out.println("start a transaction");// start a transaction
            transaction = session.beginTransaction();

            // operation 1
            System.out.println("operation 1");
            Object object = session.save(objCurso);

            // operation 2
            System.out.println("operation 2");
            session.get(Curso.class, (Serializable) object);

            // commit transaction
            System.out.println("commit transaction");
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
    public void insertarCurso() 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            String hql = "INSERT INTO Curso (idCurso, nombre, docente, lugar) "
                            + "SELECT idCurso, nombre, docente, lugar FROM Curso";


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
    public void actualizarCurso(Curso objCurso) 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            // save the student object
            String hql = "UPDATE Curso SET nombre = :nombre " 
                                    + " , docente = :docente "
                                    + " , lugar = :lugar "
                                    + "WHERE idCurso = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", objCurso.getNombre());
            query.setParameter("docente", objCurso.getDocente());
            query.setParameter("lugar", objCurso.getLugar());
            query.setParameter("ID", objCurso.getIdCurso());
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
    public void eliminarCurso(int id) 
    {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a student object
            Curso objCurso = session.get(Curso.class, id);
            if (objCurso != null) 
            {
                    String hql = "DELETE FROM Curso " + "WHERE idCurso = :ID";
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
    public Curso obtenerCurso(int id) 
    {

        Transaction transaction = null;
        Curso objCurso = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();

            // get an student object
            String hql = " FROM Curso C WHERE C.id = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("ID", id);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) 
            {
                    objCurso = (Curso) results.get(0);
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
        return objCurso;
    }
    @Override
    public List<Curso> obtenerCursos() 
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            return session.createQuery("from Curso", Curso.class).list();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
}
