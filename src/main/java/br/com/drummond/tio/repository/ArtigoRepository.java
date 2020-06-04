package br.com.drummond.tio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.drummond.tio.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Integer>{

}
