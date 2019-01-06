package br.com.blog.lerlivrosblog.service;

import java.util.List;

import br.com.blog.lerlivrosblog.model.Usuario;

public interface UsuarioServico {

	public boolean cadastrarUsuario(Usuario usuario);
	
	public Usuario buscarUsuario(int idUsuario);
	
	public List<Usuario> listarUsuarios();
	
	public Usuario logar(String apelido, String senha);
	
	public boolean excluirUsuario(int id);

}
