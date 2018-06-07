
public class Main {
	
	public static void main(String[]args) {
		
		MemoriaRAM memoriaR = new MemoriaRAM();
		MemoriaVirtual memoriaV = new MemoriaVirtual();
		MMU gerenciadorMemoria = new MMU(memoriaR,memoriaV);
		Listener listener = new Listener(gerenciadorMemoria);
		Clock clock  = new Clock(listener);
		
		clock.start();
		
		SO so = new SO(gerenciadorMemoria);
		
		so.leituraInstrucoes("4-W-2,4-R,5-W-3,5-R");
		
	}
	
	
}
