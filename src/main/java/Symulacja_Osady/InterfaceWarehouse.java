package Symulacja_Osady;

public interface InterfaceWarehouse {
	void getRes(int a,int b, int c, int d);
	public void minRes(int a,int b, int c, int d);
	public int ilestones();
	public int ileiron();
	public int ilewood();
	public int ileclay();
	public Boolean canibuildroad();
	public void bank();
	public Boolean doiwant(String what, String forwhat);
	public void wymiana(int nr);
}
