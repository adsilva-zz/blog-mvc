package br.com.blog.lerlivrosblog.repository;

import java.util.List;

import br.com.blog.lerlivrosblog.model.Postagem;

public interface PostagemRepositorioDAO {

	public boolean cadastrarPost(Postagem post);

	public List<Postagem> listarPost();

	public Postagem buscarPost(int id);

	public boolean excluirPost(int id);

	public boolean editarPost(Postagem post);
}
