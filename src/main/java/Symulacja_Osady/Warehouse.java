package Symulacja_Osady;
/**
 * Klasa implementuj?ca magazyn
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
	public void getRes(int a,int b, int c, int d) {
		getRes1(a,b,c,d);
	}
	public void minRes(int a, int b, int c, int d) {
		minRes1(a,b,c,d);
	}
	public int ilestones() {
		return ilestones1();
	}
	public int ileiron() {
		return ileiron1();
	}
	public int ileclay() {
		return ileclay1();
	}
	public int ilewood() {
		return ilewood1();
	}
	public Boolean canibuildroad() {
		return canibuildroad1();
	}
	public Boolean canibuildvillage() {
		return canibuildvillage1();
	}
	public void bank() {
		bank1();
	}
	public void wymiana(int nr) {
		wymiana1(nr);
	}
	public Boolean doiwant(String what, String forwhat) {
		return doiwant1(what,forwhat);
	}
	/**
	 * Funkcja dodaj?ca surowce
	 * @param a ilo?? "Kamienia" do dodania
	 * @param b ilo?? "?elaza" do dodania
	 * @param c ilo?? "Drewna" do dodania
	 * @param d ilo?? "Gliny" do dodania
	 */
	private void getRes1(int a,int b, int c, int d) {
		this.stone=this.stone+a;
		this.iron=this.iron+b;
		this.wood=this.wood+c;
		this.clay=this.clay+d;
	}
	/**
	 * Funkcja odejmuj?ca surowce
	 * @param a ilo?? "Kamienia" do oddania
	 * @param b ilo?? "?elaza" do oddania
	 * @param c ilo?? "Drewna" do oddania
	 * @param d ilo?? "Gliny" do oddania
	 */
	private void minRes1(int a,int b, int c, int d) {
		this.stone=this.stone-a;
		this.iron=this.iron-b;
		this.wood=this.wood-c;
		this.clay=this.clay-d;
	}
	/**
	 * Funkcja zwracaj?ca ilo?? kamienia w magazynie
	 * @return ilo?? kamienia
	 */
	private int ilestones1() {
		return this.stone;
	}
	/**
	 * Funkcja zwracaj?ca ilo?? ?elaza w magazynie
	 * @return ilo?? ?elaza
	 */
	private int ileiron1() {
		return this.iron;
	}
	/**
	 * Funkcja zwracaj?ca ilo?c kamienia w magazynie
	 * @return ilo?? kamienia
	 */
	private int ilewood1() {
		return this.wood;
	}
	/**
	 * Funkcja zwracaj?ca ilo?c gliny w magazynie
	 * @return ilo?? glny
	 */
	private int ileclay1() {
		return this.clay;
	}
	/**
	 * Funkcja sprawdzaj?ca czy w magazynie jest wystarczaj?co surowc?w do budowy <strong>Drogi</strong>
	 * @return <strong>true</strong> - je?li ilo?? surowc?w w magazynie jest wystarczaj?ca<BR>
	 * <strong>false</strong> - je?li ilo?? surowc?w w magazynie jest niewystarczaj?ca
	 */
	private Boolean canibuildroad1() {
	if(this.stone>=2&&this.clay>=1) {
	return true;
	}
	else {
	return false;
		}
	}
	/**
	 * Funkcja sprawdzaj?ca czy w magazynie jest wystarczaj?co surowc?w do budowy <strong>Wioski</strong>
	 * @return <strong>true</strong> - je?li ilo?? surowc?w w magazynie jest wystarczaj?ca<BR>
	 * <strong>false</strong> - je?li ilo?? surowc?w w magazynie jest niewystarczaj?ca
	 */
	private Boolean canibuildvillage1() {
	if(this.stone>=1&&this.clay>=1&&this.wood>=1&&this.iron>=1) {
	return true;
	}
	else {
	return false;
	}
	}

	/**
	 * Funkcja kt?ra za zadanie ma wymienia? surowce w stosunku B:A
	 */
	private void bank1() {
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
		}
	}
	/**
	 * Funkcja sprawdzaj?ca czy Frakcja chce si? wymieni? za dany surowiec
	 * @param what - surowiec jaki oferuje inna frakcja
	 * @param forwhat - surowiec do oddania
	 * @return <strong>true</strong> - je?li chce si? wymienic <br>
	 * <strong>false</strong> - je?li nie chce si? wymieni?
	 */
	private Boolean doiwant1(String what, String forwhat) {
		if(forwhat=="stone") {
			if(what=="iron") {
				if(ilestones()<2&&ileiron()>2) {
					return true;
				}
			}
			if(what=="wood") {
				if(ilestones()<2&&ilewood()>2) {
					return true;
				}
			}
			if(what=="clay") {
				if(ilestones()<2&&ileclay()>2) {
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
		return false;
	}
	/**
	 * Funkcja sluzaca do wymiany z innymi frakcjami
	 * @param nr - kt?r? frakcj? jestem
	 */
	private void wymiana1(int nr) {
		if(ilestones()<=0) {
		for (int i=0;i<Simulation.ilefrakcji();i++) {
			if(i!=nr) {
				InterfaceFrakcja trololo = Simulation.getfrakcje(i);
				if(ileiron()>=ilewood()&&ileiron()>=ileclay()) {
					if(trololo.doiwant("iron", "stone")==true){
						minRes(0, 1, 0, 0);
						getRes(1, 0, 0, 0);
						trololo.minRes(1, 0, 0, 0);
						trololo.getRes(0, 1, 0, 0);
						break;
						}
					}
				if(ilewood()>=ileiron()&&ilewood()>=ileclay()) {
					if(trololo.doiwant("wood", "stone")==true){
						minRes(0, 0, 1, 0);
						getRes(1, 0, 0, 0);
						trololo.minRes(1, 0, 0, 0);
						trololo.getRes(0, 0, 1, 0);
						break;
							}
				if(ileclay()>=ileiron()&&ileclay()>=ilewood()) {
					if(trololo.doiwant("clay", "stone")==true){
						minRes(0, 0, 0, 1);
						getRes(1, 0, 0, 0);
						trololo.minRes(1, 0, 0, 0);
						trololo.getRes(0, 0, 0, 1);
						break;
							}
						}	
					}
				}	
			}
		}
		if(ileiron()<=0) {
			for (int i=0;i<Simulation.ilefrakcji();i++) {
				if(i!=nr) {
					InterfaceFrakcja trololo = Simulation.getfrakcje(i);
					if(ilestones()>=ilewood()&&ilestones()>=ileclay()) {
						if(trololo.doiwant("stones", "iron")==true){
							minRes(1, 0, 0, 0);
							getRes(0, 1, 0, 0);
							trololo.minRes(0, 1, 0, 0);
							trololo.getRes(1, 0, 0, 0);
							break;
							}
						}
					if(ilewood()>=ilestones()&&ilewood()>=ileclay()) {
						if(trololo.doiwant("wood", "iron")==true){
							minRes(0, 0, 1, 0);
							getRes(0, 1, 0, 0);
							trololo.minRes(0, 1, 0, 0);
							trololo.getRes(0, 0, 1, 0);
							break;
								}
					if(ileclay()>=ilestones()&&ileclay()>=ilewood()) {
						if(trololo.doiwant("clay", "iron")==true){
							minRes(0, 0, 0, 1);
							getRes(0, 1, 0, 0);
							trololo.minRes(0, 1, 0, 0);
							trololo.getRes(0, 0, 0, 1);
							break;
								}
							}	
						}
					}	
				}
			}
		if(ilewood()<=0) {
			for (int i=0;i<Simulation.ilefrakcji();i++) {
				if(i!=nr) {
					InterfaceFrakcja trololo = Simulation.getfrakcje(i);
					if(ilestones()>=ileiron()&&ilestones()>=ileclay()) {
						if(trololo.doiwant("stones", "wood")==true){
							minRes(1, 0, 0, 0);
							getRes(0, 0, 1, 0);
							trololo.minRes(0, 0, 1, 0);
							trololo.getRes(1, 0, 0, 0);
							break;
							}
						}
					if(ileiron()>=ilestones()&&ileiron()>=ileclay()) {
						if(trololo.doiwant("iron", "wood")==true){
							minRes(0, 1, 0, 0);
							getRes(0, 0, 1, 0);
							trololo.minRes(0, 0, 1, 0);
							trololo.getRes(0, 1, 0, 0);
							break;
								}
					if(ileclay()>=ilestones()&&ileclay()>=ileiron()) {
						if(trololo.doiwant("clay", "wood")==true){
							minRes(0, 0, 0, 1);
							getRes(0, 0, 1, 0);
							trololo.minRes(0, 0, 1, 0);
							trololo.getRes(0, 0, 0, 1);
							break;
								}
							}	
						}
					}	
				}
			}
		if(ileclay()<=0) {
			for (int i=0;i<Simulation.ilefrakcji();i++) {
				if(i!=nr) {
					InterfaceFrakcja trololo = Simulation.getfrakcje(i);
					if(ilestones()>=ileiron()&&ilestones()>=ilewood()) {
						if(trololo.doiwant("stones", "clay")==true){
							minRes(1, 0, 0, 0);
							getRes(0, 0, 0, 1);
							trololo.minRes(0, 0, 0, 1);
							trololo.getRes(1, 0, 0, 0);
							break;
							}
						}
					if(ileiron()>=ilestones()&&ileiron()>=ilewood()) {
						if(trololo.doiwant("iron", "clay")==true){
							minRes(0, 1, 0, 0);
							getRes(0, 0, 0, 1);
							trololo.minRes(0, 0, 0, 1);
							trololo.getRes(0, 1, 0, 0);
							break;
								}
					if(ilewood()>=ilestones()&&ilewood()>=ileiron()) {
						if(trololo.doiwant("wood", "clay")==true){
							minRes(0, 0, 1, 0);
							getRes(0, 0, 0, 1);
							trololo.minRes(0, 0, 0, 1);
							trololo.getRes(0, 0, 1, 0);
							break;
								}
							}	
						}
					}	
				}
			}
		}
	}