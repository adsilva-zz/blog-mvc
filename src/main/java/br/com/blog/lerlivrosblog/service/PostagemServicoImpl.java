package br.com.blog.lerlivrosblog.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.lerlivrosblog.model.Comentario;
import br.com.blog.lerlivrosblog.model.Postagem;
import br.com.blog.lerlivrosblog.repository.PostagemRepositorioDAO;

@Service
public class PostagemServicoImpl implements PostagemServico {

	@Autowired
	private PostagemRepositorioDAO postagemRepositorioDAO;

	public boolean cadastrarPost(Postagem post) {
		post.setDataCriacao(LocalDateTime.now());
		return postagemRepositorioDAO.cadastrarPost(post);
	}

	public List<Postagem> listarPostRecentes() {
		List<Postagem> listaPost = postagemRepositorioDAO.listarPost();
		Collections.sort(listaPost, Collections.reverseOrder());
		return listaPost;
	}

	public Postagem buscarPost(int id) {
		Postagem post = postagemRepositorioDAO.buscarPost(id);
		List<Comentario> lista = post.getListaComentarios();
		Collections.sort(lista, Collections.reverseOrder());
		post.setListaComentarios(lista);
		return post;
	}

	public boolean excluirPost(int id) {
		return postagemRepositorioDAO.excluirPost(id);
	}

	public boolean editarPost(Postagem post) {
		postagemRepositorioDAO.editarPost(post);
		return true;
	}

}
