package com.casapopular.domain.entities;

import java.util.List;
import java.util.stream.Collectors;

public class Familia {
	
	private String sobrenome; 
	private Double renda;
	private Integer pontuacao;
	private Pretendente pretendente;
	private Conjuge conjuge;
	private List<Dependente> dependentes;
	
	public Familia(String sobrenome, Double renda, Integer pontuacao, Pretendente pretendente, 
			Conjuge conjuge, List<Dependente> dependentes) {
		
		super();
		this.sobrenome = sobrenome;
		this.renda = renda;
		this.pontuacao = pontuacao;
		this.pretendente = pretendente;
		this.conjuge = conjuge;
		this.dependentes = dependentes;
	}
	
	public Pretendente getPretendente() {
		return pretendente;
	}
	
	public void setPretendente(Pretendente pretendente) {
		this.pretendente = pretendente;
	}
	
	public Conjuge getConjuge() {
		return conjuge;
	}
	
	public void setConjuge(Conjuge conjuge) {
		this.conjuge = conjuge;
	}
	
	public List<Dependente> getDependentes() {
		return dependentes;
	}
	
	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public Double getRenda() {
		return renda;
	}

	public void setPontuacao(Integer pontuacao) {
		 this.pontuacao = pontuacao;
	}
	
	public Integer getPontuacao() {
		return pontuacao;
	}
	
	public Integer calcularDependentes() {
		List<Dependente> dependentesMenores = this.dependentes.stream().filter(e -> e.getIdade() <= 18).collect(Collectors.toList());
		return  dependentesMenores.size();
	}
	
	@Override
	public String toString() {
		return "Familia:" + sobrenome + ", pontuacao=" + pontuacao;
	}
}
