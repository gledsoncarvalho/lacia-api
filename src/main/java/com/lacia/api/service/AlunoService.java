package com.lacia.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.dto.UserDTO;
import com.lacia.api.exception.InvalidLoginException;
import com.lacia.api.model.User;
import com.lacia.api.repository.UserRepository;

@Service
public class AlunoService {

	private UserRepository userRepository;
	private TokenService tokenService;

	@Autowired
	public AlunoService(UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}
	

    public List<UserDTO> obterTodosAlunos(String token) throws Exception {
    	if (!token.isEmpty() && tokenService.validate(token)) {
    		Iterator iterator = userRepository.findByTipo('A').iterator();
        	List<UserDTO> usuarios = new ArrayList<>();
        	while(iterator.hasNext()) {
        		User usuario = (User) iterator.next();
        		usuarios.add(UserDTO.toDTO(usuario));
        	}
        	return usuarios;
		} else {
			throw new Exception();
		}
    }
    
    public void excluirAluno(Integer idUsuario, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			userRepository.deleteById(idUsuario);
		} else {
			throw new Exception();
		}
	}
    
    public User cadastrar(User user, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			user.setSenha("lacia123");
			user.setAprovado(true);
			user.setTipoUsuario('A');
			return userRepository.save(user);
		} else {
			throw new Exception();
		}
	}
}
