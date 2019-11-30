package com.example.forum.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.example.forum.model.Curso;
import com.example.forum.model.Topico;
import com.example.forum.repository.CursoRepository;

public class TopicoForm {

	@NotBlank
	@Length(min = 5, max = 256)
	private String titulo;
	@NotBlank
	@Length(min = 5, max = 2000)
	private String mensagem;
	@NotBlank
	private String nomeCurso;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converte(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(this.nomeCurso);
		return new Topico(this.titulo, this.mensagem, curso);
	}

}
