package com.games.GameStop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.games.GameStop.model.Produto;
import com.games.GameStop.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<Produto>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/plataforma/{paltaforma}")
	public ResponseEntity<List<Produto>> getByTitulo(@PathVariable String plataforma) {
		return ResponseEntity.ok(repository.findAllByPlataformaContainingIgnoreCase(plataforma));

	}

	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto Produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Produto));
	}

	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto Produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Produto));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
