package com.lacia.api.service;

import org.springframework.stereotype.Service;

import com.lacia.api.dto.ProjectDTO;
import com.lacia.api.dto.UserProjectSaveDTO;
import com.lacia.api.model.Project;
import com.lacia.api.model.User;
import com.lacia.api.model.UserProject;
import com.lacia.api.repository.ProjectRepository;
import com.lacia.api.repository.UserProjectRepository;
import com.lacia.api.repository.UserRepository;

@Service
public class UserProjectService {
	
	private UserProjectRepository userProjectRepository;
	private UserRepository userRepository;
	private ProjectRepository projectRepository;
	private TokenService tokenService;

	public UserProjectService (UserProjectRepository userProjectRepository, UserRepository userRepository, ProjectRepository projectRepository, TokenService tokenService) {
		
		this.userProjectRepository = userProjectRepository;
		this.userRepository = userRepository;
		this.projectRepository = projectRepository;
		this.tokenService = tokenService;
	};
	
	
	public void cadastrarUsuarioProjeto(ProjectDTO projectDTO, String token) throws Exception{
		if (!token.isEmpty() && tokenService.validate(token)) {
			Project projetoCompleto = projectRepository.findById(projectDTO.getIdProjeto()).get();
			Project projeto = projectDTO.toProject();
			projeto.setUser(projetoCompleto.getUser());
			projeto.setUsers(ProjectDTO.converterListaParaUser(projectDTO.getUsuarios()));
			projectRepository.save(projeto);
		} else {
			throw new Exception();
		}
	}
}
