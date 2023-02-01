package com.casapopular.domain;

import com.casapopular.domain.entities.Familia;

public class CalcularPontuacaoFamiliaImpl implements CalcularPontuacaoFamilia {

	@Override
	public Integer calcularPontuacaoPorRendaAte900(Familia familia) {
		return familia.getRenda() <= 900 ? 5 : 0;
	}

	@Override
	public Integer calcularPontuacaoPorRenda901a1500(Familia familia) {
		return familia.getRenda() > 900 &&  familia.getRenda() <= 1500 ? 3 : 0;
	}

	@Override
	public Integer calcularPontuacaoPorMaisDeTresDependentes(Familia familia) {
		return familia.calcularDependentes() >= 3 ? 3 : 0;
	}

	@Override
	public Integer calcularPontuacaoPorAteDoisDependentes(Familia familia) {
		return familia.calcularDependentes() == 1 || familia.calcularDependentes() == 2 ? 2 : 0;
	}

}
