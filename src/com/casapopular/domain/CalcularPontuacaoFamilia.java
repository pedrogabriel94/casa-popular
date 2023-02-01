package com.casapopular.domain;

import com.casapopular.domain.entities.Familia;

public interface CalcularPontuacaoFamilia {
	
	public Integer calcularPontuacaoPorRendaAte900(Familia familia);
	
	public Integer calcularPontuacaoPorRenda901a1500(Familia familia);
	
	public Integer calcularPontuacaoPorMaisDeTresDependentes(Familia familia);
	
	public Integer calcularPontuacaoPorAteDoisDependentes(Familia familia);
	
}
