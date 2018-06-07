
public class MMU {
	
	private MemoriaRAM memoriaR;
	private MemoriaVirtual memoriaV;
	private int clock;
	private final int TEMPO_LIMITE = 5;
	
	public MMU(MemoriaRAM mr, MemoriaVirtual mv) {
		memoriaR = mr;
		memoriaV = mv;
	}
	
	public int getClock() {
		return clock;
	}
	
	public void setClock(int i) {
		clock = i;
	}
	
	public int leitura(int endereco) {
		PaginaVirtual paginaV = memoriaV.getPagina(endereco); // busca a pagina da memoria virtual
		
		if(memoriaV.paginaPresente(endereco)) { // se a pagina buscada tiver o bit de presença verdadeiro
			int enderecoF = paginaV.getIndicePaginaFisica(); // busca o endereço do dado na memoria fisica
			
			paginaV.setReferenciada(true); // informa q a pagina virtual foi referenciada
			
			return memoriaR.getConteudo(enderecoF); // busca o dado na memoria fisica
		}
		else {
			return -1; // aqui começa o algoritmo de substituição de paginas
		}
	}
	
	private void inserirPagina(int enderecoFisico,int valor,int enderecoVirtual){
		memoriaR.instanciarPagina(enderecoFisico);
		memoriaV.getPagina(enderecoVirtual).setIndicePaginaFisica(enderecoFisico);
		memoriaR.setConteudo(enderecoFisico, valor);
		
		memoriaV.getPagina(enderecoVirtual).setReferenciada(true); 
		memoriaV.getPagina(enderecoVirtual).setModificada(true);
		memoriaV.getPagina(enderecoVirtual).setPresente(true);
	}
	
	public void escrita(int endereco, int valor) {
			
		int enderecoLivre = buscarEnderecoLivre(); // verificar pq q esta iniciando pela posicao final
		
		if(enderecoLivre == -1) { // -1 significa q n achou endereços livres
			int enderecoLiberado = substituicao();	// chama algoritmo de substituição
			inserirPagina(enderecoLiberado,valor,endereco);
		}
		else {
			inserirPagina(enderecoLivre,valor,endereco);
		}
		
		// apenas p visualizar o resultado da função
		System.out.println("endereco pagina virtual: "+ endereco +
							"\n endereco pagina fisica "+ enderecoLivre +
							"\n modificada: "+ memoriaV.getPagina(endereco).modificada() +
							"\n referenciada: "+ memoriaV.getPagina(endereco).referenciada() +
							"\n presente: "+ memoriaV.getPagina(endereco).presente()
				
		);
			
	}

	
	private int substituicao(){
		int endereco;
		
		endereco = verificarPaginas();
		
		while(endereco == -1){
			endereco = verificarPaginas();
		}
		return endereco;		
	}
	
	private int verificarPaginas(){
		int endereco = -1;
		int idade;
		
		for(int i = 0; i < memoriaV.getMemoriaVirtual().length; i++){
			
			idade = memoriaV.getPagina(i).getUltimaReferencia() - clock;
			
			if(memoriaV.getPagina(i).referenciada()){
				memoriaV.getPagina(i).setUltimaReferencia(clock);	//inserir na pagina clock atual
			}
			else if(!memoriaV.getPagina(i).referenciada() && idade > TEMPO_LIMITE){
				endereco = memoriaV.getPagina(i).getIndicePaginaFisica();
				int conteudo = memoriaR.getConteudo(endereco);
				memoriaR.liberarPagina(endereco);
				memoriaV.getPagina(i).setPresente(false);
				//inserir no hd
			}
	
		}
		return endereco;
	}
	
	private int buscarEnderecoLivre() {
		PaginaFisica[] copia = memoriaR.getMemoriaRam();
		int enderecoLivre = -1;
		
		for(int i = 0; i < copia.length; i++) {
			if(copia[i] == null) {
				enderecoLivre = i;
			}
		}
		return enderecoLivre;
	}
	

}
