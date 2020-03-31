package br.edu.utfpr.pb.atividade2.service;

import java.util.List;

import br.edu.utfpr.pb.atividade2.model.Livro;

public interface LivroService extends CrudService<Livro, Long> {

	List<Livro> findByNomeLike(String nome);
}
