package Symulacja_Osady;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import Symulacja_Osady.GradeRenderer;
import Symulacja_Osady.GUI;
import Symulacja_Osady.Map_Generator;

public class GUI2 implements ActionListener {
	public static JTable table;
	public static JTable table1;
	public static JTable table2;
	public JFrame frame1;
	public JPanel panel1;
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JLabel frakcja1;
	public JLabel frakcja2;
	public JLabel frakcja3;
	public JLabel frakcja4;
	public static JLabel stone1;
	public static JLabel iron1;
	public static JLabel wood1;
	public static JLabel clay1;
	public static JLabel stone11;
	public static JLabel iron11;
	public static JLabel wood11;
	public static JLabel clay11;
	public static JLabel stone2;
	public static JLabel iron2;
	public static JLabel wood2;
	public static JLabel clay2;
	public static JLabel stone21;
	public static JLabel iron21;
	public static JLabel wood21;
	public static JLabel clay21;
	public static JLabel stone3;
	public static JLabel iron3;
	public static JLabel wood3;
	public static JLabel clay3;
	public static JLabel stone31;
	public static JLabel iron31;
	public static JLabel wood31;
	public static JLabel clay31;
	public static JLabel stone4;
	public static JLabel iron4;
	public static JLabel wood4;
	public static JLabel clay4;
	public static JLabel stone41;
	public static JLabel iron41;
	public static JLabel wood41;
	public static JLabel clay41;
	public Object data[][];
	public DefaultTableModel model;
	public DefaultTableModel model1;
	public DefaultTableModel model2;
	public static int rozmiarplanszy;
	public Map_Generator map1;
	public GUI2(int size) {
		int xbounds=50*size;
		rozmiarplanszy=size;
		frame1 = new JFrame();
		panel1 = new JPanel();
		frame1.setSize(3*xbounds+105,xbounds+250);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(panel1);
		panel1.setLayout(null);
		frame1.setVisible(true);

		model = new DefaultTableModel(); 
		table = new JTable(model);
		model1 = new DefaultTableModel();  
		table1 = new JTable(model1); 
		model2 = new DefaultTableModel();  
		table2 = new JTable(model2);

		// Create a couple of columns 
		for (int i=0;i<size;i++)
		{
		model.addColumn("");
		model.addRow(new Object[] {});
		model1.addColumn("");
		model1.addRow(new Object[] {});
		model2.addColumn("");
		model2.addRow(new Object[] {});
		}

        table.setRowHeight(50);
		table.setBounds(20, 50, xbounds, xbounds);
		table.setEnabled(false);
        table1.setRowHeight(50);
		table1.setBounds(xbounds+40, 50, xbounds, xbounds);
		table1.setEnabled(false);
	    table2.setRowHeight(50);
	    table2.setBounds(2*xbounds+60, 50, xbounds, xbounds);
		table2.setEnabled(false);
		//table1.setOpaque(true);
		//table.setOpaque(true);
       // table1.setBackground(null);
        panel1.add(table);
        panel1.add(table1);
        panel1.add(table2);
		button1 = new JButton("Generuj");
		button1.addActionListener(this);
		button1.setBounds(10,xbounds+60,120,25);
		button2 = new JButton("Rozpocznij");
		button2.addActionListener(this);
		button2.setBounds(10,xbounds+60,120,25);
		button3 = new JButton("Zatrzymaj");
		button3.addActionListener(this);
		button3.setBounds(10,xbounds+60,120,25);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		button2.setVisible(false);
		button3.setVisible(false);
		table.setDefaultRenderer(Object.class,new GradeRenderer());
		//table1.setDefaultRenderer(Object.class,new GradeRenderer());
		frakcja1 = new JLabel("Frakcja I");
		frakcja1.setOpaque(true);
		frakcja1.setBackground(Color.RED);
		frakcja1.setBounds(10, xbounds+90, 90, 25);
		panel1.add(frakcja1);
		stone1 = new JLabel("0");
		stone1.setBounds(10, xbounds+110, 80, 25);
		panel1.add(stone1);
		iron1 = new JLabel("0");
		iron1.setBounds(10, xbounds+130, 80, 25);
		panel1.add(iron1);
		wood1 = new JLabel("0");
		wood1.setBounds(10, xbounds+150, 80, 25);
		panel1.add(wood1);
		clay1 = new JLabel("0");
		clay1.setBounds(10, xbounds+170, 80, 25);
		panel1.add(clay1);
		stone11 = new JLabel("(+0)");
		stone11.setBounds(70, xbounds+110, 80, 25);
		panel1.add(stone11);
		iron11 = new JLabel("(+0)");
		iron11.setBounds(70, xbounds+130, 80, 25);
		panel1.add(iron11);
		wood11 = new JLabel("(+0)");
		wood11.setBounds(70, xbounds+150, 80, 25);
		panel1.add(wood11);
		clay11 = new JLabel("(+0)");
		clay11.setBounds(70, xbounds+170, 80, 25);
		panel1.add(clay11);
		frakcja2 = new JLabel("Frakcja II");
		frakcja2.setOpaque(true);
		frakcja2.setBackground(Color.BLUE);
		frakcja2.setBounds(110, xbounds+90, 90, 25);
		panel1.add(frakcja2);
		stone2 = new JLabel("0");
		stone2.setBounds(110, xbounds+110, 80, 25);
		panel1.add(stone2);
		iron2 = new JLabel("0");
		iron2.setBounds(110, xbounds+130, 80, 25);
		panel1.add(iron2);
		wood2 = new JLabel("0");
		wood2.setBounds(110, xbounds+150, 80, 25);
		panel1.add(wood2);
		clay2 = new JLabel("0");
		clay2.setBounds(110, xbounds+170, 80, 25);
		panel1.add(clay2);
		stone21 = new JLabel("(+0)");
		stone21.setBounds(170, xbounds+110, 80, 25);
		panel1.add(stone21);
		iron21 = new JLabel("(+0)");
		iron21.setBounds(170, xbounds+130, 80, 25);
		panel1.add(iron21);
		wood21 = new JLabel("(+0)");
		wood21.setBounds(170, xbounds+150, 80, 25);
		panel1.add(wood21);
		clay21 = new JLabel("(+0)");
		clay21.setBounds(170, xbounds+170, 80, 25);
		panel1.add(clay21);
		Boolean x1=false;
		Boolean x2=false;
		if (Simulation.frakcje==4) {
			x1=true;
			x2=true;
		}
		if(Simulation.frakcje==3) {
			x2=true;
		}
		if(x2==true){
			frakcja3 = new JLabel("Frakcja III");
			frakcja3.setOpaque(true);
			frakcja3.setBackground(Color.CYAN);
			frakcja3.setBounds(210, xbounds+90, 90, 25);
			panel1.add(frakcja3);
			stone3 = new JLabel("0");
			stone3.setBounds(210, xbounds+110, 80, 25);
			panel1.add(stone3);
			iron3 = new JLabel("0");
			iron3.setBounds(210, xbounds+130, 80, 25);
			panel1.add(iron3);
			wood3 = new JLabel("0");
			wood3.setBounds(210, xbounds+150, 80, 25);
			panel1.add(wood3);
			clay3 = new JLabel("0");
			clay3.setBounds(210, xbounds+170, 80, 25);
			panel1.add(clay3);
			stone31 = new JLabel("(+0)");
			stone31.setBounds(270, xbounds+110, 80, 25);
			panel1.add(stone31);
			iron31 = new JLabel("(+0)");
			iron31.setBounds(270, xbounds+130, 80, 25);
			panel1.add(iron31);
			wood31 = new JLabel("(+0)");
			wood31.setBounds(270, xbounds+150, 80, 25);
			panel1.add(wood31);
			clay31 = new JLabel("(+0)");
			clay31.setBounds(270, xbounds+170, 80, 25);
			panel1.add(clay31);
		}
		if(x1==true){
			frakcja4 = new JLabel("Frakcja IV");
			frakcja4.setOpaque(true);
			frakcja4.setBackground(Color.MAGENTA);
			frakcja4.setBounds(310, xbounds+90, 90, 25);
			stone4 = new JLabel("0");
			stone4.setBounds(310, xbounds+110, 80, 25);
			panel1.add(stone4);
			iron4 = new JLabel("0");
			iron4.setBounds(310, xbounds+130, 80, 25);
			panel1.add(iron4);
			wood4 = new JLabel("0");
			wood4.setBounds(310, xbounds+150, 80, 25);
			panel1.add(wood4);
			clay4 = new JLabel("0");
			clay4.setBounds(310, xbounds+170, 80, 25);
			panel1.add(clay4);
			panel1.add(frakcja4);
			stone41 = new JLabel("(+0)");
			stone41.setBounds(370, xbounds+110, 80, 25);
			panel1.add(stone41);
			iron41 = new JLabel("(+0)");
			iron41.setBounds(370, xbounds+130, 80, 25);
			panel1.add(iron41);
			wood41 = new JLabel("(+0)");
			wood41.setBounds(370, xbounds+150, 80, 25);
			panel1.add(wood41);
			clay41 = new JLabel("(+0)");
			clay41.setBounds(370, xbounds+170, 80, 25);
			panel1.add(clay41);
		}
		frame1.setResizable(false);
		frame1.setVisible(true);
		
		
	
	}
	//sprawdzanie jaki surowiec jest na danym polu
	public static int whatresources(int x,int y) {
		if (x<0||x==Simulation.rozmiar||y<0||y==Simulation.rozmiar) {
			return 0;
		}
		if(table2.getValueAt(x, y)=="1") {
			return 1;
		}
		if(table2.getValueAt(x, y)=="2") {
			return 2;
		}
		if(table2.getValueAt(x, y)=="3") {
			return 3;
		}
		if(table2.getValueAt(x, y)=="4") {
			return 4;
		}
		else {
			return 0;
		}
	}
	/**
	 * Funkcja sprawdzazj¹ca czy na danym polu jest wybudowana droga
	 * @param x kolumna
	 * @param y wiersz
	 * @return <strong>true</strong> - jeœli na danym polu znajduje siê droga<BR>
	 * <strong>false</strong> - jjeœli na danym polu nie ma drogi
	 */
	public static Boolean isroad(int x,int y) {
		
		if (x<0||x==Simulation.rozmiar||y<0||y==Simulation.rozmiar) {
			return null;
		}
		if(table.getValueAt(x, y)=="Road11") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road21") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road31") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road41") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road12") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road22") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road32") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road42") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road13") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road23") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road33") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road43") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road14") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road24") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road34") {
			return true;
		}
		if(table.getValueAt(x, y)=="Road44") {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Sprawdza czy w okolicy danego pola znajduje siê jakaœ Wioska
	 * @param x kolumna
	 * @param y wiersz
	 * @return <strong>true</strong> - jeœli w poli¿u danego pola znajduje siê wioska<BR>
	 * <strong>false</strong> - jeœli w pobli¿u danego pola nie znajduje siê wioska
	 */
	public static Boolean isvillage(int x,int y) {
		/**
		 * Funkcja sprawdzazj¹ca czy na danym polu jest wybudowana droga
		 */
		if (x<0||x==Simulation.rozmiar||y<0||y==Simulation.rozmiar) {
			System.out.println("POZA GRANICAMI WSZECHSWIATA");
			return true;
		}
		x=x+1;
		if(x<rozmiarplanszy&&y<rozmiarplanszy&&y>=0&&x>=0) {
			if(table.getValueAt(x, y)=="O11"||table.getValueAt(x, y)=="O12"||table.getValueAt(x, y)=="O13"||table.getValueAt(x, y)=="O14"||table.getValueAt(x, y)=="O21"||table.getValueAt(x, y)=="O22"||table.getValueAt(x, y)=="O23"||table.getValueAt(x, y)=="O24"||table.getValueAt(x, y)=="O31"||table.getValueAt(x, y)=="O32"||table.getValueAt(x, y)=="O33"||table.getValueAt(x, y)=="O34"||table.getValueAt(x, y)=="O41"||table.getValueAt(x, y)=="O42"||table.getValueAt(x, y)=="O43"||table.getValueAt(x, y)=="O44") {
				System.out.println("TUTAJ JEST WIOSKA: "+x+","+y);
				return true;
			}
		}
		x=x-2;
		if(x<rozmiarplanszy&&y<rozmiarplanszy&&y>=0&&x>=0) {
			if(table.getValueAt(x, y)=="O11"||table.getValueAt(x, y)=="O12"||table.getValueAt(x, y)=="O13"||table.getValueAt(x, y)=="O14"||table.getValueAt(x, y)=="O21"||table.getValueAt(x, y)=="O22"||table.getValueAt(x, y)=="O23"||table.getValueAt(x, y)=="O24"||table.getValueAt(x, y)=="O31"||table.getValueAt(x, y)=="O32"||table.getValueAt(x, y)=="O33"||table.getValueAt(x, y)=="O34"||table.getValueAt(x, y)=="O41"||table.getValueAt(x, y)=="O42"||table.getValueAt(x, y)=="O43"||table.getValueAt(x, y)=="O44") {
				System.out.println("TUTAJ JEST WIOSKA: "+x+","+y);
				return true;
			}
		}
		x=x+1;
		y=y+1;
		if(x<rozmiarplanszy&&y<rozmiarplanszy&&y>=0&&x>=0) {
			if(table.getValueAt(x, y)=="O11"||table.getValueAt(x, y)=="O12"||table.getValueAt(x, y)=="O13"||table.getValueAt(x, y)=="O14"||table.getValueAt(x, y)=="O21"||table.getValueAt(x, y)=="O22"||table.getValueAt(x, y)=="O23"||table.getValueAt(x, y)=="O24"||table.getValueAt(x, y)=="O31"||table.getValueAt(x, y)=="O32"||table.getValueAt(x, y)=="O33"||table.getValueAt(x, y)=="O34"||table.getValueAt(x, y)=="O41"||table.getValueAt(x, y)=="O42"||table.getValueAt(x, y)=="O43"||table.getValueAt(x, y)=="O44") {
				System.out.println("TUTAJ JEST WIOSKA: "+x+","+y);
				return true;
			}
		}
		y=y-2;
		if(x<rozmiarplanszy&&y<rozmiarplanszy&&y>=0&&x>=0) {
			if(table.getValueAt(x, y)=="O11"||table.getValueAt(x, y)=="O12"||table.getValueAt(x, y)=="O13"||table.getValueAt(x, y)=="O14"||table.getValueAt(x, y)=="O21"||table.getValueAt(x, y)=="O22"||table.getValueAt(x, y)=="O23"||table.getValueAt(x, y)=="O24"||table.getValueAt(x, y)=="O31"||table.getValueAt(x, y)=="O32"||table.getValueAt(x, y)=="O33"||table.getValueAt(x, y)=="O34"||table.getValueAt(x, y)=="O41"||table.getValueAt(x, y)=="O42"||table.getValueAt(x, y)=="O43"||table.getValueAt(x, y)=="O44") {
				System.out.println("TUTAJ JEST WIOSKA: "+x+","+y);
				return true;
			}
		}
			return false;
		}
	/**
	 * Funkcja sprawdzaj¹ca czy na danym polu mo¿na coœ wybudowaæ
	 * @param x kolumna
	 * @param y wiersz
	 * @return <strong>true</strong> - jeœli na danym polu mo¿na wybudowaæ obiekt<BR>
	 * <strong>false</strong> - jeœli na danym polu nie mo¿na wybudwaæ obiektu
	 */
	public static Boolean canibuild(int x,int y) {
		if (x<0||x>=Simulation.rozmiar||y<0||y>=Simulation.rozmiar) {
			return false;
		}
		if(table.getValueAt(x, y)=="1"||table.getValueAt(x, y)=="2"||table.getValueAt(x, y)=="3"||table.getValueAt(x, y)=="4") {
			return true;
		}
		else {
			return false;
		}
	}
	public static void putvaluetab(String s,int x, int y) {
		putvaluetab1(s, x, y);
	}
	private static void putvaluetab1(String s,int x, int y) {
		table.setValueAt(s, x, y);
	}
	public static String getvaluetab(int x, int y) {
		Object abc =table.getValueAt(x, y);
		return abc.toString();
	}
	public static void labeling(int n,int s,int i, int w, int c) {
		if(n==0) {
			stone1.setText(String.valueOf(s));
			iron1.setText(String.valueOf(i));
			wood1.setText(String.valueOf(w));
			clay1.setText(String.valueOf(c));
		}
		if(n==1) {
			stone2.setText(String.valueOf(s));
			iron2.setText(String.valueOf(i));
			wood2.setText(String.valueOf(w));
			clay2.setText(String.valueOf(c));
		}
		if(n==2) {
			stone3.setText(String.valueOf(s));
			iron3.setText(String.valueOf(i));
			wood3.setText(String.valueOf(w));
			clay3.setText(String.valueOf(c));
		}
		if(n==3) {
			stone4.setText(String.valueOf(s));
			iron4.setText(String.valueOf(i));
			wood4.setText(String.valueOf(w));
			clay4.setText(String.valueOf(c));
		}
	}
	public static void labeling2(int n,int s,int i, int w, int c) {
		String x="(+";
		String d=")";
		if(n==0) {
			
			stone11.setText(String.valueOf(x+s+d));
			iron11.setText(String.valueOf(x+i+d));
			wood11.setText(String.valueOf(x+w+d));
			clay11.setText(String.valueOf(x+c+d));
		}
		if(n==1) {
			stone21.setText(String.valueOf(x+s+d));
			iron21.setText(String.valueOf(x+i+d));
			wood21.setText(String.valueOf(x+w+d));
			clay21.setText(String.valueOf(x+c+d));
		}
		if(n==2) {
			stone31.setText(String.valueOf(x+s+d));
			iron31.setText(String.valueOf(x+i+d));
			wood31.setText(String.valueOf(x+w+d));
			clay31.setText(String.valueOf(x+c+d));
		}
		if(n==3) {
			stone41.setText(String.valueOf(x+s+d));
			iron41.setText(String.valueOf(x+i+d));
			wood41.setText(String.valueOf(x+w+d));
			clay41.setText(String.valueOf(x+c+d));
		}
	}
	/**
	 * Funkcja sprawdzaj¹ca, czy mapa zosta³a zape³niona
	 * @param mapsize - rozmiar mapy wprowadzony na pocz¹tku symulacji
	 * @return <strong> true </strong>- je¿eli mapa zosta³a zape³niona <BR>
	 * <strong> false </strong>- je¿eli na mapie znajduj¹ siê pola które mo¿na zape³niæ
	 */
	public static Boolean isfull(int mapsize){
		System.out.println("Sprawdzam czy plansza jest zapelniona");
		for(int i=0;i<mapsize;i++) {
			for(int j=0;j<mapsize;j++) {
				if(table.getValueAt(i, j)=="1"||table.getValueAt(i, j)=="2"||table.getValueAt(i, j)=="3"||table.getValueAt(i, j)=="4") {
					System.out.println("Plansza nie zapelniona");
					return false;
				}
			}
		}
		System.out.println("Plansza zape³niona");
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == button1)
		{ 	
			//GUI2.data[0][1]="0";
			Simulation.start=true;
			int size=Simulation.rozmiar;
			int num=Simulation.frakcje;
			map1 = new Map_Generator(size,num);	
			button1.setVisible(false);
			button2.setVisible(true);
			//Component component = table.getComponentAt(1, 1);
			//component.getBackground();
				//System.out.println("CZERWONY");
		}
		if(source == button2) {
			Simulation.kontynuuj=true;
			button2.setVisible(false);
			button3.setVisible(true);
			button2.setText("Kontynuuj");
		}
		if(source == button3) {
			Simulation.kontynuuj=false;
			button3.setVisible(false);
			button2.setVisible(true);
			System.out.println("SYMULACJA WSTRZYMANA");
		}
	}
}

