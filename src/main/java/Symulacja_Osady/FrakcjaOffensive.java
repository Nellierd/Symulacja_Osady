package Symulacja_Osady;
/**
 * Implementacja frakcji, której za zadaniem jest nie wymienianie siê z innymi frakcjami
 * @author Nenaki
 *
 */
public class FrakcjaOffensive extends AbstractFrakcja implements InterfaceFrakcja {
	public FrakcjaOffensive(int i) {
		super(i);
	}
	/**
	 * Nadpisuje funkcjê doiwant
	 */
	@Override
	public Boolean doiwant(String a, String b) {
		return doiwant1();
	}
	/**
	 * Funkcja niezale¿na od parametrów, obiekt ten ma zawsze odrzucaæ wymiane
	 * @return <strong>false</strong>
	 */
	private Boolean doiwant1() {
		return false;
	}
}
