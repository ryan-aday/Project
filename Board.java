import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board{
    private Container pane;
    private JButton[][] Locations;
    private JButton endTurn;

    public Board(){
	Locations = new JButton[8][8];
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
