package SO;
import clock.Clock;
import clock.Listener;
import memorias.HD;
import memorias.MemoriaRAM;
import memorias.MemoriaVirtual;

public class Main {
	
	public static void main(String[]args) {
		
		final int TAMANHO_MEMORIA_RAM = 16;
		final int TAMANHO_MEMORIA_VIRTUAL = TAMANHO_MEMORIA_RAM * 2;
		final int QUANTIDADE_DE_THREADS = 2;
	
		MemoriaRAM memoriaR = new MemoriaRAM(TAMANHO_MEMORIA_RAM);
		MemoriaVirtual memoriaV = new MemoriaVirtual(TAMANHO_MEMORIA_VIRTUAL);
		HD hd = new HD(TAMANHO_MEMORIA_VIRTUAL);
		MMU gerenciadorMemoria = new MMU(memoriaR,memoriaV,hd);
		SO so = new SO(gerenciadorMemoria, TAMANHO_MEMORIA_VIRTUAL, QUANTIDADE_DE_THREADS);
		Listener listener = new Listener(gerenciadorMemoria);
		Clock clock  = new Clock(listener);
		
		clock.start();
		
		so.iniciarProcessos();
				
		
	}
	
	
}
