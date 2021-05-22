package com.cadastros.apirest.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name="TB_USUARIO", 
uniqueConstraints={@UniqueConstraint(columnNames={"cpf"}),
		@UniqueConstraint(columnNames={"email"})} )
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String cpf;


	@Column(name = "data_contribuicao", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/aaaa")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@Column
	private int idade;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @ElementCollection(targetClass=Endereco.class)
	private List<Endereco> enderecos;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
