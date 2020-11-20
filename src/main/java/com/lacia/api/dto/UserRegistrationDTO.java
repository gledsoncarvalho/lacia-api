package com.lacia.api.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.lacia.api.model.User;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UserRegistrationDTO extends User {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private char tipo;
    private int status;
    private String cpf;
    private byte[] fotoPerfil;
    private Date dataNascimento;
    

    public UserRegistrationDTO() {

    }

    public UserRegistrationDTO(String nome, String email, String senha, String telefone, char tipo, int status, String cpf, byte[] fotoPerfil, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.tipo = tipo;
        this.status = status;
        this.cpf = cpf;
        this.fotoPerfil = fotoPerfil;
        this.dataNascimento = dataNascimento;
    }

    public User toUser() {
        return new User(getId(), getNome(), getEmail(), getSenha(), getTelefone(), getTipo(), getStatus(), getCpf(), getFotoPerfil(), getDataNascimento());
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
    
    
}
