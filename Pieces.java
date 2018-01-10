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
    
    public Pieces(int x, int y){
        this.x = x;
        this.y = y;
    }
}