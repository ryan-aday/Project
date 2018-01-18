
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Board extends JFrame implements MouseListener{
    public Container pane;
    private static Pieces[][] Locations;
    private JButton demoVictoryB, demoVictoryW;
    private int blackNum;
    private int whiteNum;
    private ImageIcon blackRoll,whiteRoll,BlackIcon,WhiteIcon;
    private boolean isBlackTurn=true;

    public static String p1="";
    public static String p2="";
    
    private JTextField victor, numB, numW, turn;
    private String v="";

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
		if (i == 4 && c == 3){
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(BlackIcon);
		    Locations[i][c].setIcon(BlackIcon);
		    Locations[i][c].setColor(0);
		}
		else if (i == 3 && c == 3){
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(WhiteIcon);
		    Locations[i][c].setIcon(WhiteIcon);
		    Locations[i][c].setColor(1);
		}
		else if (i == 4 && c == 4){
		    Locations[i][c].setFocusPainted(false);
		    Locations[i][c].setEnabled(false);
		    Locations[i][c].setDisabledIcon(WhiteIcon);
		    Locations[i][c].setIcon(WhiteIcon);
		    Locations[i][c].setColor(1);
		}
		else if (i == 3 && c == 4){
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
	/*
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
	*/	

	if (checkB()==checkW()){
	    v="DRAW";
	} else if (checkB()>checkW()){
	    v=p1;
	}else v=p2;
	
	
	victor= new JTextField("WINNING: " +v);
	victor.setEditable(false);
	pane.add(victor);


	numB= new JTextField(p1+": "+checkB());
	numB.setEditable(false);
	pane.add(numB);

	numW= new JTextField(p2+": "+checkW());
	numW.setEditable(false);
	pane.add(numW);

	turn= new JTextField("Turn: "+checkTurn());
	turn.setEditable(false);
	pane.add(turn);
	
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
    //checks the rightside of the piece 
    public boolean East(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y][x + 1].getColor() == 1){
            for (int newCol = x + 2; newCol <= 7; newCol ++){
                if (Locations[y][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[y][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y][x + 1].getColor() == 0){
            for (int newCol = x + 2; newCol < 7; newCol ++){
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
    
    //checks the left side of the piece
    public boolean West(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y][x - 1].getColor() == 1){
            for (int newCol = x - 2; newCol >= 0; newCol --){
                if (Locations[y][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[y][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y][x - 1].getColor() == 0){
            for (int newCol = x - 2; newCol >= 0; newCol --){
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
    
    //checks the top side of the piece
    public boolean North(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y - 1][x].getColor() == 1){
            for (int newRow = y - 2; newRow >= 0; newRow --){
                if (Locations[newRow][x].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][x].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y - 1][x].getColor() == 0){
            for (int newRow = y - 2; newRow >= 0; newRow --){
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
    
    //checks the bottom side of the piece
    public boolean South(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y + 1][x].getColor() == 1){
            for (int newRow = y + 2; newRow <= 7; newRow ++){
                if (Locations[newRow][x].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][x].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y + 1][x].getColor() == 0){
            for (int newRow = y + 2; newRow <= 7; newRow ++){
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
    
    //checks the top-right side of the piece
    public boolean NorthEast(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y - 1][x + 1].getColor() == 1){
            for (int newRow = y - 2, newCol = x + 2 ; newRow >= 0 && newCol <= 7; newRow --, newCol++){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y - 1][x + 1].getColor() == 0){
            for (int newRow = y - 2, newCol = x + 2 ; newRow >= 0 && newCol <= 7; newRow --, newCol++){
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
    
    //checks the top-left side of the piece
    public boolean NorthWest(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y - 1][x - 1].getColor() == 1){
            for (int newRow = y - 2, newCol = x - 2 ; newRow >= 0 && newCol >= 0; newRow --, newCol--){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y - 1][x - 1].getColor() == 0){
            for (int newRow = y - 2, newCol = x - 2 ; newRow >= 0 && newCol >= 0; newRow --, newCol--){
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
    
    //checks the bottom-right side of the piece
    public boolean SouthEast(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y + 1][x + 1].getColor() == 1){
            for (int newRow = y + 2, newCol = x + 2 ; newRow <= 7 && newCol <= 7; newRow ++, newCol++){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y + 1][x + 1].getColor() == 0){
            for (int newRow = y + 2, newCol = x + 2 ; newRow <= 7 && newCol <= 7; newRow ++, newCol++){
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
    
    //checks the bottom-left side of the piece 
    public boolean SouthWest(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn && Locations[y + 1][x - 1].getColor() == 1){
            for (int newRow = y + 2, newCol = x - 2 ; newRow <= 7 && newCol >= 0; newRow ++, newCol--){
                if (Locations[newRow][newCol].getColor() == 2){
                    return false;
                }
                if (Locations[newRow][newCol].getColor() == 0){
                    return true;
                }
            }
        }
        else if (isBlackTurn == false && Locations[y + 1][x - 1].getColor() == 0){
            for (int newRow = y + 2, newCol = x - 2 ; newRow <= 7 && newCol >= 0; newRow ++, newCol--){
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
    
    //returns which side of the border the piece is on
    public int BorderPieces(Pieces p){
        //0 for left side
        //1 for top side
        //2 for right side
        //3 for bottom side
        int x = p.getCol();
        int y = p.getRow();
        if (x == 0 && (y >= 1 && y <= 6)){
            return 0;
        }
        else if (y == 0 && (x >= 1 && x <= 6)){
            return 1;
        }
        else if (x == 7 && (y >= 1 && y <= 6)){
            return 2;
        }
        else if (y == 7 && (x >= 1 && x <= 6)){
            return 3;
        }
        return -1;
    }
    
    //returns which corner the piece is on 
    public int CornerPieces(Pieces p){
        //0 for top left corner;
        //1 for top right corner;
        //2 for bottom left corner;
        //3 for bottom right corner;
        int x = p.getCol();
        int y = p.getRow();
        if (x == 0 && y == 0){
            return 0;
        }
        else if (x == 7 && y == 0){
            return 1;
        }
        else if (x == 0 && y == 7){
            return 2;
        }
        else if (x == 7 && y == 7){
            return 3;
        }
        return -1;
    }
    
    public boolean isValidMove(Pieces p){
        // checks for corner pieces 
        if (CornerPieces(p) == 0){
            return (South(p) || East(p) || SouthEast(p));
        }
        else if (CornerPieces(p) == 1){
            return (West(p) || South(p) || SouthWest(p)); 
        }
        else if (CornerPieces(p) == 2){
            return (North(p) || NorthEast(p) || East(p));
        }
        else if (CornerPieces(p) == 3){
            return (North(p) || NorthWest(p) || West(p));
        }
        
        // checks for border pieces
        if (BorderPieces(p) == 0){
            return (East(p) || North(p) || South(p) || NorthEast(p) || SouthEast(p));
        }
        else if (BorderPieces(p) == 1){
            return (South(p) || East(p) || West(p) || SouthEast(p) || SouthWest(p));
        }
        else if (BorderPieces(p) == 2){
            return (West(p) || North(p) || South(p) || NorthWest(p) || SouthWest(p));
        } 
        else if (BorderPieces(p) == 3){
            return (North(p) || East(p) || West(p) || NorthEast(p) || NorthWest(p));
        }
        return(East(p) || West(p) || North(p) || South(p) || NorthEast(p) || NorthWest(p) || SouthWest(p) || SouthEast(p));
    }
    
    public void flip(Pieces p){
        int x = p.getCol();
        int y = p.getRow();
        if (isBlackTurn){
            if (BorderPieces(p) != 2 && CornerPieces(p) != 1 && CornerPieces(p) != 3){
                if (East(p)){
                for (int newCol = x + 1; newCol <= 8; newCol ++){
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
            }
            
            if (BorderPieces(p) != 0 && CornerPieces(p) != 2 & CornerPieces(p) != 0){
                if (West(p)){
                for (int newCol = x - 1; newCol >= 0; newCol --){
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
            }
            
            if (BorderPieces(p) != 1 && CornerPieces(p) != 1 & CornerPieces(p) != 0){
                if (North(p)){
                for (int newRow = y - 1; newRow >= 0; newRow --){
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
            }
            
            if (BorderPieces(p) != 3 && CornerPieces(p) != 2 & CornerPieces(p) != 3){
                if (South(p)){
                for (int newRow = y + 1; newRow <= 8; newRow ++){
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
            }
            if (BorderPieces(p) != 1 && CornerPieces(p) != 1 & CornerPieces(p) != 0 && BorderPieces(p) != 2 && CornerPieces(p) != 3){
            if (NorthEast(p)){
                for (int newRow = y - 1, newCol = x + 1 ; newRow >= 0 && newCol <= 8; newRow --, newCol++){
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
            if (BorderPieces(p) != 1 && CornerPieces(p) != 1 & CornerPieces(p) != 0 && BorderPieces(p) != 0 && CornerPieces(p) != 2){
            if (NorthWest(p)){
                for (int newRow = y - 1, newCol = x - 1 ; newRow >= 0 && newCol >= 0; newRow --, newCol--){
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
            if (BorderPieces(p) != 3 && CornerPieces(p) != 2 && CornerPieces(p) != 3 && BorderPieces(p) != 2 && CornerPieces(p) != 1){
            if (SouthEast(p)){
                for (int newRow = y + 1, newCol = x + 1 ; newRow <= 8 && newCol <= 8; newRow ++, newCol++){
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
            if (BorderPieces(p) != 3 && CornerPieces(p) != 2 & CornerPieces(p) != 3 && BorderPieces(p) != 0 && CornerPieces(p) != 0){
            if (SouthWest(p)){
                for (int newRow = y + 1, newCol = x - 1 ; newRow <= 8 && newCol >= 0; newRow ++, newCol--){
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
        }
        if (isBlackTurn == false){
            if (BorderPieces(p) != 2 && CornerPieces(p) != 1 && CornerPieces(p) != 3){
            if (East(p)){
                for (int newCol = x + 1; newCol <= 8; newCol ++){
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
            }
            if (BorderPieces(p) != 0 && CornerPieces(p) != 2 & CornerPieces(p) != 0){
            if (West(p)){
                for (int newCol = x - 1; newCol >= 0; newCol --){
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
            }
            if (BorderPieces(p) != 1 && CornerPieces(p) != 1 & CornerPieces(p) != 0){
            if (North(p)){
                for (int newRow = y - 1; newRow >= 0; newRow --){
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
            }
            if (BorderPieces(p) != 3 && CornerPieces(p) != 2 & CornerPieces(p) != 3){
            if (South(p)){
                for (int newRow = y + 1; newRow <= 8; newRow ++){
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
            }
            if (BorderPieces(p) != 1 && CornerPieces(p) != 1 & CornerPieces(p) != 0 && BorderPieces(p) != 2 && CornerPieces(p) != 3){
            if (NorthEast(p)){
                for (int newRow = y - 1, newCol = x + 1 ; newRow >= 0 && newCol <= 8; newRow --, newCol++){
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
            if (BorderPieces(p) != 1 && CornerPieces(p) != 1 & CornerPieces(p) != 0 && BorderPieces(p) != 0 && CornerPieces(p) != 2){
             if (NorthWest(p)){
                for (int newRow = y - 1, newCol = x - 1 ; newRow >= 0 && newCol >= 0; newRow --, newCol--){
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
            if (BorderPieces(p) != 3 && CornerPieces(p) != 2 && CornerPieces(p) != 3 && BorderPieces(p) != 2 && CornerPieces(p) != 1){
            if (SouthEast(p)){
                for (int newRow = y + 1, newCol = x + 1 ; newRow <= 8 && newCol <= 8; newRow ++, newCol++){
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
            if (BorderPieces(p) != 3 && CornerPieces(p) != 2 & CornerPieces(p) != 3 && BorderPieces(p) != 0 && CornerPieces(p) != 0){
             if (SouthWest(p)){
                for (int newRow = y + 1, newCol = x - 1 ; newRow <= 8 && newCol >= 0; newRow ++, newCol--){
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
    }

	public boolean BlackNoMoves(){
        int avaliableMoves = 0;
        for (int i = 0;i < Locations.length;i ++){
            for (int c = 0;c < Locations[i].length;c ++){
                if (isValidMove(Locations[i][c])){
                    avaliableMoves += 1;
                }
            }
        }
        if (avaliableMoves >= 1){
            return true;
        }
        else {
            return false;
        }
    }

    
    //Victory Conditions
    //East(p) || West(p) || North(p) || South(p) || NorthEast(p) || NorthWest(p) || SouthWest(p) || SouthEast(p)
    public void isVictory(){
	int bcount=0;
	int wcount=0;

	int count=0;
	for (int rcount=0; rcount<8; rcount++){
	    for (int ccount=0; ccount<8; ccount++){
		if (Locations[rcount][ccount].getColor()==2){
		    count++;
		}
	    }
	}
	//System.out.println(count);
	
	if (isBlackTurn){
	    bcount=0;
	    wcount=0;
	    for (int xrcount=0; xrcount<8; xrcount++){
		for (int xccount=0; xccount<8; xccount++){
		    Pieces p= Locations[xrcount][xccount];
		    if (isBlackTurn && p.getColor()==2 && isValidMove(p)){
			bcount++;
		    }
		}
	    }isBlackTurn=false;
	    for (int wrcount=0; wrcount<8; wrcount++){
		for (int wccount=0; wccount<8; wccount++){
		    Pieces w= Locations[wrcount][wccount];
		    if (isBlackTurn==false && w.getColor()==2 && isValidMove(w)){
			wcount++;
		    }
		}
	    }isBlackTurn=true;
	}else{
	    bcount=0;
	    wcount=0;
	    for (int yrcount=0; yrcount<8; yrcount++){
		for (int yccount=0; yccount<8; yccount++){
		    Pieces m= Locations[yrcount][yccount];	
		    if (isBlackTurn==false && m.getColor()==2 && isValidMove(m)){
			wcount++;
		    }
		    }
	    }
	    isBlackTurn=true;
	    for (int brcount=0; brcount<8; brcount++){
		for (int bccount=0; bccount<8; bccount++){
			Pieces b= Locations[brcount][bccount];
			if (isBlackTurn && b.getColor()==2 && isValidMove(b)){
			    bcount++;
			}
		}
		}isBlackTurn=false;
	}
	
	//System.out.println(bcount+" "+wcount);
	
	if (count==0){
	    CloseFrame();
	    Victory.main(new String[0]);
	}else if (wcount==0){
	    isBlackTurn=true;
	}else if (bcount==0){
	    isBlackTurn=false;
	}else{}
    }


    //For closing Frame once victory conditions met
    public void CloseFrame(){
	super.dispose();
    }

    //Reports how many Black and White Pieces
    public static int checkB(){
	int B=0;
	for (int r=0; r<8; r++){
	    for (int c=0; c<8; c++){
		if (Locations[r][c].getColor()==0){
		    B++;
		}
	    }
	}return B;
    }

    public static int checkW(){
	int W=0;
	for (int r=0; r<8; r++){
	    for (int c=0; c<8; c++){
		if (Locations[r][c].getColor()==1){
		    W++;
		}
	    }
	}return W;
    }

    public String checkTurn(){
	String t="";
	if (isBlackTurn){
	    t=p1;
	}else{
	    t=p2;
	}return t;
    }

    public static String getP1(){
	return p1;
    }

    public static String getP2(){
	return p2;
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
        else {
            
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
    Pieces m = (Pieces) e.getSource();;
        
    if (isBlackTurn && m.isEnabled()){
	m.setColor(0);
	m.setFocusPainted(false);
	m.setEnabled(false);
	m.setDisabledIcon(BlackIcon);
	m.setIcon(BlackIcon);
	flip(m);
	isVictory();
	this.isBlackTurn = false;
    }
    
    else if (isBlackTurn == false && m.isEnabled()){
	m.setFocusPainted(false);
	m.setEnabled(false);
	m.setDisabledIcon(WhiteIcon);
	m.setIcon(WhiteIcon);
        m.setColor(1);
        flip(m);
	isVictory();	
	this.isBlackTurn = true;
    }
    
    if (checkB()==checkW()){
	v="DRAW";
	} else if (checkB()>checkW()){
	v=p1;
    }else v=p2;
    
    this.remove(victor);	
    victor= new JTextField("WINNING: " +v);
    victor.setEditable(false);
    this.add(victor);
    
    this.remove(numB);
    numB= new JTextField(p1+": "+checkB());
    numB.setEditable(false);
    this.add(numB);
    
    this.remove(numW);
    numW= new JTextField(p2+": "+checkW());
    
    numW.setEditable(false);
    this.add(numW);
    
    this.remove(turn);
    turn= new JTextField("Turn: "+checkTurn());
    turn.setEditable(false);
    this.add(turn);
    }
    
    
    public static void main(String[] args){
        Board g = new Board();
        g.setSize(new Dimension(800,800));
        g.setVisible(true);
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
