
public class Processo extends Thread {
	
	private SO so; //Inst�ncia do sistema operacional
	private String instrucoes;
	
	public Processo(SO so, String instrucoes){
		this.so = so;
		this.instrucoes = instrucoes;
	}
	
	public void run(){
		so.leituraInstrucoes(instrucoes);
	}

}
