package puzzle8_aStar;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//Lista de elementos a serem expandidos
		List<No> listaAberta = new ArrayList<No>();
		//Lista de elementos ja explorados
		List<No> listaFechada = new ArrayList<No>();
		
		AlgoritmoAestrela algoritmo = new AlgoritmoAestrela();
		
		algoritmo.setListaAberta(listaAberta);
		algoritmo.setListaFechada(listaFechada);
		
		//Definição da matriz inicial aleatoria, contem valores de 0-8 e "_"
		No noInicial = new No();	
		algoritmo.iniciar(noInicial);
		
		System.out.println("Matriz Inicial:");	
		algoritmo.printMatriz(noInicial.getMatriz());
		
		
		//Definição da matriz objetivo
		List<String> matrizObjetivo = new ArrayList<String>();
		
		for(int a = 0;a < 9;a++)
		{
			String valor = Integer.toString(a + 1);
			
			if(a == 8)
			{
				valor = "_";
			}
			
			matrizObjetivo.add(valor);	
		}
			
		System.out.println("\nMatriz Objetivo:");	
		algoritmo.printMatriz(matrizObjetivo);
		System.out.println("\n");
		
		//Calculo do algoritmo a*
		algoritmo.aEstrela(noInicial, matrizObjetivo);
		
	}
	
}
