package AtividadeAvaliativa01.Questao05;
/**
 * 
 * @author Lucas Vilares Barreto
 *  
 * **/
import java.util.Scanner;

public class EquipamentoUtil {
	public static void main(String[] args) {
		int operacao;
		char ans = 'N';
		int aparelho;
		int count = 0;
		Scanner kbd = new Scanner(System.in);

		EquipamentoSonoro E1 = new EquipamentoSonoro();
		EquipamentoSonoro E2 = new EquipamentoSonoro();
		EquipamentoSonoro E3 = new EquipamentoSonoro();
		EquipamentoSonoro E4 = new EquipamentoSonoro();
		EquipamentoSonoro E5 = new EquipamentoSonoro();
		EquipamentoSonoro E6 = new EquipamentoSonoro();

		Repositorio DB = new Repositorio();
		
		DB.inserir(E1);
		DB.inserir(E2);
		DB.inserir(E3);
		DB.inserir(E4);
		DB.inserir(E5);
		DB.inserir(E6);
		
		do {
			System.out.println("Qual aparelho voce deseja usar (1-6)?");
			aparelho = kbd.nextInt();
			DB.getAparelho(aparelho);
		
		do {
			
			System.out.println("********** MENU ***********");
			System.out.println("* 1 - Ligar               *");
			System.out.println("* 2 - Desligar            *");
			System.out.println("* 3 - Volume -            *");
			System.out.println("* 4 - Volume +            *");
			System.out.println("* 5 - Encerrar operacao   *");
			System.out.println("***************************");

			System.out.print("\nInforme Codigo Operacao (1-6): ");
			operacao = kbd.nextInt();

			switch (operacao) {
			case 1:
				DB.getAparelho(aparelho).ligar();
				break;
			case 2:
				DB.getAparelho(aparelho).desligar();
				
				break;
			case 3:
				((EquipamentoSonoro) DB.getAparelho(aparelho)).volumeDown();
				
				break;
			case 4:
				((EquipamentoSonoro) DB.getAparelho(aparelho)).volumeUp();
				
				break;
			case 5:
				System.out.println("Deseja sair do menu deste aparelho (S/N)?");
				ans = kbd.next().charAt(0);
				
				
				
				break;
			}
		} while (operacao != 5 && ans == 'N' || ans == 'n');
		
		if(((EquipamentoSonoro) DB.getAparelho(aparelho)).getVolume()>8) {
			count ++;
			}
			
			System.out.println("Deseja encerrar o programa (S/N)?");
			ans = kbd.next().charAt(0);
			
		}while (ans == 'N' || ans == 'n');
		
		kbd.close();
		
		System.out.println("O percentual de aparelhos com nível "+
		" de audio prejudicial e : " + count*100.0/DB.DB.length);
		
	}
}