package AtividadeAvaliativa01.Questao05;

public class EquipamentoSonoro extends Equipamento {
	private int volume = 0;
	int count=0;
	
	public EquipamentoSonoro() {
		super();
	}

	public void volumeUp() {
		if (volume < 10) {
			volume++;
		} else {
			volume = 10;
		}
		System.out.println("VOL: " + volume);
	}

	public void volumeDown() {
		if (volume > 0) {
			volume--;
		} else {
			volume = 0;
		}
		System.out.println("VOL: " + volume);
	}

	public void desligar() {
		setLigado(false);
		volume = 0;
	}

	public int getVolume() {
		return volume;
	}
}
