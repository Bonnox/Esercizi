package tamagochi;

public class TamagochiMain
{		
	
	static char comando;			// comando dell'utente
	//static int azione;			// cosa fare al tamagochi
	static int quantita_tamagochi;	// quanti tamagochi usare
	static int quantita_azioni;		// quante cose fare al tamagochi
	static Tamagochi vettore [];	// lo zoo
	static int i;					// contatore
	static String nome;				// il nome del tamagochi
	//static int contavivi;			// non farli morire!
	
	private static void inizio_gioco()
	{
		comando='a';
		System.out.println("Gioco del tamagochi\n\n");
		do
		{
			System.out.println("quanti tamagochi si vogliono creare?");
			quantita_tamagochi=MyUtil.Leggi_int();
		}
		while (!(quantita_tamagochi>0));
		
		
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
	
	private static void Ricevi_comando()
	{
		//do
		{
			System.out.println(" E - Esci\n M - Dai da mangiare\n A - Accarezza\n\n");
			comando=MyUtil.Leggi_char();
			if ((comando=='A') || (comando=='a') || (comando=='M') || (comando=='m'))
			{
				System.out.println("Quante volte? ");
				quantita_azioni=MyUtil.Leggi_int();
			}
		}
		//while ((comando!='E') || (comando!='e') || (comando!='M') || (comando!='m') || (comando!='A') || (comando!='a'));

	}
	
	private static int calcola_morti()
	{
		int count=0;
		
		for (int j=0; i<quantita_tamagochi; i++)
		{
			if (vettore[j].get_stato()==0)
			{count++;}
		}
		return count;
	}
	
	private static void mostra_tamagochi()
	{
		for (i=0; i<quantita_tamagochi; i++)
		{
			System.out.println ("ora il tamagochi " + vettore[i].come_sta_stringa() );
			//System.out.println (" ----- " + vettore[i].come_sta_stringa_debug() );
			
		}
	}
	
	
	// PROGRAMMA PRINCIPALE
	
	public static void main (String[] args)
	
	{

		//INIZIALIZZAZIONE
		
		inizio_gioco();

		Creazione_tamagochi();
		
		mostra_tamagochi();
		
		// INIZIO GIOCO
		
		do // CICLO PRINCIPALE
		{
			
			Ricevi_comando();

			
			for (i=0; i<quantita_tamagochi; i++)
			{
				if (vettore[i].get_stato()>0)
				{
					vettore[i].accudisci(comando, quantita_azioni);
				}
			}
			

			mostra_tamagochi();
			
			if (calcola_morti()==quantita_tamagochi)
			{comando='E';}
			
			
		} // FINE CICLO GIOCO
		while ((comando!='E') && (comando!='e'));
		
		System.out.println("fine");
	}
	

}
