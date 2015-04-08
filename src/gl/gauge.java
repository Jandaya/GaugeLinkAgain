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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.imageio.*;


public class gauge extends javax.swing.JFrame {
    final static Radial mphGauge = new Radial();
    final static Radial rpmGauge = new Radial();
    final static Radial1Square fuelGauge = new Radial1Square();
    final static LinearBargraph boostGauge = new LinearBargraph();
    final static DigitalRadial tempGauge = new DigitalRadial();
    final static JButton startButton = new JButton();
    final static JButton throttleButton = new JButton();
    //Image stopImage = new Image(getClass().getResource("/gl/stop_button.png"));
    //final static ImageIcon stopImage = new ImageIcon(getClass().getResource("/gl/stop_button.png"));
    //startButton.setIcon(new ImageIcon(getClass().getResource("/gl/stop_button.png")));
    public void createAndShowUI() {
        final JFrame frame = new JFrame("Dashboard");
        frame.setResizable(false);       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocation(5, 510);
        frame.setLocationByPlatform(true);
        //frame.setBackground();
        //frame.setBackground(Color.black);
        
        
        
        

        JPanel mphPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        JPanel rpmPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        JPanel boostPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 300);
            }
        };
        JPanel fuelPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        JPanel tempPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        JPanel startButtonPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        JPanel throttleButtonPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        JPanel allButtonsPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };
        
        JPanel topRowPanel= new JPanel();
        JPanel secondRowPanel=new JPanel();
        JPanel allGaugesPanel=new JPanel();
        topRowPanel.setLayout(new BoxLayout(topRowPanel, BoxLayout.X_AXIS));
        secondRowPanel.setLayout(new BoxLayout(secondRowPanel, BoxLayout.X_AXIS));
        allButtonsPanel.setLayout(new BoxLayout(allButtonsPanel, BoxLayout.X_AXIS));
        allGaugesPanel.setLayout(new BoxLayout(allGaugesPanel, BoxLayout.Y_AXIS));
        
        startButtonLook();
        
        //final Radial mphGauge = new Radial();
        mphGauge.setTitle("MPH");
        rpmGauge.setTitle("RPM");
        mphGauge.setUnitString("");
        rpmGauge.setUnitString("");
        boostGauge.setTitle("PSI");
        boostGauge.setOrientation(eu.hansolo.steelseries.tools.Orientation.VERTICAL);
        mphGauge.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        mphGauge.setPointerColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        mphGauge.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.BLUEGRAY_LCD);
        mphGauge.setMaxValue(120);
        rpmGauge.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        rpmGauge.setPointerColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        rpmGauge.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.BLUEGRAY_LCD);
        rpmGauge.setMinValue(0);
        rpmGauge.setMaxValue(10000);
        rpmGauge.setThreshold(8000);
        boostGauge.setBarGraphColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        boostGauge.setMinValue(-25);
        boostGauge.setMaxValue(40);
        mphGauge.setLedVisible(false);
        fuelGauge.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        fuelGauge.setPointerColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        fuelGauge.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.BLUEGRAY_LCD);
        fuelGauge.setTitle("Fuel");
        fuelGauge.setUnitString("Liters");
        fuelGauge.setValue(60);
        fuelGauge.setLedVisible(false);
        tempGauge.setLcdVisible(false);
        tempGauge.setTitle("Temperature");
        tempGauge.setUnitString("T");
        tempGauge.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        rpmGauge.setTrackStart(8000);
        rpmGauge.setTrackStop(10000);
        rpmGauge.setTrackSectionColor(Color.GREEN);
        rpmGauge.setTrackVisible(true);
        
        //gauge4.setTickmarkSectionsVisible(false);
        //gauge4.setGaugeType(GaugeType.TYPE1);
        //gauge4.setFrameDesign(FrameDesign.GOLD);
        //gauge4.setFrameType(FrameType.SQUARE);
        
        
        /* Track codes
        rpmGauge.setTrackStart(8000);
        rpmGauge.setTrackStop(10000);
        rpmGauge.setTrackSection(9000);
        rpmGauge.setTrackSectionColor(Color.YELLOW);
        rpmGauge.setTrackStopColor(Color.RED);
        rpmGauge.setTrackVisible(true);
        */
        //gauge2.setTickmarkSections(sctns);
        //gauge.setPointerColor(RED);
        startButtonPanel.setLayout(new BorderLayout());
        startButtonPanel.add(startButton, BorderLayout.CENTER);
        throttleButtonPanel.setLayout(new BorderLayout());
        throttleButtonPanel.add(throttleButton, BorderLayout.CENTER);
        mphPanel.setLayout(new BorderLayout());
        mphPanel.add(mphGauge, BorderLayout.CENTER);
        rpmPanel.setLayout(new BorderLayout());
        rpmPanel.add(rpmGauge, BorderLayout.CENTER);
        boostPanel.setLayout(new BorderLayout());
        boostPanel.add(boostGauge, BorderLayout.CENTER);
        fuelPanel.setLayout(new BorderLayout());
        fuelPanel.add(fuelGauge, BorderLayout.CENTER);
        mphPanel.setBackground(Color.darkGray);
        rpmPanel.setBackground(Color.darkGray);
        boostPanel.setBackground(Color.darkGray);
        fuelPanel.setBackground(Color.darkGray);
        tempPanel.setLayout(new BorderLayout());
        tempPanel.add(tempGauge, BorderLayout.CENTER);
        tempPanel.setBackground(Color.darkGray);
        topRowPanel.add(fuelPanel);
        topRowPanel.add(mphPanel);
        topRowPanel.add(rpmPanel);
        topRowPanel.add(boostPanel);
        topRowPanel.add(tempPanel);
        //secondRowPanel.add(fuelPanel);
        //secondRowPanel.add(tempPanel);
        allGaugesPanel.add(topRowPanel);
        //allGaugesPanel.add(secondRowPanel);
        allButtonsPanel.add(startButtonPanel);
        allButtonsPanel.add(throttleButtonPanel);
        allGaugesPanel.add(allButtonsPanel);
        frame.add(allGaugesPanel);

        
        
        
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //g.throttleButtonMousePressed();
                    startButton.setText("Hello");
                    
                } catch(NumberFormatException ex) { 
                    //TODO - handle invalid input 
                    System.err.println("invalid input");
                }
            }
        });
        throttleButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseExited(MouseEvent evt){
                //throttleButton.setBackground(Color.red);
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                throttleButton.setBackground(Color.red);
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                throttleButton.setBackground(Color.blue);
            }
            @Override
            public void mousePressed(MouseEvent evt){
                if (evt.getButton() == java.awt.event.MouseEvent.MOUSE_PRESSED){
                    throttleButton.setBackground(Color.black);
                    
                }
                throttleButton.setBackground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                
            }
        });
        
        
        

        //buttonsPanel.add(valueLabel);
        //buttonsPanel.add(valueField);
        //buttonsPanel.add(button);
        
        

        frame.pack();
        frame.setVisible(true);
       
        
    }
    public static void UPD(double d){
            //gauge.setValueAnimated(d);
            rpmGauge.setValueAnimated(d);
    }
    public void startButtonLook() {                                            
        
            startButton.setIcon(new ImageIcon(getClass().getResource("/gl/stop_button.png")));
            
                
            
        }
    
    
}
