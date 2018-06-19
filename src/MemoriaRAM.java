
public class MemoriaRAM {

	private PaginaFisica[] memoriaRam;
	
	public MemoriaRAM(int tamanho) {
		memoriaRam = new PaginaFisica[tamanho];
	}
	
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
