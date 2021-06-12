package Symulacja_Osady;

import java.util.concurrent.ThreadLocalRandom;

public class FrakcjaBandyta extends AbstractFrakcja implements InterfaceFrakcja {

	private int zlodziej=1;
	public FrakcjaBandyta(int i) {
		super(i);
	}
	public void checkvillages(){
		int randomNum = ThreadLocalRandom.current().nextInt(0, Simulation.frakcje);
		if(randomNum!=whatnumber()) {
			System.out.println(randomNum);
			int a = (zlodziej/2);
			this.warehouse.getRes(a, a, a, a);
			Simulation.getfrakcje(randomNum).minRes(a, a, a, a);
			zlodziej=zlodziej+1;
			GUI2.labeling2(whatnumber(),a,a,a,a);
			System.out.println("ODDAWAJ SUROWCE");
		}
		
	}
}
