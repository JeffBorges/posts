package br.com.iftm.comentarios;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostComentarioRepository extends JpaRepository<PostComentario, Integer> {
  @Query("select c.idPost as quantidade  from PostComentario c group by c.idPost order by count(c) desc")
  List<Integer> buscarIdsPostTopComentarios(Pageable page);

  List<PostComentario> findByIdPost(Integer idPost);

  long countByIdPost(Integer idPost);
}
