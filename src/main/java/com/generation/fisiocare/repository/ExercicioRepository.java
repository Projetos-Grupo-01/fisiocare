package com.generation.fisiocare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.fisiocare.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{
	
	List<Exercicio> findAllByNomeContainingIgnoreCase(String nome);
	
}