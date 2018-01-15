import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class Manual extends JFrame{
    private Container pane;

    private JButton menu;
    private JTextArea overview, rules, credits;

    public Manual(){
        this.setTitle("Othello: The Game");
	this.setSize(600,600);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//setContentPane(new JLabel(new ImageIcon("./background2.jpg")));
	pane=this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

	overview= new JTextArea("OVERVIEW:\nA move consists of outflanking your opponents disc(s), then flipping the outflanked disc(s) to your colour. \nTo outflank means to place a disc on the board so that your opponent's row (or rows) of disc(s) is bordered at each end by a disc of your colour. \n(A row may be made up of one or more discs).");

	
	rules= new JTextArea("RULES:"+"\n"+
			      "1. Black always moves first."+"\n"+
			      "2. If on your turn you cannot outflank and flip at least one opposing disc, your turn is forfeited and your opponent moves again."+"\n"+
			      "However, if a move is available to you, you may not forfeit your turn."+"\n"+
			      "3. A disc may outflank any number of discs in one or more rows in any number of directions at the same time - horizontally, vertically or diagonally."+"\n"+
			      "4. You may not skip over your own colour disc to outflank an opposing disc."+"\n"+
			      "5. Discs may only be outflanked as a direct result of a move and must fall in the direct line of the disc placed down."+"\n"+
			      "6. All discs outflanked in any one move must be flipped, even if it is to the player's advantage not to flip them at all."+"\n"+
			      "7. A player who flips a disc which should not have been turned may correct the mistake as long as the opponent has not made a subsequent move."+"\n"+
			      "If the opponent has already moved, it is too late to change and the disc(s) remain as is."+"\n"+
			      "8. Once a disc is placed on a square, it can never be moved to another square later in the game."+"\n"+
			      "9. When it is no longer possible for either player to move, the game is over. Discs are counted and the player"+"\n"+
			      "with the majority of his or her colour discs on the board is the winner.");
	
	credits=new JTextArea("Credits due to: hannu.se @ http://www.hannu.se/games/othello/rules.htm");

	menu=new JButton("Back to Main Menu");
	menu.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    CloseFrame();
		    mainMenu.main(new String[0]);
		}
	    });

	rules.setColumns(20);
        rules.setLineWrap(true);
        //textArea.setRows(5);
        rules.setWrapStyleWord(true);

	
	overview.setEditable(false);
	rules.setEditable(false);
	credits.setEditable(false);
	
	pane.add(menu);
	pane.add(overview);
	pane.add(rules);
	pane.add(credits);
    }



    private void mouseClicked(MouseEvent e){
    }
   
    private void mouseEntered(MouseEvent e){
    }
    
    private void mousePressed(MouseEvent e){
    }
    
    private void mouseReleased(MouseEvent e){
    }
    
    private void ActionPerformed(ActionEvent ae){
    }
    
    public void CloseFrame(){
	super.dispose();
    }
    
    public static void main(String[] args) {
	Manual g = new Manual();
	g.setVisible(true);
    } 
}
   
