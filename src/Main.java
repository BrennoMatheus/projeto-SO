
public class Main {
	
	public static void main(String[]args) {
		
		MemoriaRAM memoriaR = new MemoriaRAM();
		
		Listener listener = new Listener(memoriaR);
		
		Clock clock  = new Clock(listener);
		
		clock.start();
		

		
	}
	
	
}
