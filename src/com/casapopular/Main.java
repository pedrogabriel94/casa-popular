package com.casapopular;

import java.util.Arrays;
import java.util.List;

import com.casapopular.domain.CalcularPontuacaoFamilia;
import com.casapopular.domain.CalcularPontuacaoFamiliaImpl;
import com.casapopular.domain.entities.Conjuge;
import com.casapopular.domain.entities.Dependente;
import com.casapopular.domain.entities.Familia;
import com.casapopular.domain.entities.Pretendente;
import com.casapopular.usecase.OrdenarFamilia;

/**
 * @author Pedro Dimas
 *
 */
public class Main {

	public static void main(String[] args) {
		
		CalcularPontuacaoFamilia calcularPontuacaoFamilia = new CalcularPontuacaoFamiliaImpl();
		OrdenarFamilia ordenarFamilia = new OrdenarFamilia(calcularPontuacaoFamilia);
		
		Familia familia1 = new Familia(
				"Alves", 
				850.00, 
				0,
				new Pretendente("Pedro", 23),
				new Conjuge("Thalia", 24),
				Arrays.asList(new Dependente("Caleb", 24))
			);
		
		Familia familia2 = new Familia(
				"Almeida", 
				2000.00, 
				0,
				new Pretendente("Maria", 45),
				new Conjuge("Luciano", 50),
				Arrays.asList(new Dependente("Caleb", 14), new Dependente("Ruthe", 17))
			);
		
		Familia familia3 = new Familia(
				"Moreira", 
				1200.00, 
				0,
				new Pretendente("Laura", 44),
				new Conjuge("Cival", 46),
				Arrays.asList(new Dependente("Gui", 11), new Dependente("Fulano", 14), new Dependente("Ciclano", 13))	
			);
		
		List<Familia> familias =  Arrays.asList(familia1, familia2, familia3);
		
		List<Familia> familiasOrdenadas  = ordenarFamilia.execute(familias);
		
		System.out.println(familiasOrdenadas);
	}

}
