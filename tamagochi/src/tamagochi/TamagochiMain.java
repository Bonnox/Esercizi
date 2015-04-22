package tamagochi;

public class TamagochiMain
{		
	public static void main (String[] args)
	
	{
		
		// INIZIALIZZAZIONE
		
		char comando;			// comando dell'utente
		int azione;				// cosa fare al tamagochi
		int quantita_tamagochi;		// quanti tamagochi usare
		int quantita_azioni;		//quante cose fare al tamagochi
		Tamagochi vettore [];	// lo zoo
		int i;					//contatore
		String nome;			// il nome del tamagochi
		
		
		// SALUTO
		
		System.out.println("Gioco del tamagochi\n\n");
		System.out.println("quanti tamagochi si vogliono creare?");
		
		// ricevi quantita
		quantita_tamagochi=3;
		
		
		// CREAZIONE DEI TAMAGOCHI
		
		vettore = new Tamagochi [quantita_tamagochi];
		
		for (i=0; i<quantita_tamagochi; i++)
		
		{
			System.out.print("inserire il nome del " + i + "^ tamagochi: ");
			//ricevi nome
			nome = "pino";
			vettore [i] = new Tamagochi (nome);
		}
		
		
		// INIZIO GIOCO
		
		do
		{
			System.out.println("E - Esci\n M - Dai da mangiare\n A - Accarezza\n\n");
			// ricevi comando
			comando='a';
			
			if ((comando=='Q') || (comando=='q'))
			{
				
			}
			
			if ((comando=='M') || (comando=='m'))
			{
				azione=0;
			}
			
			if ((comando=='A') || (comando=='a'))
			{
				azione=1;
			}
			
			
			
			azione=0;
			quantita_azioni=5;
			
			for (i=0; i<quantita_tamagochi; i++)
			{
				if (vettore[i].get_stato()>0)
				{
					vettore[i].accudisci(azione, quantita_azioni);
				}
			}
			
			for (i=0; i<quantita_tamagochi; i++)
			{
				System.out.print ("ora il tamagochi " + i + " " + vettore[i].come_sta_stringa() );
				System.out.print ("ora il tamagochi " + vettore[i].come_sta_stringa_debug() );
			}
			
			
			for (i=0; i<quantita_tamagochi; i++)
			{
				// metti l'uscita dal morto
			}
			
		}
		while ((comando!='E') || (comando!='e'));
		
		System.out.println("tutti morti");
		
	}
	

}
