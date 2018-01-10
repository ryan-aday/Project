import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class Victory extends JFrame{
    private Container pane;

    private ImageIcon logo;
    private JLabel logoLabel;
    private JLabel l;

    public Victory(){
	this.setTitle("Othello: The Game");
	this.setSize(850,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	pane=this.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
	
	try{
	    BufferedImage img = ImageIO.read(new File("./victory.jpg"));
	    logo = new ImageIcon(img);
	    JLabel logoDisp= new JLabel(logo);
	    JOptionPane.showMessageDialog(null, logoDisp);
	}

	catch(IOException ie){
	    System.out.println("Error reading logo img file");
	}
    }
    
    public static void main(String[] args) {
	Victory g = new Victory();
	g.setVisible(true);
    } 
}
 
