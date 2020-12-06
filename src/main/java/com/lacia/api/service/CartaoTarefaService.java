package com.lacia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.dto.CartaoTarefaDTO;
import com.lacia.api.model.CartaoTarefa;
import com.lacia.api.repository.CartaoTarefaRepository;
import com.lacia.api.repository.UserRepository;

@Service
public class CartaoTarefaService {
	
	private CartaoTarefaRepository cartaoTarefaRepository;
	private UserRepository userRepository;
	private TokenService tokenService;
	
	@Autowired
	public CartaoTarefaService(CartaoTarefaRepository cartaoTarefaRepository, UserRepository userRepository, TokenService tokenService) {
		this.cartaoTarefaRepository = cartaoTarefaRepository;
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}
	
	public List<CartaoTarefa> cadastrarCartaoTarefa(CartaoTarefaDTO cartaoTarefaDTO, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			CartaoTarefa cartaoTarefa = CartaoTarefaDTO.toCartaoTarefa(cartaoTarefaDTO);
			cartaoTarefa = this.cartaoTarefaRepository.save(cartaoTarefa);
			System.out.println("ID AQUI2:: " + cartaoTarefaDTO.getIdListaTarefa());
			return this.cartaoTarefaRepository.findAllByIdListaTarefa(cartaoTarefaDTO.getIdListaTarefa());
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

	public CartaoTarefa atualizarCartaoTarefa(CartaoTarefaDTO cartaoTarefaDTO, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			CartaoTarefa cartaoTarefa = CartaoTarefaDTO.toCartaoTarefa(cartaoTarefaDTO);
			return this.cartaoTarefaRepository.save(cartaoTarefa);
		} else {
			throw new Exception();
		}
	}

	
	
	
	
	

}
