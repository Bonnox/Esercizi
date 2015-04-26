package tamagochi;
import java.util.*;

public final class MyUtil
{
	public static String Leggi_stringa()
	{
		Scanner lettore = new Scanner (System.in);
		lettore.close();
		return lettore.nextLine();

	}
	
	public static int Leggi_int()
	{
		Scanner lettore = new Scanner (System.in);
		int ritorno = lettore.nextInt();
		lettore.nextLine();
		lettore.close();
		return ritorno;
	}
	
	public static char Leggi_char()
	{
		Scanner lettore = new Scanner (System.in);
		lettore.close();
		return (lettore.nextLine()).charAt(0);
	}
	
}
