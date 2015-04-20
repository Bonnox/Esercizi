package tamagochi;

public class TamagochiMain
{		
	public static void main (String[] args)
	
	{
		char comando;
		comando='a';
		
		int azione;
		azione=0;
		int quantita;
		quantita=0;
		
		Tamagochi tama1 = new Tamagochi("pino", 25, 50);
		
		System.out.println("Gioco del tamagochi:\n E - Esci\n M - Dai da mangiare\n A - Accarezza\n");
		System.out.println ("ora il tamagochi " + tama1.come_sta_stringa_debug());
		System.out.println ();
		
		while (((comando!='Q') || (comando!='q')) && (tama1.get_stato()>0))
		{
			
			quantita=5;
			
			tama1.accudisci(azione, quantita);
			System.out.print ("ora il tamagochi " + tama1.come_sta_stringa());
			System.out.println ("   ---   " + tama1.come_sta_stringa_debug());
		}
	}
	

}
