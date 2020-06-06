package br.com.drummond.tio.resources;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.drummond.tio.model.Artigo;
import br.com.drummond.tio.repository.ArtigoRepository;

@RestController
@RequestMapping("/artigos")
public class ArtigoResources {
	
	@Autowired
	ArtigoRepository artigoRepository;
	
	@GetMapping
	public ResponseEntity<?> pegarArtigos(){
		List<Artigo> artigos = artigoRepository.findAll();
		if(artigos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não existem artigos registrados");
		}else {
			return ResponseEntity.ok(artigos);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Artigo> pegarArtigo(@PathVariable int id) {
		Optional<Artigo> artigo = artigoRepository.findById(id);
		if(artigo.isPresent()) {
			return ResponseEntity.ok(artigo.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não existe artigo com esse código");
		}
	}
	
	@GetMapping("/datas")
	public ResponseEntity<?> pegarArtigosEntreDatas(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate from, @RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate to) {
		
		List<Artigo> artigos = artigoRepository.findByDataPublicacaoBetween(from, to);
		if(artigos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não existem artigos registrados nesse intervalo");
		}else {
			return ResponseEntity.ok(artigos);
		}
		
	}
	
	@GetMapping("/titulo-area")
	public ResponseEntity<?> pegarArtigosPeloTituloOuArea(@RequestParam("search") String search) {
		List<Artigo> artigos = artigoRepository.findByTituloContainingIgnoreCaseOrAreaContainingIgnoreCase(search, search);
		if(artigos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não existem artigos registrados com essa procura!");
		}else {
			return ResponseEntity.ok(artigos);
		}
	}
	
	@GetMapping("/link")
	public ResponseEntity<Artigo> pegarArtigosPeloLink(@RequestParam("link") String link) {
		Optional<Artigo> artigo = artigoRepository.findByHiperLink(link);
		if(artigo.isPresent()) {
			return ResponseEntity.ok(artigo.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não existe artigo com esse link!");
		}
	}
		
	@GetMapping("/titulo-area-datas")
	public ResponseEntity<?> pegarArtigosPeloTituloOuAreaNumIntervaloDeDatas(@RequestParam("search") String search,
			@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
			@RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {
		List<Artigo> artigos = artigoRepository
				.findByDataPublicacaoBetweenWithTituloContainingIgnoreCaseOrAreaContainingIgnoreCase(from, to, search,
						search);
		if (artigos.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,
					"Não existem artigos registrados com essa procura!");
		} else {
			return ResponseEntity.ok(artigos);
		}
	}
	 
	@PostMapping
	public ResponseEntity<Artigo> cadastrarArtigo(@Valid @RequestBody Artigo artigo) {
		Artigo artigoParaCadastrar = artigoRepository.save(artigo);
		return ResponseEntity.status(HttpStatus.CREATED).body(artigoParaCadastrar);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Artigo> alterarArtigo(@PathVariable Integer id, @Valid @RequestBody Artigo artigo) throws IllegalArgumentException, IllegalAccessException {
		Optional<Artigo> artigoExistente = artigoRepository.findById(id);
		if(artigoExistente.isPresent()) {
			BeanUtils.copyProperties(artigo, artigoExistente.get(), "id");
			return ResponseEntity.ok(artigoRepository.save(artigoExistente.get()));
		} else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Artigo não encontrado");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarArtigo(@PathVariable Integer id) {
		Optional<Artigo> artigoExistente = artigoRepository.findById(id);
		if(artigoExistente.isPresent()) {
			artigoRepository.deleteById(artigoExistente.get().getId());
			return ResponseEntity.status(HttpStatus.OK).body("O artigo "+ artigoExistente.get().getTitulo() +" foi apagado");
		} else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Artigo não encontrado");
		}
	}
}
