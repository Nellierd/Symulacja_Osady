package Symulacja_Osady;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
/**
 * Program symuluj¹cy osady na mapie.
 * @author Konrad Ziêba
 */
public class Simulation {
	private static int rozmiar;
	private static int frakcje;
	private static int inkrementacja;
	private static Boolean start=false;
	private static Boolean start1=false;
	private static Boolean start3=false;
	private static Boolean kontynuuj=false;
	private static Map<Integer,InterfaceFrakcja> mapfrakcji;
	
	
	public static void main(String[] args) throws InterruptedException {
		new GUI();
		mapfrakcji = new TreeMap<>();
		waitforstart();
		symulacjatur();
			tofile(rozmiar,frakcje);
	}
	public static int ilefrakcji() {
		return ilefrakcji1();
	}
	public static void setilefrakcji(int a) {
		 setilefrakcji1(a);
	}
	public static int jakirozmiar() {
		return jakirozmiar1();
	}
	public static void setinkrementacje(int a) {
		setinkrementacje1(a);
	}
	public static void setjakirozmiar(int a) {
		setjakirozmiar1(a);
	}
	public static void setstart() {
		setstart01();
	}
	public static void setstart3() {
		setstart31();
	}
	public static void setstart1() {
		setstart11();
	}
	public static void setcontinuetrue() {
		setcontinuetrue1();
	}
	public static void setcontinuefalse() {
		setcontinuefalse1();
	}
	public static InterfaceFrakcja getfrakcje(int i) {
		return getfrakcje1(i);
	}
	public static void putfrakcje(int i, InterfaceFrakcja trakcja) {
		putfrakcje1(i, trakcja);
	}
	public static void defaultvillagescreator() {
		createvillages();
	}
	public static void advvillagecreator(int x1,int x2) {
		createvillagesadv(x1,x2);
	}
	/**
	 * Funkcja s³u¿¹ca do symulacji tur.
	 */
	private static void symulacjatur(){
		for (int i=0;i<inkrementacja;i++) {
			for (int z=0;z<frakcje;z++) {
				while(kontynuuj==false) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
				}	
				}
				getfrakcje(z).tura();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
				}
				if(GUI2.isfull(rozmiar)==true) {
					break;
				}
			}
			if(GUI2.isfull(rozmiar)==true) {

				break;
				}
		}
		GUI2.simfinished();
	}
	/**
	 * Funkcja sprawdzaj¹ca czy odpowiednie komponenty zosta³y za³adowane.<br>
	 * S³u¿y do omijana null exception ;P
	 */
	private static void waitforstart() {
		while(start1==false) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		while(start==false) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		while(start3==false)
		{
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		}
		}
	}
	/**
	 * Funkcja zwracaj¹ca iloœæ frakcji w symulacji
	 * @return iloœæ frakcji
	 */
	private static int ilefrakcji1() {
		return Simulation.frakcje;
	}
	/**
	 * Funkcja wstawiaj¹ca do zmiennej iloœæ frakcji na mapie
	 * @param a - iloœæ frakcji
	 */
	private static void setilefrakcji1(int a) {
		Simulation.frakcje=a;
	}
	/**
	 * Funkcja zwracaj¹ca rozmiar planszy symulacji (bok kwadratu)
	 * @return rozmiar planszy
	 */
	private static int jakirozmiar1() {
		return Simulation.rozmiar;
	}
	/**
	 * Funkcja wstawiaj¹ca do zmiennej wielkoœæ planszy
	 * @param a - wielkosc planszy
	 */
	private static void setjakirozmiar1(int a) {
		Simulation.rozmiar=a;
	}
	/**
	 * Funkcja wstawiaj¹ca do zmiennej iloœæ inkrementacji w symulacji
	 * @param a
	 */
	private static void setinkrementacje1(int a) {
		Simulation.inkrementacja=a;
	}
	/**
	 * Usawienie pierwszej flagi
	 */
	private static void setstart01() {
		start=true;
	}
	/**
	 * Ustawienie drugiej flagi
	 */
	private static void setstart11() {
		start1=true;
	}
	/**
	 * Ustawienie trzeciej flagi
	 */
	private static void setstart31() {
		start3=true;
	}
	/**
	 * Ustawienie kontynuuacji symulacji
	 */
	private static void setcontinuetrue1() {
		kontynuuj=true;
	}
	/**
	 * Ustawienei wstrzymania symulacji
	 */
	private static void setcontinuefalse1() {
		kontynuuj=false;
	}
	/**
	 * Funkcja zwracaj¹ca interface Frakcji
	 * @param i - która frakcja
	 * @return - interface frakcji
	 */
	private static InterfaceFrakcja getfrakcje1(int i) {
		return mapfrakcji.get(i);
	}
	/**
	 * Funkcja zapisujaca itnerface frakcj
	 * @param i - która frakcja
	 * @param trakcja - interface frakcji
	 */
	private static void putfrakcje1(int i, InterfaceFrakcja trakcja) {
		mapfrakcji.put(i, trakcja);
	}
	/**
	 * Funkcja zapisuj¹ca wyniki symulacji do pliku
	 * @param ile - rozmiar planszy
	 * @param ilef - iloœæ frakcji
	 */
	private static void tofile(int ile, int ilef) {
		try {
		      FileWriter simscore = new FileWriter("symulacja.txt");
		      for(int i=0;i<ile;i++) {
		    	  simscore.write("|\t");
		    	 for(int j=0;j<ile;j++) {
		    	simscore.write(GUI2.getvaluetab(i, j)+"\t |\t"); 
		    	 }
		    	 simscore.write("\n|");
		    	 for(int k=0;k<ile;k++) {
		    		 simscore.write("\t----\t |");  
		    	 }
		    	 simscore.write("\n");
		      }
		      for(int l=0;l<ilef;l++) {
		    	  InterfaceFrakcja trololo = getfrakcje(l);
		    	  int wynik = trololo.ileroads()+trololo.ilevillages();
		    	  simscore.write("Frakcja "+(l+1)+": "+wynik+" iloœæ obiektów\n");
		      }
		      simscore.close();
		    } catch (IOException e) {}
	}
	/**
	 * Funkcja tworz¹ca frakcje z ustawieniami domyœlnymi
	 */
	private static void createvillages() {
		for (int i=0;i<frakcje;i++) {
			InterfaceFrakcja interfacegrakcja = new Frakcja(i);
			mapfrakcji.put(i, interfacegrakcja);
			Map_Generator.setstart();
		}
	}
	/**
	 * Funkcja tworz¹ca wybrane frakcje z ustawieniami zaawansowanymi
	 * @param i - która to frakcja na liœcie
	 * @param a - jaki rodzaj frakcji
	 */
	private static void createvillagesadv(int i,int a) {
		if(a==0) {
			InterfaceFrakcja interfacegrakcja = new Frakcja(i);
			mapfrakcji.put(i, interfacegrakcja);
		}
		if(a==1) {
			InterfaceFrakcja interfacegrakcja = new FrakcjaBandyta(i);
			mapfrakcji.put(i, interfacegrakcja);
		}
		if(a==2) {
			InterfaceFrakcja interfacegrakcja = new FrakcjaOffensive(i);
			mapfrakcji.put(i, interfacegrakcja);
		}
	}
}
