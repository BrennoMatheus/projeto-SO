
public class MMU {
	
	private MemoriaRAM memoriaR;
	private MemoriaVirtual memoriaV;
	private HD hd;
	private int clock;
	private final int TEMPO_LIMITE = 5;
	
	public MMU(MemoriaRAM mr, MemoriaVirtual mv, HD h) {
		memoriaR = mr;
		memoriaV = mv;
		hd = h;
	}
	
	public int getClock() {
		return clock;
	}
	
	public void setClock(int i) {
		clock = i;
	}
	
	public int leitura(int endereco) {
		
		System.out.println("ler o valor do endereco: "+endereco+" da memoria virtual");
		
		PaginaVirtual paginaV = memoriaV.getPagina(endereco); // busca a pagina da memoria virtual
		
		if(memoriaV.paginaPresente(endereco)) { // se a pagina buscada tiver o bit de presença verdadeiro
			
			System.out.println("endereco fisico mapeado pela memoria virtual encontra-se na ram");
			
			int enderecoF = paginaV.getIndicePaginaFisica(); // busca o endereço do dado na memoria fisica
			
			paginaV.setReferenciada(true); // informa q a pagina virtual foi referenciada
			
			return memoriaR.getConteudo(enderecoF); // busca o dado na memoria fisica
		}
		else {
			
			System.out.println("endereco fisico mapeado pela memoria virtual não encontra-se na ram");
			System.out.println("iniciando algoritmo de substituição...");
			
			int enderecoLiberado = substituicao(); // libera um endereco da ram atraves do algoritmo
			
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
			
			int enderecoLiberado = substituicao();	// chama algoritmo de substituição
			
			System.out.println("endereco livre encontrado: "+enderecoLiberado);
			System.out.println("inserindo: "+valor+" no endereco "+enderecoLiberado);
			
			inserirPagina(enderecoLiberado,valor,endereco); // insere o dado no endereco recem liberado
		}
		else {
			
			System.out.println("endereco livre achado na ram: "+enderecoLivre);
			
			inserirPagina(enderecoLivre,valor,endereco); // insere dado no endereco livre
		}
	}
	
	private int substituicao(){
		int endereco;
		
		endereco = verificarPaginas();
		
		try {
				
			System.out.println("verificacao de paginas retornou: "+endereco);
			
			while(endereco == -1){ // enquanto não retornar um endereco livre vai percorrer a memoria verificando
				System.out.println("nao foi achada pagina livre, verificando novamente...");
				endereco = verificarPaginas();
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {
			
		}
		
		
		System.out.println("pagina livre encontrada: "+endereco);
		return endereco; // retorna o endereco liberado		
	}
	
	private int verificarPaginas(){
		int endereco = -1; // valor por padrão é -1 p a função q chamar saber se foi liberado algum endereco
		int idade;
		
		for(int i = 0; i < memoriaV.getMemoriaVirtual().length; i++){ //  percorre todas as paginas da memoria virtual
			
			System.out.println("verificando pagina "+i+" da memoria virtual");
			
			idade = memoriaV.getPagina(i).getUltimaReferencia() - clock;
			
			System.out.println("idade da pagina "+i);
			
			if(memoriaV.getPagina(i).referenciada()){ // se aquela pagina foi referenciada naquele ciclo de clock
				memoriaV.getPagina(i).setUltimaReferencia(clock);	//inserir na pagina clock atual
			
				System.out.println("pagina "+i+" foi referenciada recentemente...");
				System.out.println("atualizando tempo da ultima referencia para "+memoriaV.getPagina(i).getUltimaReferencia());
			
			}
			else if(!memoriaV.getPagina(i).referenciada() && idade > TEMPO_LIMITE){ // se não foi referenciada e a idade ultrapassou o limite estabelecido
				
				System.out.println("pagina "+i+" não foi referenciada ultimamente e sua idade ultrapassou o tempo limite");
				
				endereco = memoriaV.getPagina(i).getIndicePaginaFisica(); // pega o endereco fisico q a memoria virtual esta mapeando
				int conteudo = memoriaR.getConteudo(endereco); // busca o conteudo na ram naquele endereco
				
				System.out.println("endereco fisico mapeado na pagina virtual "+i+" é: "+endereco+" e armazena o valor: "+conteudo);
				
				memoriaR.liberarPagina(endereco); // libera aquele endereco na ram
				
				System.out.println("espaco liberado na ram no endereco: "+endereco);
				
				memoriaV.getPagina(i).setPresente(false); // avisa a pagina q mapeia aquele endereco q o dado não está mais presente
				
				System.out.println("informando pagina virtual a ausencia do dado na ram");
				
				hd.inserir(i, conteudo); // transfere o dado p o hd
				
				System.out.println("valor transferido ao hd");
			}
	
		}
		System.out.println("retornando o endereco liberado: "+endereco);
		return endereco; // retorna o endereco da ram liberado
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
		memoriaV.getPagina(enderecoVirtual).setIndicePaginaFisica(enderecoFisico);
		memoriaR.setConteudo(enderecoFisico, valor);
		
		memoriaV.getPagina(enderecoVirtual).setReferenciada(true); 
		memoriaV.getPagina(enderecoVirtual).setModificada(true);
		memoriaV.getPagina(enderecoVirtual).setPresente(true);
	}
	

}
