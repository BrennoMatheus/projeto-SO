
public class MemoriaVirtual {
	
	private Pagina[] memoriaVirtual; // array de paginas 
	
	public MemoriaVirtual() {
		memoriaVirtual = new Pagina[16]; // instancia as paginas
	}
	
	
	private int buscarPaginaLivre() {
		for(int i = 0; i < memoriaVirtual.length; i++) { // percorre as paginas da memoria virtual
			if(memoriaVirtual[i].getStatus()) { // getStatus retorna true ou false
				return i;	// retorna uma posição q estiver livre
			}
		}
		return -1; //se n achar paginas livres na memoria virtual
	}
	
	
	
	
}
