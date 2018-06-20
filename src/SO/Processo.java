package SO;
import java.util.ArrayList;

public class Processo extends Thread {
	
	private int id;
	private MMU mmu;
	private int posicaoInicial; //Na hora de criar as threads, esse parâmetro deve seguir a seguinte fórmula: n*(tam_memoria_virtual/qtd_threads)
								//n = indice do FOR q irá inicializar os processos
	private FabricaDeEntradas fde;
	private int memoria[];
	private ArrayList<String> instrucoes;
	
	public Processo(MMU mmu, int tamanhoMemoriaVirtual,  int quantidadeDeThreads, int posicaoInicial, int id){
		this.mmu = mmu;
		this.posicaoInicial = posicaoInicial;
		fde = new FabricaDeEntradas(tamanhoMemoriaVirtual/quantidadeDeThreads);
		memoria = new int[tamanhoMemoriaVirtual/quantidadeDeThreads];
		instrucoes = new ArrayList<String>();
		inicializarArrays();
		this.id = id;
	}
	
	//int [] memoria = new int[16/qtdThreads];
	
	private void inicializarArrays() {
		for(int i = 0; i < memoria.length; i++) {
			memoria[i] = posicaoInicial;
			posicaoInicial++;
		}
	}
	
	public void leituraInstrucoes(String dados){
		 String[] arrayInstrucoes = dados.split(",");;
		 inserePilhaInstrucoes(arrayInstrucoes);
	}
	
	public void inserePilhaInstrucoes(String[] instrucoes) {
		for(String instrucao : instrucoes) {
			this.instrucoes.add(instrucao);
		}
	}
	
	public String retiraPilhaInstrucoes() {
		String instrucao;
		instrucao = instrucoes.get(0);
		instrucoes.remove(0);
		return instrucao;
	}
	
	public void execute() {
		String instrucao = retiraPilhaInstrucoes();
		
		int tipoInstrucao = instrucao.indexOf('R');
		
		if(tipoInstrucao == -1) {
			escrita(instrucao);
		}
		else {
			leitura(instrucao);
		}
	}
	
	public void escrita(String s) {
		String[] instrucao = s.split("-");
		int enderecoInicial = Integer.parseInt(instrucao[0]);
		int enderecoFinal = memoria[enderecoInicial];
		int valor = Integer.parseInt(instrucao[2]);
		
		mmu.escrita(enderecoFinal, valor);
	}
	
	public void leitura(String s) {
		String[] instrucao = s.split("-");
		int enderecoInicial = Integer.parseInt(instrucao[0]);
		int enderecoFinal = memoria[enderecoInicial];
		
		int valor =  mmu.leitura(enderecoFinal);
		
		if(valor == -99999) {
			System.out.println("THREAD "+ this.id +": " + " o valor lido do endereço "+enderecoFinal+" é "+ "null");
		}
		else {
			System.out.println("THREAD "+ this.id+ ": "+"o valor lido do endereço "+enderecoFinal+" é "+ valor);
		}	
	}
	
	
	public void run(){
		String dados = fde.gerarEntradas();
		System.out.println("Instrucoes da Thread "+ this.id+ ":  " + dados);
		leituraInstrucoes(dados);
		
		
		try {
			sleep(5000);
			
			while(instrucoes.isEmpty() == false) {
				execute();
				sleep(1000);
			}
			
		}catch(Exception e) {
		}
		
		
		
	}

}
