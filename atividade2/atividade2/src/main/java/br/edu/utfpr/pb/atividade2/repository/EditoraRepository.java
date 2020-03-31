package br.edu.utfpr.pb.atividade2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.pb.atividade2.model.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long>{

	List<Editora> findByNomeLike(String nome);
}
