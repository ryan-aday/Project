import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class mainMenu extends JFrame{
    private Container pane;
    // private JFrame start, game;
    // private JFrame frame;
    //private JPanel home;
    // private JPanel game;
    
    private JButton StartGame;
    private JLabel background;

    private ImageIcon logo;
    private JLabel logoLabel;
    private JLabel l;

    public mainMenu(){
	//	frame= new JFrame("Othello");
	
	//home= new JPanel();
	pane=this.getContentPane();
        this.setTitle("Othello: The Game");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//frame.setContentPane(home);
    
	//pane=this.getContentPane();
	pane.setSize(850,300);
	pane.setLocation(100,100);
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
		    //super();
		    //frame= super();
		    // Board();
		    // frame.setVisible(false);
		    Board.main(new String[0]);
		}
	    });
		    	
        pane.add(StartGame);

    }

    
    
    public static void main(String[] args) {
	mainMenu g = new mainMenu();
	g.setVisible(true);
    } 
}
   
