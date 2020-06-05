package br.com.drummond.tio.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.drummond.tio.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Integer>{
	
	List<Artigo> findByDataPublicacaoBetween(LocalDate from, LocalDate to);
	
	List<Artigo> findByTituloContainingIgnoreCaseOrAreaContainingIgnoreCase(String search1, String search2);
	
	Optional<Artigo> findByHiperLink(String link);
	
}
