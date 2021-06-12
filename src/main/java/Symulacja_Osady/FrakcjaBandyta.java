package Symulacja_Osady;

import java.util.concurrent.ThreadLocalRandom;
/**
 * Implementacja frakcji, kt�ra zamiast pobiera� surowce z mapy, kradnie je innym frakcj�
 * @author Nenaki
 *
 */
public class FrakcjaBandyta extends AbstractFrakcja implements InterfaceFrakcja {
	private int zlodziej=1;
	public FrakcjaBandyta(int i) {
		super(i);
	}
	/**
	 * Nadpisuje funkcj� checkvillages
	 */
	@Override
	public void checkvillages() {
		checkvillages1();
	}
	/**
	 * Umo�liwia frakcji kra�� surowce innych frakcji
	 */
	private void checkvillages1(){
		int randomNum = ThreadLocalRandom.current().nextInt(0, Simulation.ilefrakcji());
		if(randomNum!=whatnumber()) {
			System.out.println(randomNum);
			int a = (zlodziej/2);
			this.warehouse.getRes(a, a, a, a);
			Simulation.getfrakcje(randomNum).minRes(a, a, a, a);
			zlodziej=zlodziej+1;
			GUI2.labeling2(whatnumber(),a,a,a,a);
		}
	}
}