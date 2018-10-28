package br.com.iftm.comentarios;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;


@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Table(name = "post_comentario")
public class PostComentario implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer       id;
  @NotEmpty
  @Size(max = 100)
  private String        autor;
  @NotNull
  private Integer       idPost;
  @NotEmpty
  @Size(max = 1000)
  private String        texto;
  private LocalDateTime dataInclusao;

}
