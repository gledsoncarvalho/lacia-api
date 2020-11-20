package com.lacia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.lacia.api.dto.UserDTO;
import com.lacia.api.service.CoordenadorService;

@RestController
public class CoordenadorController {

	private CoordenadorService coordenadorService;

	@Autowired
	public CoordenadorController(CoordenadorService coordenadorService) {
		this.coordenadorService = coordenadorService;
	}
	
	
	@GetMapping("/coordenadores")
	public ResponseEntity<Object> obterTodosCoordenadores(@RequestHeader String Authorization) {
		try {
			List<UserDTO> usuarios = coordenadorService.obterTodosCoordenadores(Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR COORDENADORES");
		}
	}
}
