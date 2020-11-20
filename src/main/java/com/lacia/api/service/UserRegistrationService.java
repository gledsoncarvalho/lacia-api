package com.lacia.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.dto.UserRegistrationDTO;
import com.lacia.api.exception.InvalidLoginException;
import com.lacia.api.model.User;
import com.lacia.api.repository.UserRepository;

@Service
public class UserRegistrationService {

	private UserRepository userRepository;
	private TokenService tokenService;

	@Autowired
	public UserRegistrationService(UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	public User registrate(User user, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			System.out.println("token válido!!");
			return userRepository.save(user);
		} else {
			throw new InvalidLoginException();
		}
	}

	public User atualizar(UserRegistrationDTO usuario, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			return userRepository.save(usuario.toUser());
		} else {
			throw new Exception();
		}
	}

	public boolean excluir(UserRegistrationDTO usuario, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			userRepository.delete(usuario.toUser());
			return true;
		} else {
			throw new Exception();
		}
	}
	
	public User obterUsuario(String email, String token) throws Exception {
		System.out.println("email:: " + email);
		if (!token.isEmpty() && tokenService.validate(token)) {
			User user = userRepository.findByEmail(email);
			return user;
		} else {
			throw new Exception();
		}
	}
}
