package br.com.iftm.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PostController {

  private final PostRepository     repository;
  private final PostTopComentarios postTopComentarios;

  @Autowired
  public PostController(PostRepository repository, PostTopComentarios postTopComentarios) {
    this.repository = repository;
    this.postTopComentarios = postTopComentarios;
  }

  @GetMapping(value = "/{id:[0-9.,]*$}/texto")
  public ResponseEntity<Post> buscarTexto(@PathVariable Integer id) {
    Post post = repository.buscarTextoPorId(id);
    Integer ida = post.getId();
    return ResponseEntity.ok(post);
  }

  @GetMapping
  public ResponseEntity<List<Post>> buscarTopComentarios(@RequestParam(value = "quantidade", defaultValue = "10") Integer quantidade) {
    return ResponseEntity.ok(postTopComentarios.buscar(quantidade));
  }
}
