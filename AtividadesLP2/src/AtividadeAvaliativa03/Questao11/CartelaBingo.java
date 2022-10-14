package AtividadeAvaliativa03.Questao11;

import java.util.Random;

public class CartelaBingo {
	int[] numerosCartela;
	int[] numerosMarcados;
	public static final int NUMEROSCARTELA = 24;
	public static final int MAXRANDOM = 99;
	private final Random geradorNumeros = new Random();

	public CartelaBingo() {
		this.numerosCartela = new int[NUMEROSCARTELA];
		this.numerosMarcados = new int[NUMEROSCARTELA];

		for (int i = 0; i < this.numerosCartela.length; i++) {
			int numeroGerado = geradorNumeros.nextInt(MAXRANDOM) + 1;

			while (numeroJaAdicionado(numeroGerado)) {
				numeroGerado = geradorNumeros.nextInt(MAXRANDOM) + 1;
			}

			this.numerosCartela[i] = numeroGerado;
		}
	}

	// metodo para evitar que tenham numeros repetidos na cartela
	public boolean numeroJaAdicionado(int numeroGerado) {
		for (int i = 0; i < this.numerosCartela.length; i++) {
			if (this.numerosCartela[i] == numeroGerado)
				return true;
		}
		return false;
	}

	public void showCartela() {
		System.out.println("--------------CARTELA---------------\n");
		for (int i = 0; i < this.numerosCartela.length; i++) {

			String numeroInserir = " [%d";
			numeroInserir = jaFoiMarcado(this.numerosCartela[i]) ? numeroInserir + " X] " : numeroInserir + " ] ";

			System.out.printf(numeroInserir, this.numerosCartela[i]);
			if ((i + 1) % 4 == 0)
				System.out.print("\n");
		}
	}

	public boolean marcarCartela(int numero) {
		if (!estaCompleta()) {

			for (int i = 0; i < this.numerosCartela.length; i++) {
				if (numero == numerosCartela[i])
					numerosMarcados[i] = numero;
			}

		} else {
			System.out.println("BINGO!!!");
			return false;
		}

		return true;

	}

	public boolean estaCompleta() {
		return numerosCartela == numerosMarcados;
	}

	public boolean jaFoiMarcado(int numero) {
		for (int i = 0; i < numerosMarcados.length; i++) {
			if (numero == numerosMarcados[i])
				return true;
		}
		return false;
	}

	public double getTaxaPontuacao() {
		return (numerosMarcados.length * 100/ NUMEROSCARTELA);
	}

	public int[] getNumerosNaoPontuados() {
		int[] numerosNaoPontuados = new int[NUMEROSCARTELA];

		for (int i = 0; i < numerosNaoPontuados.length; i++) {
			if (!jaFoiMarcado(numerosMarcados[i]))
				numerosNaoPontuados[i] = numerosMarcados[i];
		}

		return numerosNaoPontuados;
	}
}
