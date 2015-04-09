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
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;


public class gauge extends javax.swing.JFrame {
    final static Radial mphGauge = new Radial();
    final static Radial rpmGauge = new Radial();
    final static Radial1Square fuelGauge = new Radial1Square();
    final static LinearBargraph boostGauge = new LinearBargraph();
    final static DigitalRadial tempGauge = new DigitalRadial();
    final static JButton startButton = new JButton();
    final static JButton throttleButton = new JButton();
    boolean isStart = false;
    boolean isEconomic = true;
    boolean mouseOnThrottle = false;
    double speedNum = 0;
    int x = 0;
    int boost = 0, currentGear = 1;
    String gearIncrease, gearDecrease, speedIncrease, speedDecrease, rpmIncrease, rpmDecrease, boostIncrease, boostDecrease;
    boolean buttonPressed = false;
    ImageIcon leaf = new ImageIcon("leafMode.png");
    ImageIcon flag = new ImageIcon("Flag mode.png");
    private boolean mouseDown = false;
    
    
    //Image stopImage = new Image(getClass().getResource("/gl/stop_button.png"));
    //final static ImageIcon stopImage = new ImageIcon(getClass().getResource("/gl/stop_button.png"));
    //startButton.setIcon(new ImageIcon(getClass().getResource("/gl/stop_button.png")));
    public void createAndShowUI() {
        final JFrame frame = new JFrame("Dashboard");
        frame.setResizable(false);       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocation(5, 510);
        frame.setLocationByPlatform(true);


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
        
        ButtonLook();
        
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

        
        
        
        
        
        startButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseExited(MouseEvent evt){
                
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                if (isStart){
                    startButton.setIcon(new ImageIcon(getClass().getResource("/gl/stop_button.png")));
                    isStart = false;
                }
                else{
                    startButton.setIcon(new ImageIcon(getClass().getResource("/gl/start_button.png.png")));
                    isStart = true;
                }
            }
            @Override
            public void mousePressed(MouseEvent evt){
                startButton.setIcon(new ImageIcon(getClass().getResource("/gl/pressed_button.png")));
                
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                throttleButton.setBackground(Color.darkGray);
            }
        });
        
        throttleButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseExited(MouseEvent evt){
                
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                mouseDown = false;
                throttleButton.setIcon(new ImageIcon(getClass().getResource("/gl/pedalN.png")));
                
            }
            @Override
            public void mousePressed(MouseEvent evt){
                throttleButton.setBackground(Color.darkGray);
                throttleButton.setIcon(new ImageIcon(getClass().getResource("/gl/pedalY.png")));
                if (isStart){
                    mouseDown = true; 
                } 
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                throttleButton.setBackground(Color.darkGray);
            }
        });

        frame.pack();
        frame.setVisible(true);
       
        
    }
    public static void UPD(double d){
            //gauge.setValueAnimated(d);
            rpmGauge.setValueAnimated(d);
    }
    public void ButtonLook() {                                            
            startButton.setIcon(new ImageIcon(getClass().getResource("/gl/stop_button.png")));
            startButton.setBackground(Color.darkGray);
            
            throttleButton.setIcon(new ImageIcon(getClass().getResource("/gl/pedalN.png")));
            throttleButton.setBackground(Color.darkGray);        
    }
    public void mphIncrease() {
            
             
    }
    public boolean getButtonPressed(){
        return buttonPressed;
    }
    public void goToSleep(int x){
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            Logger.getLogger(gauge.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
private int changeUp(int RPM) {
    double temp;
    double tempGear;
    temp = (double)RPM;
    tempGear = (double)currentGear;
    temp = temp*(1 - Math.pow(.8,(tempGear+3)));
    return (int)temp;
}

private int changeDown(int RPM) {
    double temp;
    double tempGear;
    temp = (double)RPM;
    tempGear = (double)currentGear;
    temp = temp/(1 - Math.pow(.8,(tempGear+3)));
    if (temp > 9100) {
        //checkShiftLabel.setText("You blew your engine! Let the RPM drop more before downshifting");
    }
    return (int)temp;
}
private void isBoost(int x){
    if (boost > 0){
        //boostLabel.setText("Boost");
    }
}
private void isVacuum(int x){
    if (boost < 0){
        //boostLabel.setText("Vacuum");
    }
}
public int isBoostLimit(int x){
    if (x > 20){
        x=20;
        //psiLabel.setText("25 PSI");
    }
    return x;
}
public int isBoostLimitNeg(int x){
    if (x < -25){
        x = -25;
        //psiLabel.setText("-25 PSI");
    }
    return x;
}
public int isRevLimit(int x){
    if (x > 9100) {
        x = 9100;
        //rpm.setText("9100 RPM");
        goToSleep(50);
    }
    return x;
}

public double calcSpeed(int RPM, int gear)
{
    return RPM * gear * 0.0043021;
}


public int isVtec(int x){
    if (x > 5000) {
        //vtecdisplay.setText("VTEC!");
        x += 100;
    }
    return x;
}

public void shiftTell(int x)
{
    if(!isEconomic)
    {
        if(x > 9000)
        {
            //Shift_ind.rpmGauge.setLedColor(LedColor.GREEN_LED);
            //shiftTell.setText("Shift Up");
        }
        else{
            //Shift_ind.rpmGauge.setLedColor(LedColor.RED_LED);
            //shiftTell.setText("");
        }
    }
    else
    {
        if(x > 2500)
        {
            //Shift_ind.rpmGauge.setLedColor(LedColor.GREEN_LED);
            //shiftTell.setText("Shift Up");
        }
        else{
            //Shift_ind.rpmGauge.setLedColor(LedColor.RED_LED);
            //shiftTell.setText("");
        }
    }
}


private void checkShift(int x, boolean eco){
    
    if(x < 1800 && eco){
        //checkShiftLabel.setText("Early shift.");
    }
    else if(x > 1800 && x < 2500 && eco){
        //checkShiftLabel.setText("Good economic shift!");
    }
    else if (x > 2500 && eco){
        //checkShiftLabel.setText("Late shift.");
    }
    if(x < 8500 && !eco){
         //checkShiftLabel.setText("Early shift. (Too soon junior!)");
    }
    if(x > 8500 && x < 9200 && !eco){
         //checkShiftLabel.setText("Good performance shift!");
    }

}
    
    
    
    
}
