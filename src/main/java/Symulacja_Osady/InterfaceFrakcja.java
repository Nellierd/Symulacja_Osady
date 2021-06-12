package Symulacja_Osady;
/**
 * Implementacja interface'u Frakcji
 */
import java.util.ArrayList;
import java.util.Map;

public interface InterfaceFrakcja {
	public void putvillages(int i,int j);
	public void putroads(int i,int j);
	public ArrayList<Integer> gettvillages(int i);
	public ArrayList<Integer> getroads(int i);
	public void buildroad(Map<Integer, ArrayList<Integer>> abc);
	public void buildvillage();
	public void checkvillages();
	public int ilevillages();
	public int ileroads();
	public void tura();
	public Boolean doiwant(String a, String b);
	public void minRes(int a,int b,int c,int d);
	public void getRes(int a,int b,int c,int d);
}
