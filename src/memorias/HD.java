package memorias;

public class HD {
	private enderecoHD[] swap;
	
	public HD(int tamanho) {
		
		swap = new enderecoHD[tamanho];
		
		for(int i = 0; i < tamanho; i++) {
			swap[i] = new enderecoHD();
		}
	}
	
	public int getConteudo(int i) {
		return swap[i].getConteudo();
	}
	
	public void setConteudo(int endereco, int conteudo) {
		 swap[endereco].setConteudo(conteudo);
	}
	
	public enderecoHD[] getSwap() {
		return swap;
	}
	
	public void inserir(int endereco, int conteudo) {
		swap[endereco].setConteudo(conteudo);
	}
}
