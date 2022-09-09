package AtividadeAvaliativa01.Questao05;

public class Repositorio {
	private int indice;
	protected Equipamento[] DB;
	int count;
	
	public Repositorio() {
		DB = new Equipamento[6];
		indice = 0;
	}
	public void inserir(Equipamento E ) {
		DB[indice] = E;
		indice++;
	}
	
	public Equipamento getAparelho(int aparelho) {
		indice= aparelho-1;
		return DB[indice];
	}
	
}
