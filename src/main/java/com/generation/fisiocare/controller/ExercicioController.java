package com.generation.fisiocare.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.fisiocare.model.Exercicio;
import com.generation.fisiocare.repository.ExercicioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/exercicios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExercicioController {

	@Autowired
	private ExercicioRepository exercicioRepository;
	
	@GetMapping
	public ResponseEntity<List<Exercicio>> getAll() {
		return ResponseEntity.ok(exercicioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Exercicio> getById(@PathVariable Long id) {
		return exercicioRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Exercicio>> getAllByNome(@PathVariable String nome) {
		
		return ResponseEntity.ok(exercicioRepository.findAllByNomeContainingIgnoreCase(nome));
		
	}
	
	@PostMapping
	public ResponseEntity<Exercicio> post(@Valid @RequestBody Exercicio exercicio) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(exercicioRepository.save(exercicio));
		
	}
	
	@PutMapping
	public ResponseEntity<Exercicio> put(@Valid @RequestBody Exercicio exercicio) { 
		
		if(exercicio.getId() == null)
			return ResponseEntity.badRequest().build();
		
		if(exercicioRepository.existsById(exercicio.getId())) {
			
				return ResponseEntity.status(HttpStatus.OK).body(exercicioRepository.save(exercicio));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		Optional<Exercicio> exercicio = exercicioRepository.findById(id);
		
		if(exercicio.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		exercicioRepository.deleteById(id);
	}
}
