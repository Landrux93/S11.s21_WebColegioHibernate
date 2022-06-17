package modelo.dao;

import modelo.entity.Profesor;
import java.util.List;

public interface IProfesorDAO
{
    public void grabarProfesor(Profesor objCurso) ;
    public void insertarProfesor() ;
    public void actualizarProfesor(Profesor objCurso) ;
    public void eliminarProfesor(int id) ;
    public Profesor obtenerProfesor(int id) ;
    public List<Profesor> obtenerProfesor() ;
}
