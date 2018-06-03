// representa uma pagina da memoria virtual
public class PaginaVirtual {

	private int paginaFisica;
	
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
	
	public int getIndicePaginaFisica() {
		return paginaFisica;
	}
	
	public boolean presente() {
		return presente;
	}
	
}
