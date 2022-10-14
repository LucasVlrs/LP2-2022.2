package AtividadeAvaliativa03.Questao11;

import java.util.ArrayList;
import java.util.List;

public class SorteioThread implements Runnable {

	SorteadorBingo sorteadorBingo = new SorteadorBingo();
    CartelaBingo cartela;

    public SorteioThread(CartelaBingo cartela){
        this.cartela = cartela;
    }
    
    @Override
    public void run() {
        while(!this.cartela.estaCompleta()){
            int numero = sorteadorBingo.sortearProximoNumero();
            
            if (numero == -1 ) {
            	System.out.println("Todos os números foram sorteados !");
             break;
            }
            this.cartela.marcarCartela(numero);
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            this.cartela.showCartela();
        }
    }

    int[] getNumerosSorteados(){
        return sorteadorBingo.getNumerosSorteados();
    }

    double getTaxaPontuacao(){
        return cartela.getTaxaPontuacao();
    }

    int[] getNumerosNaoPontuados(){
        return cartela.getNumerosNaoPontuados();
    }
}
