
public class MemoriaVirtual {
	
	private PaginaVirtual[] memoriaVirtual = new PaginaVirtual[16]; // array de paginas 
	
	public MemoriaVirtual() {
		for(int i = 0; i < 16; i++) { // instancia as paginas
			memoriaVirtual[i] = new PaginaVirtual(i);
		}
	}
	
	public PaginaVirtual getPagina(int indice) {
		return memoriaVirtual[indice];
	}
	
	public boolean paginaPresente(int indice) {
		if(memoriaVirtual[indice].presente()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean paginaLivre(int endereco) {
		if(memoriaVirtual[endereco].protegida()) {
			return false;
		}
		else {
			return true;
		}
	}

}
