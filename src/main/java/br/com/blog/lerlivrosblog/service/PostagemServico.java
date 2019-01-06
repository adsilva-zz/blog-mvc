package br.com.blog.lerlivrosblog.service;

import java.util.List;

import br.com.blog.lerlivrosblog.model.Postagem;

public interface PostagemServico {

	public boolean cadastrarPost(Postagem post);

	public List<Postagem> listarPostRecentes();
	
	public Postagem buscarPost(int id);
	
	public boolean excluirPost(int id);
	
	public boolean editarPost(Postagem post);
}
