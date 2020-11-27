package com.lacia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lacia.api.dto.DadosLogin;
import com.lacia.api.dto.UserAutheticatedDTO;
import com.lacia.api.dto.UserDTO;
import com.lacia.api.dto.UserResponserDTO;
import com.lacia.api.model.User;
import com.lacia.api.service.TokenService;
import com.lacia.api.service.UserAuthenticationService;
import com.lacia.api.service.UserRegistrationService;

@RestController
public class AuthenticationController {

    private UserAuthenticationService userAuthenticationService;
    
    
    @Autowired
    public AuthenticationController(UserAuthenticationService userAuthenticationService){
        this.userAuthenticationService = userAuthenticationService;
    }

    public AuthenticationController(){

    }
    
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<Object> autenticar(@RequestBody DadosLogin dadosLogin){
    	try {
    		User user = userAuthenticationService.authenticate(dadosLogin);
            return new ResponseEntity<Object>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    	} catch (Exception e) {
    		if (e.getMessage().equals("E1")) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário sem permissão de acesso!");
    		}
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário/senha inválido");
		}	
    }
}
