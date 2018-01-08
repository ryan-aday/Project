import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class mainMenu extends JFrame{
    //    private Container pane;
    // private JFrame start, game;
    private JFrame frame;
    private JPanel home;
    // private JPanel game;
    
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

    public void actionPerformed(ActionEvent ae){
    }

    public mainMenu(){
	frame= new JFrame("Othello");
	
	home= new JPanel();
	
        frame.setTitle("Othello: The Game");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setContentPane(home);
    
	//pane=this.getContentPane();
	home.setSize(850,300);
	home.setLocation(100,100);
        home.setLayout(new BoxLayout(home, BoxLayout.LINE_AXIS));
	
	try{
	    BufferedImage img = ImageIO.read(new File("./logo.jpg"));
	    logo = new ImageIcon(img);
	    JLabel logoDisp= new JLabel(logo);
	    JOptionPane.showMessageDialog(null, logoDisp);
	    home.add(logoDisp);
	}

	catch(IOException ie){
	    System.out.println("Error reading logo img file");
	}

	home.add(Box.createHorizontalGlue());
	home.add(Box.createRigidArea(new Dimension(10, 0)));
	


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
		    	
        home.add(StartGame);

    }

    
    
    public static void main(String[] args) {
	mainMenu g = new mainMenu();
	g.setVisible(true);
    } 
}
   
