package br.edu.utfpr.pb.atividade2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.pb.atividade2.model.Autor;
import br.edu.utfpr.pb.atividade2.repository.AutorRepository;
import br.edu.utfpr.pb.atividade2.service.AutorService;

public class AutorServiceImpl extends CrudServiceImpl<Autor, Long> implements AutorService{

	
	@Autowired
	AutorRepository autorRepository;
	
	@Override
	protected JpaRepository<Autor, Long> getRepository() {
		return autorRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Autor> findByNomeLike(String nome) {
		return autorRepository.findByNomeLike(nome);
	}
	
}
