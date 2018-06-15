// representa uma pagina da memoria virtual
public class PaginaVirtual {

	private int paginaFisica;
	private long ultimaReferencia;
	
	private boolean presente;
	private boolean modificada;
	private boolean referenciada;
	
	
	public PaginaVirtual() {
		paginaFisica = 0;
		
		presente = false;
		modificada = false;
		referenciada = false;
	}
	
	public void setUltimaReferencia(long i){
		ultimaReferencia = i;
	}
	
	public long getUltimaReferencia(){
		return ultimaReferencia;
	}
	
	public boolean modificada() {
		return modificada;
	}
	
	public boolean referenciada() {
		return referenciada;
	}
	
	
	public void setPresente(boolean b) {
		presente = b;
	}
	
	public void setModificada(boolean b) {
		modificada = b;
	}
	
	public void setReferenciada(boolean b) {
		referenciada  = b;
	}
	
	public void setIndicePaginaFisica(int endereco) {
		paginaFisica = endereco;
	}
	
	public int getIndicePaginaFisica() {
		return paginaFisica;
	}
	
	public boolean presente() {
		return presente;
	}
	
}
