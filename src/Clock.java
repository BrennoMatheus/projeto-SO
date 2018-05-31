
public class Clock extends Thread {
	int contador;
	private Listener listener;
	private MemoriaRAM memoria;
	
	public Clock(MemoriaRAM m) {
		contador = 0;
		listener = new Listener();
		memoria = m;
	}
	
	public void run() {
		
		try {
			while(true) {
				contador++;
				listener.notificar(memoria,contador);
				sleep(1000);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
