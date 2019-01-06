package br.com.blog.lerlivrosblog.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Postagem implements Comparable<Postagem> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	@Lob
	private String conteudo;
	private LocalDateTime dataCriacao;
	@OneToMany(mappedBy = "postagem", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Comentario> listaComentarios;

	public Postagem() {

	}

	public Postagem(String titulo, String conteudo, LocalDateTime dataCriacao) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataCriacao = dataCriacao;
		this.listaComentarios = new ArrayList<Comentario>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Comentario> getListaComentarios() {
		return listaComentarios;
	}

	public void setListaComentarios(List<Comentario> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

	public void setid(int id) {
		this.id = id;
	}

	public int getid() {
		return id;
	}

	public boolean addComentario(Comentario comentario) {
		return this.listaComentarios.add(comentario);
	}

	public int compareTo(Postagem o) {
		return this.dataCriacao.compareTo(o.getDataCriacao());
	}
}
