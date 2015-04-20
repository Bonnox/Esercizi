package tamagochi;

import java.util.Random;



public class Tamagochi
{
	
	// costanti
	
	private final float AUMENTO_AFFETTO=0.5f;
	private final float AUMENTO_SAZIETA=0.1f;
	private final float DIMINUZIONE_AFFETTO=0.25f;
	private final float DIMINUZIONE_SAZIETA=0.5f;
	private final int SAZIETA_INFELICE_MIN=30;
	private final int SAZIETA_INFELICE_MAX=90;
	private final int AFFETTO_INFELICE=30;
	private final int SAZIETA_MIN=0;
	private final int AFFETTO_MIN=0;
	private final int SAZIETA_MAX=100;
	private final int AFFETTO_MAX=100;
	
	// variabili
	
	private String nome;
	private float sazieta;
	private float affetto;
	private int stato; // 0 morto 1 infelice 2 felice
	
	// costruttori
	
	public Tamagochi (String _nome) // ufficiale
	
	{
		Random randomGenerator = new Random();
		
		nome=_nome;
		sazieta=randomGenerator.nextInt(100);
		affetto=randomGenerator.nextInt(100);
	}
	
	
	public Tamagochi (int _sazieta, int _carezza) // metodo per il debug
	{
		sazieta=_sazieta;
		affetto=_carezza;
	}
	
	// metodi obsoleti
	
	/*private float get_sazieta ()
	{
		return sazieta;
	};
	*/
	
	/*private float get_carezza ()
	{
		return carezza;
	}
	*/
	
	// metodi interni
	
	private void dai_da_mangiare (int quantita)
	{
		
		sazieta=sazieta+(quantita*AUMENTO_SAZIETA);
		
		if (affetto>=100)
				{
					affetto=affetto-(quantita*DIMINUZIONE_AFFETTO);
				}
	}
	
	private void accarezza (int quantita)
	{
		affetto=affetto+(quantita*AUMENTO_AFFETTO);
		
		if (sazieta<=100)
				{
					sazieta=sazieta-(quantita*DIMINUZIONE_SAZIETA);
				}
		
	}
	
	// interfacce
	
	public int get_stato() // invisibile all'utente
	{
		if ((sazieta<=SAZIETA_MIN) || (affetto<=AFFETTO_MIN) || (sazieta>=SAZIETA_MAX))
		{
			stato=0; //morto
			return stato;
		}
		
		else
		
			{
		
				if ( ( (sazieta<SAZIETA_INFELICE_MIN) || ( (sazieta>SAZIETA_INFELICE_MAX) && (sazieta<SAZIETA_MAX) ) ) || (affetto<AFFETTO_INFELICE))
			
				{
					stato=1; //infelice
					return stato;
				}
		
				else
			
				{
					stato=2; //felice
					return stato;
				}
		
			}
		
	}
	
	public void accudisci (int azione, int quantita)
	{
		if (azione==0) 
				{
					dai_da_mangiare(quantita);
				}
		
			else 
			{
				accarezza(quantita);
			}
	}

	
	public String come_sta_stringa_debug()
	{
		get_stato();
		
		if (stato==0)
		{ 
			return (nome + " è morto - sazietà " + sazieta + " affetto " + affetto);
		}
		else
		{
			if (stato==1)
			{
				return (nome + " sta male - sazietà " + sazieta + " affetto " + affetto);
			}
			else
			{
				return nome + " sta bene - sazietà " + sazieta + " " + affetto;
			}
		}
	}
	
	public String come_sta_stringa()
	{
		String ritorno;
		get_stato();
		
		if (stato==0)
		{ 
			ritorno = nome + " è morto";
			return ritorno;
		}
		else
		{
			if (stato==1) //casistiche dello star male
			{
				ritorno = nome + " sta male: ";
				if ((affetto<AFFETTO_INFELICE) && (sazieta<SAZIETA_INFELICE_MIN))
				{
					ritorno += "è depresso ed ha fame";
				}
				if ((affetto<AFFETTO_INFELICE) && (sazieta>SAZIETA_INFELICE_MAX))
				{
					ritorno += "è depresso ed ha mangiato troppo";
				}
				if (sazieta<SAZIETA_INFELICE_MIN)
				{
					ritorno += "ha fame";
				}
				if (affetto<AFFETTO_INFELICE)
				{
					ritorno += "è depresso";
				}
				if (sazieta>SAZIETA_INFELICE_MAX)
				{
					ritorno += "ha mangiato troppo";
				}	
				return ritorno;
			}
			else
			{
				ritorno = nome + " sta bene ";
				return ritorno;
			}
		}
	}
	
	
	
}