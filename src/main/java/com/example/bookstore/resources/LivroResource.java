package com.example.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.bookstore.domain.Livro;
import com.example.bookstore.dtos.LivroDTO;
import com.example.bookstore.service.LivroService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	//ENDPOINT PARA PEGAR LIVRO PELO ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro livro = livroService.pegarLivroPorId(id);
		return ResponseEntity.ok().body(livro);
	}

	//ENDPOINT PARA PEGAR TODOS LIVRO POR CATEGORIA
	@GetMapping()
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat)
			throws ObjectNotFoundException {
		List<Livro> list = livroService.pegarLivrosPorCategoria(id_cat);
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}

	//ENDPOINT PARA ATUALIZAR UM LIVRO
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> atualizarLivro(@PathVariable Integer id, @Valid @RequestBody Livro livro) {
		Livro newLivro = livroService.atualizarLivo(id, livro);
		return ResponseEntity.ok().body(newLivro);
	}

	//ENDPOINT PARA SALVAR UM NOVO LIVRO
	@PostMapping
	public ResponseEntity<Livro> criandoNovoLivro(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@Valid @RequestBody Livro livro) throws ObjectNotFoundException {
		Livro newLivro = livroService.novoLivro(id_cat, livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}")
				.buildAndExpand(newLivro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//ENDPOINT DE DELEÇÃO DE LIVRO
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarLivro(@PathVariable Integer id) {
		livroService.deletarLivros(id);
		return ResponseEntity.noContent().build();
	}

}
