package br.com.iftm.comentarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class PostComentarioController {

  private final PostComentarioRepository repository;

  @Autowired
  public PostComentarioController(PostComentarioRepository repository) {
    this.repository = repository;
  }

  @GetMapping(value = "/post/{idPost:[0-9.,]*$}/comentario")
  public ResponseEntity<List<PostComentario>> buscar(@PathVariable Integer idPost) {
    return ResponseEntity.ok(repository.findByIdPost(idPost));
  }

  @GetMapping(value = "/post/{idPost:[0-9.,]*$}/comentario/count")
  public ResponseEntity<Map<String, Long>> contarPorPost(@PathVariable Integer idPost) {
    Map<String, Long> resultado = new HashMap<>();
    resultado.put("quantidade", repository.countByIdPost(idPost));
    return ResponseEntity.ok(resultado);
  }

  @GetMapping(value = "/post/top/comentario")
  public ResponseEntity<List<Integer>> buscarIdsTopComentarios(@RequestParam(value = "quantidade", defaultValue = "10") Integer quantidade) {
    return ResponseEntity.ok(repository.buscarIdsPostTopComentarios(PageRequest.of(0, quantidade)));
  }

}
