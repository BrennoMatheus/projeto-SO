package clock;
import SO.MMU;

public class Listener implements ClockListener {

	private MMU gerenciador;
	
	public Listener(MMU mmu) {
		gerenciador = mmu;
	}
	public void notificar(long i) {
		gerenciador.setClock(i);
		gerenciador.reiniciarBitR();
		gerenciador.reiniciarBitM();
	}


}
