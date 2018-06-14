
public class Listener implements ClockListener {

	private MMU gerenciador;
	private SO sistemaOperacional;
	
	public Listener(MMU mmu,SO so) {
		gerenciador = mmu;
		sistemaOperacional = so;
	}
	public void notificar(int i) {
		gerenciador.setClock(i);
		gerenciador.reiniciarBitR();
		gerenciador.reiniciarBitM();
	}

}
