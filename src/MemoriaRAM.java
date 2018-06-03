
public class MemoriaRAM {

	private PaginaFisica[] memoriaRam = new PaginaFisica[8]; 
	private int clock;
	
	public MemoriaRAM() {
		for(int i = 0; i < 8; i++){
			memoriaRam[i] = new PaginaFisica(i);
		}
	}
	
	public int getConteudo(int i) {
		return memoriaRam[i].getConteudo();
	}
	
	public int getClock() {
		return clock;
	}
	
	public void setClock(int i) {
		clock = i;
	}
	
	public void setConteudo(int endereco, int conteudo) {
		memoriaRam[endereco].setConteudo(conteudo);
	}
}
