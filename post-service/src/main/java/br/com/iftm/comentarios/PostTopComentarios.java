package br.com.iftm.comentarios;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostTopComentarios {

  private final PostRepository repository;
  private final RestTemplate   restTemplate;

  @Autowired
  public PostTopComentarios(PostRepository repository, RestTemplate restTemplate) {
    this.repository = repository;
    this.restTemplate = restTemplate;
  }

  @HystrixCommand(fallbackMethod = "buscarSimples")
  public List<Post> buscar(Integer quantidade) {
    URI uri = URI.create("http://localhost:8082/comentario/post/top/comentario?quantidade=" + quantidade);
    Integer[] ids = this.restTemplate.getForObject(uri, Integer[].class);
    if (ids == null) {
      throw new RuntimeException("Top comentarios não encontrado");
    }
    List<Integer> idsList = Arrays.asList(ids);
    List<Post> posts = repository.buscarSimples(Arrays.asList(ids));
    return posts.stream()
                .sorted(Comparator.comparingInt(o -> idsList.indexOf(o.getId())))
                .collect(Collectors.toList());
  }


  public List<Post> buscarSimples(Integer quantidade) {
    return repository.buscarSimples(PageRequest.of(0, quantidade, Sort.by("dataInclusao")));
  }
}
