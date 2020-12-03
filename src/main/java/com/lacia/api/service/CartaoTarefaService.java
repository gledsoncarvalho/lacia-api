package com.lacia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.model.CartaoTarefa;
import com.lacia.api.repository.CartaoTarefaRepository;

@Service
public class CartaoTarefaService {
	
	private CartaoTarefaRepository cartaoTarefaRepository;
	private TokenService tokenService;
	
	@Autowired
	public CartaoTarefaService(CartaoTarefaRepository cartaoTarefaRepository, TokenService tokenService) {
		this.cartaoTarefaRepository = cartaoTarefaRepository;
		this.tokenService = tokenService;
	}
	
	public List<CartaoTarefa> cadastrarCartaoTarefa(CartaoTarefa cartaoTarefa, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			this.cartaoTarefaRepository.save(cartaoTarefa);
			return this.cartaoTarefaRepository.findAllByIdListaTarefa(cartaoTarefa.getListaTarefa().getIdListaTarefa());
		} else {
			throw new Exception();
		}
	}
	
	public void excluirCartaoTarefa(Integer idCartaoTarefa, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			this.cartaoTarefaRepository.deleteById(idCartaoTarefa);
		} else {
			throw new Exception();
		}
	}

	public CartaoTarefa atualizarCartaoTarefa(CartaoTarefa cartaoTarefa, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			return this.cartaoTarefaRepository.save(cartaoTarefa);
		} else {
			throw new Exception();
		}
	}

	
	
	
	
	

}
