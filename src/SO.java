import java.util.ArrayList;

public class SO {
	
	private MMU gerenciadorMemoria;
	private int tamanhoMemoriaVirtual;
	private int quantidadeThreads;
	
	public SO(MMU g, int tamanhoMemoriaVirtual, int quantidadeThreads){
		gerenciadorMemoria = g;
		this.tamanhoMemoriaVirtual = tamanhoMemoriaVirtual;
		this.quantidadeThreads = quantidadeThreads;
	}
	
	public void iniciarProcessos() {
		int posicaoInicial;
		for(int i = 0; i < quantidadeThreads; i++) {
			posicaoInicial = i*(tamanhoMemoriaVirtual/quantidadeThreads);
			new Processo(gerenciadorMemoria, tamanhoMemoriaVirtual, quantidadeThreads,posicaoInicial,i).start();
		}
	}
	
	/*public int quantidadeInstrucoes(){ // metodo de teste
		return instrucoes.size();
	}*/
	
	/*public void leituraInstrucoes(String s){
		 String[] arrayInstrucoes = s.split(",");
		 inserePilhaInstrucoes(arrayInstrucoes);
	}*/
	
	/*public void inserePilhaInstrucoes(String[] instrucoes) {
		for(String instrucao : instrucoes) {
			this.instrucoes.add(instrucao);
		}
	}*/
	
	/*public String retiraPilhaInstrucoes() {
		String instrucao;
		instrucao = instrucoes.get(0);
		instrucoes.remove(0);
		return instrucao;
	}*/
	
	/*public void execute() {
		String instrucao = retiraPilhaInstrucoes();
		
		int tipoInstrucao = instrucao.indexOf('R');
		
		if(tipoInstrucao == -1) {
			escrita(instrucao);
		}
		else {
			leitura(instrucao);
		}
	}*/
	
	
	/*public void escrita(String s) {
		String[] instrucao = s.split("-");
		int endereco = Integer.parseInt(instrucao[0]);
		int valor = Integer.parseInt(instrucao[2]);
		
		gerenciadorMemoria.escrita(endereco, valor);
	}*/
	
	/*public void leitura(String s) {
		String[] instrucao = s.split("-");
		int endereco = Integer.parseInt(instrucao[0]);
		
		int valor =  gerenciadorMemoria.leitura(endereco);
		
		if(valor == -99999) {
			System.out.println("o valor lido do endereço "+instrucao[0]+" é "+ "null");
		}
		else {
			System.out.println("o valor lido do endereço "+instrucao[0]+" é "+ valor);
		}	
	}*/
}
