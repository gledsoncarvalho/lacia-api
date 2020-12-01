package com.lacia.api.dto;

import com.lacia.api.model.User;
import com.lacia.api.model.UserProject;

public class UserProjectSaveDTO {
	
	private Integer idUsuario;
	private String nome;
	private byte[] fotoPerfil;
	
	public UserProjectSaveDTO() { }

	public UserProjectSaveDTO(Integer idUsuario, String nome, byte[] fotoPerfil) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.fotoPerfil = fotoPerfil;
	}
	
	public static UserProjectSaveDTO toUserProjectSaveDTO(User user) {
		return new UserProjectSaveDTO(user.getIdUsuario(), user.getNome(), user.getFotoPerfil());
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
	
}
