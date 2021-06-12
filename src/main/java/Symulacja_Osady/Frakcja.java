package Symulacja_Osady;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import Symulacja_Osady.Map_Generator;
import Symulacja_Osady.GUI2;
/**
 * Implementacja Frakcji
 * @author Nenaki
 *
 */
public class Frakcja {
	public Warehouse warehouse; 
	public Map<Integer, ArrayList<Integer>> villages;
	public Map<Integer, ArrayList<Integer>> roads;
	public int nrfr;
	public Boolean building=true;
	public Boolean building2=true;
	public Frakcja(int i) {
		this.nrfr=i;
		this.warehouse = new Warehouse();
		this.villages = new TreeMap<>();
		this.roads = new TreeMap<>();
	}
	/**
	 * Funkcja s³u¿¹ca do umieszczania danej wioski na liœcie
	 * @param i Kolumna
	 * @param j Wiersz
	 */
	public void putvillages(int i,int j) {

		ArrayList<Integer> tab = new ArrayList<Integer>();
		tab.add(0, i);
		tab.add(1, j);
		this.villages.put(villages.size(), tab);
	}
	/**
	 * Funkcja s³u¿¹ca do umieszczania danej drogi na liœcie
	 * @param i Kolumna
	 * @param j Wiersz
	 */
	public void putroads(int i,int j) {

		ArrayList<Integer> tab = new ArrayList<Integer>();
		tab.add(0, i);
		tab.add(1, j);
		this.roads.put(roads.size(), tab);
	}
	/**
	 * Funcka s³u¿¹ca do zwracania lokacji danej Wioski
	 * @param i Klucz danej wioski
	 * @return Wektor licz bêd¹cy koordynatami danej wioski
	 */
	public ArrayList<Integer> gettvillages(int i) {
		return villages.get(i);
	}
	/**
	 * Funcka s³u¿¹ca do zwracania lokacji danej Drogi
	 * @param i Klucz danej wioski
	 * @return Wektor licz bêd¹cy koordynatami danej Drogi
	 */
	public ArrayList<Integer> getroads(int i) {
		return roads.get(i);
	}
	/**
	 * Funkcja buduj¹ca drogê
	 * @param abc Mapa obiektów obok których ma siê pojawiæ dana wioska
	 */
	public void buildroad(Map<Integer, ArrayList<Integer>> abc) {
		int a=0;
		int b=0;
		int a1=0;
		int b1=0;
		int a2=0;
		int b2=0;
		int a3=0;
		int b3=0;
		int a4=0;
		int b4=0;
		Boolean canbuildroad=false;
		int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
		for (int i=0;i<abc.size();i++) {
		ArrayList<Integer> xyz=abc.get(i);
		int osc=xyz.get(0);
		int osr=xyz.get(1);
		osc=osc-1;
		//Sprawdzamy czy dookola danej wioski mo¿na zbudowaæ drogê
		Boolean zmienna1 = GUI2.canibuild(osc, osr);
		if(zmienna1 == true) {
			a1=osc;
			b1=osr;
		}
		osc=osc+2;
		Boolean zmienna2 = GUI2.canibuild(osc, osr);
		if(zmienna2 == true) {
			a2=osc;
			b2=osr;
		}
		osc=osc-1;
		osr=osr+1;
		Boolean zmienna3 = GUI2.canibuild(osc, osr);
		if(zmienna3 == true) {
			a3=osc;
			b3=osr;
		}
		osr=osr-2;
		Boolean zmienna4 = GUI2.canibuild(osc, osr);
		if(zmienna4 == true) {
			a4=osc;
			b4=osr;
		}
		//Sprawdzamy czy mozna budowac droge wokó³ danej wioski i jesli tak to przypisujemy wartoœæ
		if(zmienna1==true||zmienna2==true||zmienna3==true||zmienna4==true) {
			Boolean iszmienna=false;
			while (iszmienna==false) {
			if((randomNum==1&&zmienna1==true)) {
				a=a1;
				b=b1;
				iszmienna=true;
				canbuildroad=true;
			}
			else if (randomNum==2&&zmienna2==true) {
				a=a2;
				b=b2;
				iszmienna=true;
				canbuildroad=true;
			}
			else if (randomNum==3&&zmienna3==true) {
				a=a3;
				b=b3;
				iszmienna=true;
				canbuildroad=true;
			}
			else if (randomNum==4&&zmienna4==true){
				a=a4;
				b=b4;
				iszmienna=true;
				canbuildroad=true;
			}
			else {
				randomNum = ThreadLocalRandom.current().nextInt(1, 5);
			}
			}
			break;
		}
		}
		//Sprawdzamy czy przypisana zosta³a wartoœæ wioski do zbudowania, nie chcemy randomowo budowaæ wiosek jeœli ca³a mapa jest zape³niona
		if(canbuildroad==true) {
			if (nrfr==0) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.putvaluetab("Road11", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.putvaluetab("Road12", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.putvaluetab("Road13", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.putvaluetab("Road14", a, b);
				}
				System.out.println("BUDUJE DROWE FRAKCJI 1 W PUNKCIE: "+a+","+b);
			}
			if (nrfr==1) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.putvaluetab("Road21", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.putvaluetab("Road22", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.putvaluetab("Road23", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.putvaluetab("Road24", a, b);
				}
				System.out.println("BUDUJE DROWE FRAKCJI 2 W PUNKCIE: "+a+","+b);
			}
			if (nrfr==2) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.putvaluetab("Road31", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.putvaluetab("Road32", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.putvaluetab("Road33", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.putvaluetab("Road34", a, b);
				}
				System.out.println("BUDUJE DROWE FRAKCJI 3 W PUNKCIE: "+a+","+b);
			}
			if (nrfr==3) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.putvaluetab("Road41", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.putvaluetab("Road42", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.putvaluetab("Road43", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.putvaluetab("Road44", a, b);
				}
				System.out.println("BUDUJE DROWE FRAKCJI 4 W PUNKCIE: "+a+","+b);
			}
			warehouse.minRes(2, 0, 0, 1);
			putroads(a,b);
		}
		else {
			building2=false;
			System.out.println("NIE MOZNA ZBUDOWAC DROGI");
		}
		
	}
	/**
	 * Funkcja do budowania wiosek <p>
	 * <strong>Uwaga:</strong> z uwagi na za³o¿enia implementacji wioska budowana jest obok dróg
	 */
	public void buildvillage() {
		int a=0;
		int b=0;
		int a1=0;
		int b1=0;
		int a2=0;
		int b2=0;
		int a3=0;
		int b3=0;
		int a4=0;
		int b4=0;
		
		Boolean canbuildroad=false;
		int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
		for (int i=0;i<roads.size();i++) {
		ArrayList<Integer> xyz=roads.get(i);
		int osc=xyz.get(0);
		int osr=xyz.get(1);
		osc=osc-1;
		//Sprawdzamy czy dookola danej wioski mo¿na zbudowaæ drogê
		Boolean zmienna1 = GUI2.canibuild(osc, osr);
		//Boolean zmienna11 = GUI2.isvillage(osc, osr);
		if(zmienna1 == true) {
			a1=osc;
			b1=osr;
		}
		osc=osc+2;
		Boolean zmienna2 = GUI2.canibuild(osc, osr);
		//Boolean zmienna21 = GUI2.isvillage(osc, osr);
		if(zmienna2 == true) {
			a2=osc;
			b2=osr;
		}
		osc=osc-1;
		osr=osr+1;
		Boolean zmienna3 = GUI2.canibuild(osc, osr);
		//Boolean zmienna31 = GUI2.isvillage(osc, osr);
		if(zmienna3 == true) {
			a3=osc;
			b3=osr;
		}
		osr=osr-2;
		Boolean zmienna4 = GUI2.canibuild(osc, osr);
		//Boolean zmienna41 = GUI2.isvillage(osc, osr);
		if(zmienna4 == true) {
			a4=osc;
			b4=osr;
		}
		//Sprawdzamy czy mozna budowac droge wokó³ danej wioski i jesli tak to przypisujemy wartoœæ
		//if((zmienna1==true&&zmienna11==false)||(zmienna2==true&&zmienna21==false)||(zmienna3==true&&zmienna31==false)||(zmienna4==true&&zmienna41==false)) {
			/*if(zmienna11==false&&zmienna21==false&&zmienna31==false&&zmienna41==false) {
				break;
			}*/
			if(zmienna1==true||zmienna2==true||zmienna3==true||zmienna4==true) {
			Boolean iszmienna=false;
			while (iszmienna==false) {
			if((randomNum==1&&zmienna1==true)) {
				a=a1;
				b=b1;
				iszmienna=true;
				canbuildroad=true;
			}
			else if (randomNum==2&&zmienna2==true) {
				a=a2;
				b=b2;
				iszmienna=true;
				canbuildroad=true;
			}
			else if (randomNum==3&&zmienna3==true) {
				a=a3;
				b=b3;
				iszmienna=true;
				canbuildroad=true;
			}
			else if (randomNum==4&&zmienna4==true){
				a=a4;
				b=b4;
				iszmienna=true;
				canbuildroad=true;
			}
			else {
				randomNum = ThreadLocalRandom.current().nextInt(1, 5);
			}
			}
			break;
		}
		}
		//Sprawdzamy czy przypisana zosta³a wartoœæ wioski do zbudowania, nie chcemy randomowo budowaæ wiosek jeœli ca³a mapa jest zape³niona
		if(canbuildroad==true) {
			if (nrfr==0) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.table.setValueAt("R11", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.table.setValueAt("R12", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.table.setValueAt("R13", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.table.setValueAt("R14", a, b);
				}
				System.out.println("BUDUJE WIOSKE FRAKCJI 1 W PUNKCIE: "+a+","+b);
			}
			if (nrfr==1) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.table.setValueAt("R21", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.table.setValueAt("R22", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.table.setValueAt("R23", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.table.setValueAt("R24", a, b);
				}
				System.out.println("BUDUJE WIOSKE FRAKCJI 2 W PUNKCIE: "+a+","+b);
			}
			if (nrfr==2) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.table.setValueAt("R31", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.table.setValueAt("R32", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.table.setValueAt("R33", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.table.setValueAt("R34", a, b);
				}
				System.out.println("BUDUJE WIOSKE FRAKCJI 3 W PUNKCIE: "+a+","+b);
			}
			if (nrfr==3) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.putvaluetab("R41", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.putvaluetab("R42", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.putvaluetab("R43", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.putvaluetab("R44", a, b);
				}
				System.out.println("BUDUJE WIOSKE FRAKCJI 4 W PUNKCIE: "+a+","+b);
			}
			warehouse.minRes(1, 1, 1, 1);
			putvillages(a,b);
		}
		else {
			System.out.println("NIE MOZNA TUTAJ TEGO ZBUDOWAC");
			building=false;
		}
		
	}
	/**
	 * Funkcja pobieraj¹ca surowce z planszy<p>
	 * 
	 */
	public void checkvillages(){
		int stone=0;
		int irone=0;
		int wood=0;
		int clay=0;
		
		for (int i=0;i<villages.size();i++) {
		ArrayList<Integer> xyz=villages.get(i);
		int osc=xyz.get(1);
		int osr=xyz.get(0);
		int zmienna = GUI2.whatresources(xyz.get(1), xyz.get(0));
		osc=osc-1;
		int zmienna1 = GUI2.whatresources(osc, osr);
		osc=osc+2;
		int zmienna2 = GUI2.whatresources(osc, osr);
		osc=osc-1;
		osr=osr+1;
		int zmienna3 = GUI2.whatresources(osc, osr);
		osr=osr-2;
		int zmienna4 = GUI2.whatresources(osc, osr);
		//System.out.println(GUI2.table2.getValueAt(xyz.get(1),xyz.get(0)));
		//System.out.println("Kolumna:"+xyz.get(0));
		//System.out.println("Wiersz:"+xyz.get(1));
		//System.out.println("Doszed³em tutaj:columna: "+ xyz.get(0) +"wiersz" + xyz.get(1));
		//System.out.println("Zmienna:"+zmienna);
		if(zmienna==1)
			stone++;
		if(zmienna==2)
			irone++;
		if(zmienna==3)
			wood++;
		if(zmienna==4)
			clay++;
		if(zmienna1==1)
			stone++;
		if(zmienna1==2)
			irone++;
		if(zmienna1==3)
			wood++;
		if(zmienna1==4)
			clay++;
		if(zmienna2==1)
			stone++;
		if(zmienna2==2)
			irone++;
		if(zmienna2==3)
			wood++;
		if(zmienna2==4)
			clay++;
		if(zmienna3==1)
			stone++;
		if(zmienna3==2)
			irone++;
		if(zmienna3==3)
			wood++;
		if(zmienna3==4)
			clay++;
		if(zmienna4==1)
			stone++;
		if(zmienna4==2)
			irone++;
		if(zmienna4==3)
			wood++;
		if(zmienna4==4)
			clay++;
	}
		this.warehouse.getRes(stone, irone, wood, clay);
		GUI2.labeling2(nrfr, stone, irone, wood, clay);
	}
	public void wymiana() {
		if(warehouse.ilestones()==0) {
		
		}
	}
	public int ilevillages() {
		return villages.size();
	}
	public int ileroads() {
		return roads.size();
	}
	/**
	 * Funkcja s³u¿¹ca do implementacji tury Frakcji
	 */
	public void tura() {
		
		checkvillages();//Dodanie zasobów na poczatku tury
		GUI2.labeling(nrfr, warehouse.ilestones(), warehouse.ileiron(), warehouse.ilewood(), warehouse.ileclay());
		warehouse.bank();
		GUI2.labeling(nrfr, warehouse.ilestones(), warehouse.ileiron(), warehouse.ilewood(), warehouse.ileclay());
		//this.warehouse.ileRes();//Wyœwietlenie iloœci zasobów
		if(warehouse.canibuildvillage()==true&&roads.size()>1) {
			while(warehouse.canibuildvillage()==true&&building==true) {
			System.out.println("WIOSKA: "+nrfr+" CHCE BUDOWAÆ WIOSKE!!!");
			buildvillage();
			}
		}
		if(warehouse.canibuildroad()==true&&roads.size()>0)
		{
			while(warehouse.canibuildroad()==true&&building2==true) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
			if(randomNum==0&&roads.size()>0) {
			System.out.println("WIOSKA: "+nrfr+" CHCE BUDOWAÆ DROGE OBOK WIOSKI");
			buildroad(villages);
			}
			if(randomNum==1||roads.size()==0) {
				System.out.println("WIOSKA: "+nrfr+" CHCE BUDOWAÆ DROGE OBOK DROGI");
				buildroad(roads);
				}
		}
		}
		if(warehouse.canibuildroad()==true&&roads.size()==0)
		{
			System.out.println("WIOSKA: "+nrfr+" CHCE BUDOWAÆ DROGE");
			buildroad(villages);
			//this.warehouse.ileRes();
		}
		building=true;
		building2=true;
	}
}
