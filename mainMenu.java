import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class mainMenu extends JFrame{
    private Container pane;

    private JButton StartGame, manual;

    private ImageIcon logo;
    private JLabel logoLabel;
    private JLabel l;

    private JTextField p1, p2;

    public mainMenu(){
        this.setTitle("Othello: The Game");
	this.setSize(850,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	setContentPane(new JLabel(new ImageIcon("./background2.jpg")));
	pane=this.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

	try{
	    BufferedImage img = ImageIO.read(new File("./logo.jpg"));
	    logo = new ImageIcon(img);
	    JLabel logoDisp= new JLabel(logo);
	    JOptionPane.showMessageDialog(null, logoDisp);
	    pane.add(logoDisp);
	    
	    pane.add(Box.createHorizontalGlue());
	    pane.add(Box.createRigidArea(new Dimension(10, 0)));
	}
	
	catch(IOException ie){
	    System.out.println("Error reading logo img file");
	}

	p1= new JTextField("BLACK");
	p2= new JTextField("WHITE");
	
	StartGame=new JButton("Start Game");
	StartGame.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    Board.p1=p1.getText();
		    Board.p2=p2.getText();
		    
		    CloseFrame();
		    Board.main(new String[0]);
		}
	    });

	manual=new JButton("Manual- For the Sad Bois");
	manual.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    CloseFrame();
		    Manual.main(new String[0]);
		}
	    });
	pane.add(p1);
	pane.add(p2);
	pane.add(StartGame);
	pane.add(manual);	
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
	mainMenu g = new mainMenu();
	g.setVisible(true);
    } 
}
   
