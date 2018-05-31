
public class Main {
	
	public static void main(String[]args) {
		
		MemoriaRAM memoriaR = new MemoriaRAM();
		
		Clock clock  = new Clock(memoriaR);
		
		clock.start();
		
		while(true) {
			System.out.println(memoriaR.getClock());
		}
		
	}
	
	public static void leituraInstrucoes(String s){
		String[] arrayInstrucoes = s.split(",");
		
		for(String instrucao : arrayInstrucoes) {
			if(instrucao.length() > 3) {
				escrita(instrucao);
			}
			else {
				leitura(instrucao);
			}
		}
	}
	
	public static void escrita(String s) {
		String[] instrucao = s.split("-");
		System.out.println("escrever o valor " + instrucao[2] + " no endere�o " + instrucao[0] + " da mem�ria");
	}
	
	public static void leitura(String s) {
		String[] instrucao = s.split("-");
		System.out.println("ler o valor que est� no endere�o " + instrucao[0] + " da mem�ria");
	}
}
