package br.com.iftm.comentarios;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;


@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Post implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer       id;
  @NotEmpty
  @Size(max = 250)
  private String        titulo;
  @NotEmpty
  @Size(max = 500)
  private String        subTitulo;
  @NotEmpty
  @Size(max = 10000)
  private String        texto;
  private LocalDateTime dataInclusao;

  public Post(int id, String texto) {
    this.id = id;
    this.texto = texto;
  }

  public Post(Integer id, String titulo, String subTitulo, LocalDateTime dataInclusao) {
    this.id = id;
    this.titulo = titulo;
    this.subTitulo = subTitulo;
    this.dataInclusao = dataInclusao;
  }
}
