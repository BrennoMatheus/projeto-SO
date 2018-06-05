
public class MemoriaRAM {

	private PaginaFisica[] memoriaRam = new PaginaFisica[8]; 
	private int[] enderecos;
	
	public MemoriaRAM(int tamanho) {
		enderecos = new int[tamanho];
	}
	
	public int getConteudo(int i) {
		return enderecos[i];
	}	
	
	public void setConteudo(int endereco, int conteudo) {
		enderecos[endereco] = conteudo;
	}
}
