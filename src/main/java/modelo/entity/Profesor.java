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
@Table(name = "tbDocente")
public class Profesor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idtbDocente")
  int idDocente;
  @Column(name = "nombreDocente")
  String nombreDocente;
  @Column(name = "apellidoDocente")
  String apellidoDocente;
  @Column(name = "especialidadDocente")
  String especialidadDocente;
  @Column(name = "fecha")
  String fechaDocente;

  public Profesor() {
  }

  public Profesor(int idDocente, String nombreDocente, String apellidoDocente, String especialidadDocente, String fechaDocente) {
    this.idDocente = idDocente;
    this.nombreDocente = nombreDocente;
    this.apellidoDocente = apellidoDocente;
    this.especialidadDocente = especialidadDocente;
    this.fechaDocente = fechaDocente;
  }

  public int getIdDocente() {
    return idDocente;
  }

  public void setIdDocente(int idDocente) {
    this.idDocente = idDocente;
  }

  public String getNombreDocente() {
    return nombreDocente;
  }

  public void setNombreDocente(String nombreDocente) {
    this.nombreDocente = nombreDocente;
  }

  public String getApellidoDocente() {
    return apellidoDocente;
  }

  public void setApellidoDocente(String apellidoDocente) {
    this.apellidoDocente = apellidoDocente;
  }

  public String getEspecialidadDocente() {
    return especialidadDocente;
  }

  public void setEspecialidadDocente(String especialidadDocente) {
    this.especialidadDocente = especialidadDocente;
  }

  public String getFechaDocente() {
    return fechaDocente;
  }

  public void setFechaDocente(String fechaDocente) {
    this.fechaDocente = fechaDocente;
  }

  


}
