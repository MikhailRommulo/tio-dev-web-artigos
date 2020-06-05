package br.com.drummond.tio.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.drummond.tio.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Integer>{
	
	List<Artigo> findByDataPublicacaoBetween(LocalDate from, LocalDate to);
	
}
