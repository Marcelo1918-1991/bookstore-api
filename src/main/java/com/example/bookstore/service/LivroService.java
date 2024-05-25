package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Categoria;
import com.example.bookstore.domain.Livro;
import com.example.bookstore.repositories.LivroRepository;
import com.example.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro pegarLivroPorId(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> pegarLivrosPorCategoria(Integer id_cat) throws javassist.tools.rmi.ObjectNotFoundException {
		categoriaService.pegarPorId(id_cat);
		return livroRepository.pegarLivroPorCategoria(id_cat); 
	}

	public Livro atualizarLivo(Integer id, Livro livro) {
		Livro newLivro = pegarLivroPorId(id);
		atualizandoLivro(newLivro, livro);
		return livroRepository.save(newLivro);
	}

	private void atualizandoLivro(Livro newLivro, Livro livro) {
		newLivro.setTitulo(livro.getTitulo());
		newLivro.setAutor(livro.getAutor());
		newLivro.setTexto(livro.getTexto());
	}

	public Livro novoLivro(Integer id_cat, Livro livro) throws javassist.tools.rmi.ObjectNotFoundException {
		livro.setId(null);
		Categoria categoria = categoriaService.pegarPorId(id_cat);
		livro.setCategoria(categoria);
		return livroRepository.save(livro);
	}

	public void deletarLivros(Integer id) {
		Livro livro = pegarLivroPorId(id);
		livroRepository.delete(livro);
	}
}
