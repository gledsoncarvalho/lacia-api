package com.lacia.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacia.api.dto.ProjectDTO;
import com.lacia.api.model.Project;
import com.lacia.api.model.User;
import com.lacia.api.repository.ProjectRepository;
import com.lacia.api.repository.UserRepository;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;
	private UserRepository userRepository;
	private TokenService tokenService;
	
	
	@Autowired
	public ProjectService(ProjectRepository projectRepository, UserRepository  userRepository, TokenService tokenService) {
		this.projectRepository = projectRepository;
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}
	
	public void cadastrarProjeto(ProjectDTO projectDTO, String token)  throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			User user = userRepository.findByEmail(projectDTO.getEmailUsuario());
			Project project = projectDTO.toProject(); 
			project.setUser(user);
			projectRepository.save(project);
		} else {
			throw new Exception();
		}
	}
	
	
	public List<ProjectDTO> obterProjetoPorUsuario(String email, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			User user = userRepository.findByEmail(email);
			Iterator iterator = projectRepository.findAllByUser(user.getIdUsuario()).iterator();
			List<ProjectDTO> projetos = new ArrayList<>();
			while (iterator.hasNext()) {
				Project projeto = (Project) iterator.next();
				projetos.add(ProjectDTO.toDTO(projeto));
			}
			return projetos;
		} else {
			throw new Exception();
		}
	}
	
	public List<ProjectDTO> obterProjetos(String email, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			User user = userRepository.findByEmail(email);
			Iterator iterator = projectRepository.findAll(user.getIdUsuario()).iterator();
			List<ProjectDTO> projetos = new ArrayList<>();
			while (iterator.hasNext()) {
				Project projeto = (Project) iterator.next();
				projetos.add(ProjectDTO.toDTO(projeto));
			}
			return projetos;
		} else {
			throw new Exception();
		}
	}
	 
	
	public void reprovarProjeto(Integer idProjeto, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			projectRepository.reproveProject(idProjeto);
		} else {
			throw new Exception();
		}
	}

	public void aprovarProjeto(Integer idProjeto, String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			projectRepository.approveProject(idProjeto);
		} else {
			throw new Exception();
		}
	}
	
	public List<ProjectDTO> obterProjetosCadastrados(String token) throws Exception {
		if (!token.isEmpty() && tokenService.validate(token)) {
			Iterator iterator = projectRepository.findAllCadastrados().iterator();
			List<ProjectDTO> projetos = new ArrayList<>();
			while (iterator.hasNext()) {
				Project projeto = (Project) iterator.next();
				projetos.add(ProjectDTO.toDTO(projeto));
			}
			return projetos;
		} else {
			throw new Exception();
		}
	}
}
