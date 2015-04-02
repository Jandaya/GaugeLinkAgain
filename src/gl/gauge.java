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
import javax.swing.JFrame.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import eu.hansolo.steelseries.gauges.*;
import eu.hansolo.steelseries.*;
import eu.hansolo.steelseries.tools.*;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;


public class gauge extends javax.swing.JFrame {
    final static Radial gauge = new Radial();
    final static Radial gauge2 = new Radial();
    final static LinearBargraph gauge3 = new LinearBargraph();
    public static void createAndShowUI(final gaugeForm g) {
        final JFrame frame = new JFrame("Dashboard");
        frame.setResizable(false);
        Container con = frame.getContentPane();
        con.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocation(5, 510);
        frame.setLocationByPlatform(true);
        //frame.setBackground();
        //frame.setBackground(Color.black);
        
        
        

        JPanel panel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        JPanel panel2 = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        JPanel panel3 = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 300);
            }
        };
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        //final Radial gauge = new Radial();
        gauge.setTitle("MPH");
        gauge2.setTitle("RPM");
        gauge.setUnitString("");
        gauge2.setUnitString("");
        gauge3.setTitle("PSI");
        gauge3.setOrientation(eu.hansolo.steelseries.tools.Orientation.VERTICAL);
        gauge.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        gauge.setPointerColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        gauge.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.BLUEGRAY_LCD);
        gauge.setMaxValue(120);
        gauge2.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        gauge2.setPointerColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        gauge2.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.BLUEGRAY_LCD);
        gauge2.setMinValue(0);
        gauge2.setMaxValue(10000);
        gauge2.setThreshold(8000);
        gauge3.setBarGraphColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        gauge3.setMinValue(-25);
        gauge3.setMaxValue(40);
        //gauge2.setTickmarkSections(sctns);
        //gauge.setPointerColor(RED);

        panel.setLayout(new BorderLayout());
        panel.add(gauge, BorderLayout.CENTER);
        panel2.setLayout(new BorderLayout());
        panel2.add(gauge2, BorderLayout.CENTER);
        panel3.setLayout(new BorderLayout());
        panel3.add(gauge3, BorderLayout.CENTER);
        panel.setBackground(Color.darkGray);
        panel2.setBackground(Color.darkGray);
        panel3.setBackground(Color.darkGray);
        mainPanel.add(panel);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        frame.add(mainPanel);

        JPanel buttonsPanel = new JPanel();
        JLabel valueLabel = new JLabel("Value:");

        final JTextField valueField = new JTextField(7);
        valueField.setText("30");
        JButton button = new JButton("Set");
        
        
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.valueOf(valueField.getText());
                    //gauge.setValueAnimated(g.speedNum);
                    gauge2.setValueAnimated(g.x);
                    gauge3.setValue(g.boost);
                } catch(NumberFormatException ex) { 
                    //TODO - handle invalid input 
                    System.err.println("invalid input");
                }
            }
        });
        
        

        //buttonsPanel.add(valueLabel);
        //buttonsPanel.add(valueField);
        //buttonsPanel.add(button);

        frame.add(buttonsPanel, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
       
        
    }
    public static void UPD(double d){
            //gauge.setValueAnimated(d);
            gauge2.setValueAnimated(d);
    }
    
    
}
