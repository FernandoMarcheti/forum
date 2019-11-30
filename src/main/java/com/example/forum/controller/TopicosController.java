package com.example.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.controller.dto.TopicoDto;
import com.example.forum.model.Topico;
import com.example.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		List<Topico> topicos = null;
		if(nomeCurso == null) {
			topicos = topicoRepository.findAll();
		} else {
			topicos = topicoRepository.findByCurso_Nome(nomeCurso);
		}
		
		return TopicoDto.converte(topicos);
	}
}
