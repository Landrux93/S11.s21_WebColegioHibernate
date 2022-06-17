package modelo.dao;

import modelo.entity.Curso;
import java.util.List;

public interface ICursoDAO
{
    public void grabarCurso(Curso objCurso) ;
    public void insertarCurso() ;
    public void actualizarCurso(Curso objCurso) ;
    public void eliminarCurso(int id) ;
    public Curso obtenerCurso(int id) ;
    public List<Curso> obtenerCursos() ;
}
