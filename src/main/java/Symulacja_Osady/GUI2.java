package Symulacja_Osady;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Implementacja interface''u graficznego dla symulacji
 * @author Nenaki
 *
 */
public class GUI2 implements ActionListener{
	private static JTable table;
	private static JTable table2;
	private JFrame frame1;
	private JPanel panel1;
	private static JButton button1;
	private static JButton button2;
	private static JButton button3;
	private static JButton button4;
	private JLabel frakcja1;
	private JLabel frakcja2;
	private JLabel frakcja3;
	private JLabel frakcja4;
	private static JLabel stone1;
	private static JLabel iron1;
	private static JLabel wood1;
	private static JLabel clay1;
	private static JLabel stone11;
	private static JLabel iron11;
	private static JLabel wood11;
	private static JLabel clay11;
	private static JLabel stone2;
	private static JLabel iron2;
	private static JLabel wood2;
	private static JLabel clay2;
	private static JLabel stone21;
	private static JLabel iron21;
	private static JLabel wood21;
	private static JLabel clay21;
	private static JLabel stone3;
	private static JLabel iron3;
	private static JLabel wood3;
	private static JLabel clay3;
	private static JLabel stone31;
	private static JLabel iron31;
	private static JLabel wood31;
	private static JLabel clay31;
	private static JLabel stone4;
	private static JLabel iron4;
	private static JLabel wood4;
	private static JLabel clay4;
	private static JLabel stone41;
	private static JLabel iron41;
	private static JLabel wood41;
	private static JLabel clay41;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private static int rozmiarplanszy;
	public Map_Generator map1;
	private int xbounds;
	public GUI2(int size) {
		xbounds=50*size;
		rozmiarplanszy=size;
		guiinitialization();
		scoreinitialization();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == button1)
		{ 	
			Simulation.setstart();
			map1 = new Map_Generator( Simulation.jakirozmiar(),Simulation.ilefrakcji());	
			button1.setVisible(false);
			button2.setVisible(true);
		}
		if(source == button2) {
			Simulation.setcontinuetrue();
			button2.setVisible(false);
			button3.setVisible(true);
			button2.setText("Kontynuuj");
		}
		if(source == button3) {
			Simulation.setcontinuefalse();
			button3.setVisible(false);
			button2.setVisible(true);
		}
		if(source == button4) {
			System.exit(0);
		}
	}
	public static int whatresources(int x,int y) {
		return whatresources1(x,y);
	}
	public static Boolean isroad(int x,int y) {
		return isroad1(x,y);
	}
	public static Boolean isvillage(int x,int y) {
		return isvillage1(x,y);
	}
	public static Boolean canibuild(int x,int y) {
		return canibuild1(x,y);
	}
	public static void putvaluetab(String s,int x, int y) {
		putvaluetab1(s, x, y);
	}
	public static void putvaluetab2(String s,int x, int y) {
		putvaluetab21(s, x, y);
	}
	public static String getvaluetab2(int x, int y) {
		return getvaluetab21(x,y);
	}
	public static void labeling(int n,int s,int i, int w, int c) {
		labeling1(n,s,i,w,c);
	}
	public static Boolean isfull(int mapsize) {
		return isfull1(mapsize);
	}
	public static String getvaluetab(int x, int y) {
		Object abc =table.getValueAt(x, y);
		return abc.toString();
	}
	public static void labeling2(int n,int s,int i, int w, int c) {
		labeling21(n,s,i,w,c);
	}
	public static void simfinished() {
		simfinished1();
	}
	/**
	 * Inicjalizacja komponentów interface'u
	 */
	private void guiinitialization() {
		frame1 = new JFrame();
		panel1 = new JPanel();
		frame1.setSize(xbounds+75,xbounds+250);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(panel1);
		panel1.setLayout(null);
		frame1.setVisible(true);
		model = new DefaultTableModel(); 
		table = new JTable(model);
		model2 = new DefaultTableModel();  
		table2 = new JTable(model2);
		for (int i=0;i<rozmiarplanszy;i++)
		{
		model.addColumn("");
		model.addRow(new Object[] {});
		model2.addColumn("");
		model2.addRow(new Object[] {});
		}
        table.setRowHeight(50);
		table.setBounds(20, 50, xbounds, xbounds);
		table.setEnabled(false);
        panel1.add(table);
		button1 = new JButton("Generuj");
		button1.addActionListener(this);
		button1.setBounds(10,xbounds+60,120,25);
		button2 = new JButton("Rozpocznij");
		button2.addActionListener(this);
		button2.setBounds(10,xbounds+60,120,25);
		button3 = new JButton("Zatrzymaj");
		button3.addActionListener(this);
		button3.setBounds(10,xbounds+60,120,25);
		button4 = new JButton("Zakoñcz");
		button4.addActionListener(this);
		button4.setBounds(10,xbounds+60,120,25);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		button2.setVisible(false);
		button3.setVisible(false);
		button4.setVisible(false);
		table.setDefaultRenderer(Object.class,new BoardRenderer());
	}
	/**
	 * Inicjalizacja wyników
	 */
	private void scoreinitialization() {
		Boolean x1=false;
		Boolean x2=false;
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
		if(Simulation.ilefrakcji()>1) {
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
		}
		if (Simulation.ilefrakcji()==4) {
			x1=true;
			x2=true;
		}
		if(Simulation.ilefrakcji()==3) {
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
		
		frame1.setVisible(true);
	}
	/**
	 * Funkcja sprawdzaj¹ca jaki surowiec znajduje siê na danym polu
	 * @param x - rz¹d
	 * @param y - kolumna
	 * @return rodzaj surowca
	 */
	private static int whatresources1(int x,int y) {
		if (x<0||x==Simulation.jakirozmiar()||y<0||y==Simulation.jakirozmiar()) {
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
	 * <strong>false</strong> - jeœli na danym polu nie ma drogi
	 */
	private static Boolean isroad1(int x,int y) {
		if (x<0||x==Simulation.jakirozmiar()||y<0||y==Simulation.jakirozmiar()) {
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
	private static Boolean isvillage1(int x,int y) {
		/**
		 * Funkcja sprawdzazj¹ca czy na danym polu jest wybudowana droga
		 */
		if (x<0||x==Simulation.jakirozmiar()||y<0||y==Simulation.jakirozmiar()) {
			return true;
		}
		x=x+1;
		if(x<rozmiarplanszy&&y<rozmiarplanszy&&y>=0&&x>=0) {
			if(table.getValueAt(x, y)=="O11"||table.getValueAt(x, y)=="O12"||table.getValueAt(x, y)=="O13"||table.getValueAt(x, y)=="O14"||table.getValueAt(x, y)=="O21"||table.getValueAt(x, y)=="O22"||table.getValueAt(x, y)=="O23"||table.getValueAt(x, y)=="O24"||table.getValueAt(x, y)=="O31"||table.getValueAt(x, y)=="O32"||table.getValueAt(x, y)=="O33"||table.getValueAt(x, y)=="O34"||table.getValueAt(x, y)=="O41"||table.getValueAt(x, y)=="O42"||table.getValueAt(x, y)=="O43"||table.getValueAt(x, y)=="O44") {
				return true;
			}
		}
		x=x-2;
		if(x<rozmiarplanszy&&y<rozmiarplanszy&&y>=0&&x>=0) {
			if(table.getValueAt(x, y)=="O11"||table.getValueAt(x, y)=="O12"||table.getValueAt(x, y)=="O13"||table.getValueAt(x, y)=="O14"||table.getValueAt(x, y)=="O21"||table.getValueAt(x, y)=="O22"||table.getValueAt(x, y)=="O23"||table.getValueAt(x, y)=="O24"||table.getValueAt(x, y)=="O31"||table.getValueAt(x, y)=="O32"||table.getValueAt(x, y)=="O33"||table.getValueAt(x, y)=="O34"||table.getValueAt(x, y)=="O41"||table.getValueAt(x, y)=="O42"||table.getValueAt(x, y)=="O43"||table.getValueAt(x, y)=="O44") {
				return true;
			}
		}
		x=x+1;
		y=y+1;
		if(x<rozmiarplanszy&&y<rozmiarplanszy&&y>=0&&x>=0) {
			if(table.getValueAt(x, y)=="O11"||table.getValueAt(x, y)=="O12"||table.getValueAt(x, y)=="O13"||table.getValueAt(x, y)=="O14"||table.getValueAt(x, y)=="O21"||table.getValueAt(x, y)=="O22"||table.getValueAt(x, y)=="O23"||table.getValueAt(x, y)=="O24"||table.getValueAt(x, y)=="O31"||table.getValueAt(x, y)=="O32"||table.getValueAt(x, y)=="O33"||table.getValueAt(x, y)=="O34"||table.getValueAt(x, y)=="O41"||table.getValueAt(x, y)=="O42"||table.getValueAt(x, y)=="O43"||table.getValueAt(x, y)=="O44") {
				return true;
			}
		}
		y=y-2;
		if(x<rozmiarplanszy&&y<rozmiarplanszy&&y>=0&&x>=0) {
			if(table.getValueAt(x, y)=="O11"||table.getValueAt(x, y)=="O12"||table.getValueAt(x, y)=="O13"||table.getValueAt(x, y)=="O14"||table.getValueAt(x, y)=="O21"||table.getValueAt(x, y)=="O22"||table.getValueAt(x, y)=="O23"||table.getValueAt(x, y)=="O24"||table.getValueAt(x, y)=="O31"||table.getValueAt(x, y)=="O32"||table.getValueAt(x, y)=="O33"||table.getValueAt(x, y)=="O34"||table.getValueAt(x, y)=="O41"||table.getValueAt(x, y)=="O42"||table.getValueAt(x, y)=="O43"||table.getValueAt(x, y)=="O44") {
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
	private static Boolean canibuild1(int x,int y) {
		if (x<0||x>=Simulation.jakirozmiar()||y<0||y>=Simulation.jakirozmiar()) {
			return false;
		}
		if(table.getValueAt(x, y)=="1"||table.getValueAt(x, y)=="2"||table.getValueAt(x, y)=="3"||table.getValueAt(x, y)=="4") {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Funkcja umieszczaj¹ca obiekty na mapie
	 * @param s nazwa obiektu
	 * @param x kolumna
	 * @param y rzad
	 */
	private static void putvaluetab1(String s,int x, int y) {
		table.setValueAt(s, x, y);
	}
	/**
	 * Funkcja umieszczaj¹ca obiekty na mapie surowców
	 * @param s jaki surowiec
	 * @param x kolumna
	 * @param y rzad
	 */
	private static void putvaluetab21(String s,int x, int y) {
		table2.setValueAt(s, x, y);
	}
	/**
	 * Funkcja zwracaj¹ca wartoœæ pola
	 * @param x kolumna
	 * @param y rzad
	 * @return surowiec
	 */
	private static String getvaluetab21(int x, int y) {
		Object abc =table2.getValueAt(x, y);
		return abc.toString();
	}
	private static void simfinished1() {
		button2.setVisible(false);
		button3.setVisible(false);
		button4.setVisible(true);
	}
	/**
	 * Funkcja umieszczaj¹ca ilosc surowców na tablicy wyników
	 * @param n która wioska
	 * @param s ilosc kamienia
	 * @param i ilosc zelaza
	 * @param w ilosc drewna
	 * @param c ilosc gliny
	 */
	private static void labeling1(int n,int s,int i, int w, int c) {
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
	/**
	 * Funkcja umieszczajaca wartoœæ przychodów frakcji na tablicy wyników
	 * @param n która wioska
	 * @param s ilosc kamienia
	 * @param i ilosc zelaza
	 * @param w ilosc drewna
	 * @param c ilosc gliny
	 */
	private static void labeling21(int n,int s,int i, int w, int c) {
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
	private static Boolean isfull1(int mapsize){
		for(int i=0;i<mapsize;i++) {
			for(int j=0;j<mapsize;j++) {
				if(table.getValueAt(i, j)=="1"||table.getValueAt(i, j)=="2"||table.getValueAt(i, j)=="3"||table.getValueAt(i, j)=="4") {
					return false;
				}
			}
		}
		return true;
	}
}

