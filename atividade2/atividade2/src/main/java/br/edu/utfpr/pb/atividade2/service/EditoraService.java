package br.edu.utfpr.pb.atividade2.service;

import java.util.List;

import br.edu.utfpr.pb.atividade2.model.Editora;

public interface EditoraService extends CrudService<Editora, Long>{

	List<Editora> findByNomeLike(String nome);
}
