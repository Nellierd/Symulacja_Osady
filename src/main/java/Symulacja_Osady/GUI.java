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
	
	public JFrame frame;
	public JPanel panel;
	public JLabel rozmiarlabel;
	public JTextField rozmiartext;
	public JLabel surowcelabel;
	public JTextField inkrementacjatext;
	public JButton button;
	public JLabel success;
	public JLabel frakcjelabel;
	public JTextField frakcjetext;


	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(295,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		
		/**Panel do wprowadznia rozmiaru**/
		rozmiarlabel = new JLabel("Rozmiar:");
		rozmiarlabel.setBounds(10, 20, 80, 25);
		panel.add(rozmiarlabel);

		rozmiartext = new JTextField(20);
		rozmiartext.setBounds(100,20,165,25);
		panel.add(rozmiartext);
		/**Panel do wprowadznia frakcji**/
		frakcjelabel = new JLabel("Frakcje:");
		frakcjelabel.setBounds(10, 50, 80, 25);
		
		
		frakcjetext = new JTextField(20);
		frakcjetext.setBounds(100,50,165,25);
		panel.add(frakcjetext);
		/**Panel do wprowadznia surowców**/
		surowcelabel = new JLabel("Inkrementacja:");
		surowcelabel.setBounds(10, 80, 100, 25);
		

		
		inkrementacjatext = new JTextField(20);
		inkrementacjatext.setBounds(100,80,165,25);
		

		button = new JButton("Symulacja");
		button.addActionListener(this);
		button.setBounds(20,110,120,25);
		panel.add(button);
		
		JLabel success = new JLabel("10");
		success.setBounds(20,110,300,25);
		panel.add(success);
		panel.add(inkrementacjatext);
		panel.add(surowcelabel);
		panel.add(frakcjelabel);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == button)
		{ 
			/**Zamiana Stringa na Int**/
			Simulation.rozmiar = Integer.parseInt(rozmiartext.getText());
			Simulation.frakcje = Integer.parseInt(frakcjetext.getText());
			Simulation.inkrementacja = Integer.parseInt(inkrementacjatext.getText());
			Simulation.start1 = true;
			new GUI2(Simulation.rozmiar);
			frame.setVisible(false);
		}
		
	}
}