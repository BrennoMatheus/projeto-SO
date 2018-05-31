
public class Clock extends Thread {
	int contador;
	private Listener listener;
	
	public Clock(Listener l) {
		contador = 0;
		listener = l;
	}
	
	public void run() {
		
		try {
			while(true) {
				contador++;
				listener.notificar(contador);
				sleep(1000);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
