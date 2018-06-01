
public class MemoriaRAM {

	private PaginaFisica[] memoriaRam = null; 
	private int clock;
	
	public MemoriaRAM() {
		memoriaRam = new PaginaFisica[8];
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
