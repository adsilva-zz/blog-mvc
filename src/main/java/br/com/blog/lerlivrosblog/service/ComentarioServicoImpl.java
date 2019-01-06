package br.com.blog.lerlivrosblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.lerlivrosblog.model.Comentario;
import br.com.blog.lerlivrosblog.repository.ComentarioRepositorioDAO;

@Service
public class ComentarioServicoImpl implements ComentarioServico {

	@Autowired
	private ComentarioRepositorioDAO comentarioRepositorio;

	public boolean cadastrarComentario(Comentario comentario) {
		comentarioRepositorio.cadastrarComentario(comentario);
		return true;
	}

	public boolean deletarComentario(int id) {
		comentarioRepositorio.deletarComentario(id);
		return true;
	}

}
