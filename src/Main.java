
public class Main {
	
	public static void main(String[]args) {
		String s = "4-R,5-R,0-R,4-W-2";
		
		Main.leituraInstrucoes(s);
		
		Clock clock  = new Clock();
		
		clock.start();
		
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
