import java.util.Iterator;

public class MMU {
	
	private MemoriaRAM memoriaR;
	private MemoriaVirtual memoriaV;
	private HD hd;
	private long clock;
	private final int TEMPO_LIMITE = 5;
	
	public MMU(MemoriaRAM mr, MemoriaVirtual mv, HD h) {
		memoriaR = mr;
		memoriaV = mv;
		hd = h;
	}
	
	public long getClock() {
		return clock;
	}
	
	public void setClock(long i) {
		clock = i;
	}
	
	public int leitura(int endereco) {
		
		System.out.println("ler o valor do endereco: "+endereco+" da memoria virtual");
		
		if(memoriaV.paginaPresente(endereco)) { // se a pagina buscada tiver o bit de presença verdadeiro
			
			System.out.println("endereco fisico mapeado pela memoria virtual encontra-se na ram");
			
			int enderecoF = memoriaV.getPagina(endereco).getIndicePaginaFisica(); // busca o endereço do dado na memoria fisica
			
			memoriaV.getPagina(endereco).setReferenciada(true); // informa q a pagina virtual foi referenciada
			memoriaV.getPagina(endereco).setUltimaReferencia(clock);	//inserir na pagina clock atual
			
			return memoriaR.getConteudo(enderecoF); // busca o dado na memoria fisica
		}
		else {
			
			System.out.println("endereco fisico mapeado pela memoria virtual não encontra-se na ram");
			System.out.println("iniciando algoritmo de substituição...");
			
			int enderecoLiberado = substituicao(endereco); // libera um endereco da ram atraves do algoritmo
			
			System.out.println("endereco fisico liberado: "+enderecoLiberado);
			
			memoriaR.setConteudo(enderecoLiberado, hd.getConteudo(endereco)); // transfere o dado do hd para a memoria ram
			memoriaV.getPagina(endereco).setPresente(true); // avisa a memoria virtual q o dado q ela mapeia está presente na ram
			
			System.out.println("conteudo transferido do hd para a ram");
			System.out.println("conteudo retornado: "+memoriaR.getConteudo(enderecoLiberado));
			
			return memoriaR.getConteudo(enderecoLiberado); // retorna o conteudo lido da ram
		}
	}
	
	public void escrita(int endereco, int valor) {
		
		System.out.println("escrever "+ valor + " em "+ endereco);
		
		int enderecoLivre = buscarEnderecoLivre();
		
		System.out.println("endereco retornado achado :" + enderecoLivre);
		
		if(enderecoLivre == -1) { // -1 significa q n achou endereços livres
			
			System.out.println("não foi encontrada pagina livre, iniciar algoritmo de substituicao...");
			
			int enderecoLiberado = substituicao(endereco);	// chama algoritmo de substituição
			
			System.out.println("endereco livre encontrado: "+enderecoLiberado);
			System.out.println("inserindo: "+valor+" no endereco "+enderecoLiberado);
			
			inserirPagina(enderecoLiberado,valor,endereco); // insere o dado no endereco recem liberado
		}
		else {
			
			System.out.println("endereco livre achado na ram: "+enderecoLivre);
			
			inserirPagina(enderecoLivre,valor,endereco); // insere dado no endereco livre
		}
	}
	
	private int substituicao(int enderecoV){
		int endereco;
		
		endereco = verificarPaginas(enderecoV);
	
		System.out.println("verificacao de paginas retornou: "+endereco);
			
		while(endereco == -1){ // enquanto não retornar um endereco livre vai percorrer a memoria verificando
			System.out.println("nao foi achada pagina livre, verificando novamente...");
			endereco = verificarPaginas(enderecoV);
		}
	
		System.out.println("pagina livre encontrada: "+endereco);
		return endereco; // retorna o endereco liberado		
	}
	
	private int verificarPaginas(int enderecoV){
		int endereco = -1; // valor por padrão é -1 p a função q chamar saber se foi liberado algum endereco
		long idade;
		
		
		for(int i = 0; i < memoriaV.getMemoriaVirtual().length; i++){ //  percorre todas as paginas da memoria virtual q foram instanciadas
			
			if(memoriaV.existe(i)){
				idade = clock - memoriaV.getPagina(i).getUltimaReferencia();
				
				System.out.println("verificando pagina "+i+" da memoria virtual");
				System.out.println("idade da pagina "+i+": "+idade);
				
				if(memoriaV.getPagina(i).referenciada()){ // se aquela pagina foi referenciada naquele ciclo de clock
					memoriaV.getPagina(i).setUltimaReferencia(clock);	//inserir na pagina clock atual
		
					System.out.println("pagina "+i+" foi referenciada recentemente...");
					System.out.println("atualizando tempo da ultima referencia para "+memoriaV.getPagina(i).getUltimaReferencia());
					
				}
				else if(!memoriaV.getPagina(i).referenciada() && !memoriaV.getPagina(i).modificada() && idade > TEMPO_LIMITE){ // se não foi referenciada e a idade ultrapassou o limite estabelecido
					
					System.out.println("pagina "+i+" não foi referenciada ultimamente e sua idade ultrapassou o tempo limite");
					
					endereco = memoriaV.getPagina(i).getIndicePaginaFisica(); // pega o endereco fisico q a memoria virtual esta mapeando
					int conteudo = memoriaR.getConteudo(endereco); // busca o conteudo na ram naquele endereco
					
					System.out.println("endereco fisico mapeado na pagina virtual "+i+" é: "+endereco+" e armazena o valor: "+conteudo);
					
					memoriaR.liberarPagina(endereco); // libera aquele endereco na ram
					
					System.out.println("espaco liberado na ram no endereco: "+endereco);
					
					memoriaV.getPagina(i).setPresente(false); // avisa a pagina q mapeia aquele endereco q o dado não está mais presente
					
					System.out.println("informando pagina virtual a ausencia do dado na ram");
					
					hd.inserir(enderecoV, conteudo); // transfere o dado p o hd
					
					System.out.println("valor transferido ao hd");
					
					break;
				}
		
			}
			
		}
			
		System.out.println("retornando o endereco liberado: "+endereco);
		return endereco; // retorna o endereco da ram liberado
			
	}
	
	public void reiniciarBitR() {
		for(int i = 0; i < memoriaV.getMemoriaVirtual().length; i++ ) {
			if(memoriaV.existe(i)){
				memoriaV.getPagina(i).setReferenciada(false);
			}
		}
	}
	
	public void reiniciarBitM(){
		for(int i = 0; i < memoriaV.getMemoriaVirtual().length; i++ ) {
			if(memoriaV.existe(i)){
				memoriaV.getPagina(i).setModificada(false);
			}
		}
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
	
	private void inserirPagina(int enderecoFisico,int valor,int enderecoVirtual){
		memoriaR.instanciarPagina(enderecoFisico);
		memoriaV.instanciarPagina(enderecoVirtual);
		memoriaV.getPagina(enderecoVirtual).setIndicePaginaFisica(enderecoFisico);
		memoriaR.setConteudo(enderecoFisico, valor);
		
		memoriaV.getPagina(enderecoVirtual).setReferenciada(true); 
		memoriaV.getPagina(enderecoVirtual).setModificada(true);
		memoriaV.getPagina(enderecoVirtual).setPresente(true);
	}
	

}
