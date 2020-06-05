package br.com.drummond.tio.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.drummond.tio.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Integer>{
	
	List<Artigo> findByDataPublicacaoBetween(LocalDate from, LocalDate to);
	
	List<Artigo> findByTituloContainingIgnoreCaseOrAreaContainingIgnoreCase(String search1, String search2);
	
	Optional<Artigo> findByHiperLink(String link);
	
	@Query(value = "select * from artigo where (titulo like %?3% or area like %?4%) and data_publicacao between ?1 and ?2", nativeQuery = true)
	List<Artigo> findByDataPublicacaoBetweenWithTituloContainingIgnoreCaseOrAreaContainingIgnoreCase(LocalDate from, LocalDate to, String search1, String search2);
	 	
}
