
public class ControleConcorrencia implements InterfaceControle {
	
	private MMU gerenciadorMemoria;
	
	
	public ControleConcorrencia(MemoriaRAM mr, MemoriaVirtual mv){
		gerenciadorMemoria = new MMU(mr,mv);
	}

	
	public synchronized int leitura(int endereco) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public synchronized void escrita(int endereco, int valor) {
		// TODO Auto-generated method stub
		
	}
	

}
