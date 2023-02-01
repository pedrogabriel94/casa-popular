package com.casapopular.domain.entities;

public class Pretendente extends Pessoa{
	
	public Pretendente(String nome, Integer idade) {
		super(nome, idade);
	}

	@Override
	public String toString() {
		return "Pretendente [getNome()=" + getNome() + ", getIdade()=" + getIdade() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
