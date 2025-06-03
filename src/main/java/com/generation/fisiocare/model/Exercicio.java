package com.generation.fisiocare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_exercicios") 
public class Exercicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do exercício é obrigatório.")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String nome;

    @NotNull(message = "O número de séries é obrigatório.")
    @Min(value = 1, message = "O número de séries deve ser no mínimo 1.")
    @Column(nullable = false)
    private Integer numeroSeries;

    @NotNull(message = "O número de repetições é obrigatório.")
    @Min(value = 1, message = "O número de repetições deve ser no mínimo 1.")
    @Column(nullable = false)
    private Integer repeticoes;

    @Size(max = 255, message = "O intervalo deve ter no máximo 255 caracteres.")
    @Column(length = 255)
    private String intervalo;

    @Size(max = 255, message = "O equipamento deve ter no máximo 255 caracteres.")
    @Column(length = 255)
    private String equipamento;

    @Size(max = 500, message = "As observações devem ter no máximo 500 caracteres.")
    @Column(length = 500)
    private String observacoes;

    @Size(max = 5000, message = "A mídia deve ter no máximo 5000 caracteres.")
    @Column(length = 5000)
    private String midia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroSeries() {
		return numeroSeries;
	}

	public void setNumeroSeries(Integer numeroSeries) {
		this.numeroSeries = numeroSeries;
	}

	public Integer getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(Integer repeticoes) {
		this.repeticoes = repeticoes;
	}

	public String getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}	
}