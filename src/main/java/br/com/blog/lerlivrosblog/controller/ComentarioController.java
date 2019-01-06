package br.com.blog.lerlivrosblog.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.blog.lerlivrosblog.model.Comentario;
import br.com.blog.lerlivrosblog.model.Postagem;
import br.com.blog.lerlivrosblog.model.Usuario;
import br.com.blog.lerlivrosblog.service.ComentarioServico;
import br.com.blog.lerlivrosblog.service.PostagemServico;
import br.com.blog.lerlivrosblog.service.UsuarioServico;
import br.com.blog.lerlivrosblog.utilities.Validacao;

@WebServlet(name = "salvarComentario", urlPatterns = "/comentario/salvarComentario")
public class ComentarioController extends HttpServlet {

	private static final long serialVersionUID = -4486366780994479605L;

	@Autowired
	private ComentarioServico comentarioServico;

	@Autowired
	private PostagemServico postagemServico;

	@Autowired
	private UsuarioServico usuarioServico;

	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Resgatando o objeto post
		Postagem post = new Postagem();
		post = postagemServico.buscarPost(Integer.parseInt(req.getParameter("postId")));

		// Resgatando o objeto usuario
		Usuario usuario = new Usuario();
		usuario = usuarioServico.buscarUsuario(Integer.parseInt(req.getParameter("usuarioId")));

		// Montando o Objeto Comentario
		Comentario comentario = new Comentario();
		comentario.setTexto(req.getParameter("comentario"));
		comentario.setDataCriacao(LocalDateTime.now());
		comentario.setPostagem(post);
		comentario.setUsuario(usuario);

		// condição para deletar comentario
		if (Integer.parseInt(req.getParameter("deletar")) == 1) {
			comentarioServico.deletarComentario(Integer.parseInt(req.getParameter("idComentario")));
			resp.sendRedirect("http://localhost:8080/lerlivrosblog/postagem/showPost?id=" + post.getid());
		} else {
			// condição para salvar comentario

			// Validando o comentário
			if (Validacao.validarPalavrasOfensivas(comentario.getTexto())) {
				String mensagem = "Não é permitido palavras ofensivas";
				resp.sendRedirect("http://localhost:8080/lerlivrosblog/postagem/showPost?id=" + post.getid()
						+ "&mensagem=" + mensagem);
			} else {
				// Salvando o Objeto comentario
				comentarioServico.cadastrarComentario(comentario);
				resp.sendRedirect("http://localhost:8080/lerlivrosblog/postagem/showPost?id=" + post.getid());
			}

		}
	}

}
