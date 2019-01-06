package br.com.blog.lerlivrosblog.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import br.com.blog.lerlivrosblog.model.Usuario;

@Component
@SessionScope
public class UserSession {
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
