
public class Clock extends Thread {
	long contador;
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
				sleep(500);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
