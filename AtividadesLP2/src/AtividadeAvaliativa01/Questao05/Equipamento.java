package AtividadeAvaliativa01.Questao05;

public class Equipamento extends Repositorio{
	 
	private boolean ligado; // indicativo de equipamento ligado (true) ou desligado (false)
	 
	 public Equipamento() {
	 this.ligado = false;
	 }
	 public boolean isLigado() {
	 return ligado;
	 }
	 public void ligar() {
	 setLigado(true);
	 }
	 
	 public void desligar() {
	 setLigado(false);
	 }
	 
	 protected void setLigado(boolean ligado) {
	 this.ligado = ligado;
	 }
	 
}
