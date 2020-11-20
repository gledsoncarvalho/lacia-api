package com.lacia.api.dto;

import java.sql.Date;

import com.lacia.api.model.User;

public class UserDTO {

	private int id;
	private String nome;
	private String email;
	private char tipoUsuario;
	private String cpf;
	private Date dataNascimento;
	private String telefone;
	
	public UserDTO() { }
	
	public UserDTO(int id, String nome, String email, char tipo, String cpf, Date dataNascimento, String telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tipoUsuario = tipo;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
	

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getNome(), user.getEmail(), user.getTipoUsuario(), user.getCpf(), user.getDataNascimento(), user.getTelefone());
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
	
}
