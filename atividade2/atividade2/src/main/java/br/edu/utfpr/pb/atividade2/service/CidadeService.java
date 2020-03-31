package br.edu.utfpr.pb.atividade2.service;

import java.util.List;

import br.edu.utfpr.pb.atividade2.model.Cidade;

public interface CidadeService extends CrudService<Cidade, Long>{

	List<Cidade> findByNomeLike(String nome);
}
