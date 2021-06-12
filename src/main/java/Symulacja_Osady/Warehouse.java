package Symulacja_Osady;
/**
 * Klasa implementuj¹ca magazyn
 * @author Nenaki
 *
 */
public class Warehouse implements InterfaceWarehouse {
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
	private void getRes1(int a,int b, int c, int d) {
		this.stone=this.stone+a;
		this.iron=this.iron+b;
		this.wood=this.wood+c;
		this.clay=this.clay+d;
	}
	public void getRes(int a,int b, int c, int d) {
		getRes1(a,b,c,d);
	}
	/**
	 * Funkcja odejmuj¹ca surowce
	 * @param a iloœæ "Kamienia" do oddania
	 * @param b iloœæ "¯elaza" do oddania
	 * @param c iloœæ "Drewna" do oddania
	 * @param d iloœæ "Gliny" do oddania
	 */
	private void minRes1(int a,int b, int c, int d) {
		this.stone=this.stone-a;
		this.iron=this.iron-b;
		this.wood=this.wood-c;
		this.clay=this.clay-d;
}
	public void minRes(int a, int b, int c, int d) {
		minRes1(a,b,c,d);
	}
	/**
	 * Funkcja wyœwietlaj¹ca aktualnie posiadane surowce
	 */
	public int ilestones() {
		return ilestones1();
	}
	private int ilestones1() {
		return this.stone;
	}
	public int ileiron() {
		return ileiron1();
	}
	private int ileiron1() {
		return this.iron;
	}
	public int ilewood() {
		return ilewood1();
	}
private int ilewood1() {
	return this.wood;
}
public int ileclay() {
	return ileclay1();
}
public int ileclay1() {
	return this.clay;
}

	/**
	 * Funkcja sprawdzaj¹ca czy w magazynie jest wystarczaj¹co surowców do budowy <strong>Drogi</strong>
	 * @return <strong>true</strong> - jeœli iloœæ surowców w magazynie jest wystarczaj¹ca<BR>
	 * <strong>false</strong> - jeœli iloœæ surowców w magazynie jest niewystarczaj¹ca
	 */
	private Boolean canibuildroad1() {
	if(this.stone>=2&&this.clay>=1) {
	return true;
	}
	else {
	return false;
	}
	}
	public Boolean canibuildroad() {
		return canibuildroad1();
	}
	public Boolean canibuildvillage() {
		return canibuildvillage1();
	}
	/**
	 * Funkcja sprawdzaj¹ca czy w magazynie jest wystarczaj¹co surowców do budowy <strong>Wioski</strong>
	 * @return <strong>true</strong> - jeœli iloœæ surowców w magazynie jest wystarczaj¹ca<BR>
	 * <strong>false</strong> - jeœli iloœæ surowców w magazynie jest niewystarczaj¹ca
	 */
	private Boolean canibuildvillage1() {
	if(this.stone>=1&&this.clay>=1&&this.wood>=1&&this.iron>=1) {
	return true;
	}
	else {
	return false;
	}
	}
	public void bank() {
		bank1();
	}
	/**
	 * Funkcja która za zadanmie ma wymieniaæ surowce w stosunku B:A kiedy ¿aden gracz nie chce siê wymieniæ
	 */
	private void bank1() {
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
	public Boolean doiwant(String what, String forwhat) {
		return doiwant1(what,forwhat);
	}
	public Boolean doiwant1(String what, String forwhat) {
		if(forwhat=="stone") {
			if(what=="iron") {
				if(ilestones()<2&&ileiron()>2) {
					System.out.println("Chce wymieniæ Kamien za zelazo");
					return true;
				}
			}
			if(what=="wood") {
				if(ilestones()<2&&ilewood()>2) {
					System.out.println("Chce wymieniæ Kamien za drewno");
					return true;
				}
			}
			if(what=="clay") {
				if(ilestones()<2&&ileclay()>2) {
					System.out.println("Chce wymieniæ Kamien za Gline");
					return true;
				}
			}
		}
		if(forwhat=="iron") {
			if(what=="stone") {
				if(ileiron()<2&&ilestones()>2) {
					return true;
				}
			}
			if(what=="wood") {
				if(ileiron()<2&&ilewood()>2) {
					return true;
				}
			}
			if(what=="clay") {
				if(ileiron()<2&&ileclay()>2) {
					return true;
				}
			}
		}
		if(forwhat=="wood") {
			if(what=="stone") {
				if(ilewood()<2&&ilestones()>2) {
					return true;
				}
			}
			if(what=="iron") {
				if(ilewood()<2&&ileiron()>2) {
					return true;
				}
			}
			if(what=="clay") {
				if(ilewood()<2&&ileclay()>2) {
					return true;
				}
			}
		}
		if(forwhat=="clay") {
			if(what=="stone") {
				if(ileclay()<2&&ilestones()>2) {
					return true;
				}
			}
			if(what=="iron") {
				if(ileclay()<2&&ileiron()>2) {
					return true;
				}
			}
			if(what=="wood") {
				if(ileclay()<2&&ilewood()>2) {
					return true;
				}
			}
		}
		System.out.println("Nie chce sie wymieniac z tb ciapciaku");
		return false;
	}
	public void wymiana(int nr) {
		wymiana1(nr);
	}
	private void wymiana1(int nr) {
		if(ilestones()==0) {
		for (int i=0;i<Simulation.ilefrakcji();i++) {
			if(i!=nr) {
				InterfaceFrakcja trololo = Simulation.getfrakcje(i);
				if(ileiron()>=ilewood()&&ileiron()>=ileclay()) {
					if(trololo.doiwant("iron", "stone")==true){
						minRes(0, 1, 0, 0);
						getRes(1, 0, 0, 0);
						trololo.minRes(1, 0, 0, 0);
						trololo.getRes(0, 1, 0, 0);
						System.out.println("Dokonano wymiany surowcow");
						break;
						}
					}
				if(ilewood()>=ileiron()&&ilewood()>=ileclay()) {
					if(trololo.doiwant("wood", "stone")==true){
						minRes(0, 0, 1, 0);
						getRes(1, 0, 0, 0);
						trololo.minRes(1, 0, 0, 0);
						trololo.getRes(0, 0, 1, 0);
						System.out.println("Dokonano wymiany surowcow");
						break;
							}
				if(ileclay()>=ileiron()&&ileclay()>=ilewood()) {
					if(trololo.doiwant("clay", "stone")==true){
						minRes(0, 0, 0, 1);
						getRes(1, 0, 0, 0);
						trololo.minRes(1, 0, 0, 0);
						trololo.getRes(0, 0, 0, 1);
						System.out.println("Dokonano wymiany surowcow");
						break;
							}
						}	
					}
				}	
			}
		}
		if(ileiron()==0) {
			for (int i=0;i<Simulation.ilefrakcji();i++) {
				if(i!=nr) {
					InterfaceFrakcja trololo = Simulation.getfrakcje(i);
					if(ilestones()>=ilewood()&&ilestones()>=ileclay()) {
						if(trololo.doiwant("stones", "iron")==true){
							minRes(1, 0, 0, 0);
							getRes(0, 1, 0, 0);
							trololo.minRes(0, 1, 0, 0);
							trololo.getRes(1, 0, 0, 0);
							System.out.println("Dokonano wymiany surowcow");
							break;
							}
						}
					if(ilewood()>=ilestones()&&ilewood()>=ileclay()) {
						if(trololo.doiwant("wood", "iron")==true){
							minRes(0, 0, 1, 0);
							getRes(0, 1, 0, 0);
							trololo.minRes(0, 1, 0, 0);
							trololo.getRes(0, 0, 1, 0);
							System.out.println("Dokonano wymiany surowcow");
							break;
								}
					if(ileclay()>=ilestones()&&ileclay()>=ilewood()) {
						if(trololo.doiwant("clay", "iron")==true){
							minRes(0, 0, 0, 1);
							getRes(0, 1, 0, 0);
							trololo.minRes(0, 1, 0, 0);
							trololo.getRes(0, 0, 0, 1);
							System.out.println("Dokonano wymiany surowcow");
							break;
								}
							}	
						}
					}	
				}
			}
		if(ilewood()==0) {
			for (int i=0;i<Simulation.ilefrakcji();i++) {
				if(i!=nr) {
					InterfaceFrakcja trololo = Simulation.getfrakcje(i);
					if(ilestones()>=ileiron()&&ilestones()>=ileclay()) {
						if(trololo.doiwant("stones", "wood")==true){
							minRes(1, 0, 0, 0);
							getRes(0, 0, 1, 0);
							trololo.minRes(0, 0, 1, 0);
							trololo.getRes(1, 0, 0, 0);
							System.out.println("Dokonano wymiany surowcow");
							break;
							}
						}
					if(ileiron()>=ilestones()&&ileiron()>=ileclay()) {
						if(trololo.doiwant("iron", "wood")==true){
							minRes(0, 1, 0, 0);
							getRes(0, 0, 1, 0);
							trololo.minRes(0, 0, 1, 0);
							trololo.getRes(0, 1, 0, 0);
							System.out.println("Dokonano wymiany surowcow");
							break;
								}
					if(ileclay()>=ilestones()&&ileclay()>=ileiron()) {
						if(trololo.doiwant("clay", "wood")==true){
							minRes(0, 0, 0, 1);
							getRes(0, 0, 1, 0);
							trololo.minRes(0, 0, 1, 0);
							trololo.getRes(0, 0, 0, 1);
							System.out.println("Dokonano wymiany surowcow");
							break;
								}
							}	
						}
					}	
				}
			}
		if(ileclay()==0) {
			for (int i=0;i<Simulation.ilefrakcji();i++) {
				if(i!=nr) {
					InterfaceFrakcja trololo = Simulation.getfrakcje(i);
					if(ilestones()>=ileiron()&&ilestones()>=ilewood()) {
						if(trololo.doiwant("stones", "clay")==true){
							minRes(1, 0, 0, 0);
							getRes(0, 0, 0, 1);
							trololo.minRes(0, 0, 0, 1);
							trololo.getRes(1, 0, 0, 0);
							System.out.println("Dokonano wymiany surowcow");
							break;
							}
						}
					if(ileiron()>=ilestones()&&ileiron()>=ilewood()) {
						if(trololo.doiwant("iron", "clay")==true){
							minRes(0, 1, 0, 0);
							getRes(0, 0, 0, 1);
							trololo.minRes(0, 0, 0, 1);
							trololo.getRes(0, 1, 0, 0);
							System.out.println("Dokonano wymiany surowcow");
							break;
								}
					if(ilewood()>=ilestones()&&ilewood()>=ileiron()) {
						if(trololo.doiwant("wood", "clay")==true){
							minRes(0, 0, 1, 0);
							getRes(0, 0, 0, 1);
							trololo.minRes(0, 0, 0, 1);
							trololo.getRes(0, 0, 1, 0);
							System.out.println("Dokonano wymiany surowcow");
							break;
								}
							}	
						}
					}	
				}
			}
	}
	}