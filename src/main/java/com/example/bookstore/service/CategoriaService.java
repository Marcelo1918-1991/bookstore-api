package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Categoria;
import com.example.bookstore.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

import java.util.Optional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	public Categoria findById(Integer id) throws ObjectNotFoundException {
	    Optional<Categoria> categoria = categoriaRepository.findById(id);
	    return categoria.orElseThrow(() -> new ObjectNotFoundException(
	                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
