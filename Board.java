import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Board extends JFrame implements MouseListener{
    public Container pane;
    private Pieces[][] Locations;
    private JButton endTurn;
    private int blackNum;
    private int whiteNum;
    private ImageIcon blackRoll,whiteRoll;
    
    public int Player=1;
    
    public Board(){
	pane = this.getContentPane();
	Locations = new Pieces[8][8];
	pane.setLayout(new GridLayout(9,9));
	blackRoll = new ImageIcon("darkGray.png");
	whiteRoll = new ImageIcon("lightGray.jpg");
	Image BTemp = blackRoll.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
	blackRoll = new ImageIcon(BTemp);
	
	for (int i = 0;i < Locations.length;i ++){
	    for (int c = 0; c < Locations[i].length;c ++){
            Locations[i][c] = new Pieces(i,c);
            Locations[i][c].addMouseListener(this);
	    
		if (i == 3 && c == 3){
		    ImageIcon temp = new ImageIcon ("black.png");
		    Image image = temp.getImage();
		    Image newImage = image.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
		    ImageIcon icon = new ImageIcon (newImage);
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(icon);
		    Locations[i][c].setIcon(icon);
		}
		else if (i == 4 && c == 3){
		    ImageIcon temp = new ImageIcon ("white.png");
		    Image image = temp.getImage();
		    Image newImage = image.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
		    ImageIcon icon = new ImageIcon (newImage);
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(icon);
		    Locations[i][c].setIcon(icon);
		}
		else if (i == 3 && c == 4){
		    ImageIcon temp = new ImageIcon ("white.png");
		    Image image = temp.getImage();
		    Image newImage = image.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
		    ImageIcon icon = new ImageIcon (newImage);
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(icon);
		    Locations[i][c].setIcon(icon);
		}
		else if (i == 4 && c == 4){
		    ImageIcon temp = new ImageIcon ("black.png");
		    Image image = temp.getImage();
		    Image newImage = image.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
		    ImageIcon icon = new ImageIcon (newImage);
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(icon);
		    Locations[i][c].setIcon(icon);
		}
		Locations[i][c].setBackground(new Color(0,153,76));
		Locations[i][c].setBorder(new LineBorder(Color.BLACK));
		pane.add(Locations[i][c]);
	    }
	}
	endTurn = new JButton("End Turn");
	pane.add(endTurn);
    }
    
    public void clearColor(JButton[][] a){
        for (int i = 0;i < a.length; i++){
            for (int c = 0;c < a[i].length; c++){
                a[i][c].setBorder(new LineBorder(Color.BLACK));
            }
        }
    }

    public int getPlayer(){
	return Player;
    }

    public void showValidMoves(int x, int y){
	if (Pieces[Pieces.getX()][Pieces.getY()].getColor==1){
	    if (Pieces[Pieces.getX()-1][Pieces.getY()-1]){
	    }
	}
    }
    
    public void isVictory(){
	for (int rcount=0; rcount<8; rcount++){
	    for (int ccount=0; ccount<8; ccount++){
		if (Locations[rcount][ccount]==null){
		}else Victory.main(new String[0]);
	    }
	}
    }

    public void actionPerformed(ActionEvent e){
	
    }
    
    public void mousePressed(MouseEvent e){
	   
    }
    
    public void mouseReleased(MouseEvent e){
	
    }
    
    public void mouseEntered(MouseEvent e){
        Pieces m = (Pieces) e.getSource();
	if (m.getIcon() == null){
        m.setIcon(blackRoll);
	}
    }
    
    public void mouseExited(MouseEvent e){
	   Pieces m = (Pieces) e.getSource();
	   if (m.getIcon() == blackRoll){
	   m.setIcon(null);
	   }
    }
    
    public void mouseClicked(MouseEvent e){
        ImageIcon temp = new ImageIcon ("black.png");
        Image image = temp.getImage();
        Image newImage = image.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon (newImage);
        Pieces m = (Pieces) e.getSource();
        m.setFocusPainted(false);
        m.setEnabled(false);
		m.setDisabledIcon(icon);
		m.setIcon(icon);
    }
    
    public static void main(String[] args){
        Board g = new Board();
        g.setSize(new Dimension(800,800));
        g.setVisible(true);
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
