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
import java.util.*;
import java.lang.*;


public class Board extends JFrame implements MouseListener{
    public Container pane;
    private Pieces[][] Locations;
    private JButton endTurn;
    private int blackNum;
    private int whiteNum;
    private ImageIcon blackRoll,whiteRoll;
    private boolean isBlackTurn=true;;
        
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
		    Locations[i][c].setColor(0);Victory.main(new String[0]);
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
		    
		}else {Locations[i][c].setColor(-1);}
		    
		Locations[i][c].setBackground(new Color(0,153,76));
		Locations[i][c].setBorder(new LineBorder(Color.BLACK));
		pane.add(Locations[i][c]);
	    }
	}
	//endTurn = new JButton("End Turn");
	//pane.add(endTurn);
    }
    
    public void clearColor(JButton[][] a){
        for (int i = 0;i < a.length; i++){
            for (int c = 0;c < a[i].length; c++){
                a[i][c].setBorder(new LineBorder(Color.BLACK));
            }
        }
    }


    //code doesn't work yet, need to think on it tonight
    public void isValidMove(int color, Pieces m){
	int x=m.getCol();
	int y=m.getRow();

	
	//if ((x<8 && x>-1) && (y<8 && y>-1) && Locations[x][y]!= null){    
	    // for (int rcount=0; rcount<8; rcount++){
	    //	for (int ccount=0; ccount<8; ccount++){
	    //	    Pieces mainX=Locations[x][y].getRow();
	    //	    Pieces mainY=Locations[x][y].getCol();
	    

	ArrayList<Pieces> neighbors=new ArrayList<Pieces>(4);
	
	try{
	    neighbors.add(Locations[x-1][y-1]);
	    System.out.println(neighbors.get(neighbors.size()-1).getRow()+ " " + neighbors.get(neighbors.size()-1).getCol());
	}
	catch(NullPointerException first){}
	catch(ArrayIndexOutOfBoundsException a){}

	try{
	    neighbors.add(Locations[x-1][y+1]);
	    System.out.println(neighbors.get(neighbors.size()-1).getRow()+ " " + neighbors.get(neighbors.size()-1).getCol());
	}
	catch(NullPointerException second){}
	catch(ArrayIndexOutOfBoundsException b){}
	
	try{
	    neighbors.add(Locations[x+1][y-1]);
	    System.out.println(neighbors.get(neighbors.size()-1).getRow()+ " " + neighbors.get(neighbors.size()-1).getCol());
	}
	catch(NullPointerException third){}
	catch(ArrayIndexOutOfBoundsException c){}
	
	try{
	    neighbors.add(Locations[x+1][y+1]);
	    System.out.println(neighbors.get(neighbors.size()-1).getRow()+ " " + neighbors.get(neighbors.size()-1).getCol());
	}
	catch(NullPointerException fourth){}
	catch(ArrayIndexOutOfBoundsException d){}

	try{

	    for (int count=0; count<neighbors.size(); count++){
		System.out.println(neighbors.get(count).getRow()+ " " + neighbors.get(count).getCol());
		if (neighbors.get(count).getColor()!= 0 && neighbors.get(count).getColor()!=1 && m.getColor()!=-1){
		    neighbors.get(count).setBorder(new LineBorder(Color.BLUE));
		    System.out.println("true");
		}
	    }System.out.println("false");
	}
	catch (NullPointerException Impossible){}
    }

    public void flip(int x, int y){
	if (Locations[x][y].getColor()==0){
	    Locations[x][y].setColor(1);
	}else if (Locations[x][y].getColor()==1){
	    Locations[x][y].setColor(0);
	}else{}
    }
    
    
    public void isVictory(){
	int counter=0;
	for (int rcount=0; rcount<8; rcount++){
	    for (int ccount=0; ccount<8; ccount++){
		if (Locations[rcount][ccount].getColor()==-1){
		    counter++;
		}
	    }
	}

	if (counter==64){
	    Victory.main(new String[0]);
	}
    }

    public void actionPerformed(ActionEvent e){
	
    }
    
    public void mousePressed(MouseEvent e){}

    
    public void mouseReleased(MouseEvent e){
	
    }
    
    public void mouseEntered(MouseEvent e){
        Pieces m = (Pieces) e.getSource();
        m.setFocusPainted(false);
	if (m.getIcon() == null){
	    m.setIcon(blackRoll);
	}
	System.out.println(m.getColor());
	//	isValidMove(0,m);
    }
    
    public void mouseExited(MouseEvent e){
	   Pieces m = (Pieces) e.getSource();
	   if (m.getIcon() == blackRoll){
	   m.setIcon(null);
	   }
	   m.setBorder(new LineBorder(Color.BLACK));
    }
    
    public void mouseClicked(MouseEvent e){
        ImageIcon BTemp = new ImageIcon ("black.png");
	ImageIcon WTemp = new ImageIcon ("white.png");
	Image WImage = WTemp.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
        Image BImage = BTemp.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);;
        ImageIcon BIcon = new ImageIcon (BImage);
	ImageIcon WIcon = new ImageIcon (WImage);
        Pieces m = (Pieces) e.getSource();

	if (isBlackTurn && m.getColor()==-1){
		m.setFocusPainted(false);
		m.setEnabled(false);
		m.setDisabledIcon(BIcon);
		m.setIcon(BIcon);
		m.setColor(0);
		this.isBlackTurn = false;
	}else if (!isBlackTurn && m.getColor()==-1){
		m.setFocusPainted(false);
		m.setEnabled(false);
		m.setDisabledIcon(WIcon);
		m.setIcon(WIcon);
		m.setColor(1);
		this.isBlackTurn = true;
	}else{}
	isVictory();
	    
    }
    
    
    public static void main(String[] args){
        Board g = new Board();
        g.setSize(new Dimension(800,800));
        g.setVisible(true);
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
