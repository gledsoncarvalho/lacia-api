package com.lacia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.dto.ProjectDTO;
import com.lacia.api.dto.UserProjectSaveDTO;
import com.lacia.api.model.ListaTarefa;
import com.lacia.api.repository.ListaTarefaRepository;

@Service
public class ListaTarefaService {


	private ListaTarefaRepository listaTarefaRepository;
	private TokenService tokenService;

	@Autowired
	public ListaTarefaService(ListaTarefaRepository listaTarefaRepository, TokenService tokenService) {
		this.listaTarefaRepository = listaTarefaRepository;
		this.tokenService = tokenService;
	}
	
	public ListaTarefa cadastrarListaTarefa(ListaTarefa listaTarefa, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			return this.listaTarefaRepository.save(listaTarefa);
		} else {
			throw new Exception();
		}
	}
	
	public List<ListaTarefa> obterListasTarefas(Integer idProjeto, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			return this.listaTarefaRepository.findAllByIdProjeto(idProjeto);
		} else {
			throw new Exception();
		}
	}
	
	public void excluirListaTarefa(Integer idProjeto, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			this.listaTarefaRepository.deleteById(idProjeto);
		} else {
			throw new Exception();
		}
	}

	public ListaTarefa atualizarListaTarefa(ListaTarefa listaTarefa, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			return this.listaTarefaRepository.save(listaTarefa);
		} else {
			throw new Exception();
		}
	}
	
}
