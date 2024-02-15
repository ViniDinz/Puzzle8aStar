package puzzle8_aStar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class AlgoritmoAestrela {
	
	private List<No> listaAberta;
	
	private List<No> listaFechada;

	public List<No> getListaAberta() {
		return listaAberta;
	}

	public void setListaAberta(List<No> listaAberta) {
		this.listaAberta = listaAberta;
	}

	public List<No> getListaFechada() {
		return listaFechada;
	}

	public void setListaFechada(List<No> listaFechada) {
		this.listaFechada = listaFechada;
	}
	
	//Inicialização do nó inicial com os elementos em posições aleatorias
	public void iniciar(No no)
	{
		Random random = new Random();
		
		no.setProfundidade(0);
				
		List<String> elementos = new ArrayList<String>();
		
		no.setMatriz(elementos);
		
		no.setNoParente(no);
				
		for(int a = 0; a <= 8;a++)
		{
					
			while(true) {
				 int aleatorio = random.nextInt(9) + 1;
			
				String valor = Integer.toString(aleatorio);
			
				if(aleatorio == 9)
				{
					valor = "_";	
				}
			
				if(!no.getMatriz().contains(valor))
				{
										
					no.getMatriz().add(valor);
					break;
				}
				else
				{
					
				}
			}
		}
	}
	
	public void printMatriz(List<String> matriz)
	{
		int elemento = 0;
		for(int a = 0;a < 3;a++)
		{
			for(int b = 0;b < 3;b++)
			{	
				
				System.out.print(matriz.get(elemento) + " ");
				elemento++;
			}
			System.out.print("\n");
		}
	}
	
	//Função que expande o nó selecionado e adiciona os novos nós a lista aberta
	public void expandirNo(No no, List<String> matrizObjetivo)
	{
		int posicaoUnderline = 0;
		//Acha a posicao do underline no nó a ser expandido
		for(int a =0;a < 9;a++)
		{
			if(no.getMatriz().get(a).equals("_"))
			{
				posicaoUnderline = a;
			}
		}
		
		//Expandir para cima
		if(posicaoUnderline - 3 >= 0)
		{
			No noCima = new No();
			
			List<String> matrizCima = new ArrayList<String>();
			
			matrizCima.addAll(no.getMatriz());
			
			noCima.setProfundidade(no.getProfundidade() + 1);
			
			noCima.setMatriz(matrizCima);
			
			noCima.setNoParente(no);
			
			//Troca o lugar do valor de cima com o underscore
			noCima.getMatriz().set(posicaoUnderline, noCima.getMatriz().get(posicaoUnderline - 3));
			noCima.getMatriz().set(posicaoUnderline - 3, "_");
			
			noCima.setNumerosErrados(matrizObjetivo);
			noCima.setCusto();
			
			int eIgualCima = 0;
			//Verificar se ja existe um no com a mesma matriz na lista fechada
			for(int b = 0;b < listaFechada.size();b++)
			{
						
				if(noCima.getMatriz().equals(listaFechada.get(b).getMatriz()))
				{
					eIgualCima = 1;
				}
			}
			if(eIgualCima == 0)
			{
				listaAberta.add(noCima);
				//Printa a expanção do nó para cima
				//System.out.println("Expandindo para cima");
				//printMatriz(noCima.getMatriz());
				//System.out.print("\n");
			}
		}
		//Expandir para esquerda
		if(posicaoUnderline != 0 && posicaoUnderline != 3 && posicaoUnderline != 6)
		{
			
			No noEsquerda = new No();
			
			List<String> matrizEsquerda= new ArrayList<String>();
			
			matrizEsquerda.addAll(no.getMatriz());
			
			noEsquerda.setProfundidade(no.getProfundidade() + 1);
			
			noEsquerda.setMatriz(matrizEsquerda);
			
			noEsquerda.setNoParente(no);
			
			//Troca o lugar do valor da esquerda com o underscore
			noEsquerda.getMatriz().set(posicaoUnderline, noEsquerda.getMatriz().get(posicaoUnderline - 1));
			noEsquerda.getMatriz().set(posicaoUnderline - 1, "_");
			
			noEsquerda.setNumerosErrados(matrizObjetivo);
			noEsquerda.setCusto();
			
			int eIgualEsquerda = 0;
			//Verificar se ja existe um no com a mesma matriz na lista fechada
			for(int b = 0;b < listaFechada.size();b++)
			{
						
				if(noEsquerda.getMatriz().equals(listaFechada.get(b).getMatriz()))
				{
					eIgualEsquerda = 1;
				}
			}
			if(eIgualEsquerda == 0)
			{
				listaAberta.add(noEsquerda);
				//Printa a expanção do nó para esquerda
				//System.out.println("Expandindo para Esquerda");
				//printMatriz(noEsquerda.getMatriz());
				//System.out.print("\n");
			}
			
		}
		//Expandir para direita
		if(posicaoUnderline != 2 && posicaoUnderline != 5 && posicaoUnderline != 8)
		{
			
			No noDireita = new No();
			
			List<String> matrizDireita= new ArrayList<String>();
			
			matrizDireita.addAll(no.getMatriz());
			
			noDireita.setProfundidade(no.getProfundidade() + 1);
			
			noDireita.setMatriz(matrizDireita);
			
			noDireita.setNoParente(no);
			
			//Troca o lugar do valor da direita com o underscore
			noDireita.getMatriz().set(posicaoUnderline, noDireita.getMatriz().get(posicaoUnderline + 1));
			noDireita.getMatriz().set(posicaoUnderline + 1, "_");
			
			noDireita.setNumerosErrados(matrizObjetivo);
			noDireita.setCusto();
			
			int eIgualDireita = 0;
			//Verificar se ja existe um no com a mesma matriz na lista fechada
			for(int b = 0;b < listaFechada.size();b++)
			{
						
				if(noDireita.getMatriz().equals(listaFechada.get(b).getMatriz()))
				{
					eIgualDireita = 1;
				}
			}
			if(eIgualDireita == 0)
			{
				listaAberta.add(noDireita);
				//Printa a expanção do nó para direita
				//System.out.println("Expandindo para direita");
				//printMatriz(noDireita.getMatriz());
				//System.out.print("\n");
			}
			
		}
		//Expandir para baixo
		if(posicaoUnderline + 3 <= 8)
		{
			
			No noBaixo = new No();
			
			List<String> matrizBaixo= new ArrayList<String>();
			
			matrizBaixo.addAll(no.getMatriz());
			
			noBaixo.setProfundidade(no.getProfundidade() + 1);
			
			noBaixo.setMatriz(matrizBaixo);
			
			noBaixo.setNoParente(no);
			
			//Troca o lugar do valor de baixo com o underscore
			noBaixo.getMatriz().set(posicaoUnderline, noBaixo.getMatriz().get(posicaoUnderline + 3));
			noBaixo.getMatriz().set(posicaoUnderline + 3, "_");
			
			noBaixo.setNumerosErrados(matrizObjetivo);
			noBaixo.setCusto();
			
			int eIgualBaixo = 0;
			//Verificar se ja existe um no com a mesma matriz na lista fechada
			for(int b = 0;b < listaFechada.size();b++)
			{
						
				if(noBaixo.getMatriz().equals(listaFechada.get(b).getMatriz()))
				{
					eIgualBaixo = 1;
				}
			}
			if(eIgualBaixo == 0) 
			{
				listaAberta.add(noBaixo);
				//Printa a expanção do nó para baixo
				//System.out.println("Expandindo para baixo");
				//printMatriz(noBaixo.getMatriz());
				//System.out.print("\n");
			}
		}
	}
	
	//Ordena as lista em ordem crescente do valor de custo
	public void sort(List<No> nos)
	{
		Comparator<No> comparator = Comparator.comparingInt(No::getCusto).thenComparingInt(No::getNumerosErrados);
		Collections.sort(nos, comparator);
	}
	//Imprime o caminho escolhido pelo algoritmo após todas as expançoes
	public void printCaminhoEscolhido(No noObjetivo)
	{
		No noAtual = noObjetivo;
		
		int chegouNoFim = 0;
		
		List<No> listaNos = new ArrayList<No>();
		
		listaNos.add(noAtual);
		
		while(chegouNoFim == 0)
		{
			noAtual = noAtual.getNoParente();
		
			listaNos.add(noAtual);
			
			if(noAtual.getNoParente().equals(noAtual))
			{
				chegouNoFim = 1;
			}
		}
		
		Collections.reverse(listaNos);
		
		for(int a = 0; a < listaNos.size();a++)
		{
			printMatriz(listaNos.get(a).getMatriz());
			System.out.print("\n");
		}
	}
	
	public void aEstrela(No noInicial, List<String> matrizObjetivo)
	{
		
		noInicial.setNumerosErrados(matrizObjetivo);
		noInicial.setCusto();
		
		listaAberta.add(noInicial);
		
		int valoresErrados = noInicial.getNumerosErrados();
		
		while(valoresErrados != 0)
		{
			No noAtual = new No();
			
			noAtual = listaAberta.get(0);
			
			valoresErrados = noAtual.getNumerosErrados();
			
			//Printa todas as matrizes que o algoritmo passa 
			//System.out.println("Matriz Atual:");
			//printMatriz(noAtual.getMatriz());
			//System.out.print("\n");
			
			expandirNo(noAtual, matrizObjetivo);
			
			listaFechada.add(noAtual);
			
			listaAberta.remove(noAtual);
			
			sort(listaAberta);
			
			if(valoresErrados == 0)
			{
				printCaminhoEscolhido(noAtual);
			}					
		}
		
				
	}

}
