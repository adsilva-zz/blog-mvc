package br.com.blog.lerlivrosblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.lerlivrosblog.model.Usuario;
import br.com.blog.lerlivrosblog.service.UsuarioServico;
import br.com.blog.lerlivrosblog.session.UserSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServico usuarioServico;

	@Autowired
	private UserSession userSession;

	@RequestMapping("/cadastrarUsuario")
	private ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("usuario/cadastrarUsuario");
		return modelAndView;
	}

	@RequestMapping("/salvarUsuario")
	private ModelAndView salvar(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("redirect:/postagem/listarPost");
		usuarioServico.cadastrarUsuario(usuario);
		return modelAndView;
	}

	@RequestMapping("/logar")
	private ModelAndView logar() {
		if (userSession.getUsuario() != null) {
			return new ModelAndView("redirect:/postagem/listarPost");
		}
		ModelAndView modelAndView = new ModelAndView("usuario/logar");
		return modelAndView;
	}

	@RequestMapping("/autenticar")
	private ModelAndView autenticar(String apelido, String senha) {
		Usuario user = usuarioServico.logar(apelido, senha);
		if (user != null) {
			System.out.println(user.getNome());
			userSession.setUsuario(user);
			ModelAndView modelAndView = new ModelAndView("redirect:/postagem/listarPost");
			return modelAndView;
		}
		return new ModelAndView("usuario/logar");
	}

	@RequestMapping("/sair")
	private ModelAndView sair() {
		userSession.setUsuario(null);
		ModelAndView modelAndView = new ModelAndView("redirect:/postagem/listarPost");
		return modelAndView;
	}

	@RequestMapping("/listarUsuario")
	private ModelAndView listarUsuario() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", userSession.getUsuario());
		modelAndView.addObject("usuarios", usuarioServico.listarUsuarios());
		return modelAndView;
	}

	@RequestMapping("/excluirUsuario")
	private ModelAndView excluirUsuario(int id) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/postagem/listarPost");
		usuarioServico.excluirUsuario(id);
		return modelAndView;
	}
}
