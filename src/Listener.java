
public class Listener implements ClockListener {

	private MemoriaRAM memoria;
	
	public Listener(MemoriaRAM m) {
		memoria = m;
	}
	public void notificar(int i) {
		memoria.setClock(i);
	}

}
