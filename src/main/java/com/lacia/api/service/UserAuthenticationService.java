package com.lacia.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.dto.DadosLogin;
import com.lacia.api.dto.UserDTO;
import com.lacia.api.dto.UserRegistrationDTO;
import com.lacia.api.exception.ExistingEmailException;
import com.lacia.api.exception.InvalidLoginException;
import com.lacia.api.model.User;
import com.lacia.api.repository.UserRepository;

@Service
public class UserAuthenticationService {

	private final UserRepository userRepository;
	private final TokenService tokenService;

	@Autowired
	public UserAuthenticationService(UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	public User authenticate(DadosLogin dados) throws Exception {
		User user = userRepository.findByEmail(dados.getEmail());
		if (dados.getSenha().equals(user.getSenha())) {
			user.setToken(tokenService.generateToken(user));
			return user;
		} else {
			throw new InvalidLoginException();
		}
	}

}
