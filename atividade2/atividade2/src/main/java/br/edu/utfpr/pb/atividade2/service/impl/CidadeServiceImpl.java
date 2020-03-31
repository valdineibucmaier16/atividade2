package br.edu.utfpr.pb.atividade2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.pb.atividade2.model.Cidade;
import br.edu.utfpr.pb.atividade2.repository.CidadeRepository;
import br.edu.utfpr.pb.atividade2.service.CidadeService;


public class CidadeServiceImpl extends CrudServiceImpl<Cidade, Long> implements CidadeService {

	
	@Autowired
	private CidadeRepository cidadeRepository;	
	
	@Override
	protected JpaRepository<Cidade, Long> getRepository() {		
		return cidadeRepository;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Cidade> findByNomeLike(String nome) {
		return cidadeRepository.findByNomeLike(nome);
	}

}
