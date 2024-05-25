package com.valdir.bookstore.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeDoCampo;
	private String messagemErro;
	
	public FieldMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FieldMessage(String nomeDoCampo, String messagemErro) {
		super();
		this.nomeDoCampo = nomeDoCampo;
		this.messagemErro = messagemErro;
	}
	public String getNomeDoCampo() {
		return nomeDoCampo;
	}
	public void setNomeDoCampo(String nomeDoCampo) {
		this.nomeDoCampo = nomeDoCampo;
	}
	public String getMessagemErro() {
		return messagemErro;
	}
	public void setMessagemErro(String messagemErro) {
		this.messagemErro = messagemErro;
	}
	
	
}
