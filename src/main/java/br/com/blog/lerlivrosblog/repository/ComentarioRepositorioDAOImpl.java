package br.com.blog.lerlivrosblog.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.blog.lerlivrosblog.model.Comentario;

@Repository
public class ComentarioRepositorioDAOImpl implements ComentarioRepositorioDAO {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public boolean cadastrarComentario(Comentario comentario) {
		manager.persist(comentario);
		return true;
	}

	@Transactional
	public boolean deletarComentario(int id) {
		Comentario comentario = manager.find(Comentario.class, new Integer(id));
		manager.remove(comentario);
		return true;
	}

}
