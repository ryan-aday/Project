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
    private JButton demoVictoryB, demoVictoryW;
    private int blackNum;
    private int whiteNum;
    private ImageIcon blackRoll,whiteRoll,BlackIcon,WhiteIcon;
    private boolean isBlackTurn;


    //Board Setup
    public Board(){
	pane = this.getContentPane();
	Locations = new Pieces[8][8];
	pane.setLayout(new GridLayout(9,9));
	blackRoll = new ImageIcon("darkGray.png");
	whiteRoll = new ImageIcon("lightGray.png");
	Image BTemp = blackRoll.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
	blackRoll = new ImageIcon(BTemp);
	Image WTemp = whiteRoll.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
	whiteRoll = new ImageIcon(WTemp);
	BlackIcon = new ImageIcon("black.png");
	Image BImage = BlackIcon.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
	BlackIcon = new ImageIcon (BImage);
	WhiteIcon = new ImageIcon("white.png");
	Image WImage = WhiteIcon.getImage().getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
	WhiteIcon = new ImageIcon (WImage);
	isBlackTurn = true;

	//Preset Locations for Starting Pieces
	for (int i = 0;i < Locations.length;i ++){
	    for (int c = 0; c < Locations[i].length;c ++){
            Locations[i][c] = new Pieces(c,i);
            Locations[i][c].addMouseListener(this);
            Locations[i][c].setEnabled(false);
		if (i == 3 && c == 3){
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(BlackIcon);
		    Locations[i][c].setIcon(BlackIcon);
		    Locations[i][c].setColor(0);
		}
		else if (i == 4 && c == 3){
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(WhiteIcon);
		    Locations[i][c].setIcon(WhiteIcon);
		    Locations[i][c].setColor(1);
		}
		else if (i == 3 && c == 4){
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(WhiteIcon);
		    Locations[i][c].setIcon(WhiteIcon);
		    Locations[i][c].setColor(1);
		}
		else if (i == 4 && c == 4){
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(BlackIcon);
		    Locations[i][c].setIcon(BlackIcon);
		    Locations[i][c].setColor(0);
		}
		Locations[i][c].setBackground(new Color(0,153,76));
		Locations[i][c].setBorder(new LineBorder(Color.BLACK));
		pane.add(Locations[i][c]);
	    }
	}

	//Demo Button to simulate a total Black Win
	JButton demoVictoryB= new JButton("BWin");
	demoVictoryB.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    for (int r=0; r<8; r++){
			for (int c=0; c<8; c++){
			    Locations[r][c].setFocusPainted(false);
			    Locations[r][c].setEnabled(false);
			    Locations[r][c].setDisabledIcon(BlackIcon);
			    Locations[r][c].setIcon(BlackIcon);
			    Locations[r][c].setColor(0);
			}
		    }isVictory();
		}
	    });
	pane.add(demoVictoryB);
	
	//Demo Button to simulate a total White Win
	JButton demoVictoryW= new JButton("WWin");
	demoVictoryW.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    for (int r=0; r<8; r++){
			for (int c=0; c<8; c++){
			    Locations[r][c].setFocusPainted(false);
			    Locations[r][c].setEnabled(false);
			    Locations[r][c].setDisabledIcon(WhiteIcon);
			    Locations[r][c].setIcon(WhiteIcon);
			    Locations[r][c].setColor(1);
			}
		    }isVictory();
		}
	    });
	pane.add(demoVictoryW);

    }
	    
	    


    //For when mouse hovers over pieces
    public void clearColor(JButton[][] a){
        for (int i = 0;i < a.length; i++){
            for (int c = 0;c < a[i].length; c++){
                a[i][c].setBorder(new LineBorder(Color.BLACK));
            }
        }
    }
    
    public boolean isBorderPiece(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
	return true;
    }
    
    public boolean isCornerPiece(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
	return true;
    }

    //Asks if Player  Pieces are in certain locations
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
        else if (isBlackTurn == false && Locations[y][x + 1].getColor() == 0){
            for (int newCol = x + 2; newCol < 8; newCol ++){
                if (Locations[y][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[y][newCol].getColor() == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean West(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y][x - 1].getColor() == 1){
            for (int newCol = x - 2; newCol > 0; newCol --){
                if (Locations[y][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[y][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y][x - 1].getColor() == 0){
            for (int newCol = x - 2; newCol > 0; newCol --){
                if (Locations[y][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[y][newCol].getColor() == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean North(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y - 1][x].getColor() == 1){
            for (int newRow = y - 2; newRow > 0; newRow --){
                if (Locations[newRow][x].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][x].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y - 1][x].getColor() == 0){
            for (int newRow = y - 2; newRow > 0; newRow --){
                if (Locations[newRow][x].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][x].getColor() == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean South(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y + 1][x].getColor() == 1){
            for (int newRow = y + 2; newRow < 8; newRow ++){
                if (Locations[newRow][x].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][x].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y + 1][x].getColor() == 0){
            for (int newRow = y + 2; newRow < 8; newRow ++){
                if (Locations[newRow][x].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][x].getColor() == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean NorthEast(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y - 1][x + 1].getColor() == 1){
            for (int newRow = y - 2, newCol = x + 2 ; newRow > 0 && newCol < 8; newRow --, newCol++){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y - 1][x + 1].getColor() == 0){
            for (int newRow = y - 2, newCol = x + 2 ; newRow > 0 && newCol < 8; newRow --, newCol++){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean NorthWest(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y - 1][x - 1].getColor() == 1){
            for (int newRow = y - 2, newCol = x - 2 ; newRow > 0 && newCol > 0; newRow --, newCol--){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y - 1][x - 1].getColor() == 0){
            for (int newRow = y - 2, newCol = x - 2 ; newRow > 0 && newCol > 0; newRow --, newCol--){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean SouthEast(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y + 1][x + 1].getColor() == 1){
            for (int newRow = y + 2, newCol = x + 2 ; newRow < 8 && newCol < 8; newRow ++, newCol++){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y + 1][x + 1].getColor() == 0){
            for (int newRow = y + 2, newCol = x + 2 ; newRow < 8 && newCol < 8; newRow ++, newCol++){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean SouthWest(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y + 1][x - 1].getColor() == 1){
            for (int newRow = y + 2, newCol = x - 2 ; newRow < 8 && newCol > 0; newRow ++, newCol--){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y + 1][x - 1].getColor() == 0){
            for (int newRow = y + 2, newCol = x - 2 ; newRow < 8 && newCol > 0; newRow ++, newCol--){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isValidMove(Pieces p){
        return(East(p) || West(p) || North(p) || South(p) || NorthEast(p) || NorthWest(p) || SouthWest(p) || SouthEast(p));
    }
    
    public void flip(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn){
            if (East(p)){
                for (int newCol = x + 1; newCol < 8; newCol ++){
                    if (Locations[y][newCol].getColor() == 1){
                        Locations[y][newCol].setColor(0);
                        Locations[y][newCol].setDisabledIcon(BlackIcon);
                        Locations[y][newCol].setIcon(BlackIcon);
                    }
                    else {
                        break;
                    }
                }
            }
            if (West(p)){
                for (int newCol = x - 1; newCol > 0; newCol --){
                if (Locations[y][newCol].getColor() == 1){
                    Locations[y][newCol].setColor(0);
                    Locations[y][newCol].setDisabledIcon(BlackIcon);
                    Locations[y][newCol].setIcon(BlackIcon);
                }
                else {
                    break;
                }
                }
            }
            
            if (North(p)){
                for (int newRow = y - 1; newRow > 0; newRow --){
                if (Locations[newRow][x].getColor() == 1){
                    Locations[newRow][x].setColor(0);
                    Locations[newRow][x].setDisabledIcon(BlackIcon);
                    Locations[newRow][x].setIcon(BlackIcon);
                }
                    else {
                        break;
                    }
            }
            }
            
            if (South(p)){
                for (int newRow = y + 1; newRow < 8; newRow ++){
                if (Locations[newRow][x].getColor() == 1){
                    Locations[newRow][x].setColor(0);
                    Locations[newRow][x].setDisabledIcon(BlackIcon);
                    Locations[newRow][x].setIcon(BlackIcon);
                }
                    else {
                        break;
                    }
            }
            }
            
            if (NorthEast(p)){
                for (int newRow = y - 1, newCol = x + 1 ; newRow > 0 && newCol < 8; newRow --, newCol++){
                if (Locations[newRow][newCol].getColor() == 1){
                    Locations[newRow][newCol].setColor(0);
                    Locations[newRow][newCol].setDisabledIcon(BlackIcon);
                    Locations[newRow][newCol].setIcon(BlackIcon);
                }
                    else {
                        break;
                    }
                }
            }
            
            if (NorthWest(p)){
                for (int newRow = y - 1, newCol = x - 1 ; newRow > 0 && newCol > 0; newRow --, newCol--){
                if (Locations[newRow][newCol].getColor() == 1){
                    Locations[newRow][newCol].setColor(0);
                    Locations[newRow][newCol].setDisabledIcon(BlackIcon);
                    Locations[newRow][newCol].setIcon(BlackIcon);
                }
                else {
                    break;
                }
            }
            }
            
            if (SouthEast(p)){
                for (int newRow = y + 1, newCol = x + 1 ; newRow < 8 && newCol < 8; newRow ++, newCol++){
                if (Locations[newRow][newCol].getColor() == 1){
                    Locations[newRow][newCol].setColor(0);
                    Locations[newRow][newCol].setDisabledIcon(BlackIcon);
                    Locations[newRow][newCol].setIcon(BlackIcon);
                }
                else {
                    break;
                }
            }
            }
            
            if (SouthWest(p)){
                for (int newRow = y + 1, newCol = x - 1 ; newRow < 8 && newCol > 0; newRow ++, newCol--){
                if (Locations[newRow][newCol].getColor() == 1){
                    Locations[newRow][newCol].setColor(0);
                    Locations[newRow][newCol].setDisabledIcon(BlackIcon);
                    Locations[newRow][newCol].setIcon(BlackIcon);
                }
                else {
                    break;
                }
            }
            }
            }
        if (isBlackTurn == false){
            if (East(p)){
                for (int newCol = x + 1; newCol < 8; newCol ++){
                    if (Locations[y][newCol].getColor() == 0){
                        Locations[y][newCol].setColor(1);
                        Locations[y][newCol].setDisabledIcon(WhiteIcon);
                        Locations[y][newCol].setIcon(WhiteIcon);
                    }
                    else {
                        break;
                    }
                }
            }
            if (West(p)){
                for (int newCol = x - 1; newCol > 0; newCol --){
                if (Locations[y][newCol].getColor() == 0){
                    Locations[y][newCol].setColor(1);
                    Locations[y][newCol].setDisabledIcon(WhiteIcon);
                    Locations[y][newCol].setIcon(WhiteIcon);
                }
                else {
                    break;
                }
                }
            }
            
            if (North(p)){
                for (int newRow = y - 1; newRow > 0; newRow --){
                if (Locations[newRow][x].getColor() == 0){
                    Locations[newRow][x].setColor(1);
                    Locations[newRow][x].setDisabledIcon(WhiteIcon);
                    Locations[newRow][x].setIcon(WhiteIcon);
                }
                    else {
                        break;
                    }
            }
            }
            
            if (South(p)){
                for (int newRow = y + 1; newRow < 8; newRow ++){
                if (Locations[newRow][x].getColor() == 0){
                    Locations[newRow][x].setColor(1);
                    Locations[newRow][x].setDisabledIcon(WhiteIcon);
                    Locations[newRow][x].setIcon(WhiteIcon);
                }
                    else {
                        break;
                    }
            }
            }
            
            if (NorthEast(p)){
                for (int newRow = y - 1, newCol = x + 1 ; newRow > 0 && newCol < 8; newRow --, newCol++){
                if (Locations[newRow][newCol].getColor() == 0){
                    Locations[newRow][newCol].setColor(1);
                    Locations[newRow][newCol].setDisabledIcon(WhiteIcon);
                    Locations[newRow][newCol].setIcon(WhiteIcon);
                }
                    else {
                        break;
                    }
                }
            }
            
             if (NorthWest(p)){
                for (int newRow = y - 1, newCol = x - 1 ; newRow > 0 && newCol > 0; newRow --, newCol--){
                if (Locations[newRow][newCol].getColor() == 0){
                    Locations[newRow][newCol].setColor(1);
                    Locations[newRow][newCol].setDisabledIcon(WhiteIcon);
                    Locations[newRow][newCol].setIcon(WhiteIcon);
                }
                else {
                    break;
                }
            }
            }
            
            if (SouthEast(p)){
                for (int newRow = y + 1, newCol = x + 1 ; newRow < 8 && newCol < 8; newRow ++, newCol++){
                if (Locations[newRow][newCol].getColor() == 0){
                    Locations[newRow][newCol].setColor(1);
                    Locations[newRow][newCol].setDisabledIcon(WhiteIcon);
                    Locations[newRow][newCol].setIcon(WhiteIcon);
                }
                else {
                    break;
                }
            }
            }
            
             if (SouthWest(p)){
                for (int newRow = y + 1, newCol = x - 1 ; newRow < 8 && newCol > 0; newRow ++, newCol--){
                if (Locations[newRow][newCol].getColor() == 0){
                    Locations[newRow][newCol].setColor(1);
                    Locations[newRow][newCol].setDisabledIcon(WhiteIcon);
                    Locations[newRow][newCol].setIcon(WhiteIcon);
                }
                else {
                    break;
                }
            }
            }
        }
    }

    
    //Victory Conditions
    public void isVictory(){
	for (int rcount=0; rcount<8; rcount++){
	    for (int ccount=0; ccount<8; ccount++){
		if (Locations[rcount][ccount].getColor()==2){
		}else Victory.main(new String[0]);
	    }
	}
    }

    //Empty Methods due to abstract class, for extra features if we have time
    public void actionPerformed(ActionEvent e){
	
    }
    
    public void mousePressed(MouseEvent e){
	   
    }
    
    public void mouseReleased(MouseEvent e){
	
    }

    //Mouse Methods for when Mouse enters Field
    public void mouseEntered(MouseEvent e){
        Pieces m = (Pieces) e.getSource();
	   if (m.getColor() == 2 && isValidMove(m) && isBlackTurn){
        m.setEnabled(true);
        m.setIcon(blackRoll);
        m.setFocusPainted(false);
	   }
        else if (m.getColor() == 2 && isValidMove(m) && isBlackTurn == false){
            m.setEnabled(true);
            m.setIcon(whiteRoll);
            m.setFocusPainted(false);
        }
    }
    
    public void mouseExited(MouseEvent e){
	Pieces m = (Pieces) e.getSource();
	if (m.getIcon() == blackRoll || m.getIcon() == whiteRoll){
	    m.setEnabled(false);
	    m.setIcon(null);
	    m.setColor(2);
	}
    }
	    
    public void mouseClicked(MouseEvent e){
    Pieces m = (Pieces) e.getSource();
    System.out.println(m.getColor());
        
    if (isBlackTurn && m.isEnabled()){
    m.setColor(0);
    m.setFocusPainted(false);
    m.setEnabled(false);
	m.setDisabledIcon(BlackIcon);
	m.setIcon(BlackIcon);
    flip(m);
	this.isBlackTurn = false;
	}
	
	else if (isBlackTurn == false && m.isEnabled()){
	    m.setFocusPainted(false);
	    m.setEnabled(false);
	    m.setDisabledIcon(WhiteIcon);
	    m.setIcon(WhiteIcon);
        m.setColor(1);
        flip(m);
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
