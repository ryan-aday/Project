import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class mainMenu extends JFrame{
    private Container start, game;
    private JButton StartGame;
    private JLabel background;

    private ImageIcon logo;
    private JLabel logoLabel;
    private JLabel l;

    
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

	start = this.getContentPane();
	start.setLayout(new BoxLayout(start, BoxLayout.LINE_AXIS));
	
	try{
	    BufferedImage img = ImageIO.read(new File("./logo.jpg"));
	    logo = new ImageIcon(img);
	    JLabel logoDisp= new JLabel(logo);
	    JOptionPane.showMessageDialog(null, logoDisp);
	    start.add(logoDisp);
	}

	catch(IOException ie){
	    System.out.println("Error reading logo img file");
	}

	start.add(Box.createHorizontalGlue());
	start.add(Box.createRigidArea(new Dimension(10, 0)));
	


	StartGame=new JButton("Start Game");
	StartGame.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{}
	    });
		    
	
	start.add(StartGame);

    }

    public static void main(String[] args) {
	mainMenu g = new mainMenu();
	g.setVisible(true);
    } 
}
   
