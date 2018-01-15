import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Pieces extends JButton{
    private int x;
    private int y;
    private int color;
    
    public Pieces(int x, int y){
        this.x = x;
        this.y = y;
        this.color = 2;
    }
    
    public int getRow(){
	return y;
    }

    public int getCol(){
	return x;
    }

    public int getColor(){
	return color;
    }
    
    public void setColor(int col){
	   color=col;
    }
    
}
