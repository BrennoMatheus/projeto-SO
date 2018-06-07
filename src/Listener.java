
public class Listener implements ClockListener {

	private MMU gerenciador;
	
	public Listener(MMU mmu) {
		gerenciador = mmu;
	}
	public void notificar(int i) {
		gerenciador.setClock(i);
	}

}
