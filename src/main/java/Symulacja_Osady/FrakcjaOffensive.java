package Symulacja_Osady;

public class FrakcjaOffensive extends AbstractFrakcja implements InterfaceFrakcja {
	public FrakcjaOffensive(int i) {
		super(i);
	}
	@Override
	public Boolean doiwant(String a, String b) {
		System.out.println("NIGDY SIE NIE WYMIENIAM");
		return false;
	}
}
