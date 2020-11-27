package com.lacia.api.dto;

import java.sql.Date;

import com.lacia.api.model.User;

public class UserDTO {

	private int idUsuario;
	private String nome;
	private String email;
	private char tipoUsuario;
	private String cpf;
	private Date dataNascimento;
	private String telefone;
	private Boolean isAprovado;
	private String token;
	
	public UserDTO() { }
	
	public UserDTO(int idUsuario, String nome, String email, char tipo, String cpf, Date dataNascimento, String telefone, Boolean isAprovado, String token) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.tipoUsuario = tipo;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.isAprovado = isAprovado;
		this.token = token;
	}
	
    public User toUser() {
        return new User(getIdUsuario(), getNome(), getEmail(),  getTelefone(), getDataNascimento());
    }


    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getIdUsuario(), user.getNome(), user.getEmail(), user.getTipoUsuario(), user.getCpf(), user.getDataNascimento(), user.getTelefone(), user.isAprovado(), user.getToken());
    }
    
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(char tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Boolean getIsAprovado() {
		return isAprovado;
	}

	public void setIsAprovado(Boolean isAprovado) {
		this.isAprovado = isAprovado;
	}

	public String getToken() {
		return token;
	}
}
