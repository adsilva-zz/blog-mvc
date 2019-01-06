package br.com.blog.lerlivrosblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.lerlivrosblog.model.TipoUsuario;
import br.com.blog.lerlivrosblog.model.Usuario;
import br.com.blog.lerlivrosblog.repository.UsuarioRepositorioDAO;

@Service
public class UsuarioServicoImpl implements UsuarioServico {

	@Autowired
	private UsuarioRepositorioDAO usuarioRepositorio;

	public boolean cadastrarUsuario(Usuario usuario) {
		usuario.setTipo(TipoUsuario.CADASTRADO);
		return usuarioRepositorio.cadastrarUsuario(usuario);
	}

	public Usuario buscarUsuario(int idUsuario) {
		return usuarioRepositorio.buscarUsuario(idUsuario);
	}

	public Usuario logar(String apelido, String senha) {
		return usuarioRepositorio.logar(apelido, senha);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.listarUsuarios();
	}

	public boolean excluirUsuario(int id) {
		return usuarioRepositorio.excluirUsuario(id);
	}

}
