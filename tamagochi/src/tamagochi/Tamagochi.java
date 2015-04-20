package tamagochi;

import java.util.Random;


public class Tamagochi
{
	
	// costanti
	
	private final double AUMENTO_AFFETTO=0.5;
	private final double AUMENTO_SAZIETA=0.1;
	private final double DIMINUZIONE_AFFETTO=0.25;
	private final double DIMINUZIONE_SAZIETA=0.5;
	private final int SAZIETA_INFELICE_MIN=30;
	private final int SAZIETA_INFELICE_MAX=90;
	private final int AFFETTO_INFELICE=30;
	private final int SAZIETA_MIN=0;
	private final int AFFETTO_MIN=0;
	private final int SAZIETA_MAX=100;
	private final int AFFETTO_MAX=100;
	
	// variabili
	
	private String nome;
	private double sazieta;
	private double affetto;
	private int stato; // 0 morto - 1 infelice - 2 felice
	private int specifica_stato_infelice;
	
	// costruttori
	
	public Tamagochi (String _nome) // ufficiale
	
	{
		Random randomGenerator = new Random();
		
		nome=_nome;
		sazieta=randomGenerator.nextInt(98)+1; // controllo mortalità infantile :D
		affetto=randomGenerator.nextInt(98)+1;
		
	}
		
	public Tamagochi (String _nome, int _sazieta, int _affetto) // costruttore per il debug
	{
		nome=_nome;
		sazieta=_sazieta;
		affetto=_affetto;
	}
	
	// metodi interni
	
	private double get_sazieta()
	{
		if (sazieta<SAZIETA_MIN) {sazieta=SAZIETA_MIN;}
		if (sazieta>SAZIETA_MAX) {sazieta=SAZIETA_MAX;}
		return sazieta;
	}

	private double get_affetto()
	{
		if (affetto<AFFETTO_MIN) {affetto=AFFETTO_MIN;}
		if (affetto>AFFETTO_MAX) {affetto=AFFETTO_MAX;}
		return affetto;
	}
	
	private void dai_da_mangiare (int quantita)
	{	
		if (get_stato()>0)
		{
		affetto=affetto-(quantita*DIMINUZIONE_AFFETTO);
		
		if (affetto<=100)
				{
					sazieta=sazieta+(quantita*AUMENTO_SAZIETA);
				}
		}
	}
	
	// interfacce
	
	private void accarezza (int quantita)
	{
		if (get_stato()>0)
		{
		sazieta=sazieta-(quantita*DIMINUZIONE_SAZIETA);
		
		if (sazieta<=100)
				{
					
					affetto=affetto+(quantita*AUMENTO_AFFETTO);
				}
		}
	}
	
	public int get_stato() // invisibile all'utente
	{
		if ((get_sazieta()<=SAZIETA_MIN) || (get_affetto()<=AFFETTO_MIN) || (get_sazieta()>=SAZIETA_MAX))
		{
			stato=0; //morto
			return stato;
		}
		
		else
		
			{
		
				if ( ( (sazieta<SAZIETA_INFELICE_MIN) || ( (sazieta>SAZIETA_INFELICE_MAX) && (sazieta<SAZIETA_MAX) ) ) || (affetto<AFFETTO_INFELICE))
			
				{
					stato=1; //infelice
					
					if ((affetto<AFFETTO_INFELICE) && (sazieta<SAZIETA_INFELICE_MIN))
					{
						specifica_stato_infelice=1;
					}
					if ((affetto<AFFETTO_INFELICE) && (sazieta>SAZIETA_INFELICE_MAX))
					{
						specifica_stato_infelice=2;
					}
					if (sazieta<SAZIETA_INFELICE_MIN)
					{
						specifica_stato_infelice=3;
					}
					if (affetto<AFFETTO_INFELICE)
					{
						specifica_stato_infelice=4;
					}
					if (sazieta>SAZIETA_INFELICE_MAX)
					{
						specifica_stato_infelice=5;
					}	
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
		//get_stato();
		String ritorno;
		
		
		if (get_stato()==0)
		{ 
			ritorno = (nome + " è morto - sazietà " + sazieta + " affetto " + affetto);
			return ritorno;
		}
		else
		{
			if (get_stato()==1)
			{
				ritorno = (nome + " sta male - sazietà " + sazieta + " affetto " + affetto);
				return ritorno;
			}
			else
			{
				ritorno = nome + " sta bene - sazietà " + sazieta + " " + affetto;
				return ritorno;
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
				if (specifica_stato_infelice==1)
				{
					ritorno += "è depresso ed ha fame";
				}
				if (specifica_stato_infelice==2)
				{
					ritorno += "è depresso ed ha mangiato troppo";
				}
				if (specifica_stato_infelice==3)
				{
					ritorno += "ha fame";
				}
				if (specifica_stato_infelice==4)
				{
					ritorno += "è depresso";
				}
				if (specifica_stato_infelice==5)
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