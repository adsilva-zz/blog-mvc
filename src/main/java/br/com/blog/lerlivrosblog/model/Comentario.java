package br.com.blog.lerlivrosblog.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario implements Comparable<Comentario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Usuario usuario;
	private String texto;
	private LocalDateTime dataCriacao;
	@ManyToOne
	private Postagem postagem;

	public Comentario() {

	}

	public Comentario(Usuario usuario, String texto, LocalDateTime dataCriacao, Postagem postagem) {
		super();
		this.usuario = usuario;
		this.texto = texto;
		this.dataCriacao = dataCriacao;
		this.postagem = postagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getId() {
		return id;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public int compareTo(Comentario comentario) {
		return this.dataCriacao.compareTo(comentario.getDataCriacao());
	}

}
