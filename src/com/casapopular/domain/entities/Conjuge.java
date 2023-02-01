package com.casapopular.domain.entities;

public class Conjuge extends Pessoa{

	public Conjuge(String nome, Integer idade) {
		super(nome, idade);
	}
	
	@Override
	public String toString() {
		return "Pretendente [getNome()=" + getNome() + ", getIdade()=" + getIdade() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
