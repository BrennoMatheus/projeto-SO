
public class HD {
	private enderecoHD[] swap = new enderecoHD[16];
	
	public int getConteudo(int i) {
		return swap[i].getConteudo();
	}	
	
	public void setConteudo(int endereco, int conteudo) {
		 swap[endereco].setConteudo(conteudo);
	}
	
	public enderecoHD[] getSwap() {
		return swap;
	}
	
	public void instanciarPagina(int endereco) {
		swap[endereco] = new enderecoHD();
	}
}
