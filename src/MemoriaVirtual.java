
public class MemoriaVirtual {
	
	private PaginaVirtual[] memoriaVirtual; // array de paginas 
	
	public MemoriaVirtual(int tamanho) {
		memoriaVirtual = new PaginaVirtual[tamanho];
	}
	
	public PaginaVirtual[] getMemoriaVirtual(){
		return memoriaVirtual;
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
	
	public void instanciarPagina(int i) {
		memoriaVirtual[i] = new PaginaVirtual();
	}
	
	public boolean existe(int i){
		if(memoriaVirtual[i] != null){
			return true;
		}
		else{
			return false;
		}
	}
	
}
