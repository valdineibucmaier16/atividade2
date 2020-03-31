package br.edu.utfpr.pb.atividade2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.pb.atividade2.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	List<Livro> findByNomeLike(String nome);
}
