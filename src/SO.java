
public class SO {
	
	private MMU gerenciadorMemoria;
	
	public SO(MemoriaRAM mr, MemoriaVirtual mv ){
		gerenciadorMemoria = new MMU(mr,mv);
	}
	
	public void leituraInstrucoes(String s){
		String[] arrayInstrucoes = s.split(",");
		
		for(String instrucao : arrayInstrucoes) {
			if(instrucao.length() > 3) {
				escrita(instrucao);
			}
			else {
				leitura(instrucao);
			}
		}
	}
	
	public void escrita(String s) {
		String[] instrucao = s.split("-");
		int endereco = Integer.parseInt(instrucao[0]);
		int valor = Integer.parseInt(instrucao[2]);
		
		gerenciadorMemoria.escrita(endereco, valor);
	}
	
	public int leitura(String s) {
		String[] instrucao = s.split("-");
		int endereco = Integer.parseInt(instrucao[0]);
		
		return gerenciadorMemoria.leitura(endereco);	
	}
}
