/**
 * 
 */
package Symulacja_Osady;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
/**
 * @author Nenaki
 *
 */
public class Simulation {
	public static int rozmiar;
	public static int frakcje;
	public static int inkrementacja;
	public static Boolean start;
	public static Boolean start1;
	public static Boolean start3;
	public static Boolean kontynuuj=false;
	private static Map<Integer,Frakcja> mapfrakcji;
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		start=false;
		start1=false;
		start3=false;
		mapfrakcji = new TreeMap<>();
		new GUI();
		while(start1==false) {
			TimeUnit.SECONDS.sleep(1);
		}
		for (int i=0;i<frakcje;i++) {
			//System.out.println(i);
			mapfrakcji.put(i, new Frakcja(i));
			//Frakcja trololo = Simulation.getfrakcje(0);
			//trololo.putvillages(randomNum1,randomNum2);
			//ArrayList<Integer> ta= trololo.gettvillages(0);
			//System.out.println("Jestem tutaj ");
		}
		while(start==false) {
			TimeUnit.SECONDS.sleep(1);
		}

		System.out.println("japierdole kurwa ");
		while(start3==false)
		{
		TimeUnit.SECONDS.sleep(1);
		//System.out.println("CZEKAÑSKO");
		}
		for (int i=0;i<inkrementacja;i++) {
			System.out.println("TURA: "+i+"!!");
			for (int z=0;z<frakcje;z++) {
				System.out.println("TRWA TURA WIOSKI: "+z);
				while(kontynuuj==false) {
				TimeUnit.SECONDS.sleep(1);	
				}
				//getcords(z);
				turax(z);
				TimeUnit.SECONDS.sleep(1);
				if(GUI2.isfull(rozmiar)==true) {
					break;
				}
				GUI2.table.setDefaultRenderer(Object.class,new GradeRenderer());
			}
			System.out.println("KONIEC TURY: "+i);
			if(GUI2.isfull(rozmiar)==true) {
				System.out.println("PLANSZA PELNA");
				break;
			}
			}
			System.out.println("Koniec symulacji");
			tofile(rozmiar,frakcje);
}
	//obiera dany obiekt frakcja
	public static Frakcja getfrakcje(int i) {
		return mapfrakcji.get(i);
	}
//wstawia dany obiekt frakcja
public static void putfrakcje(int i, Frakcja trakcja) {
	mapfrakcji.put(i, trakcja);
}
public static void getcords(int m) {
	Frakcja trololo = getfrakcje(m);
	ArrayList<Integer> xyz=trololo.gettvillages(0);
	System.out.println("Powtorka:Wioska nr "+m+" JEST TU:" + xyz.get(0) + " " + xyz.get(1));
}
public static void turax(int m) {
	Frakcja trololo = getfrakcje(m);
	trololo.tura();
	mapfrakcji.put(m, trololo);
}
public static void tofile(int ile, int ilef) {
	   try {
		      FileWriter myWriter = new FileWriter("symulacja.txt");
		      for(int i=0;i<ile;i++) {
		    	  myWriter.write("|\t");
		    	 for(int j=0;j<ile;j++) {
		    	myWriter.write(GUI2.getvaluetab(i, j)+"\t |\t"); 
		    	 }
		    	 myWriter.write("\n|");
		    	 for(int k=0;k<ile;k++) {
		    		 myWriter.write("\t----\t |");  
		    	 }
		    	 myWriter.write("\n");
		      }
		      for(int l=0;l<ilef;l++) {
		    	  Frakcja trololo = getfrakcje(l);
		    	  int wynik = trololo.ileroads()+trololo.ilevillages();
		    	  myWriter.write("Frakcja "+(l+1)+": "+wynik+" iloœæ obiektów\n");
		      }
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
}
}
