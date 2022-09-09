package AtividadeAvaliativa01.Questao11;

import java.util.Scanner;

public class SomaNumerosUtil {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		String sequencia;
		int somaTotal = 0;
		boolean deuRuim = false;
		
		do {
			try {
				System.out.println("Digite uma sequencia de números (separados por vírgula) :");
				sequencia = kbd.nextLine();

				String[] lista = sequencia.split(",");
				for (String l : lista) {
					somaTotal += Integer.parseInt(l);
				}

				System.out.println("A sequencia dada foi: " + sequencia);
				System.out.println("A soma da sequencia dada e: " + somaTotal);

			} catch (NumberFormatException ex) {
				System.err.println("Erro na digitacao da sequencia. Digite novamente!");
				deuRuim = true;
			}

		} while (deuRuim == true);

	}
}
