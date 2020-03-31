package br.edu.utfpr.pb.atividade2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.utfpr.pb.atividade2.model.Genero;
import br.edu.utfpr.pb.atividade2.repository.GeneroRepository;
import br.edu.utfpr.pb.atividade2.service.GeneroService;

public class GeneroServiceImpl extends CrudServiceImpl<Genero, Long> implements GeneroService{

	
	@Autowired
	GeneroRepository generoRepository;
	
	
	@Override
	protected JpaRepository<Genero, Long> getRepository() {
		return generoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Genero> findByNomeLike(String nome) {
		return generoRepository.findByNomeLike(nome);
	}
	
}
