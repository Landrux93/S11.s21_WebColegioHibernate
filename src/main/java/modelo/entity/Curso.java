
package modelo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author ANIBAL
 */
@Entity
@Table(name = "curso")
public class Curso 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCurso")
	int idCurso;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "docente")
	String docente;
	@Column(name = "lugar")
	String lugar;
	
	public Curso(int idCurso, String nombre, String docente, String lugar) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.docente = docente;
		this.lugar = lugar;
	}
	
	public Curso() 
	{
		super();
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	

}
