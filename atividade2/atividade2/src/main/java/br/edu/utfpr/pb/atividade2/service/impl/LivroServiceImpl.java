package br.edu.utfpr.pb.atividade2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


import br.edu.utfpr.pb.atividade2.model.Livro;
import br.edu.utfpr.pb.atividade2.repository.LivroRepository;
import br.edu.utfpr.pb.atividade2.service.LivroService;

public class LivroServiceImpl extends CrudServiceImpl<Livro, Long> implements LivroService{

	@Autowired
	LivroRepository livroRepository;

	@Override
	protected JpaRepository<Livro, Long> getRepository() {
		return livroRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Livro> findByNomeLike(String nome) {
		return livroRepository.findByNomeLike(nome);
	}
	
	
	
	
	
	
}
