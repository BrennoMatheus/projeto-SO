public class MolduraPagina {

	private static int LEITURA = 0;
	private static int ESCRITA = 1;

	
	private MolduraPagina prox = null; // variavel vai apontar p a proxima moldura de pagina da memoria ram
	
	private boolean modificada;
	private boolean referenciada;
	private int operacao;
	public int conteudo;
	
	public MolduraPagina() {
		
		modificada = false;
		referenciada = false;
		operacao = 0;
	}
	
	
	
	public MolduraPagina getProx() {
		return prox;
	}
	
	public void setProx(MolduraPagina p) {
		prox = p;
	}
}
