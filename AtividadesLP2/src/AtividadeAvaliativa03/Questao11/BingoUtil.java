package AtividadeAvaliativa03.Questao11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BingoUtil {
	public static void main(String[] args) throws Exception {
		Scanner scnr = new Scanner(System.in);
		CartelaBingo cartela = new CartelaBingo();
		SorteioThread sorteio = new SorteioThread(cartela);
		
		Thread thread = new Thread(sorteio, "Sorteio");		
		
		thread.run();
		
		while(true){
            try{
                int escolha = 0;
            System.out.println("1- Opcoes");
            System.out.println("2- Encerrar");
            escolha = scnr.nextInt();
            if(escolha == 1){
            System.out.println("--------------------------MENU----------------------------");
            System.out.println("1- numeros sorteados");
            System.out.println("2- percentual de números da cartela pontuados");
            System.out.println("3- números da cartela que ainda não se encontram pontuados");

            escolha = scnr.nextInt();
            switch(escolha){
                case 1: //numeros sorteados
                    int[] numerosSorteados = sorteio.getNumerosSorteados();

                    for (int i = 0; i < numerosSorteados.length; i++){
                        System.out.println(numerosSorteados[i]);
                    }
                    continue;
                case 2: //taxa de numeros pontuados
                    double taxa = sorteio.getTaxaPontuacao();
                    System.out.print("Preenchido: " );
                    System.out.printf("%.1f%% \n", taxa);
                    continue;
                case 3: //numeros que nao foram pontuados na tabela
                    int[] numerosNaoSorteados = sorteio.getNumerosNaoPontuados();

                    for (int i = 0; i < numerosNaoSorteados.length; i++){
                        if(numerosNaoSorteados[i] != 0) System.out.println(numerosNaoSorteados[i]);
                    }
                    continue;
                default: 
                    System.err.println("Selecione uma opcao valida!");
            }
            }else if (escolha == 2){
            	System.out.println("OBRIGADO POR JOGAR!");
            	thread.interrupt();
                break;
            }else{
                System.err.println("Selecione uma opcao valida!");
                continue;
            }
            scnr.close();

            }catch(InputMismatchException e){
                System.err.println("Erro na digitacao!");
                scnr.nextLine();
                continue;
            }
            
        }
	}
}
