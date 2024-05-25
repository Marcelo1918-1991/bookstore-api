package com.example.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.Categoria;
import com.example.bookstore.dtos.CategoriaDTO;
import com.example.bookstore.repositories.CategoriaRepository;
import com.example.bookstore.service.exceptions.DataIntegrityViolationException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria pegarPorId(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> pegarTodasCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria criandoCategoria(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public Categoria editarCategoria(Integer id, CategoriaDTO objDto) throws ObjectNotFoundException {
		Categoria obj = pegarPorId(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriaRepository.save(obj);
	}

	public void deletarCategoriaPorId(Integer id) throws ObjectNotFoundException {
		pegarPorId(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityViolationException("Objeto não pode ser deletado! Possui livros associados");

		}

	}

}
