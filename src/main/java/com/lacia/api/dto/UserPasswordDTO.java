package com.lacia.api.dto;

public class UserPasswordDTO {
	private String senhaAtual;
	private String novaSenha;
	
	public UserPasswordDTO(String senhaAtual, String novaSenha) {
		this.senhaAtual = senhaAtual;
		this.novaSenha = novaSenha;
	}

	public UserPasswordDTO() {
		
	}
	
	public String getSenhaAtual() {
		return senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

}
