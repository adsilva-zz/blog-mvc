package br.com.blog.lerlivrosblog.repository;

import br.com.blog.lerlivrosblog.model.Comentario;

public interface ComentarioRepositorioDAO {

	public boolean cadastrarComentario(Comentario comentario);

	public boolean deletarComentario(int id);

}
