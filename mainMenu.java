import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class mainMenu extends JFrame{
    private Container pane;
    private JButton PlayGame;
    private JLabel background;

    public void mouseClicked(MouseEvent e){
    }

    public void mouseEntered(MouseEvent e){
    }

    public void mousePressed(MouseEvent e){
    }

    public void mouseReleased(MouseEvent e){
    }

    public void ActionPerformed(ActionEvent ae){
    }

    public mainMenu(){
	this.setTitle("Othello: The Game");
	this.setSize(850,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

	PlayGame=new JButton("Start Game");
	
	pane.add(PlayGame);

    }

    public static void main(String[] args) {
	mainMenu g = new mainMenu();
	g.setVisible(true);
    } 
}
   
