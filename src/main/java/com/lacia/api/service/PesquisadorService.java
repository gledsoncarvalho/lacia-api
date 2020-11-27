package com.lacia.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.dto.UserDTO;
import com.lacia.api.model.User;
import com.lacia.api.repository.UserRepository;

@Service
public class PesquisadorService {
	private UserRepository userRepository;
	private TokenService tokenService;

	@Autowired
	public PesquisadorService(UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	public List<UserDTO> obterTodosPesquisadoresAprovados(String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			Iterator iterator = userRepository.findByTipo('P').iterator();
			List<UserDTO> usuarios = new ArrayList<>();
			while (iterator.hasNext()) {
				User usuario = (User) iterator.next();
				usuarios.add(UserDTO.toDTO(usuario));
			}
			return usuarios;
		} else {
			throw new Exception();
		}
	}

	public List<UserDTO> obterTodosPesquisadores(String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			Iterator iterator = userRepository.findAll('P').iterator();
			List<UserDTO> usuarios = new ArrayList<>();
			while (iterator.hasNext()) {
				User usuario = (User) iterator.next();
				usuarios.add(UserDTO.toDTO(usuario));
			}
			return usuarios;
		} else {
			throw new Exception();
		}
	}

	public void reprovarPesquisador(Integer idUsuario, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			userRepository.reproveUser(idUsuario);
		} else {
			throw new Exception();
		}
	}

	public void aprovarPesquisador(Integer idUsuario, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			userRepository.approveUser(idUsuario);
		} else {
			throw new Exception();
		}
	}

	public void excluirPesquisador(Integer idUsuario, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			userRepository.deleteById(idUsuario);
		} else {
			throw new Exception();
		}
	}
}
