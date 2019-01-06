package br.com.blog.lerlivrosblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.lerlivrosblog.model.Postagem;
import br.com.blog.lerlivrosblog.service.PostagemServico;
import br.com.blog.lerlivrosblog.session.UserSession;

@Controller
@RequestMapping("/postagem")
public class PostagemController {

	@Autowired
	private PostagemServico postagemServico;

	@Autowired
	private UserSession userSession;

	@RequestMapping("/listarPost")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("postagem/listarPost");
		modelAndView.addObject("user", userSession.getUsuario());
		modelAndView.addObject("postagens", postagemServico.listarPostRecentes());
		return modelAndView;
	}

	@RequestMapping("/salvarPost")
	public String save(Postagem post) {
		postagemServico.cadastrarPost(post);
		return "redirect:/postagem/listarPost";
	}

	@RequestMapping("/cadastrarPost")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("postagem/cadastrarPost");
		modelAndView.addObject("user", userSession.getUsuario());
		return modelAndView;
	}

	@RequestMapping("/showPost")
	public ModelAndView show(int id, String mensagem) {
		ModelAndView modelAndView = new ModelAndView("postagem/showPost");
		int qnt = postagemServico.buscarPost(id).getListaComentarios().size();
		modelAndView.addObject("user", userSession.getUsuario());
		modelAndView.addObject("post", postagemServico.buscarPost(id));
		modelAndView.addObject("qnt", qnt);
		modelAndView.addObject("mensagem", mensagem);
		return modelAndView;
	}

	@RequestMapping("/excluirPost")
	public ModelAndView excluirPost(int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/postagem/listarPost");
		postagemServico.excluirPost(id);
		return modelAndView;
	}

	@RequestMapping("/editarPost")
	public ModelAndView editarPost(int id) {
		ModelAndView modelAndView = new ModelAndView("postagem/editarPost");
		modelAndView.addObject("user", userSession.getUsuario());
		modelAndView.addObject("post", postagemServico.buscarPost(id));
		return modelAndView;
	}

	@RequestMapping("/salvarEdicao")
	public ModelAndView salvarEdicao(Postagem post) {
		ModelAndView modelAndView = new ModelAndView("redirect:/postagem/listarPost");
		postagemServico.editarPost(post);
		return modelAndView;
	}
}
