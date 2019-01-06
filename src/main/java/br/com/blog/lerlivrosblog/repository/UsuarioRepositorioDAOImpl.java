package br.com.blog.lerlivrosblog.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.blog.lerlivrosblog.model.Usuario;

@Repository
public class UsuarioRepositorioDAOImpl implements UsuarioRepositorioDAO {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public boolean cadastrarUsuario(Usuario usuario) {
		manager.persist(usuario);
		return true;
	}

	@Transactional
	public Usuario buscarUsuario(int idUsuario) {
		return manager.find(Usuario.class, new Integer(idUsuario));
	}

	@Transactional
	public Usuario logar(String apelido, String senha) {
		Usuario user = (Usuario) manager
				.createQuery("SELECT u from Usuario u where u.apelido = :apelido and u.senha = :senha")
				.setParameter("apelido", apelido).setParameter("senha", senha).getSingleResult();

		return user;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> listarUsuarios() {
		return manager.createQuery("select u from Usuario u").getResultList();
	}

	@Transactional
	public boolean excluirUsuario(int id) {
		Query query = manager.createQuery("DELETE FROM Comentario c WHERE c.usuario.id = :id");
		query.setParameter("id", id).executeUpdate();
		manager.remove(this.buscarUsuario(id));
		return true;
	}

}
