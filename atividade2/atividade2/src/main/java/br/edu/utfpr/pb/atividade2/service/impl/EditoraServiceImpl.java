package br.edu.utfpr.pb.atividade2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.utfpr.pb.atividade2.model.Editora;
import br.edu.utfpr.pb.atividade2.repository.EditoraRepository;
import br.edu.utfpr.pb.atividade2.service.EditoraService;

public class EditoraServiceImpl extends CrudServiceImpl<Editora, Long> implements EditoraService{

	@Autowired
	EditoraRepository editoraRepository;
	
	@Override
	protected JpaRepository<Editora, Long> getRepository() {
		return editoraRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Editora> findByNomeLike(String nome) {
		return editoraRepository.findByNomeLike(nome);
	}
	

}
