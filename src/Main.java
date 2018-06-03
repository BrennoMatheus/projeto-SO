
public class Main {
	
	public static void main(String[]args) {
		
		MemoriaRAM memoriaR = new MemoriaRAM();
		MemoriaVirtual memoriaV = new MemoriaVirtual();
		Listener listener = new Listener(memoriaR);
		Clock clock  = new Clock(listener);
		
		clock.start();
		
		SO so = new SO(memoriaR,memoriaV);
		
		so.leituraInstrucoes("4-W-2,4-R,5-W-3,5-R");
		
	}
	
	
}
