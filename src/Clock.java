
public class Clock extends Thread {
	int contador;
	
	public Clock() {
		contador = 0;
	}
	
	public void run() {
		
		try {
			while(true) {
				contador++;
				System.out.println(contador);
				sleep(1000);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
