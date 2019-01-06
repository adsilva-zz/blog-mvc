package br.com.blog.lerlivrosblog.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.blog.lerlivrosblog.model.Comentario;
import br.com.blog.lerlivrosblog.model.Postagem;

@Repository
public class PostagemRepositorioDAOImpl implements PostagemRepositorioDAO {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public boolean cadastrarPost(Postagem post) {
		manager.persist(post);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Postagem> listarPost() {
		return manager.createQuery("select p from Postagem p").getResultList();
	}

	@Transactional
	public Postagem buscarPost(int idPost) {
		return manager.find(Postagem.class, new Integer(idPost));
	}

	@Transactional
	public boolean excluirPost(int id) {
		manager.remove(this.buscarPost(id));
		return true;
	}

	@Transactional
	public boolean editarPost(Postagem post) {
		post.setDataCriacao(LocalDateTime.now());
		List<Comentario> listaComentarios = new ArrayList<Comentario>();
		post.setListaComentarios(listaComentarios);
		manager.merge(post);
		return true;
	}

}
