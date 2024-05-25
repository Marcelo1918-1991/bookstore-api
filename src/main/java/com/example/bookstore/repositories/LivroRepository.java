package com.example.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	@Query("SELECT livro FROM Livro livro WHERE livro.categoria.id = :id_cat ORDER BY titulo")
	List<Livro> pegarLivroPorCategoria(@Param(value="id_cat") Integer id_cat);

}
