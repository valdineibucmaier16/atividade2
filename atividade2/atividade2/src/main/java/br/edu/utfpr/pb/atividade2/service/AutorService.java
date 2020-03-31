package br.edu.utfpr.pb.atividade2.service;

import java.util.List;

import br.edu.utfpr.pb.atividade2.model.Autor;

public interface AutorService extends CrudService<Autor, Long>{

	List<Autor> findByNomeLike(String nome);
}
