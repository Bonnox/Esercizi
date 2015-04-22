package tamagochi;

public class TamagochiMain
{		
	
	static char comando;			// comando dell'utente
	static int azione;				// cosa fare al tamagochi
	static int quantita_tamagochi;	// quanti tamagochi usare
	static int quantita_azioni;		// quante cose fare al tamagochi
	static Tamagochi vettore [];	// lo zoo
	static int i;					// contatore
	static String nome;				// il nome del tamagochi
	static int contavivi;			// non farli morire!
	
	private static void inizio_gioco()
	{
		System.out.println("Gioco del tamagochi\n\n");
		System.out.println("quanti tamagochi si vogliono creare?");
		
		quantita_tamagochi=MyUtil.Leggi_int();
	}
	
	private static void Creazione_tamagochi()
	{
		vettore = new Tamagochi [quantita_tamagochi];
		
		for (i=0; i<quantita_tamagochi; i++)
		
		{
			System.out.print("inserire il nome del " + (i+1) + "^ tamagochi: ");
			nome = MyUtil.Leggi_stringa();
			vettore [i] = new Tamagochi (nome);
		}
	}
	
	public static void main (String[] args)
	
	{

		inizio_gioco();

		Creazione_tamagochi();
		
		
		// INIZIO GIOCO
		
		while ((comando!='E') || (comando!='e'))
		{
			do
			{
				System.out.println(" E - Esci\n M - Dai da mangiare\n A - Accarezza\n\n");
				comando=MyUtil.Leggi_char();
			
				if ((comando=='M') || (comando=='m'))
				{
					azione=0;
				}
				else
				{
					if ((comando=='A') || (comando=='a'))
					{
						azione=1;
					}
					else
					{
						azione=2;
					}
				}
			}
			while ((azione>1));
		

			System.out.println("Quante volte? ");
			quantita_azioni=MyUtil.Leggi_int();
			
			
			for (i=0; i<quantita_tamagochi; i++)
			{
				if (vettore[i].get_stato()>0)
				{
					vettore[i].accudisci(azione, quantita_azioni);
				}
			}
			
			for (i=0; i<quantita_tamagochi; i++)
			{
				System.out.println ("ora il tamagochi " + i + " " + vettore[i].come_sta_stringa() );
				System.out.print (" ----- " + vettore[i].come_sta_stringa_debug() );
			}
			
			if (contavivi==0)
				{comando='E';}
		}
		
		System.out.println("fine");
	}
	

}
