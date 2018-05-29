public class MolduraPagina {
	private static int NAO_REFERENCIADA = 0;
	private static int REFERENCIADA = 1;
	private static int LEITURA = 2;
	private static int ESCRITA = 3;
	private static int MODIFICADA = 4;
	private static int NAO_MODIFICADA = 5;
	
	
	private MolduraPagina prox = null; // variavel vai apontar p a proxima moldura de pagina da memoria ram
	
	private int modificada;
	private int referenciada;
	private int operacao;
	public int conteudo;
	
	public MolduraPagina() {
		
		modificada = NAO_MODIFICADA;
		referenciada = NAO_REFERENCIADA;
		operacao = 0;
	}
	
	
	
	public MolduraPagina getProx() {
		return prox;
	}
	
	public void setProx(MolduraPagina p) {
		prox = p;
	}
}
