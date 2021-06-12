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
					GUI2.table.setValueAt("1", i, j);
					GUI2.table2.setValueAt("1", i, j);
				}
				//if(randomNum==1)
				if(randomNum==2) {
					GUI2.table.setValueAt("2", i, j);
					GUI2.table2.setValueAt("2", i, j);
				}
				//if(randomNum==2)
				//if(randomNum==3)
				if(randomNum==3) {
					GUI2.table.setValueAt("3", i, j);
					GUI2.table2.setValueAt("3", i, j);
				}
				//if(randomNum==4)
				if(randomNum==4) {
					GUI2.table.setValueAt("4", i, j);
					GUI2.table2.setValueAt("4", i, j);
				}
				
				GUI2.table1.setValueAt("", i, j);
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
			while(GUI2.table1.getValueAt(randomNum1, randomNum2)!="")
			{
				randomNum1 = ThreadLocalRandom.current().nextInt(0, size);
				randomNum2 = ThreadLocalRandom.current().nextInt(0, size);
				System.out.println("Powtorka" + randomNum1 + "  " + randomNum2);
			}
			
			//if(table1.getValueAt(randomNum1, randomNum2)=="")
					GUI2.table1.setValueAt(k, randomNum1, randomNum2);
				if (k==0) {
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="1") {
					GUI2.table.setValueAt("R11", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="2") {
					GUI2.table.setValueAt("R12", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="3") {
					GUI2.table.setValueAt("R13", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="4") {
					GUI2.table.setValueAt("R14", randomNum1, randomNum2);
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
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="1") {
					GUI2.table.setValueAt("R21", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="2") {
					GUI2.table.setValueAt("R22", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="3") {
					GUI2.table.setValueAt("R23", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="4") {
					GUI2.table.setValueAt("R24", randomNum1, randomNum2);
					}
					trololo.putvillages(randomNum1,randomNum2);
					Simulation.putfrakcje(k, trololo);
					ArrayList<Integer> xyz=trololo.gettvillages(0);
					System.out.println("Wioska nr 2 JEST TU:" + xyz.get(0) + " " + xyz.get(1));
				}
				if (k==2)
				{
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="1") {
					GUI2.table.setValueAt("R31", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="2") {
					GUI2.table.setValueAt("R32", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="3") {
					GUI2.table.setValueAt("R33", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="4") {
					GUI2.table.setValueAt("R34", randomNum1, randomNum2);
					}

					trololo.putvillages(randomNum1,randomNum2);
					Simulation.putfrakcje(k, trololo);
					ArrayList<Integer> xyz=trololo.gettvillages(0);
					System.out.println("Wioska nr 3 JEST TU:" + xyz.get(0) + " " + xyz.get(1));
				}
				

				if (k==3) {
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="1") {
					GUI2.table.setValueAt("R41", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="2") {
					GUI2.table.setValueAt("R42", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="3") {
					GUI2.table.setValueAt("R43", randomNum1, randomNum2);
					}
					if(GUI2.table2.getValueAt(randomNum1, randomNum2)=="4") {
					GUI2.table.setValueAt("R44", randomNum1, randomNum2);
					}
					Simulation.putfrakcje(k, trololo);
					trololo.putvillages(randomNum1,randomNum2);
					ArrayList<Integer> xyz=trololo.gettvillages(0);
					System.out.println("Wioska nr 4 JEST TU:" + xyz.get(0) + " " + xyz.get(1));
				}
					
		}
		Simulation.start3=true;
	}
	public static void setstart() {
		simstarted=true;
	}
}
