package Symulacja_Osady;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
 
public class GradeRenderer extends JLabel implements TableCellRenderer
{
 
    public GradeRenderer()
    {
        super.setOpaque(true);
        //super.setFont(new Font("Consolas", Font.BOLD, 14));
        //super.setForeground(Color.BLUE);
    }
     public static void getcolor(int i, int j) {
  
     }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column)
    {
        String a=(String) value;
        if(a == "1") {						//kamien
        	super.setText("");
            super.setBackground(new Color(224,224,224));
        }
        else if(a == "2") {					//zelazo
        	super.setText("");
            super.setBackground(new Color(153,204,255));
        }
        else if(a == "3") {					//drewno
        	super.setText("");
            super.setBackground(new Color(204,255,153));
        }
        else if(a == "4") {					//glina
        	super.setText("");
        	//super.setText(Symulacja_Osady.GUI2.table1.getValue(row,column));
            super.setBackground(new Color(255,204,153));
        }
        else if(a == "R11") {
        	super.setText("益");
           	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        	super.setHorizontalTextPosition(SwingConstants.CENTER);
        	super.setHorizontalAlignment(SwingConstants.CENTER);
        	super.setBackground(new Color(224,224,224));
            super.setForeground(Color.RED);
        }
        else if(a == "R12") {
        	super.setText("益");
           	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        	super.setHorizontalTextPosition(SwingConstants.CENTER);
        	super.setHorizontalAlignment(SwingConstants.CENTER);
        	super.setBackground(new Color(153,204,255));
            super.setForeground(Color.RED);
        }
        else if(a == "R13") {
        	super.setText("益");
           	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        	super.setHorizontalTextPosition(SwingConstants.CENTER);
        	super.setHorizontalAlignment(SwingConstants.CENTER);
        	super.setBackground(new Color(204,255,153));
            super.setForeground(Color.RED);
        }
        else if(a == "R14") {
        	super.setText("益");
           	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        	super.setHorizontalTextPosition(SwingConstants.CENTER);
        	super.setHorizontalAlignment(SwingConstants.CENTER);
        	super.setBackground(new Color(255,204,153));
            super.setForeground(Color.RED);
        }
    else if(a == "R21") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(224,224,224));
        super.setForeground(Color.BLUE);
    }
    else if(a == "R22") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(153,204,255));
        super.setForeground(Color.BLUE);
    }
    else if(a == "R23") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(204,255,153));
        super.setForeground(Color.BLUE);
    }
    else if(a == "R24") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(255,204,153));
        super.setForeground(Color.BLUE);
    }
    else if(a == "R31") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(224,224,224));
        super.setForeground(Color.CYAN);
    }
    else if(a == "R32") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(153,204,255));
        super.setForeground(Color.CYAN);
    }
    else if(a == "R33") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(204,255,153));
        super.setForeground(Color.CYAN);
    }
    else if(a == "R34") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(255,204,153));
        super.setForeground(Color.CYAN);
    }
    else if(a == "R41") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(224,224,224));
        super.setForeground(Color.MAGENTA);
    }
    else if(a == "R42") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(153,204,255));
        super.setForeground(Color.MAGENTA);
    }
    else if(a == "R43") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(204,255,153));
        super.setForeground(Color.MAGENTA);
    }
    else if(a == "R44") {
    	super.setText("益");
       	super.setFont(new Font("Segoe UI", Font.PLAIN, 50));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(255,204,153));
        super.setForeground(Color.MAGENTA);
    }
    else if(a == "Road11") {
    	super.setText("+");
    	super.setFont(new Font("Serif", Font.PLAIN, 72));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(224,224,224));
        super.setForeground(Color.RED);
    }
    else if(a == "Road12") {
    	super.setText("+");
    	super.setFont(new Font("Serif", Font.PLAIN, 72));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(153,204,255));
        super.setForeground(Color.RED);
    }
    else if(a == "Road13") {
    	super.setText("+");
    	super.setFont(new Font("Serif", Font.PLAIN, 72));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(204,255,153));
        super.setForeground(Color.RED);
    }
    else if(a == "Road14") {
    	super.setText("+");
    	super.setFont(new Font("Serif", Font.PLAIN, 72));
    	super.setHorizontalTextPosition(SwingConstants.CENTER);
    	super.setHorizontalAlignment(SwingConstants.CENTER);
    	super.setBackground(new Color(255,204,153));
        super.setForeground(Color.RED);
    }
else if(a == "Road21") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(224,224,224));
    super.setForeground(Color.BLUE);
}
else if(a == "Road22") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(153,204,255));
    super.setForeground(Color.BLUE);
}
else if(a == "Road23") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(204,255,153));
    super.setForeground(Color.BLUE);
}
else if(a == "Road24") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(255,204,153));
    super.setForeground(Color.BLUE);
}
else if(a == "Road31") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(224,224,224));
    super.setForeground(Color.CYAN);
}
else if(a == "Road32") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(153,204,255));
    super.setForeground(Color.CYAN);
}
else if(a == "Road33") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(204,255,153));
    super.setForeground(Color.CYAN);
}
else if(a == "Road34") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(255,204,153));
    super.setForeground(Color.CYAN);
}
else if(a == "Road41") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(224,224,224));
    super.setForeground(Color.MAGENTA);
}
else if(a == "Road42") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(153,204,255));
    super.setForeground(Color.MAGENTA);
}
else if(a == "Road43") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(204,255,153));
    super.setForeground(Color.MAGENTA);
}
else if(a == "Road44") {
	super.setText("+");
	super.setFont(new Font("Serif", Font.PLAIN, 72));
	super.setHorizontalTextPosition(SwingConstants.CENTER);
	super.setHorizontalAlignment(SwingConstants.CENTER);
	super.setBackground(new Color(255,204,153));
    super.setForeground(Color.MAGENTA);
}
       /* else if(a == "6") {
        	super.setText("O");
        	super.setBackground(Color.GREEN);
            super.setForeground(Color.BLUE);
        }
        else if(a == "7") {
        	super.setText("O");
        	super.setBackground(Color.GREEN);
            super.setForeground(Color.RED);
        }
        else if(a == "8") {
        	super.setText("O");
        	super.setBackground(Color.GREEN);
            super.setForeground(Color.YELLOW);
        }
        else if(a == ""){
        	super.setText(" ");
        }
       */ 	
        //super.setFont(new Font("Courier New", Font.ITALIC, 12));
        //super.setForeground(Color.BLUE);
        return this;
    }
     
}