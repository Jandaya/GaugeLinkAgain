/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gl;

/**
 *
 * @author My
 */


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import eu.hansolo.steelseries.gauges.Radial;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;


public class RPM extends javax.swing.JFrame {
    final static Radial RPM = new Radial();
    public static void createAndShowUI(final gaugeForm g) {
        final JFrame frame = new JFrame("RPM gauge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        JPanel panel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };

        //final Radial gauge = new Radial();
        RPM.setTitle("RPM");
        RPM.setUnitString("X100 RPM");

        panel.setLayout(new BorderLayout());
        panel.add(RPM, BorderLayout.CENTER);
        frame.add(panel);

        JButton button = new JButton("Set");        // can delete later

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RPM.setValueAnimated(g.x);  //taking RPM value and animate on gauge
                } catch(NumberFormatException ex) { 
                    //TODO - handle invalid input 
                    System.err.println("invalid input");
                }
            }
        });
       
        frame.pack();
        frame.setVisible(true);   
    }
    public static void RPM_DIS(double d){
            RPM.setValueAnimated(d);
    }
}
