package com.lacia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.lacia.api.dto.UserDTO;
import com.lacia.api.service.PesquisadorService;

@RestController
public class PesquisadorController {
	
	private PesquisadorService pesquisadorService;

	@Autowired
	public PesquisadorController(PesquisadorService pesquisadorService) {
		this.pesquisadorService = pesquisadorService;
	}
	
	@GetMapping("/pesquisadores")
	public ResponseEntity<Object> obterTodosPesquisadores(@RequestHeader String Authorization) {
		try {
			List<UserDTO> pesquisadores = pesquisadorService.obterTodosPesquisadores(Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pesquisadores);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR PESQUISADORES");
		}
	}


}
