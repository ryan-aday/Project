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
    private int BlackOrWhite; // 0 is black, 1 is white
    
    public Pieces(int x, int y, int l){
        this.x = x;
        this.y = y;
        BlackOrWhite = l;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setColor(int l){
        BlackOrWhite = l;
    }
    
    public int getColor(){
        return BlackOrWhite;
    }

}