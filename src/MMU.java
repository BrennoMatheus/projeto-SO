
public class MMU {
	
	private MemoriaRAM memoriaR;
	private MemoriaVirtual memoriaV;
	
	public MMU(MemoriaRAM mr, MemoriaVirtual mv) {
		memoriaR = mr;
		memoriaV = mv;
	}
	
	public int leitura(int endereco) {
		PaginaVirtual paginaV = memoriaV.getPagina(endereco); // busca a pagina da memoria virtual
		
		if(memoriaV.paginaPresente(endereco)) { // se a pagina buscada tiver o bit de presen�a verdadeiro
			int enderecoF = paginaV.getIndicePaginaFisica(); // busca o endere�o do dado na memoria fisica
			
			paginaV.setReferenciada(true); // informa q a pagina virtual foi referenciada
			paginaV.setProtegida(true); // informa q a pagina n�o est� disponivel p escrita, somente p leitura
			
			return memoriaR.getConteudo(enderecoF); // busca o dado na memoria fisica
		}
		else {
			return -1; // aqui come�a o algoritmo de substitui��o de paginas
		}
	}
	
	public void escrita(int endereco, int valor) {
		if(memoriaV.paginaLivre(endereco)) { // se a pagina estiver livre p escrita
			
			PaginaVirtual paginaV = memoriaV.getPagina(endereco);
			int enderecoF = paginaV.getIndicePaginaFisica();
			memoriaR.setConteudo(enderecoF, valor);
			
			paginaV.setReferenciada(true); 
			paginaV.setModificada(true);
			paginaV.setProtegida(true);
		}
		else {
			// n sei ainda cmo proceder nesse caso
		}
	}
	

}
