package com.lacia.api.service;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.dto.UserDTO;
import com.lacia.api.dto.UserPasswordDTO;
import com.lacia.api.dto.UserRegistrationDTO;
import com.lacia.api.exception.InvalidLoginException;
import com.lacia.api.model.User;
import com.lacia.api.repository.UserRepository;

import net.bytebuddy.asm.Advice.Thrown;

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

	public User atualizar(UserDTO usuario, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			User user = userRepository.findId(usuario.getIdUsuario());
			user.setNome(usuario.getNome());
			user.setTelefone(usuario.getTelefone());
			user.setEmail(usuario.getEmail());
			user.setDataNascimento(usuario.getDataNascimento());
			user.setCpf(usuario.getCpf());
			user.setToken(tokenService.generateToken(user));
			return userRepository.save(user);
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
		if (!token.isEmpty() && tokenService.validate(token)) {
			System.out.println("ENTROU");
			User user = userRepository.findByEmail(email);
			return user;
		} else {
			throw new Exception();
		}
	}
	
	public User atualizarImagem(Integer id, byte[] fotoPerfil, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			User user = userRepository.findId(id);
		    user.setFotoPerfil(fotoPerfil);
			user.setToken(tokenService.generateToken(user));
		    return userRepository.save(user);
		} else {
			throw new Exception();
		}
	}
	
	public void atualizarSenha(Integer id, UserPasswordDTO usuario, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			User user = userRepository.findByIdAndPassword(id, usuario.getSenhaAtual());
			if (user != null) {
				user.setSenha(usuario.getNovaSenha());
				user = userRepository.save(user);
			} else {
				throw new Exception();
			}
		} else {
			throw new Exception();
		}
	}
	
	public void solicitarAcessoPesquisador(UserDTO user) throws Exception {
		User usuario = user.toUser();
		usuario.setSenha("lacia123");
		usuario.setTipoUsuario('P');
		usuario.setDataNascimento(new Date(System.currentTimeMillis()));
		userRepository.save(usuario);
	}
	
	public void recuperarSenha(String email) throws Exception {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new Exception();
		}
	}
	
}
