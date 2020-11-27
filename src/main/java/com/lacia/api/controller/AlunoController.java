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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.lacia.api.dto.UserAutheticatedDTO;
import com.lacia.api.dto.UserDTO;
import com.lacia.api.model.User;
import com.lacia.api.service.AlunoService;

@RestController
public class AlunoController {
	
	private AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@CrossOrigin
	@GetMapping("/alunos")
	public ResponseEntity<Object> obterTodosAlunos(@RequestHeader String Authorization) {
		try {
			List<UserDTO> usuarios = alunoService.obterTodosAlunos(Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR ALUNOS");
		}
	}
	
	@CrossOrigin
	@DeleteMapping("aluno/excluir/{idUsuario}")
	public ResponseEntity<Object> excluirPesquisador(@RequestHeader String Authorization, @PathVariable("idUsuario") Integer idUsuario) {
		try {
			this.alunoService.excluirAluno(idUsuario, Authorization);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}

	@CrossOrigin
	@PostMapping("/aluno/cadastrar")
	public ResponseEntity<Object> cadastrar(@RequestBody UserDTO userRegistrationDTO,
			@RequestHeader String Authorization) {
		try {
			User user = alunoService.cadastrar(userRegistrationDTO.toUser(), Authorization);
			return new ResponseEntity<Object>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL CADASTRAR O USUÁRIO");
		}

	}
}
