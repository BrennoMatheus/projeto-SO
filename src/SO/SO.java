package SO;
import java.util.ArrayList;

public class SO {
	
	private MMU gerenciadorMemoria;
	private int tamanhoMemoriaVirtual;
	private int quantidadeThreads;
	
	public SO(MMU g, int tamanhoMemoriaVirtual, int quantidadeThreads){
		gerenciadorMemoria = g;
		this.tamanhoMemoriaVirtual = tamanhoMemoriaVirtual;
		this.quantidadeThreads = quantidadeThreads;
	}
	
	public void iniciarProcessos() {
		int posicaoInicial;
		for(int i = 0; i < quantidadeThreads; i++) {
			posicaoInicial = i*(tamanhoMemoriaVirtual/quantidadeThreads);
			new Processo(gerenciadorMemoria, tamanhoMemoriaVirtual, quantidadeThreads,posicaoInicial,i).start();
		}
	}
}
