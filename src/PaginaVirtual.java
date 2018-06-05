// representa uma pagina da memoria virtual
public class PaginaVirtual {

	private int paginaFisica;
	private int clock;
	
	private boolean presente;
	private boolean modificada;
	private boolean referenciada;
	private boolean protegida;
	
	
	public PaginaVirtual(int indice) {
		paginaFisica = 0;
		
		presente = false;
		modificada = false;
		referenciada = false;
		protegida = false;
	}
	
	public boolean modificada() {
		return modificada;
	}
	
	public boolean referenciada() {
		return referenciada;
	}
	
	public boolean protegida() {
		return protegida;
	}
	
	public void setPresente(boolean b) {
		presente = b;
	}
	
	public void setProtegida(boolean b) {
		protegida = b;
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
	
	public int getClock() {
		return clock;
	}
	
	public void setClock(int i) {
		clock = i;
	}
	
}
