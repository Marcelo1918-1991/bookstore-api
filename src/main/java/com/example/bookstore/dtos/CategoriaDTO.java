package com.example.bookstore.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.bookstore.domain.Categoria;

public class CategoriaDTO {

	private Integer id;
	
	@Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
	@NotEmpty(message = "Campo NOME é obrigatório!")
	private String nome;
	
	@Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 100 caracteres")
	@NotEmpty(message = "Campo DESCRIÇÃO é obrigatório!")
	private String descricao;
	
	public CategoriaDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
