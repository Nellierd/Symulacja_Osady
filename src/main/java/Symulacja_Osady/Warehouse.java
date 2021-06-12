package Symulacja_Osady;
/**
 * Klasa implementuj¹ca magazyn
 * @author Nenaki
 *
 */
public class Warehouse {
	private int stone;
	private int iron;
	private int wood;
	private int clay;
	
	public Warehouse() {
		this.stone=0;
		this.iron=0;
		this.wood=0;
		this.clay=0;
	}
	/**
	 * Funkcja dodaj¹ca surowce
	 * @param a iloœæ "Kamienia" do dodania
	 * @param b iloœæ "¯elaza" do dodania
	 * @param c iloœæ "Drewna" do dodania
	 * @param d iloœæ "Gliny" do dodania
	 */
	public void getRes(int a,int b, int c, int d) {
		this.stone=this.stone+a;
		this.iron=this.iron+b;
		this.wood=this.wood+c;
		this.clay=this.clay+d;
	}
	/**
	 * Funkcja odejmuj¹ca surowce
	 * @param a iloœæ "Kamienia" do oddania
	 * @param b iloœæ "¯elaza" do oddania
	 * @param c iloœæ "Drewna" do oddania
	 * @param d iloœæ "Gliny" do oddania
	 */
	public void minRes(int a,int b, int c, int d) {
		this.stone=this.stone-a;
		this.iron=this.iron-b;
		this.wood=this.wood-c;
		this.clay=this.clay-d;
}
	/**
	 * Funkcja wyœwietlaj¹ca aktualnie posiadane surowce
	 */
	public void ileRes() {
		System.out.println("Mam "+this.stone+" kamienia");
		System.out.println("Mam "+this.iron+" zelaza");
		System.out.println("Mam "+this.wood+" drewna");
		System.out.println("Mam "+this.clay+" gliny");
}
	public int ilestones() {
		return this.stone;
	}
	public int ileiron() {
		return this.iron;
	}

public int ilewood() {
	return this.wood;
}
public int ileclay() {
	return this.clay;
}

	/**
	 * Funkcja sprawdzaj¹ca czy w magazynie jest wystarczaj¹co surowców do budowy <strong>Drogi</strong>
	 * @return <strong>true</strong> - jeœli iloœæ surowców w magazynie jest wystarczaj¹ca<BR>
	 * <strong>false</strong> - jeœli iloœæ surowców w magazynie jest niewystarczaj¹ca
	 */
	public Boolean canibuildroad() {
	if(this.stone>=2&&this.clay>=1) {
	return true;
	}
	else {
	return false;
	}
	}
	/**
	 * Funkcja sprawdzaj¹ca czy w magazynie jest wystarczaj¹co surowców do budowy <strong>Wioski</strong>
	 * @return <strong>true</strong> - jeœli iloœæ surowców w magazynie jest wystarczaj¹ca<BR>
	 * <strong>false</strong> - jeœli iloœæ surowców w magazynie jest niewystarczaj¹ca
	 */
	public Boolean canibuildvillage() {
	if(this.stone>=1&&this.clay>=1&&this.wood>=1&&this.iron>=1) {
	return true;
	}
	else {
	return false;
	}
	}
	/**
	 * Funkcja która za zadanmie ma wymieniaæ surowce w stosunku B:A kiedy ¿aden gracz nie chce siê wymieniæ
	 */
	public void bank() {
		System.out.println("Wymieniam surowce");
		if(ilestones()<2||ileiron()<2||ilewood()<2||ileclay()<2) {
			if(ileiron()<2&&ilestones()>5) {
				getRes(0,1,0,0);
				minRes(3,0,0,0);
			}
			if(ilewood()<2&&ilestones()>5) {
				getRes(0,0,1,0);
				minRes(3,0,0,0);
			}
			if(ileclay()<2&&ilestones()>5) {
				getRes(0,0,0,1);
				minRes(3,0,0,0);
			}
			if(ilestones()<2&&ileiron()>5) {
				getRes(1,0,0,0);
				minRes(0,3,0,0);
			}
			if(ilewood()<2&&ileiron()>5) {
				getRes(0,0,1,0);
				minRes(0,3,0,0);
			}
			if(ileclay()<2&&ileiron()>5) {
				getRes(0,0,0,1);
				minRes(0,3,0,0);
			}
			if(ilestones()<2&&ilewood()>5) {
				getRes(1,0,0,0);
				minRes(0,0,3,0);
			}
			if(ileiron()<2&&ilewood()>5) {
				getRes(0,1,0,0);
				minRes(0,0,3,0);
			}
			if(ileclay()<2&&ilewood()>5) {
				getRes(0,0,0,1);
				minRes(0,0,3,0);
			}
			if(ilestones()<2&&ileclay()>5) {
				getRes(1,0,0,0);
				minRes(0,0,0,3);
			}
			if(ileiron()<2&&ileclay()>5) {
				getRes(0,1,0,0);
				minRes(0,0,0,3);
			}
			if(ilewood()<2&&ileclay()>5) {
				getRes(0,0,1,0);
				minRes(0,0,0,3);
			}
		}
		else {
			System.out.println("NIE POTRZEBUJESZ WYMIENIAC SUROWCOW");
		}
	}
	}