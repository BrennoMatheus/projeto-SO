
public class Listener implements ClockListener {

	public void notificar(MemoriaRAM m, int i) {
		m.setClock(i);
	}

}
