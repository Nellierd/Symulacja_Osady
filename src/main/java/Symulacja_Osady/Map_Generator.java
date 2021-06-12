package Symulacja_Osady;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import Symulacja_Osady.GUI2;
import Symulacja_Osady.Simulation;
/**
 * Klasa implementuj¹ca Generator mapy
 * W pierwszej kolejnoœci generowana jest mapa surowców, na której póniej umieszczane s¹ frakcje 
 * @author Nenaki
 *
 */
public class Map_Generator {
	public static int[][] tablica;
	public static Boolean simstarted=false;
	public Map_Generator(int size,int frnum)
	{
		int[][] tablica = new int[size][size];
		for (int i=0;i<size;i++)
		{
			for (int j=0;j<size;j++)
			{
				int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
				tablica[i][j]=randomNum;
				if(randomNum==1) {
					GUI2.putvaluetab("1", i, j);
					GUI2.putvaluetab2("1", i, j);
				}
				//if(randomNum==1)
				if(randomNum==2) {
					GUI2.putvaluetab("2", i, j);
					GUI2.putvaluetab2("2", i, j);
				}
				//if(randomNum==2)
				//if(randomNum==3)
				if(randomNum==3) {
					GUI2.putvaluetab("3", i, j);
					GUI2.putvaluetab2("3", i, j);
				}
				//if(randomNum==4)
				if(randomNum==4) {
					GUI2.putvaluetab("4", i, j);
					GUI2.putvaluetab2("4", i, j);
				}
				
				GUI2.putvaluetab3("", i, j);
				//Generowanie surowców na mapie
				//System.out.println("mapa:"+i+" "+j+" " + mapa[i][j]);
				
			}
	}
		for (int k=0;k<frnum;k++)
		{
			InterfaceFrakcja trololo = Simulation.getfrakcje(k);
			int randomNum1 = ThreadLocalRandom.current().nextInt(0, size);
			int randomNum2 = ThreadLocalRandom.current().nextInt(0, size);
			//System.out.println(randomNum1 + "  " + randomNum2);
			while(GUI2.getvaluetab1(randomNum1, randomNum2)!="")
			{
				randomNum1 = ThreadLocalRandom.current().nextInt(0, size);
				randomNum2 = ThreadLocalRandom.current().nextInt(0, size);
				System.out.println("Powtorka" + randomNum1 + "  " + randomNum2);
			}
	
			//if(table1.getValueAt(randomNum1, randomNum2)=="")
					GUI2.putvaluetab3(String.valueOf(k), randomNum1, randomNum2);
				if (k==0) {
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="1") {
					GUI2.putvaluetab("R11", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="2") {
					GUI2.putvaluetab("R12", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="3") {
					GUI2.putvaluetab("R13", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="4") {
					GUI2.putvaluetab("R14", randomNum1, randomNum2);
					}
					//GUI2.table.setValueAt("R1", randomNum1, randomNum2);
					while(simstarted==false) {
						try {
							TimeUnit.SECONDS.sleep(5);
						} catch (InterruptedException e) {
						}
					}
					
					trololo.putvillages(randomNum1,randomNum2);
					ArrayList<Integer> xyz=trololo.gettvillages(0);
					Simulation.putfrakcje(k, trololo);
					//Simulation.getfrakcje(k) = trololo;
					System.out.println("Wioska nr 1 JEST TU:" + xyz.get(0) + " " + xyz.get(1));
					}

				if (k==1) {
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="1") {
					GUI2.putvaluetab("R21", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="2") {
					GUI2.putvaluetab("R22", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="3") {
					GUI2.putvaluetab("R23", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="4") {
					GUI2.putvaluetab("R24", randomNum1, randomNum2);
					}
					trololo.putvillages(randomNum1,randomNum2);
					Simulation.putfrakcje(k, trololo);
					ArrayList<Integer> xyz=trololo.gettvillages(0);
					System.out.println("Wioska nr 2 JEST TU:" + xyz.get(0) + " " + xyz.get(1));
				}
				if (k==2)
				{
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="1") {
					GUI2.putvaluetab("R31", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="2") {
					GUI2.putvaluetab("R32", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="3") {
					GUI2.putvaluetab("R33", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="4") {
					GUI2.putvaluetab("R34", randomNum1, randomNum2);
					}

					trololo.putvillages(randomNum1,randomNum2);
					Simulation.putfrakcje(k, trololo);
					ArrayList<Integer> xyz=trololo.gettvillages(0);
					System.out.println("Wioska nr 3 JEST TU:" + xyz.get(0) + " " + xyz.get(1));
				}
				

				if (k==3) {
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="1") {
					GUI2.putvaluetab("R41", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="2") {
					GUI2.putvaluetab("R42", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="3") {
					GUI2.putvaluetab("R43", randomNum1, randomNum2);
					}
					if(GUI2.getvaluetab2(randomNum1, randomNum2)=="4") {
					GUI2.putvaluetab("R44", randomNum1, randomNum2);
					}
					Simulation.putfrakcje(k, trololo);
					trololo.putvillages(randomNum1,randomNum2);
					ArrayList<Integer> xyz=trololo.gettvillages(0);
					System.out.println("Wioska nr 4 JEST TU:" + xyz.get(0) + " " + xyz.get(1));
				}
					
		}
		Simulation.setstart3();
	}
	public static void setstart() {
		simstarted=true;
	}
}
