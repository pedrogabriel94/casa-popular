package com.casapopular.usecase;

import java.util.List;
import java.util.stream.Collectors;

import com.casapopular.domain.CalcularPontuacaoFamilia;
import com.casapopular.domain.entities.Familia;

public class OrdenarFamilia {
	
	private CalcularPontuacaoFamilia calcularPontuacaoFamilia;
	
	public OrdenarFamilia(CalcularPontuacaoFamilia calcularPontuacaoFamilia) {
		this.calcularPontuacaoFamilia = calcularPontuacaoFamilia;
	}
	
	public List<Familia> execute(List<Familia> familias){
		
		List<Familia> familiasComPontos = this.calculaPontos(familias);
		
		return familiasComPontos.stream().sorted((f1, f2) -> f2.getPontuacao().compareTo(f1.getPontuacao())).collect(Collectors.toList());
	}
	
	public List<Familia> calculaPontos(List<Familia> familias){
		Integer pontos = 0;
		for(Familia f : familias) {
			pontos += this.calcularPontuacaoFamilia.calcularPontuacaoPorRendaAte900(f);
			pontos += this.calcularPontuacaoFamilia.calcularPontuacaoPorRenda901a1500(f);
			pontos += this.calcularPontuacaoFamilia.calcularPontuacaoPorMaisDeTresDependentes(f);
			pontos += this.calcularPontuacaoFamilia.calcularPontuacaoPorAteDoisDependentes(f);
			f.setPontuacao(pontos);
			pontos = 0;
		}
		
		return familias;
	}

}
