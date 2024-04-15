package com.example.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Categoria;
import com.example.bookstore.domain.Livro;
import com.example.bookstore.repositories.CategoriaRepository;
import com.example.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired	
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI", null);
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção", null);
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de biografias", null);

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Marcelo", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The time machine", "Xavier", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The war of the worlds", "Sousa", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Matos", "Lorem ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

	}
}
