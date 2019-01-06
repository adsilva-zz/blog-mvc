package br.com.blog.lerlivrosblog.service;

import br.com.blog.lerlivrosblog.model.Comentario;

public interface ComentarioServico {

	public boolean cadastrarComentario(Comentario comentario);
	
	public boolean deletarComentario(int id);
	
}
