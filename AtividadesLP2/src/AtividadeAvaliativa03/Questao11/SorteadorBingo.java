package AtividadeAvaliativa03.Questao11;

import java.util.Collection;
import java.util.Random;

public class SorteadorBingo {

	public static final int MAX = 99; // maior número a ser sorteado
	// array de status de números (se enésimo número sorteado, true; caso contrário,
	// false)
	private boolean[] statusNumeros;
	private int quantidade; // quantidade de números sorteados
	private Random geradorNumeros; // gerador randômico de números

	public SorteadorBingo() {
		quantidade = 0; // inicialização de quantidade de números sorteados
		statusNumeros = new boolean[MAX]; // instanciação de array de status de números
		geradorNumeros = new Random(); // instanciação de gerador randômico de números
	}

	// retorno de próximo número sorteado ou -1 se todos já estiverem sido sorteados
	public int sortearProximoNumero() {
		if (quantidade == MAX) // se todos os números já sorteados...
			return -1;
		else { // caso contrário...
			boolean naoSorteado = false; // flag de indicação de número já ter sido sorteado
			int numero = 0; // inicialização de número a ser sorteado
			// repetição de geração de número randômico enquanto este já ter sido sorteado
			do {
				// geração de próximo número randômico entre 1 (um) e máximo definido por MAX
				numero = geradorNumeros.nextInt(MAX) + 1;
				if (!statusNumeros[numero - 1]) {
					naoSorteado = true;
					this.statusNumeros[numero - 1] = naoSorteado;
				} // se número já não tiver sido sorteado...
				 // atualização de flag (número não sorteado)
			} while (!naoSorteado); // atualização de indicador de sorteio
			quantidade++; // atualização de quantidade de números sorteados
			return numero; // retorno de número sorteado
		}
	}

	// retorno de array de números até então sorteados
	public int[] getNumerosSorteados() {
		int[] numeros = new int[quantidade]; // array de números sorteados
		int proximoNum = 1; // próximo número a ser testado e inicializado com 1 (um)
		// identificação de números sorteados e armazenamento em array

		for (int i = 0; i < quantidade; i++) {
			while (!statusNumeros[proximoNum - 1]) // se próximo número não tiver tido sorteado...
				proximoNum++; // atualização de próximo número a ser testado
			numeros[i] = proximoNum; // inserção de número em enésimo índice de array
			proximoNum++; // atualização de próximo número a ser testado
		}
		return numeros; // retorno de array de números sorteados
	}
}
