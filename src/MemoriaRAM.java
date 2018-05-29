
public class MemoriaRAM {

	private MolduraPagina listaCircular = null; // variavel vai ser usada p criar a lista circular de molduras de paginas
	
	
	public MemoriaRAM() {
		criaListaCircular(); // cria lista circular no construtor da memoria ram
	}
	
	private void criaListaCircular() {
		listaCircular = new MolduraPagina(); // instancia a primeira moldura de pagina
		listaCircular.conteudo = 7; // insere um conteudo qualqr na pagina p testar visualizando depois
		listaCircular.setProx(listaCircular); // como é a primeira pagina, o elemento q iria apontar p a proxima moldura aponta p ele mesmo
		
		for(int i = 0; i < 7; i++) { // instancia o restante das molduras e insere na lista circular
			MolduraPagina p = new MolduraPagina();
			p.conteudo = i; // teste p visualizar se ta td certo
			insereListaCircular(p);
		}
	}
	
	private void insereListaCircular(MolduraPagina p) { // manipula as referencias p inserir o elemento e a lista ficar circular
		MolduraPagina aux = this.listaCircular.getProx();
		this.listaCircular.setProx(p);
		p.setProx(aux);
	}
	
	public void percorrerLista(MolduraPagina p) { // metodo p testar se a lista ta certa
		System.out.println(p.conteudo);
		percorrerLista(p.getProx());
	}
	
	public MolduraPagina getLista() {
		return this.listaCircular;
	}
}
