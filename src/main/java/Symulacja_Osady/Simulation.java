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
	private static Map<Integer,InterfaceFrakcja> mapfrakcji;
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
		/*for (int i=0;i<frakcje;i++) {
			InterfaceFrakcja interfacegrakcja = new Frakcja(i);
			mapfrakcji.put(i, interfacegrakcja);
		}
		InterfaceFrakcja interfacegrakcja0 = new Frakcja(0);
		mapfrakcji.put(0, interfacegrakcja0);
		InterfaceFrakcja interfacegrakcja1 = new FrakcjaOffensive(1);
		mapfrakcji.put(1, interfacegrakcja1);
		InterfaceFrakcja interfacegrakcja2 = new Frakcja(2);
		mapfrakcji.put(2, interfacegrakcja2);
		InterfaceFrakcja interfacegrakcja3 = new FrakcjaBandyta(3);
		mapfrakcji.put(3, interfacegrakcja3);*/
		while(start==false) {
			TimeUnit.SECONDS.sleep(1);
		}
		while(start3==false)
		{
		TimeUnit.SECONDS.sleep(1);
		}
		for (int i=0;i<inkrementacja;i++) {
			System.out.println("TURA: "+i+"!!");
			for (int z=0;z<frakcje;z++) {
				System.out.println("TRWA TURA WIOSKI: "+z);
				while(kontynuuj==false) {
				TimeUnit.SECONDS.sleep(1);	
				}
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
	public static InterfaceFrakcja getfrakcje(int i) {
		return mapfrakcji.get(i);
	}
//wstawia dany obiekt frakcja
public static void putfrakcje(int i, InterfaceFrakcja trakcja) {
	mapfrakcji.put(i, trakcja);
}
public static void getcords(int m) {
	ArrayList<Integer> xyz=getfrakcje(m).gettvillages(0);
	System.out.println("Powtorka:Wioska nr "+m+" JEST TU:" + xyz.get(0) + " " + xyz.get(1));
}
public static void turax(int m) {
	getfrakcje(m).tura();
}
public static void tofile(int ile, int ilef) {
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
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
private static void createvillages() {
	for (int i=0;i<frakcje;i++) {
	InterfaceFrakcja interfacegrakcja = new Frakcja(i);
	mapfrakcji.put(i, interfacegrakcja);
	Map_Generator.setstart();
}
}
public static void defaultvillagescreator() {
	createvillages();
}
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
	System.out.println("Village created!!");
}
public static void advvillagecreator(int x1,int x2) {
	createvillagesadv(x1,x2);
}
}
