package com.example.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable{
    
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Length(min = 3, max = 100, message = "O campo TÍTULO deve ter entre 3 e 100 caracteres")
	@NotEmpty(message = "Campo TÍTULO é obrigatório!")
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Length(min = 3, max = 40, message = "O campo AUTOR deve ter entre 3 e 40 caracteres")
   	@NotEmpty(message = "Campo AUTOR é obrigatório!")
    @Column(name = "autor", nullable = false)
    private String autor; 
    
    @Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 3 e 40 caracteres")
   	@NotEmpty(message = "Campo TEXTO é obrigatório!")
    @Column(name = "texto", nullable = false)
    private String texto; 
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
        super();
    }

    public Livro(Integer id, String titulo, String autor, String texto, Categoria categoria) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.categoria = categoria; 
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1; 
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        return Objects.equals(id, other.id);
    } 
}
