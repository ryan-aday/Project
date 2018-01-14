//import java.awt.Color;
//import java.awt.Graphics;
//import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
//import javax.swing.ImageIcon;
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
    private boolean isBlackTurn;
    
    public Board(){
	pane = this.getContentPane();
	Locations = new Pieces[8][8];
	pane.setLayout(new GridLayout(9,9));
    blackRoll = new ImageIcon("darkGray.png");
	whiteRoll = new ImageIcon("lightGray.jpg");
	Image BTemp = blackRoll.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
	blackRoll = new ImageIcon(BTemp);
    Image WTemp = whiteRoll.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
	whiteRoll = new ImageIcon(WTemp);
	isBlackTurn = true;
	
	for (int i = 0;i < Locations.length;i ++){
	    for (int c = 0; c < Locations[i].length;c ++){
            Locations[i][c] = new Pieces(c,i);
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
            Locations[i][c].setColor(0);
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
            Locations[i][c].setColor(1);
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
            Locations[i][c].setColor(1);
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
            Locations[i][c].setColor(0);
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
    
    public boolean East(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y][x + 1].getColor() == 1){
            for (int newCol = x + 2; newCol < 8; newCol ++){
                if (Locations[y][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[y][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        return false;
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
	   if (m.getColor() == 2){
        m.setIcon(blackRoll);
        m.setFocusPainted(false);
        System.out.println(isEast(m));
	   }
    }
    
    public void mouseExited(MouseEvent e){
	   Pieces m = (Pieces) e.getSource();
	   if (m.getIcon() == blackRoll){
	       m.setIcon(null);
           m.setColor(2);
	   }
    }
    
    public void mouseClicked(MouseEvent e){
        ImageIcon BTemp = new ImageIcon ("black.png");
	ImageIcon WTemp = new ImageIcon ("white.png");
	Image WImage = WTemp.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
        Image BImage = BTemp.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);;
        ImageIcon BIcon = new ImageIcon (BImage);
	ImageIcon WIcon = new ImageIcon (WImage);
        Pieces m = (Pieces) e.getSource();
        System.out.println(m.getColor());
	if (isBlackTurn){
        m.setColor(0);
    m.setFocusPainted(false);
    m.setEnabled(false);
	m.setDisabledIcon(BIcon);
	m.setIcon(BIcon);
	this.isBlackTurn = false;
	}
	
	else {
	    m.setFocusPainted(false);
	    m.setEnabled(false);
	    m.setDisabledIcon(WIcon);
	    m.setIcon(WIcon);
        m.setColor(1);
	    this.isBlackTurn = true;
	}
    }
    
    
    public static void main(String[] args){
        Board g = new Board();
        g.setSize(new Dimension(800,800));
        g.setVisible(true);
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
