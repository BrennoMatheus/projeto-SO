
public class MemoriaRAM {

	private PaginaFisica[] memoriaRam = new PaginaFisica[8];
	
	
	public int getConteudo(int i) {
		return memoriaRam[i].getConteudo();
	}	
	
	public void setConteudo(int endereco, int conteudo) {
		 memoriaRam[endereco].setConteudo(conteudo);
	}
	
	public PaginaFisica[] getMemoriaRam() {
		return memoriaRam;
	}
	
	public void liberarPagina(int i){
		memoriaRam[i] = null;
	}
	
	public void instanciarPagina(int endereco) {
		memoriaRam[endereco] = new PaginaFisica();
	}
}
