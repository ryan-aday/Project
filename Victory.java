import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;

public class Victory extends JFrame{
    private Container pane;

    private JButton toMain;

    private ImageIcon logo;
    private JLabel logoLabel;
    private JLabel l;

    private JTextField victor, numB, numW;

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
	    //pane.add(logoDisp);
	}

	catch(IOException ie){
	    System.out.println("Error reading logo img file");
	}

	pane.add(Box.createHorizontalGlue());
        pane.add(Box.createRigidArea(new Dimension(10, 0)));

	String v="";
	if (Board.checkB()>Board.checkW()){
	    v=Board.getP1();
	}else v=Board.getP2();
	
	
	victor= new JTextField("VICTOR: " +v);
	victor.setEditable(false);
	pane.add(victor);


	numB= new JTextField("Number of "+Board.getP1()+"'s Pieces: "+Board.checkB());
	numB.setEditable(false);
	pane.add(numB);

	numW= new JTextField("Number of "+Board.getP2()+"'s Pieces: "+Board.checkW());
	numW.setEditable(false);
	pane.add(numW);

	toMain=new JButton("Back to Main Menu");
	toMain.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
		    CloseFrame();
		    mainMenu.main(new String[0]);
		}
	    });
		    	
        pane.add(toMain);

    }
    
    //USeless for now, might use for future fanciness
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

    //Used to close Window
    public void CloseFrame(){
	super.dispose();
    }
    
    public static void main(String[] args) {
	Victory g = new Victory();
	g.setVisible(true);
    } 
}
   
