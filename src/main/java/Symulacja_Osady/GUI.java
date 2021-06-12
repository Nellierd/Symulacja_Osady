/**
 * 
 */
package Symulacja_Osady;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Nenaki
 *
 */
public class GUI implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
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
	private JLabel buttonlabel;
	private JLabel buttonlabel1;

	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(465,220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setTitle("Symulacja Osady - Konrad Ziêba");
		
		/**Panel do wprowadznia rozmiaru**/
		rozmiarlabel = new JLabel("Rozmiar:");
		rozmiarlabel.setBounds(10, 20, 80, 25);
		panel.add(rozmiarlabel);
		rozmiarlabel1 = new JLabel("(Wprowadz wartoœæ <4-15>)");
		rozmiarlabel1.setBounds(275, 20, 180, 25);
		panel.add(rozmiarlabel1);

		rozmiartext = new JTextField(20);
		rozmiartext.setBounds(100,20,165,25);
		panel.add(rozmiartext);
		/**Panel do wprowadznia frakcji**/
		frakcjelabel = new JLabel("Frakcje:");
		frakcjelabel.setBounds(10, 50, 80, 25);
		frakcjelabel1 = new JLabel("(Wprowadz wartoœæ <1-4>)");
		frakcjelabel1.setBounds(275, 50, 180, 25);
		panel.add(frakcjelabel1);
		frakcjetext = new JTextField(20);
		frakcjetext.setBounds(100,50,165,25);
		panel.add(frakcjetext);
		/**Panel do wprowadznia surowców**/
		surowcelabel = new JLabel("Inkrementacja:");
		surowcelabel.setBounds(10, 80, 100, 25);
		surowcelabel1 = new JLabel("(Wprowadz wartoœæ x>0)");
		surowcelabel1.setBounds(275, 80, 180, 25);
		panel.add(surowcelabel1);
		
		inkrementacjatext = new JTextField(20);
		inkrementacjatext.setBounds(100,80,165,25);
		

		button = new JButton("Symulacja domyœlna");
		button.addActionListener(this);
		button.setBounds(10,110,190,25);
		panel.add(button);
		buttonlabel = new JLabel("(Zachowanie wiosek <Default>)");
		buttonlabel.setBounds(210, 110, 180, 25);
		panel.add(buttonlabel);
		
		button1 = new JButton("Symulacja zaawansowana");
		button1.addActionListener(this);
		button1.setBounds(10,145,190,25);
		panel.add(button1);
		buttonlabel1 = new JLabel("(Ustaw zachowanie)");
		buttonlabel1.setBounds(210, 145, 180, 25);
		panel.add(buttonlabel1);
		panel.add(inkrementacjatext);
		panel.add(surowcelabel);
		panel.add(frakcjelabel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		Simulation.setjakirozmiar(Integer.parseInt(rozmiartext.getText()));
		Simulation.setilefrakcji(Integer.parseInt(frakcjetext.getText()));
		Simulation.setinkrementacje(Integer.parseInt(inkrementacjatext.getText()));
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
}