package puzzle8_aStar;

import java.util.List;

public class No {
	
	private List<String> matriz;
	
	private int numerosErrados;
	
	private int profundidade;
	
	private int custo;
	
	private No noParente;

	public List<String> getMatriz() {
		return matriz;
	}

	public void setMatriz(List<String> elementos) {
		this.matriz = elementos;
	}

	public int getNumerosErrados() {
		return numerosErrados;
	}

	public void setNumerosErrados(List<String> matrizObjetivo) {
		
		int valoresIncorretos = 0;
		
		for(int b = 0;b < 9;b++)
		{
					
			if(!this.getMatriz().get(b).equals(matrizObjetivo.get(b)))
			{
				valoresIncorretos++;
			}
		}
		this.numerosErrados = valoresIncorretos;
		
	}

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}
	
	public int getCusto() {
		return custo;
	}

	//Define o valor do custo de acordo com a heuristica,
	//numero de nós expandidos + distancia para o objetivo(numero de elementos em posição errada)
	public void setCusto() {
		
		this.custo = this.getNumerosErrados() + this.getProfundidade(); 
	}

	public No getNoParente() {
		return noParente;
	}

	public void setNoParente(No noParente) {
		this.noParente = noParente;
	}

}
