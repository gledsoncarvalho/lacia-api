package com.lacia.api.service;

import java.util.Objects;

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
		System.out.println("a: " + user.isAprovado());
		if (dados.getSenha().equals(user.getSenha())) {
			if (Objects.isNull(user.isAprovado()) || !user.isAprovado()) {
				throw new Exception("E1");
			}
			user.setToken(tokenService.generateToken(user));
			return user;
		} else {
			throw new Exception("E2");
		}
	}

}
