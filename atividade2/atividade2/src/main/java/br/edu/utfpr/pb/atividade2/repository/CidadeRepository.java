package br.edu.utfpr.pb.atividade2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.pb.atividade2.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	List<Cidade> findByNomeLike(String nome);
}
