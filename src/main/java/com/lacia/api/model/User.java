package com.lacia.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
	private String nome;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private String telefone;
    @Column
    private Date dataNascimento;
    @Column
    private String cpf;
    @Column(name = "tipo")
    private char tipoUsuario;
    @Column
    @Lob
    private byte[] fotoPerfil;
    @Transient
    private String token;

    public User(Integer id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public User(Integer id, String nome, String email, String senha, String telefone, char tipoUsuario, String cpf, byte[] fotoPerfil, Date dataNascimento){
        this.id = id;
    	this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.cpf = cpf;
        this.fotoPerfil = fotoPerfil;
        this.dataNascimento = dataNascimento;
    }

    public User(){

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

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    

    public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(char tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}


}
