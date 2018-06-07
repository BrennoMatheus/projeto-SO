
public class HD {
	private enderecoHD[] swap = new enderecoHD[16];
	
	public HD() {
		for(int i = 0; i < 16; i++) {
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
