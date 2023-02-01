package test;

import java.util.Arrays;
import java.util.List;

import com.casapopular.domain.CalcularPontuacaoFamilia;
import com.casapopular.domain.CalcularPontuacaoFamiliaImpl;
import com.casapopular.domain.entities.Conjuge;
import com.casapopular.domain.entities.Dependente;
import com.casapopular.domain.entities.Familia;
import com.casapopular.domain.entities.Pretendente;
import com.casapopular.usecase.OrdenarFamilia;

import junit.framework.TestCase;

public class TestePontuacao extends  TestCase {
	
	private CalcularPontuacaoFamilia calcularPontuacaoFamilia = new CalcularPontuacaoFamiliaImpl();
	OrdenarFamilia ordenarFamilia = new OrdenarFamilia(calcularPontuacaoFamilia);
	
	Familia familiaTeste = new Familia(
			"Moreira", 
			1200.00, 
			0,
			new Pretendente("Laura", 44),
			new Conjuge("Cival", 46),
			Arrays.asList(new Dependente("Gui", 11), new Dependente("Fulano", 14), new Dependente("Ciclano", 13))	
		);
	
	Familia familiaTeste2 = new Familia(
			"Alves", 
			850.00, 
			0,
			new Pretendente("Pedro", 23),
			new Conjuge("Thalia", 24),
			Arrays.asList(new Dependente("Caleb", 24))
		);
	
	Familia familiaTeste3 = new Familia(
			"Almeida", 
			2000.00, 
			0,
			new Pretendente("Maria", 45),
			new Conjuge("Luciano", 50),
			Arrays.asList(new Dependente("Caleb", 14), new Dependente("Ruthe", 17))
		);
	
	
	public void testeCalcularPontuacaoPorRendaAte900() {
		Integer retorno = this.calcularPontuacaoFamilia.calcularPontuacaoPorRendaAte900(familiaTeste2);
		
		assertEquals(5, retorno, 0);
	}

	public void testeCalcularPontuacaoPorRenda901a1500() {
		Integer retorno = this.calcularPontuacaoFamilia.calcularPontuacaoPorRenda901a1500(familiaTeste);
		
		assertEquals(3, retorno, 0);
	}
	
	public void testeCalcularPontuacaoPorMaisDeTresDependentes() {
		Integer retorno = this.calcularPontuacaoFamilia.calcularPontuacaoPorMaisDeTresDependentes(familiaTeste);
		
		assertEquals(3, retorno, 0);
	}
	
	public void testeCalcularPontuacaoPorAteDoisDependentes() {
		Integer retorno = this.calcularPontuacaoFamilia.calcularPontuacaoPorAteDoisDependentes(familiaTeste3);
		
		assertEquals(2, retorno, 0);
	}
	
	public void testeCalcularPontuacaoFamilia() {
		List<Familia> familias = Arrays.asList(familiaTeste);
		
		List<Familia> familiaComPontos = this.ordenarFamilia.calculaPontos(familias);
				
		assertEquals(6, familiaComPontos.get(0).getPontuacao(), 0);
	}
	
	public void testeCalcularOrdenacaoFamilias() {
		List<Familia> familias = Arrays.asList(familiaTeste, familiaTeste2, familiaTeste3);
		
		List<Familia> familiaComPontos = this.ordenarFamilia.execute(familias);
				
		assertEquals("Moreira", familiaComPontos.get(0).getSobrenome());
		assertEquals("Alves", familiaComPontos.get(1).getSobrenome());
		assertEquals("Almeida", familiaComPontos.get(2).getSobrenome());
	}
}
