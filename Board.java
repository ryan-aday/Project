import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Board extends JFrame{
    private Container pane;
    private JButton[][] Locations;
    private JButton endTurn;

    public Board(){
    pane = this.getContentPane();
	Locations = new JButton[8][8];
    pane.setLayout(new GridLayout(9,9));

    for (int i = 0;i < Locations.length;i ++){
	   for (int c = 0; c < Locations[i].length;c ++){
            Locations[i][c] = new JButton();
		    Locations[i][c].setBackground(new Color(0,153,76));
            Locations[i][c].setBorder(new LineBorder(Color.BLACK));
            pane.add(Locations[i][c]);
	    }
	}
    endTurn = new JButton("End Turn");
    pane.add(endTurn);
    }
    
    public void actionPerformed(ActionEvent e){
	
    }

    public void mouseClicked(MouseEvent e){
	
    }

    public static void main(String[] args){
        Board g = new Board();
        g.setSize(new Dimension(800,800));
        g.setVisible(true);
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
