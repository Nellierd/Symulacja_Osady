package Symulacja_Osady;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Implementuje interface graficzny okna ustawieñ symulacji
 * @author Nenaki
 *
 */
public class GUISettings implements ItemListener, ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JLabel frakcja1;
	private JLabel frakcja2;
	private JLabel frakcja3;
	private JLabel frakcja4;
	private JButton button;
	private JEditorPane opis;
	private JCheckBox checkbox11;
	private JCheckBox checkbox12;
	private JCheckBox checkbox13;
	private JCheckBox checkbox21;
	private JCheckBox checkbox22;
	private JCheckBox checkbox23;
	private JCheckBox checkbox31;
	private JCheckBox checkbox32;
	private JCheckBox checkbox33;
	private JCheckBox checkbox41;
	private JCheckBox checkbox42;
	private JCheckBox checkbox43;
	private int numberoffrakcje;
	
	public GUISettings(int ilewiosek)  {
		numberoffrakcje=ilewiosek;
		/**Panel do wprowadznia rozmiaru**/
		frameinitialization();
		checkboxinitialization();
		settingsinitialization();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == button) {
			frakcjainitialization();
			Simulation.setstart1();
			Map_Generator.setstart();
			new GUI2(Simulation.jakirozmiar());
			frame.setVisible(false);
		}
		
	}
	/**
	 * ItemListener, sprawdza czy dany checkbox jest zaznaczony i odznacza inne jesli to konieczne
	 */
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if(source == checkbox11 && checkbox11.isSelected() == true) {
			checkbox12.setSelected(false);
			checkbox13.setSelected(false);
		}
		if(source == checkbox12 && checkbox12.isSelected() == true) {
			checkbox11.setSelected(false);
			checkbox13.setSelected(false);
			checkbox22.setSelected(false);
			checkbox32.setSelected(false);
			checkbox42.setSelected(false);
		}
		if(source == checkbox13 && checkbox13.isSelected() == true) {
			checkbox12.setSelected(false);
			checkbox11.setSelected(false);
		}
		if(source == checkbox21 && checkbox21.isSelected() == true) {
			checkbox22.setSelected(false);
			checkbox23.setSelected(false);
		}
		if(source == checkbox22 && checkbox22.isSelected() == true) {
			checkbox21.setSelected(false);
			checkbox23.setSelected(false);
			checkbox12.setSelected(false);
			checkbox32.setSelected(false);
			checkbox42.setSelected(false);
		}
		if(source == checkbox23 && checkbox23.isSelected() == true) {
			checkbox22.setSelected(false);
			checkbox21.setSelected(false);
		}
		if(source == checkbox31 && checkbox31.isSelected() == true) {
			checkbox32.setSelected(false);
			checkbox33.setSelected(false);
		}
		if(source == checkbox32 && checkbox32.isSelected() == true) {
			checkbox31.setSelected(false);
			checkbox33.setSelected(false);
			checkbox22.setSelected(false);
			checkbox12.setSelected(false);
			checkbox42.setSelected(false);
		}
		if(source == checkbox33 && checkbox33.isSelected() == true) {
			checkbox32.setSelected(false);
			checkbox31.setSelected(false);
		}
		if(source == checkbox41 && checkbox41.isSelected() == true) {
			checkbox42.setSelected(false);
			checkbox43.setSelected(false);
		}
		if(source == checkbox42 && checkbox42.isSelected() == true) {
			checkbox41.setSelected(false);
			checkbox43.setSelected(false);
			checkbox22.setSelected(false);
			checkbox32.setSelected(false);
			checkbox12.setSelected(false);
		}
		if(source == checkbox43 && checkbox43.isSelected() == true) {
			checkbox42.setSelected(false);
			checkbox41.setSelected(false);
		}
	}
	/**
	 * Inicjalizacja ramki interface'u
	 */
	private void frameinitialization() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(445,35*numberoffrakcje+290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setTitle("Ustawienia wiosek");
	}
	/**
	 * Inicjalizacja checkboxów
	 */
	private void checkboxinitialization() {
		opis = new JEditorPane();
		opis.setContentType("text/html");
		opis.setEditable(false);
		opis.setBackground(null);
		opis.setText("Frakcje dzielimy na 3 rodzaje:<br<strong>Default</strong> - wioska domyœlna, robi to co powinna robiæ przeciêtna frakcja<br><strong>Bandyta</strong> - zamiast pobieraæ surowce z mapy kradnie surowce innym frakcj¹<br><strong>Monopol</strong> - Frakcja ta nie przyjmuje ¿adnych ofert wymiany<br><br>Nale¿y zaznaczyæ, ¿e mo¿na stworzyæ tylko jedn¹ frakcjê <strong>Bandyta</strong> w symulacj<Br>Je¿eli nie zostanie wybrany ¿adny rodzaj, frakcja zostanie stworzona z ustawieniami <strong>Default</strong>");
		opis.setBounds(10, 10, 425,200);
		panel.add(opis);
		frakcja1 = new JLabel("Frakcja 1:");
		frakcja1.setBounds(10, 210, 80, 25);
		panel.add(frakcja1);
		checkbox11 = new JCheckBox("Default");
		checkbox11.setBounds(70,210,70,25);
		checkbox11.addItemListener(this);
		panel.add(checkbox11);
		checkbox12 = new JCheckBox("Bandyta");
		checkbox12.setBounds(140,210,75,25);
		checkbox12.addItemListener(this);
		panel.add(checkbox12);
		checkbox13 = new JCheckBox("Monopol");
		checkbox13.setBounds(210,210,80,25);
		checkbox13.addItemListener(this);
		panel.add(checkbox13);
		frakcja2 = new JLabel("Frakcja 2:");
		frakcja2.setBounds(10, 245, 80, 25);
		panel.add(frakcja2);
		checkbox21 = new JCheckBox("Default");
		checkbox21.setBounds(70,245,70,25);
		checkbox21.addItemListener(this);
		panel.add(checkbox21);
		checkbox22 = new JCheckBox("Bandyta");
		checkbox22.setBounds(140,245,75,25);
		checkbox22.addItemListener(this);
		panel.add(checkbox22);
		checkbox23 = new JCheckBox("Monopol");
		checkbox23.setBounds(210,245,80,25);
		checkbox23.addItemListener(this);
		panel.add(checkbox23);
		frakcja3 = new JLabel("Frakcja 3:");
		frakcja3.setBounds(10, 280, 80, 25);
		panel.add(frakcja3);
		checkbox31 = new JCheckBox("Default");
		checkbox31.setBounds(70,280,70,25);
		checkbox31.addItemListener(this);
		panel.add(checkbox31);
		checkbox32 = new JCheckBox("Bandyta");
		checkbox32.setBounds(140,280,75,25);
		checkbox32.addItemListener(this);
		panel.add(checkbox32);
		checkbox33 = new JCheckBox("Monopol");
		checkbox33.setBounds(210,280,80,25);
		checkbox33.addItemListener(this);
		panel.add(checkbox33);
		frakcja4 = new JLabel("Frakcja 4:");
		frakcja4.setBounds(10, 315, 80, 25);
		panel.add(frakcja4);
		checkbox41 = new JCheckBox("Default");
		checkbox41.setBounds(70,315,70,25);
		checkbox41.addItemListener(this);
		panel.add(checkbox41);
		checkbox42 = new JCheckBox("Bandyta");
		checkbox42.setBounds(140,315,75,25);
		checkbox42.addItemListener(this);
		panel.add(checkbox42);
		checkbox43 = new JCheckBox("Monopol");
		checkbox43.setBounds(210,315,80,25);
		checkbox43.addItemListener(this);
		panel.add(checkbox43);
		button = new JButton("Rozpocznij");
		button.addActionListener(this);
		button.setBounds(10,35*numberoffrakcje+210,190,25);
		panel.add(button);
		frame.setVisible(true);
	}
	/**
	 * Inicjalizacja ustawieñ
	 */
	private void settingsinitialization() {
		if(numberoffrakcje<4) {
			frakcja4.setVisible(false);
			checkbox41.setVisible(false);
			checkbox42.setVisible(false);
			checkbox43.setVisible(false);
			if(numberoffrakcje<3) {
			frakcja3.setVisible(false);
			checkbox31.setVisible(false);
			checkbox32.setVisible(false);			
			checkbox33.setVisible(false);
			if(numberoffrakcje<2) {
				frakcja2.setVisible(false);
				checkbox21.setVisible(false);
				checkbox22.setVisible(false);			
				checkbox23.setVisible(false);
					}
				}
			}
	}
	/**
	 * Inicjalizuje wygenerowane frakcje
	 */
	private void frakcjainitialization() {
		for(int i=0;i<numberoffrakcje;i++) {
			if(i==0&&checkbox11.isSelected()==true) {
				Simulation.advvillagecreator(0, 0);
			}
			if(i==0&&checkbox12.isSelected()==true) {
				Simulation.advvillagecreator(0, 1);
			}
			if(i==0&&checkbox13.isSelected()==true) {
				Simulation.advvillagecreator(0, 2);
			}
			if(i==0&&checkbox13.isSelected()==false&&checkbox12.isSelected()==false&&checkbox13.isSelected()==false) {
				Simulation.advvillagecreator(0, 0);
			}
			if(i==1&&checkbox21.isSelected()==true) {
				Simulation.advvillagecreator(1, 0);
			}
			if(i==1&&checkbox22.isSelected()==true) {
				Simulation.advvillagecreator(1, 1);
			}
			if(i==1&&checkbox23.isSelected()==true) {
				Simulation.advvillagecreator(1, 2);
			}
			if(i==1&&checkbox23.isSelected()==false&&checkbox22.isSelected()==false&&checkbox23.isSelected()==false) {
				Simulation.advvillagecreator(1, 0);
			}
			if(i==2&&checkbox31.isSelected()==true) {
				Simulation.advvillagecreator(2, 0);
			}
			if(i==2&&checkbox32.isSelected()==true) {
				Simulation.advvillagecreator(2, 1);
			}
			if(i==2&&checkbox33.isSelected()==true) {
				Simulation.advvillagecreator(2, 2);
			}
			if(i==2&&checkbox33.isSelected()==false&&checkbox32.isSelected()==false&&checkbox33.isSelected()==false) {
				Simulation.advvillagecreator(2, 0);
			}
			if(i==3&&checkbox41.isSelected()==true) {
				Simulation.advvillagecreator(3, 0);
			}
			if(i==3&&checkbox42.isSelected()==true) {
				Simulation.advvillagecreator(3, 1);
			}
			if(i==3&&checkbox43.isSelected()==true) {
				Simulation.advvillagecreator(3, 2);
			}
			if(i==3&&checkbox43.isSelected()==false&&checkbox42.isSelected()==false&&checkbox43.isSelected()==false) {
				Simulation.advvillagecreator(3, 0);
			}
		}
	}
}
