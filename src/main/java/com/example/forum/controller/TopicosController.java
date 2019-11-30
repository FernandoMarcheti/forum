package com.example.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.controller.dto.TopicoDto;
import com.example.forum.model.Curso;
import com.example.forum.model.Topico;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@GetMapping
	public List<TopicoDto> lista() {
		Topico topico = new Topico("Titulo 1", "Mensagem título 1", new Curso("Spring", "Programação"));
		
		return TopicoDto.converte(Arrays.asList(topico));
	}
}
