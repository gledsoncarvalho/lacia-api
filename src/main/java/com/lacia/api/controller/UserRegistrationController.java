package com.lacia.api.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lacia.api.dto.UserAutheticatedDTO;
import com.lacia.api.dto.UserDTO;
import com.lacia.api.dto.UserRegistrationDTO;
import com.lacia.api.model.User;
import com.lacia.api.service.UserRegistrationService;

@RestController
public class UserRegistrationController {

	private UserRegistrationService userRegistrationService;

	@Autowired
	public UserRegistrationController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	public UserRegistrationController() {

	}

	@PostMapping("/usuario")
	public ResponseEntity<Object> registrate(@RequestBody UserDTO userRegistrationDTO,
			@RequestHeader String Authorization) {
		try {
			User user = userRegistrationService.registrate(userRegistrationDTO.toUser(), Authorization);
			System.out.println("ID: " + user.getIdUsuario());
			return new ResponseEntity<Object>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL CADASTRAR O USUÁRIO");
		}

	}

	@CrossOrigin
	@PutMapping("/usuario")
	public ResponseEntity<Object> atualizar(@RequestBody UserDTO usuario, @RequestHeader String Authorization) {
		try {
			User user = this.userRegistrationService.atualizar(usuario, Authorization);
			return new ResponseEntity<Object>(UserDTO.toDTO(user), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL ATUALIZAR O USUÁRIO");
		}
	}

	@DeleteMapping("/usuario")
	public ResponseEntity<Object> excluir(@RequestBody UserRegistrationDTO usuario,
			@RequestHeader String Authorization) {
		try {
			this.userRegistrationService.excluir(usuario, Authorization);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}

	@CrossOrigin
	@PostMapping("/usuarioObter")
	public ResponseEntity<Object> obterUsuario(@RequestBody String email, @RequestHeader String Authorization) {
		try {
			User user = this.userRegistrationService.obterUsuario(email, Authorization);
			return new ResponseEntity<Object>(UserDTO.toDTO(user), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL OBTER O USUÁRIO");
		}
	}

	@CrossOrigin
	@PutMapping("/usuario/imagem/{idUsuario}")
	public ResponseEntity<Object> atualizarImagem(@PathVariable("idUsuario") Integer idUsuario, @RequestBody byte[] fotoPerfil,
			@RequestHeader String Authorization) {
		try {
			this.userRegistrationService.atualizarImagem(idUsuario, fotoPerfil, Authorization);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
}
