package Symulacja_Osady;
/**
 * Implementacja frakcji, kt�rej za zadaniem jest nie wymienianie si� z innymi frakcjami
 * @author Nenaki
 *
 */
public class FrakcjaOffensive extends AbstractFrakcja implements InterfaceFrakcja {
	public FrakcjaOffensive(int i) {
		super(i);
	}
	/**
	 * Nadpisuje funkcj� doiwant
	 */
	@Override
	public Boolean doiwant(String a, String b) {
		return doiwant1();
	}
	/**
	 * Funkcja niezale�na od parametr�w, obiekt ten ma zawsze odrzuca� wymiane
	 * @return <strong>false</strong>
	 */
	private Boolean doiwant1() {
		return false;
	}
}
