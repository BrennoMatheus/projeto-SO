import java.util.ArrayList;

public class SO {
	
	private MMU gerenciadorMemoria;
	private ArrayList<String> instrucoes;
	
	public SO(MMU g ){
		gerenciadorMemoria = g;
		instrucoes = new ArrayList<String>();
	}
	
	public int quantidadeInstrucoes(){ // metodo de teste
		return instrucoes.size();
	}
	
	public void leituraInstrucoes(String s){
		 String[] arrayInstrucoes = s.split(",");
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
		int endereco = Integer.parseInt(instrucao[0]);
		int valor = Integer.parseInt(instrucao[2]);
		
		gerenciadorMemoria.escrita(endereco, valor);
	}
	
	public void leitura(String s) {
		String[] instrucao = s.split("-");
		int endereco = Integer.parseInt(instrucao[0]);
		
		int valor =  gerenciadorMemoria.leitura(endereco);
		
		if(valor == -99999) {
			System.out.println("o valor lido do endereço "+instrucao[0]+" é "+ "null");
		}
		else {
			System.out.println("o valor lido do endereço "+instrucao[0]+" é "+ valor);
		}	
	}
}
