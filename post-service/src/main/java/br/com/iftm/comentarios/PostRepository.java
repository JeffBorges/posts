package br.com.iftm.comentarios;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
  @Query("select new Post(p.id, p.titulo, p.subTitulo, p.dataInclusao) from Post p order by p.dataInclusao")
  List<Post> buscarSimples(Pageable page);

  @Query("select new Post(p.id, p.titulo, p.subTitulo, p.dataInclusao) from Post p where p.id in (?1)")
  List<Post> buscarSimples(List<Integer> ids);

  @Query("select new Post(p.id, p.texto) from Post p where p.id = ?1")
  Post buscarTextoPorId(Integer id);
}
