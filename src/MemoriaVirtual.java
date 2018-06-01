
public class MemoriaVirtual {
	
	private PaginaVirtual[] memoriaVirtual; // array de paginas 
	
	public MemoriaVirtual() {
		memoriaVirtual = new PaginaVirtual[16]; // instancia as paginas
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
