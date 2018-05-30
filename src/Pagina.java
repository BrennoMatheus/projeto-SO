// representa uma pagina da memoria virtual
public class Pagina {
	
	private static int LIVRE = 0;
	private static int OCUPADA = 1;

	private int status; // indica se esta livre ou ocupada
	private int moldura_de_pagina;
	private int conteudo;
	
	public Pagina() {
		status = LIVRE;
		moldura_de_pagina = 0;
		conteudo = 0;
	}
	
	public boolean getStatus() { // retorna true se estiver livre
		if(status == LIVRE){
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
