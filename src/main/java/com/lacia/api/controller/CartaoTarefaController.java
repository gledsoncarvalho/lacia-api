package com.lacia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacia.api.model.CartaoTarefa;
import com.lacia.api.service.CartaoTarefaService;

@RestController
public class CartaoTarefaController {

	private CartaoTarefaService cartaoTarefaService;

	@Autowired
	public CartaoTarefaController(CartaoTarefaService cartaoTarefaService) {
		this.cartaoTarefaService = cartaoTarefaService;
	}
	
	@PostMapping("/cartaoTarefa")
	public ResponseEntity<Object> cadastrarCartaoTarefa(@RequestBody CartaoTarefa cartaoTarefa, String Authorization) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.cartaoTarefaService.cadastrarCartaoTarefa(cartaoTarefa, Authorization));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL GRAVAR LISTA");
		}
	}
	
	@DeleteMapping("/cartaoTarefa/excluir/{idCartaoTarefa}")
	public ResponseEntity<Object> excluirCartaoTarefa(@PathVariable("idCartaoTarefa") Integer idCartaoTarefa, String Authorization) {
		try {
			this.cartaoTarefaService.excluirCartaoTarefa(idCartaoTarefa, Authorization);
			return ResponseEntity.status(HttpStatus.CREATED).body(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	
	@PutMapping("/cartaoTarefa/atualizar")
	public ResponseEntity<Object> atualizarCartaoTarefa(@RequestBody CartaoTarefa cartaoTarefa, String Authorization) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.cartaoTarefaService.atualizarCartaoTarefa(cartaoTarefa, Authorization));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL ATUALIZAR CARTÃO TAREFA");
		}
	}
	
	
}
