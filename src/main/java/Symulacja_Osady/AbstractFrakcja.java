package Symulacja_Osady;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Klasa abstrakcyjna, która jest podstaw¹ dla pozosta³ych frakcji w tej symulacji
 * @author Nenaki
 *
 */

public abstract class AbstractFrakcja {
	/**
	 * Magazyn frakcji
	 */
	public Warehouse warehouse;
	/**
	 * Lista osad nale¿¹ca do frakcji
	 */
	private Map<Integer, ArrayList<Integer>> villages;
	/**
	 * lista dróg nalezaca do frakcji
	 */
	private Map<Integer, ArrayList<Integer>> roads;
	/**
	 * Numer przypisany do frakcji
	 */
	private int nrfr;
	/**
	 * Zmienna sprawdzaj¹ca czy budowanie wiosek zosta³o zakoñczone
	 */
	public Boolean building=true;
	/**
	 * Zmienna sprawdzaj¹ca czy budowanie drog zostalo zakonczone
	 */
	public Boolean building2=true;
	public AbstractFrakcja(int i) {
		this.nrfr=i;
		this.warehouse = new Warehouse();
		this.villages = new TreeMap<>();
		this.roads = new TreeMap<>();
	}
	/**
	 * Wywo³annie prywatnej metody putvillages1
	 * @param i - Kolumna
	 * @param j - Wiersz
	 */
	public void putvillages(int i,int j) {
		putvillages1(i,j);
	}
	/**
	 * Wywo³anie prywatnej metody whatnumber1
	 * @return numer jaki posiada frakcja
	 */
	public int whatnumber() {
		return whatnumber1();
	}
	/**
	 * Wywo³anie prywatnej metody putroads1
	 * @param i - Kolumna
	 * @param j - Wiersz
	 */
	public void putroads(int i,int j) {
		putroads1(i,j);
	}
	/**
	 * Wywo³anie prywantej metody gettvillages1
	 * @param i - numer osady
	 * @return - wektor po³o¿enia wioski na mapie
	 */
	public ArrayList<Integer> gettvillages(int i){
		return gettvillages1(i);
	}
	/**
	 * Wywo³anie prywantej metody getroads1
	 * @param i - numer drogi
	 * @return - wektor po³o¿enia drogi na mapie
	 */
	public ArrayList<Integer> getroads(int i){
		return getroads1(i);
	}
	/**
	 * Wywo³anie prywantnej metody buildroad1
	 * @param abc Wektor polo¿enia nowej drogi
	 */
	public void buildroad(Map<Integer, ArrayList<Integer>> abc) {
		buildroad1(abc);
	}
	/**
	 * Wywo³anie prywatnej metody build buildvillages1
	 */
	public void buildvillage() {
		buildvillage1();
	}
	/**
	 * Wywo³anie prywatnej metody ilevillages1
	 * @return - iloœæ posiadanych wiosek
	 */
	public int ilevillages() {
		return ilevillages1();
	}
	/**
	 * Wywo³anie prywatnej metody ileroads1
	 * @return - iloœæ posiadanych drog
	 */
	public int ileroads() {
		return ileroads1();
	}
	/**
	 * Wywo³anie prywatnej metody doiwant1
	 * @param a - jak surowiec
	 * @param b - za jaki surowiec
	 * @return - czy chce siê wymieniæ
	 */
	public Boolean doiwant(String a, String b) {
		return doiwant1(a,b);
	}
	/**
	 * Wywo³anie prywatnej metody minRed1
	 * @param a - ile kamienia
	 * @param b - ile zelaza
	 * @param c - ile drewna
	 * @param d - ile gliny
	 */
	public void minRes(int a,int b,int c,int d) {
		minRes1(a,b,c,d);
	}
	public void checkvillages() {
		checkvillages1();
	}
	/**
	 * Wywo³anie prywatnej metody getRed1
	 * @param a - ile kamienia
	 * @param b - ile zelaza
	 * @param c - ile drewna
	 * @param d - ile gliny
	 */
	public void getRes(int a,int b,int c,int d) {
		getRes1(a,b,c,d);
	}
	/**
	 * Wywo³anie prywatnej metody tura1
	 */
	public void tura() {
		tura1();
	}
	private int ilevillages1() {
		return villages.size();
	}
	private int ileroads1() {
		return roads.size();
	}
	/**
	 * Funkcja s³u¿¹ca do umieszczania danej wioski na liœcie
	 * @param i Kolumna
	 * @param j Wiersz
	 */
	private void putvillages1(int i,int j) {

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
	private void putroads1(int i,int j) {

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
	private ArrayList<Integer> gettvillages1(int i) {
		return villages.get(i);
	}
	/**
	 * Funcka s³u¿¹ca do zwracania lokacji danej Drogi
	 * @param i Klucz danej wioski
	 * @return Wektor licz bêd¹cy koordynatami danej Drogi
	 */
	private ArrayList<Integer> getroads1(int i) {
		return roads.get(i);
	}
	/**
	 * Funkcja buduj¹ca drogê
	 * @param abc Mapa obiektów obok których ma siê pojawiæ dana wioska
	 */
	private void buildroad1(Map<Integer, ArrayList<Integer>> abc) {
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
			}
			warehouse.minRes(2, 0, 0, 1);
			putroads(a,b);
		}
		else {
			building2=false;
		}
		
	}
	/**
	 * Funkcja do budowania wiosek <p>
	 * <strong>Uwaga:</strong> z uwagi na za³o¿enia implementacji wioska budowana jest obok dróg
	 */
	private void buildvillage1() {
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
					GUI2.putvaluetab("R11", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.putvaluetab("R12", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.putvaluetab("R13", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.putvaluetab("R14", a, b);
				}
			}
			if (nrfr==1) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.putvaluetab("R21", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.putvaluetab("R22", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.putvaluetab("R23", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.putvaluetab("R24", a, b);
				}
			}
			if (nrfr==2) {
				if (GUI2.whatresources(a, b)==1) {
					GUI2.putvaluetab("R31", a, b);
				}
				if (GUI2.whatresources(a, b)==2) {
					GUI2.putvaluetab("R32", a, b);
				}
				if (GUI2.whatresources(a, b)==3) {
					GUI2.putvaluetab("R33", a, b);
				}
				if (GUI2.whatresources(a, b)==4) {
					GUI2.putvaluetab("R34", a, b);
				}
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
			}
			warehouse.minRes(1, 1, 1, 1);
			putvillages(a,b);
		}
		else {
			building=false;
		}
		
	}
	/**
	 * Funkcja pobieraj¹ca surowce z planszy
	 * 
	 */
	private void checkvillages1(){
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
	/**
	 * Funkcja sprawdzaj¹ca czy frakcja chce dany surowiec
	 * @param a - surowiec jaki chce oddaæ inna wioska
	 * @param b - surowiec jaki chce w zamian
	 * @return <strong>true</strong> - jeœli chce siê wymieniæ <BR>
	 * <strong>false</strong> - jeœli nie chce siê wymieniæ
	 */
	private Boolean doiwant1(String a, String b) {
		return warehouse.doiwant(a, b);
	}
	private void minRes1(int a,int b,int c,int d) {
		warehouse.minRes(a, b, c, d);
	}
	private void getRes1(int a,int b,int c,int d) {
		warehouse.getRes(a, b, c, d);
	}
	public void wymiana (int a) {
		wymiana1(a);
	}
	private void wymiana1(int a) {
		warehouse.wymiana(a);
	}
	/**
	 * Funkcja s³u¿¹ca do implementacji tury Frakcji
	 */
	private void tura1() {
		checkvillages();//Dodanie zasobów na poczatku tury
		GUI2.labeling(nrfr, warehouse.ilestones(), warehouse.ileiron(), warehouse.ilewood(), warehouse.ileclay());
		wymiana(nrfr);
		GUI2.labeling(nrfr, warehouse.ilestones(), warehouse.ileiron(), warehouse.ilewood(), warehouse.ileclay());
		warehouse.bank();
		GUI2.labeling(nrfr, warehouse.ilestones(), warehouse.ileiron(), warehouse.ilewood(), warehouse.ileclay());
		if(warehouse.canibuildvillage()==true&&roads.size()>1) {
			while(warehouse.canibuildvillage()==true&&building==true) {
			buildvillage();
			}
		}
		if(warehouse.canibuildroad()==true&&roads.size()>0)
		{
			while(warehouse.canibuildroad()==true&&building2==true) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
			if(randomNum==0&&roads.size()>0) {
			buildroad(villages);
			}
			if(randomNum==1||roads.size()==0) {
				buildroad(roads);
				}
		}
		}
		if(warehouse.canibuildroad()==true&&roads.size()==0)
		{
			buildroad(villages);
		}
		building=true;
		building2=true;
	}
/**
 * Funkcja zwracajaca numer frakcji
 * @return numer frakcji
 */
private int whatnumber1() {
	return nrfr;
}
}
