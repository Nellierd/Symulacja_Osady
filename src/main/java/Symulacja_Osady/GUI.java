package Symulacja_Osady;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Graficzny interface s³u¿¹cy do wprowadzania parametrów symulacji.
 * @author Nenaki
 *
 */
public class GUI implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JEditorPane opis;
	private JLabel rozmiarlabel;
	private JLabel rozmiarlabel1;
	private JTextField rozmiartext;
	private JLabel surowcelabel;
	private JLabel surowcelabel1;
	private JTextField inkrementacjatext;
	private JButton button;
	private JButton button1;
	private JLabel frakcjelabel;
	private JLabel frakcjelabel1;
	private JTextField frakcjetext;

	public GUI() {
		frameinitialization();
		labelsbinitialization();
		buttoninitialization();
	}
	/**
	 * ActionListener, sprawdza który przycisk zosta³ wcisniêty.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		try {
			Simulation.setjakirozmiar(Integer.parseInt(rozmiartext.getText()));
			try {
				Simulation.setilefrakcji(Integer.parseInt(frakcjetext.getText()));
				try {
					Simulation.setinkrementacje(Integer.parseInt(inkrementacjatext.getText()));
					try {
						if((Integer.parseInt(rozmiartext.getText())==1&&Integer.parseInt(frakcjetext.getText())==1)||(Integer.parseInt(rozmiartext.getText())>1&&Integer.parseInt(frakcjetext.getText())<5)) {
						if(source == button)
						{ 
							Simulation.defaultvillagescreator();
							Simulation.setstart1();
							new GUI2(Simulation.jakirozmiar());
							frame.setVisible(false);
						}
						if(source == button1) {
							frame.setVisible(false);
							new GUISettings(Integer.parseInt(frakcjetext.getText()));
						}
						}
					} catch (NumberFormatException f) {}
				} catch (NumberFormatException f) {}
			} catch (NumberFormatException f) {}
		} catch (NumberFormatException f) {
		}
	}
	/**
	 * Inicjalizacja ramki
	 */
	private void frameinitialization() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(465,470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setResizable(false);
		frame.setTitle("Symulacja Osady - Konrad Ziêba");
	}
	/**
	 * Inicjalizacja reszty komponentów graficznych
	 */
	private void labelsbinitialization() {
		opis = new JEditorPane();
		opis.setContentType("text/html");
		opis.setEditable(false);
		opis.setBackground(null);
		opis.setText("Program prostej symulacji przedstawiaj¹cy zachowanie frakcji walcz¹cych o przejêcie jak najwiekszego terenu na mapie w kszta³cie kwadratu (aXa).<br><br>W celu winicjalizacji symulacji proszê o wprowadzenie (liczby ca³kowite):<br><strong>Rozmiaru mapy</strong> - wprowadz d³ugoœæ boku planszy (iloœæ pól)<br><strong>Iloœæ frakcji</strong> - ile frakcji ma wzi¹œæ udzia³ w symulacji <br><strong>Iloœæ iteracji</strong> - ile wynosi maksylamna liczba iteracji <br><br>W celu rozpoczêcia proszê wybraæ rodzaj symulacji:<br><strong>Domyœlna symulacja</strong> - frakcje zachowuj¹ siê identycznie<br><strong>Symulacja zaawansowana</strong> - wybierz rodzaj frakcji jakie maj¹ wzi¹œæ udzia³ w symulacji ");
		//()
		opis.setBounds(10, 10, 425,250);
		panel.add(opis);
		rozmiarlabel = new JLabel("Rozmiar:");
		rozmiarlabel.setBounds(10, 270, 80, 25);
		panel.add(rozmiarlabel);
		rozmiarlabel1 = new JLabel("(Wprowadz wartoœæ <4-15>)");
		rozmiarlabel1.setBounds(275, 270, 180, 25);
		panel.add(rozmiarlabel1);
		rozmiartext = new JTextField(20);
		rozmiartext.setBounds(100,270,165,25);
		rozmiartext.setOpaque(true);
		panel.add(rozmiartext);
		/**Panel do wprowadznia frakcji**/
		frakcjelabel = new JLabel("Frakcje:");
		frakcjelabel.setBounds(10, 300, 80, 25);
		frakcjelabel1 = new JLabel("(Wprowadz wartoœæ <1-4>)");
		frakcjelabel1.setBounds(275, 300, 180, 25);
		panel.add(frakcjelabel1);
		frakcjetext = new JTextField(20);
		frakcjetext.setBounds(100,300,165,25);
		panel.add(frakcjetext);
		/**Panel do wprowadznia surowców**/
		surowcelabel = new JLabel("Inkrementacja:");
		surowcelabel.setBounds(10, 330, 100, 25);
		surowcelabel1 = new JLabel("(Wprowadz wartoœæ x>=0)");
		surowcelabel1.setBounds(275, 330, 180, 25);
		panel.add(surowcelabel1);
		inkrementacjatext = new JTextField(20);
		inkrementacjatext.setBounds(100,330,165,25);
		panel.add(inkrementacjatext);
		panel.add(surowcelabel);
		panel.add(frakcjelabel);
	}
	/**
	 * Inicjalizacja przycisków
	 */
	private void buttoninitialization() {
		button = new JButton("Symulacja domyœlna");
		button.addActionListener(this);
		button.setBounds(110,360,190,25);
		panel.add(button);
		button1 = new JButton("Symulacja zaawansowana");
		button1.addActionListener(this);
		button1.setBounds(110,395,190,25);
		panel.add(button1);
		frame.setVisible(true);
	}
}