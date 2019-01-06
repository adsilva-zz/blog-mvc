package br.com.blog.lerlivrosblog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Column(unique = true)
	private String email;
	private String senha;
	@Column(unique = true)
	private String apelido;
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;

	public Usuario() {
	}

	public Usuario(String nome, String email, String senha, String apelido, TipoUsuario tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.apelido = apelido;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

}
