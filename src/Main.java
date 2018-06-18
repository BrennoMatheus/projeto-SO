
public class Main {
	
	public static void main(String[]args) {
	
		MemoriaRAM memoriaR = new MemoriaRAM();
		MemoriaVirtual memoriaV = new MemoriaVirtual();
		HD hd = new HD();
		MMU gerenciadorMemoria = new MMU(memoriaR,memoriaV,hd);
		SO so = new SO(gerenciadorMemoria);
		Listener listener = new Listener(gerenciadorMemoria,so);
		Clock clock  = new Clock(listener);
		clock.start();
		so.leituraInstrucoes("0-W-0,0-R,1-W-1,1-R,2-W-2,2-R,3-W-3,3-R,4-W-4,4-R,5-W-5,5-R,6-W-6,6-R,7-W-7,7-R,8-W-8,8-R,9-W-9,9-R,10-W-10,10-R,11-W-11,11-R,12-W-12,12-R,13-W-13,13-R,14-W-14,14-R,15-W-15,15-R");
		
		int i = so.quantidadeInstrucoes();
		int cont = 0;
		
		try{
			while(cont < i){
				so.execute();
				cont++;
				Thread.sleep(500);
			}
			
			String a = "asdasdh";
			a ="asdasdfa";
		}
		catch(Exception e){
			e.getMessage();
		}
		
		
		
		
	}
	
	
}
