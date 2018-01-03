import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame{
    private Container pane;
    private JButton[][] Locations;
    private JButton endTurn;

    public Board(){
	Locations = new JButton[8][8];
	pane = this.getContentPane();
	endTurn = new JButton("End Turn");

	pane.add(endTurn);
        for (int i = 0;i < Locations.length;i ++){
	    for (int c = 0; c < Locations[i].length;c ++){
		
	    }
	}
    }
    
    public void actionPerformed(ActionEvent e){
	
    }

    public void mouseClicked(MouseEvent e){
	
    }

    public static void main(String[] args){
        Board g = new Board();
	g.setVisible(true);
    }
}
