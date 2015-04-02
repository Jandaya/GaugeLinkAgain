package gl;
import gl.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joseph
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //gaugeForm gauge = new gaugeForm();
        //gauge.setVisible(true);
        // TODO code application logic here
        //Circle cir = new Circle();
        
        JFrame frame = new JFrame("Circle");
        //JFrame f = new JFrame("f");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.setLocation(695,5);
        frame.setResizable(true);
        //f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.getContentPane().setBackground(Color.BLACK);
        //Container c = frame.getContentPane();
        //c.setBackground(Color.red);
	frame.add(new Circle());
	frame.setSize(700, 500);
	frame.setVisible(true);
        
    }
    
}