package com.lacia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lacia.api.model.ListaTarefa;
import com.lacia.api.service.ListaTarefaService;

@RestController
@CrossOrigin(origins = "*")
public class ListaTarefaController {

	private ListaTarefaService listaTarefaService;

	@Autowired
	public ListaTarefaController(ListaTarefaService listaTarefaService) {
		this.listaTarefaService = listaTarefaService;
	}
	
	@PostMapping("/listaTarefa")
	public ResponseEntity<Object> cadastrarTarefa(@RequestBody ListaTarefa listaTarefa, String Authorization) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.listaTarefaService.cadastrarListaTarefa(listaTarefa, Authorization));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL GRAVAR LISTA");
		}
	}
	
	@GetMapping("/listaTarefa/todos/{idProjeto}")
	public ResponseEntity<Object> obterTodosListaTarefa(@PathVariable("idProjeto") Integer idProjeto, String Authorization) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.listaTarefaService.obterListasTarefas(idProjeto, Authorization));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL GRAVAR LISTA");
		}
	}
	
	@DeleteMapping("/listaTarefa/excluir/{idListaTarefa}")
	public ResponseEntity<Object> excluirListaTarefa(@PathVariable("idListaTarefa") Integer idListaTarefa, String Authorization) {
		try {
			this.listaTarefaService.excluirListaTarefa(idListaTarefa, Authorization);
			return ResponseEntity.status(HttpStatus.CREATED).body(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	
	@PutMapping("/listaTarefa/atualizar")
	public ResponseEntity<Object> atualizarListaTarefa(@RequestBody ListaTarefa listaTarefa, String Authorization) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.listaTarefaService.atualizarListaTarefa(listaTarefa, Authorization));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL ATUALIZAR LISTA TAREFA");
		}
	}
}
