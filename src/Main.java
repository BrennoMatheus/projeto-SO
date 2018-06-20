
public class Main {
	
	public static void main(String[]args) {
		
		final int TAMANHO_MEMORIA_RAM = 16;
		final int TAMANHO_MEMORIA_VIRTUAL = TAMANHO_MEMORIA_RAM * 2;
		final int QUANTIDADE_DE_THREADS = 2;
	
		MemoriaRAM memoriaR = new MemoriaRAM(TAMANHO_MEMORIA_RAM);
		MemoriaVirtual memoriaV = new MemoriaVirtual(TAMANHO_MEMORIA_VIRTUAL);
		HD hd = new HD();
		MMU gerenciadorMemoria = new MMU(memoriaR,memoriaV,hd);
		SO so = new SO(gerenciadorMemoria, TAMANHO_MEMORIA_VIRTUAL, QUANTIDADE_DE_THREADS);
		Listener listener = new Listener(gerenciadorMemoria,so);
		Clock clock  = new Clock(listener);
		FabricaDeEntradas fabrica = new FabricaDeEntradas(TAMANHO_MEMORIA_VIRTUAL);
		
		clock.start();
		
		so.iniciarProcessos();
		
		/*String entradas = fabrica.gerarEntradas();
		
		System.out.println(entradas);
		
		so.leituraInstrucoes(entradas);
		
		int i = so.quantidadeInstrucoes();
		int cont = 0;
		
		try{
			while(cont < i){
				so.execute();
				cont++;
				Thread.sleep(1000);
			}
			
			String a = "asdasdh";
			a ="asdasdfa";
		}
		catch(Exception e){
			e.getMessage();
		}*/
		
		
		
		
	}
	
	
}
