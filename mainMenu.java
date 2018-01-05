import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class mainMenu extends Board{
    private Container pane;
    //private JPanel game;
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
	getContentPane().removeAll();
        this.setTitle("Othello: The Game");
	this.setSize(850,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	pane=this.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
	
	try{
	    BufferedImage img = ImageIO.read(new File("./logo.jpg"));
	    logo = new ImageIcon(img);
	    JLabel logoDisp= new JLabel(logo);
	    JOptionPane.showMessageDialog(null, logoDisp);
	    pane.add(logoDisp);
	}

	catch(IOException ie){
	    System.out.println("Error reading logo img file");
	}

	pane.add(Box.createHorizontalGlue());
	pane.add(Box.createRigidArea(new Dimension(10, 0)));
	


	StartGame=new JButton("Start Game");
	StartGame.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    //getContentPane().removeAll();
		    //super.Board();
		    
		    /*
		    getContentPane().add(game, BorderLayout.CENTER);
		    getContentPane().doLayout();
		    update(getGraphics());
		    */
		}
	    });
		    
	
        pane.add(StartGame);

    }
    
    public static void main(String[] args) {
	mainMenu g = new mainMenu();
	g.setVisible(true);
    } 
}
   
