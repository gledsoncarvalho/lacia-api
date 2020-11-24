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
	

    public List<UserDTO> obterTodosPesquisadores(String token) throws Exception {
    	if (!token.isEmpty() && tokenService.validate(token)) {
    		Iterator iterator = userRepository.findByTipo('P').iterator();
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
}


