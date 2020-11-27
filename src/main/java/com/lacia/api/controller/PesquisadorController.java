package com.lacia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@CrossOrigin
	@GetMapping("/pesquisadores")
	public ResponseEntity<Object> obterTodosPesquisadoresAprovados(@RequestHeader String Authorization) {
		try {
			List<UserDTO> pesquisadores = pesquisadorService.obterTodosPesquisadoresAprovados(Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pesquisadores);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR PESQUISADORES");
		}
	}

	@CrossOrigin
	@GetMapping("/pesquisador/todos")
	public ResponseEntity<Object> obterTodosPesquisadores(@RequestHeader String Authorization) {
		try {
			List<UserDTO> pesquisadores = pesquisadorService.obterTodosPesquisadores(Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pesquisadores);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR PESQUISADORES");
		}
	}

	@CrossOrigin
	@DeleteMapping("pesquisador/excluir/{idUsuario}")
	public ResponseEntity<Object> excluirPesquisador(@RequestHeader String Authorization, @PathVariable("idUsuario") Integer idUsuario) {
		try {
			this.pesquisadorService.excluirPesquisador(idUsuario, Authorization);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	
	@CrossOrigin
	@PutMapping("pesquisador/aprovar/{idUsuario}")
	public ResponseEntity<Object> aprovarPesquisador(@PathVariable("idUsuario") Integer idUsuario, @RequestHeader String Authorization) {
		try {
			this.pesquisadorService.aprovarPesquisador(idUsuario, Authorization);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	
	@CrossOrigin
	@PutMapping("pesquisador/reprovar/{idUsuario}")
	public ResponseEntity<Object> reprovarPesquisador(@RequestHeader String Authorization, @PathVariable("idUsuario") Integer idUsuario) {
		try {
			this.pesquisadorService.reprovarPesquisador(idUsuario, Authorization);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
}
