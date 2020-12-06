package com.lacia.api.controller;

import java.util.List;

import org.apache.el.parser.ELParserTreeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.lacia.api.dto.ProjectDTO;
import com.lacia.api.dto.UserDTO;
import com.lacia.api.dto.UserProjectSaveDTO;
import com.lacia.api.service.ProjectService;
import com.lacia.api.service.UserProjectService;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {

	private ProjectService projectService;
	private UserProjectService userProjectService;

	@Autowired
	public ProjectController(ProjectService projectService, UserProjectService userProjectService) {
		this.projectService = projectService;
		this.userProjectService = userProjectService;
	}
	
	@PostMapping("/projeto/cadastrar")
	public ResponseEntity<Object> cadastrar(@RequestBody ProjectDTO projectDTO,
			@RequestHeader String Authorization) {
		try {
		    projectService.cadastrarProjeto(projectDTO, Authorization);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	
	@GetMapping("/projeto/meus/{email}")
	public ResponseEntity<Object> obterProjetoPorUsuario (@PathVariable("email") String email, @RequestHeader String Authorization) {
		try {
			List<ProjectDTO> projetos = projectService.obterProjetoPorUsuario(email, Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(projetos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR PROJETOS");
		}
	}
	
	@GetMapping("/projeto/todos/{email}")
	public ResponseEntity<Object> obterProjetos (@PathVariable("email") String email, @RequestHeader String Authorization) {
		try {
			List<ProjectDTO> projetos = projectService.obterProjetos(email, Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(projetos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR PROJETOS");
		}
	}
	
	@PutMapping("projeto/aprovar/{idProjeto}")
	public ResponseEntity<Object> aprovarProjeto(@PathVariable("idProjeto") Integer idProjeto, @RequestHeader String Authorization) {
		try {
			this.projectService.aprovarProjeto(idProjeto, Authorization);;
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	
	@PutMapping("projeto/reprovar/{idProjeto}")
	public ResponseEntity<Object> reprovarProjeto(@PathVariable("idProjeto") Integer idProjeto, @RequestHeader String Authorization) {
		try {
			this.projectService.reprovarProjeto(idProjeto, Authorization);;
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	
	@GetMapping("/projeto/todos")
	public ResponseEntity<Object> obterProjetosCadastrados (@RequestHeader String Authorization) {
		try {
			List<ProjectDTO> projetos = projectService.obterProjetosCadastrados(Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(projetos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR OS PROJETOS");
		}
	}
	
	@GetMapping("/projeto/membros/{email}")
	public ResponseEntity<Object> obterProjetosPorUsuarioMembro(@PathVariable("email") String email, @RequestHeader String Authorization) {
		try {
			List<ProjectDTO> projetos = projectService.obterProjetosPorUsuarioMembro(email, Authorization);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(projetos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CONSULTAR OS PROJETOS");
		}
	}
	
	@PostMapping("/projeto/usuario")
	public ResponseEntity<Object> cadastrarUsuarioProjeto(@RequestBody UserProjectSaveDTO userProjectSaveDTO,
			@RequestHeader String Authorization) {
		try {
		    userProjectService.cadastrarUsuarioProjeto(userProjectSaveDTO, Authorization);
			return ResponseEntity.status(HttpStatus.CREATED).body(true);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	
	
}
