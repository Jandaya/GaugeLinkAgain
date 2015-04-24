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
import java.util.TimerTask;
import java.util.Timer;


public class gauge extends javax.swing.JFrame {
    final static Radial mphGauge = new Radial();
    final static Radial rpmGauge = new Radial();
    final static DigitalRadial boostGauge = new DigitalRadial();
    final static DigitalRadial tempGauge = new DigitalRadial();
    final static DisplaySingle distanceGauge = new DisplaySingle();
    final static DisplaySingle fuelGauge = new DisplaySingle();
    final static JButton startButton = new JButton();
    final static JButton throttleButton = new JButton();
    final static JButton shiftUpButton = new JButton();
    final static JButton shiftDownButton = new JButton();
    final static JButton modeButton = new JButton();
    final static JLabel shiftFeedback = new JLabel();
    final static JButton resetButton = new JButton();
    final static JButton helpButton = new JButton();
    final static JButton dragButton = new JButton();
    boolean isStart = false;
    boolean isEconomic = false;
    boolean mouseOnThrottle = false;
    boolean frameOpen = false;
    double speedNum = 0;
    int x = 0;
    int boost = 0, currentGear = 1;
    double fuelUsed = 0;
    double distCovered = 0;
    String gearIncrease, gearDecrease, speedIncrease, speedDecrease, rpmIncrease, rpmDecrease, boostIncrease, boostDecrease;
    boolean buttonPressed = false;
    private boolean mouseDown = false;
    
    
    

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
                return new Dimension(300, 300);
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
        JPanel shiftUpButtonPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        JPanel shiftDownButtonPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 0);
            }
        };
        JPanel modeButtonPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        JPanel shiftFeedbackPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(50, 50);
            }
        };
        JPanel fuelPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 100);
            }
        };
        JPanel distancePanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 100);
            }
        };
        JPanel bufferPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        JPanel resetPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 80);
            }
        };
        JPanel helpPanel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(300, 80);
            }
        };
        JPanel dragPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(80,100);
            }
        };
        
        
        JPanel numGaugesPanel = new JPanel();
        JPanel topRowPanel= new JPanel();
        JPanel secondRowPanel=new JPanel();
        JPanel leftSidePanel=new JPanel();
        JPanel rightSidePanel = new JPanel();
        JPanel shiftButtonPanel = new JPanel();
        topRowPanel.setLayout(new BoxLayout(topRowPanel, BoxLayout.X_AXIS));
        secondRowPanel.setLayout(new BoxLayout(secondRowPanel, BoxLayout.X_AXIS));
        shiftButtonPanel.setLayout(new BoxLayout(shiftButtonPanel, BoxLayout.Y_AXIS));
        allButtonsPanel.setLayout(new BoxLayout(allButtonsPanel, BoxLayout.X_AXIS));
        numGaugesPanel.setLayout(new BoxLayout(numGaugesPanel, BoxLayout.Y_AXIS));
        //allButtonsPanel.setBackground(Color.darkGray);
        leftSidePanel.setLayout(new BoxLayout(leftSidePanel, BoxLayout.Y_AXIS));
        rightSidePanel.setLayout(new BoxLayout(rightSidePanel, BoxLayout.X_AXIS));
        
        
        ButtonLook();
        
        mphGauge.setTitle("MPH");
        rpmGauge.setTitle("RPM");
        mphGauge.setUnitString("");
        rpmGauge.setUnitString("");
        boostGauge.setTitle("PSI");
        boostGauge.setOrientation(eu.hansolo.steelseries.tools.Orientation.VERTICAL);
        mphGauge.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        mphGauge.setPointerColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        mphGauge.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.BLUEGRAY_LCD);
        mphGauge.setMaxValue(200);
        rpmGauge.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        rpmGauge.setPointerColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        rpmGauge.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.BLUEGRAY_LCD);
        rpmGauge.setMinValue(0);
        rpmGauge.setMaxValue(10000);
        rpmGauge.setThreshold(8000);
        boostGauge.setMinValue(-20);
        boostGauge.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.BLUEGRAY_LCD);
        //boostGauge.setBarGraphColor(eu.hansolo.steelseries.tools.ColorDef.BLUE);
        boostGauge.setMinValue(-25);
        boostGauge.setMaxValue(40);
        mphGauge.setLedVisible(false);
        tempGauge.setLcdVisible(false);
        tempGauge.setTitle("Temperature");
        tempGauge.setUnitString("T");
        tempGauge.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLACK);
        rpmGauge.setTrackStart(8000);
        rpmGauge.setTrackStop(10000);
        rpmGauge.setTrackSectionColor(Color.GREEN);
        rpmGauge.setTrackVisible(true);
        fuelGauge.setLcdUnitString("mpg");
        distanceGauge.setLcdUnitString("miles");
        
        

        startButtonPanel.setLayout(new BorderLayout());
        startButtonPanel.add(startButton, BorderLayout.CENTER);
        startButtonPanel.setBackground(Color.darkGray);
        fuelPanel.setLayout(new BorderLayout());
        fuelPanel.add(fuelGauge, BorderLayout.CENTER);
        fuelPanel.setBackground(Color.darkGray);
        resetPanel.setLayout(new BorderLayout());
        resetPanel.add(resetButton, BorderLayout.CENTER);
        resetPanel.setBackground(Color.darkGray);
        helpPanel.setLayout(new BorderLayout());
        helpPanel.add(helpButton, BorderLayout.CENTER);
        helpPanel.setBackground(Color.darkGray);
        bufferPanel.setLayout(new BorderLayout());
        bufferPanel.setBackground(Color.darkGray);
        distancePanel.setLayout(new BorderLayout());
        distancePanel.add(distanceGauge, BorderLayout.CENTER);
        distancePanel.setBackground(Color.darkGray);
        throttleButtonPanel.setLayout(new BorderLayout());
        throttleButtonPanel.add(throttleButton, BorderLayout.CENTER);
        throttleButtonPanel.setBackground(Color.darkGray);
        shiftUpButtonPanel.setLayout(new BorderLayout());
        shiftUpButtonPanel.add(shiftUpButton, BorderLayout.CENTER);
        shiftUpButtonPanel.setBackground(Color.darkGray);
        shiftDownButtonPanel.setLayout(new BorderLayout());
        shiftDownButtonPanel.add(shiftDownButton, BorderLayout.CENTER);
        shiftDownButtonPanel.setBackground(Color.darkGray);
        modeButtonPanel.setLayout(new BorderLayout());
        modeButtonPanel.add(modeButton, BorderLayout.CENTER);
        modeButtonPanel.setBackground(Color.darkGray);
        shiftFeedbackPanel.setLayout(new BorderLayout());
        shiftFeedbackPanel.add(shiftFeedback, BorderLayout.CENTER);
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
        shiftFeedbackPanel.setBackground(Color.darkGray);
        tempPanel.setLayout(new BorderLayout());
        tempPanel.add(tempGauge, BorderLayout.CENTER);
        tempPanel.setBackground(Color.darkGray);
        shiftUpButton.setIcon(new ImageIcon(getClass().getResource("Neutral.png")));
        resetButton.setBackground(Color.darkGray);
        resetButton.setForeground(Color.red);
        resetButton.setFont(new Font("Arial", Font.BOLD, 20));
        resetButton.setText("RESET MILES TRAVELED");
        helpButton.setBackground(Color.darkGray);
        helpButton.setForeground(Color.yellow);
        helpButton.setFont(new Font("Arial", Font.BOLD, 20));
        helpButton.setText("NEED HELP? CLICK HERE");
        dragPanel.setLayout(new BorderLayout());
        dragPanel.add(dragButton, BorderLayout.CENTER);
        dragPanel.setBackground(Color.darkGray);
        
        //topRowPanel.add(fuelPanel);
        numGaugesPanel.add(helpPanel);
        numGaugesPanel.add(fuelPanel);
        numGaugesPanel.add(distancePanel);
        numGaugesPanel.add(resetPanel);
        numGaugesPanel.add(bufferPanel);
        topRowPanel.add(mphPanel);
        topRowPanel.add(rpmPanel);
        topRowPanel.add(boostPanel);
        //topRowPanel.add(numGaugesPanel);
        shiftButtonPanel.add(shiftUpButtonPanel);
        //shiftButtonPanel.add(shiftDownButtonPanel);
        leftSidePanel.add(shiftFeedbackPanel);
        leftSidePanel.add(topRowPanel);
        //allGaugesPanel.add(secondRowPanel);
        allButtonsPanel.add(startButtonPanel);
        allButtonsPanel.add(throttleButtonPanel);
        allButtonsPanel.add(shiftButtonPanel);
        allButtonsPanel.add(modeButtonPanel);
        allButtonsPanel.add(dragPanel);
        leftSidePanel.add(allButtonsPanel);
        rightSidePanel.add(leftSidePanel);
        rightSidePanel.add(numGaugesPanel);
        frame.add(rightSidePanel);

        
        
        
        
        
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
                    stopValues();
                }
                else{
                    startButton.setIcon(new ImageIcon(getClass().getResource("/gl/start_button.png.png")));
                    isStart = true;
                    startValues();
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
        
        resetButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseExited(MouseEvent evt){
                
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                
            }
            @Override
            public void mousePressed(MouseEvent evt){
                
                
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                distCovered = 0;
                distanceGauge.setLcdValue(0);
            }
        });
        
        helpButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseExited(MouseEvent evt){
                
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                
            }
            @Override
            public void mouseReleased(MouseEvent evt){
                
            }
            @Override
            public void mousePressed(MouseEvent evt){
                
                
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                JOptionPane.showMessageDialog(null," Welcome to GaugeLink, a semi-automatic transmission simulator.  This program is designed to help individuals\n" +
"understand the basics of driving a manual transimission car, or a car with a manual shifting option.  For\n" +
"simplicity of learning, a clutch is not offered in this program.\n" +
"\n" +
"You will operate an accelerator ('shift' key) and two other buttons to shift up ('a' key) or shift down ('z' key) \n" +
"through the gears of the transmission.  There will also be a series of gauges to inform you of how your car is \n" +
"running.\n" +
"\n" +
"If this is your first time manually shifting gears on a vehicle, here are some gear/transmission basics.\n" +
"\n" +
"	- Lower gears provide easy, quick acceleration, but low top speed.  \n" +
"		- Imagine riding a small BMX bicycle: it is very easy to pedal and get up to speed, but \n" +
"		you may only achieve 10-13 mph.\n" +
"		- If you are starting from a stop sign or red light, you should use first gear, and shift up\n" +
"		as you build speed\n" +
"	- Higher gears accelerate slowly, but can achieve very high speeds.  \n" +
"		- Imagine riding a large mountain bicycle or road bicycle: the higher gears make it very \n" +
"		difficult to pedal or accelerate, but you can relatively easily cruise above 24 mph and \n" +
"		keep up with cars in local streets.\n" +
"		- If you are holding a constant speed and not accelerating, you should use the highest gear\n" +
"		that keeps your vehicle's RPM above 1800.\n" +
"	- Most cars have usable power between 1800 - 3200 RPM.  \n" +
"		- When you shift up gears, your RPM will drop with the same vehicle speed.  Try shifting up at \n" +
"		the top of this range to keep RPM in between this range to maximize fuel economy.\n" +
"		- When you shift down, your RPM will increase with the same vehicle speed.  Try shifting down\n" +
"		at the bottom of this range to avoid over-revving your engine.\n" +
"		- If you want to maximize performance, use the RPM range of 4000 to the rev limit (9000 in this\n" +
"		case, varies by car).  However, this will burn more fuel, and revving over the limit can destroy\n" +
"		your engine.\n" +
"\n" +
"Click next to proceed, and start your car when you are ready.  Happy shifting!");
                
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        throttleButton.addKeyListener(new KeyListener(){
            @Override
            public void keyReleased(KeyEvent evt){
                mouseDown = false;
                throttleButton.setIcon(new ImageIcon(getClass().getResource("/gl/pedalN.png")));
            }
            @Override
            public void keyPressed(KeyEvent evt){
                if(evt.getKeyCode() == KeyEvent.VK_SHIFT){
                    mouseDown = true;
                    throttleButton.setIcon(new ImageIcon("pedalY.png"));
                    initThread();
                }
                if(evt.getKeyCode() == KeyEvent.VK_A){
                    checkShift(x,isEconomic);
                    if (currentGear <= 5){
                       // x-=1000;
                        x = changeUp(x);
                        currentGear+=1;
                        gearIncrease=Integer.toString(currentGear);
                        //shiftUpButton.setText("SHIFT UP BUTTON: gear " + gearIncrease);
                        shiftDownButton.setText("SHIFT DOWN BUTTON: gear " + gearIncrease);
                       // gearNumber.setText(gearIncrease);
                        changeGearImage();
                    }
                }

                if(evt.getKeyCode() == KeyEvent.VK_Z){   
                    if (currentGear >= 2){
                        //x+=1000;
                        x = changeDown(x);
                        currentGear-=1;
                        gearDecrease=Integer.toString(currentGear);
                        shiftDownButton.setText("SHIFT DOWN BUTTON: gear " + gearDecrease);
                        //shiftUpButton.setText("SHIFT UP BUTTON: gear " + gearDecrease);
                        //gearNumber.setText(gearDecrease);
                        changeGearImage();
                    }
                }
            }
            @Override
            public void keyTyped(KeyEvent evt){
                
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
                    initThread();
                } 
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                throttleButton.setBackground(Color.darkGray);
            }
        });
        
        shiftUpButton.addKeyListener(new KeyListener(){
            @Override
            public void keyReleased(KeyEvent evt){
                
            }
            @Override
            public void keyPressed(KeyEvent evt){
                
            }
            @Override
            public void keyTyped(KeyEvent evt){
                
            }
        });
        
        shiftUpButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseExited(MouseEvent evt){
                
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                
            }
            @Override
            public void mouseReleased(MouseEvent evt){

            }
            @Override
            public void mousePressed(MouseEvent evt){
                
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                if(isStart){
                    checkShift(x,isEconomic);
                    if (currentGear <= 5){
                        //x-=1000;
                        x = changeUp(x);
                        currentGear+=1;
                        gearIncrease=Integer.toString(currentGear);
                        changeGearImage();
                        //shiftUpButton.setText("SHIFT UP BUTTON: gear " + gearIncrease);
                        shiftDownButton.setText("SHIFT DOWN BUTTON: gear " + gearIncrease);
                        //gearNumber.setText(gearIncrease);
                    }
                }
            }
        });
        
        shiftDownButton.addKeyListener(new KeyListener(){
            @Override
            public void keyReleased(KeyEvent evt){
                
            }
            @Override
            public void keyPressed(KeyEvent evt){
             
            }
            @Override
            public void keyTyped(KeyEvent evt){
                
            }
        });
        
        shiftDownButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseExited(MouseEvent evt){
                
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                
            }
            @Override
            public void mouseReleased(MouseEvent evt){

            }
            @Override
            public void mousePressed(MouseEvent evt){
                
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                if(isStart){
                    if (currentGear >= 2){
                        //x-=1000;
                        currentGear-=1;
                        gearDecrease=Integer.toString(currentGear);
                        //shiftUpButton.setText("SHIFT UP BUTTON: gear " + gearDecrease);
                        shiftDownButton.setText("SHIFT DOWN BUTTON: gear " + gearDecrease);
                        //gearNumber.setText(gearIncrease);
                    }
                }
            }
        });
        
        modeButton.addMouseListener(new MouseListener(){
            @Override
            public void mouseExited(MouseEvent evt){
                
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                
            }
            @Override
            public void mouseReleased(MouseEvent evt){

            }
            @Override
            public void mousePressed(MouseEvent evt){
                
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                if(isStart){
                    if (isEconomic == true){
                        modeButton.setIcon(new ImageIcon(getClass().getResource("/gl/Flag mode.png")));
                        isEconomic = false;
                    }
                    else{
                        modeButton.setIcon(new ImageIcon(getClass().getResource("/gl/leafMode.png")));
                        isEconomic = true;
                    }
                }
            }
        });
        
        dragButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Drag_tree dt = new Drag_tree();
                
                if (isStart){
                    startButton.setIcon(new ImageIcon(getClass().getResource("/gl/stop_button.png")));
                    isStart = false;
                    stopValues();
                }
                treeThread();
                /*
                while (dt.getTreeStatus() != true){
                    if(dt.getTreeStatus()){
                        startButton.setIcon(new ImageIcon(getClass().getResource("/gl/start_button.png.png")));
                        isStart = true;
                        startValues();
                        break;
                    }
                }*/
                /*else{
                    startButton.setIcon(new ImageIcon(getClass().getResource("/gl/start_button.png.png")));
                    isStart = true;
                    startValues();
                }*/
                /*if(!frameOpen){
                    dt.setVisible(true);
                    frameOpen=true;
                }
                else{
                    frameOpen=false;
                    dt.setVisible(false);
                }
                */
            }
        });

        frame.pack();
        frame.setVisible(true);   
    }
    

public void ButtonLook() {                                            
    startButton.setIcon(new ImageIcon(getClass().getResource("/gl/stop_button.png")));
    //startButton.setBackground(Color.darkGray);
    startButton.setContentAreaFilled(false);
    startButton.setFocusPainted(false);
            
    throttleButton.setIcon(new ImageIcon(getClass().getResource("/gl/pedalN.png")));
    //throttleButton.setBackground(Color.darkGray); 
    throttleButton.setContentAreaFilled(false);
    //throttleButton.setOpaque(false);
    throttleButton.setFocusPainted(false);
    
    modeButton.setIcon(new ImageIcon(getClass().getResource("/gl/Flag mode.png")));
    modeButton.setContentAreaFilled(false);
    //modeButton.setBackground(Color.darkGray);
    modeButton.setFocusPainted(false);
    
    //shiftUpButton.setText("SHIFT UP BUTTON: gear 0");
    //shiftUpButton.setBackground(Color.darkGray);
    shiftUpButton.setContentAreaFilled(false);
    shiftUpButton.setForeground(Color.cyan);
    shiftUpButton.setFocusPainted(false);
    
    shiftDownButton.setText("SHIFT DOWN BUTTON: gear 0");
    //shiftDownButton.setBackground(Color.darkGray);
    shiftDownButton.setContentAreaFilled(false);
    shiftDownButton.setForeground(Color.cyan);
    shiftDownButton.setFocusPainted(false);
    
    shiftFeedback.setBackground(Color.darkGray);
    shiftFeedback.setForeground(Color.WHITE);
    shiftFeedback.setFont(new Font("Courier", Font.BOLD, 30));
    shiftFeedback.setHorizontalTextPosition(JLabel.CENTER);
    shiftFeedback.setVerticalTextPosition(JLabel.CENTER);
    shiftFeedback.setText("Shift Feedback: (try shifting!)");
    
    dragButton.setIcon(new ImageIcon(getClass().getResource("/gl/drag_icon.png")));
    dragButton.setContentAreaFilled(false);
    dragButton.setFocusPainted(false);
}
public void goToSleep(int x){
    try {
        Thread.sleep(x);
    } catch (InterruptedException ex) {
        Logger.getLogger(gauge.class.getName()).log(Level.SEVERE, null, ex);
    }
}
private boolean isRunning = false;
private synchronized boolean checkAndMark() {
    if (isRunning) return false;
    isRunning = true;
    return true;
} 

private void treeThread(){
    new Thread(){
        public void run(){
            goToSleep(2300);
            //this is where you reactivate the buttons
            startButton.setIcon(new ImageIcon(getClass().getResource("/gl/start_button.png.png")));
            isStart = true;
            startValues();
            
        }
    }.start();
}

// creates a thread in run time
private void initThread() {
    if (checkAndMark()) {
        new Thread() {
            public void run() {
                do {
                    //sleeps the system, so that we dont build the values too fast
                    goToSleep(50);
                    
                    // checks to display vtec
                    x = isVtec(x);
                    // checks rev limit, 
                    x = isRevLimit(x);
                    
                    // increment speed and display
                    speedNum = x * currentGear *0.0043021;
                    speedNum = Math.round(speedNum * 100.0) / 100.0;
                    speedIncrease = Double.toString(speedNum);
                    //speed.setText(speedIncrease + " MPH");
                    mphGauge.setValue(speedNum);
                    /*
                   if ((currentGear == 1) && (speedNum < 45)){
                    speedNum=speedNum+.5;
                    speedIncrease = Double.toString(speedNum);
                    speed.setText(speedIncrease + " MPH");
                   }
                   else if ((currentGear == 2) && (speedNum < 60)){
                    speedNum=speedNum+.5;
                    speedIncrease = Double.toString(speedNum);
                    speed.setText(speedIncrease + " MPH");
                   }
                    */
              
                    // RPM increase
                    x = x + 100/currentGear;  
                    rpmIncrease = Integer.toString(x);
                    rpmGauge.setValue(x);
                    //rpm.setText(rpmIncrease + " RPM");
                    
                    
                    fuelGauge.setLcdValue(calcFuel());
                    distanceGauge.setLcdValue(calcDist());
                    
                    //increase boost with a limit of 20
                    boost++;
                    boostIncrease = Integer.toString(boost);
                    boostGauge.setValue(boost);
                    //psiLabel.setText(boostIncrease + " PSI");
                    
                    isBoost(boost);
                    isVacuum(boost);
                    
                    boost = isBoostLimit(boost);
                    
                    shiftTell(x);
                    
                    
                } while (mouseDown);
                isRunning = false;
                throttleButton.setIcon(new ImageIcon("pedalN.png"));
                // once the mouse is released, this loop is entered.
                    do {
                        //sleep so it doesn't decrease topo quickly
                        goToSleep(30);
                        
                        //disable the loop once all of the parameters have been met.
                        if (!isStart){
                               //System.out.println("stopped!");
                        break;
                        }
                        
                        //decrement the RPM
                        x-=50;
                        // decrease the RPM
                        rpmDecrease = Integer.toString(x);
                        rpmGauge.setValue(x);
                        //rpm.setText(rpmDecrease + " RPM");
                        
                        
                        // decrease speed.
                        speedNum = x * currentGear *0.0043021;
                        speedNum = Math.round(speedNum * 100.0) / 100.0;
                        speedDecrease = Double.toString(speedNum);
                        mphGauge.setValue(speedNum);
                        //speed.setText(speedDecrease + " MPH");
                        
                        // to synchronize, forces speed to only have a min value of 0
                        if(speedNum < 0){
                            speedNum = 0;
                            speedDecrease = Double.toString(speedNum);
                            mphGauge.setValue(speedNum);
                            //speed.setText(speedDecrease + " MPH");
                        }
                        
                        
                        
                        //vtec remove once dropped out of 5000
                        if (x < 5000)
                            //vtecdisplay.setText("");
                      
                        // minimum RPM is 800
                        if (x <= 800) {
                            x=800;
                            rpmDecrease = Integer.toString(x);
                            rpmGauge.setValue(x);
                            //rpm.setText(rpmDecrease + " RPM");
                        }
                        
                        fuelGauge.setLcdValue(calcFuel());
                        distanceGauge.setLcdValue(calcDist());
                        
                        
                        
                        // decrement boost, only allow for -25
                        boost--;
                        boostDecrease = Integer.toString(boost);
                        boostGauge.setValue(boost);
                        //psiLabel.setText(boostDecrease + " PSI");
                        isBoost(boost);
                        isVacuum(boost);
                        boost = isBoostLimitNeg(boost);
                        
                        shiftTell(x);
                        
                        // to exit loop when min reached disable comment:
                        /*
                        if (boost <=- 25 && x <= 800){
                           break;
                        }
                        */
                        
                        
                    }while (mouseDown == false);
                
                  
            }
        }.start();
    }
}
private void startValues(){
        x=800;
        boost = -25;
        rpmGauge.setValue(x);
        mphGauge.setValue(0);
        boostGauge.setValue(boost);
        currentGear = 1;
        changeGearImage();
        //shiftUpButton.setText("SHIFT UP BUTTON: gear 1");
        shiftDownButton.setText("SHIFT DOWN BUTTON: gear 1");
        startButton.setEnabled(true);
        fuelGauge.setLcdValue(0);
        distanceGauge.setLcdValue(0);
                        
        if(isEconomic){
            //ModePic.setIcon(leaf);
        }
        else{
            //ModePic.setIcon(flag);
        isStart = true;
        }
}
private void stopValues(){
        x=0;
        boost = 0;
        rpmGauge.setValue(x);
        mphGauge.setValue(0);
        boostGauge.setValue(boost);
        currentGear = 0;
        //shiftUpButton.setText("SHIFT UP BUTTON: gear 0");
        shiftDownButton.setText("SHIFT DOWN BUTTON: gear 0");
        //speed.setText("0 MPH");
        //psiLabel.setText("0 PSI");
        //boostLabel.setText("Vacuum");
        //rpm.setText("0 RPM");
        //mode.setEnabled(false);
        //throttleButton.setEnabled(false);
        //shiftUpButton.setEnabled(false);
        //shiftDownButton.setEnabled(false);
        startButton.setEnabled(true);
        fuelGauge.setLcdValue(0);
        distanceGauge.setLcdValue(0);
        
        //ModePic.setIcon(new ImageIcon(""));
        //isEconomic = true;
        isStart = false;
}   

public void keyPressed(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_A){
        checkShift(x,isEconomic);
            if (currentGear <= 5){
               // x-=1000;
                x = changeUp(x);
                currentGear+=1;
                gearIncrease=Integer.toString(currentGear);
                //gearNumber.setText(gearIncrease);
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_Z){   
            if (currentGear >= 2){
                //x+=1000;
                x = changeDown(x);
                currentGear-=1;
                gearDecrease=Integer.toString(currentGear);
                //gearNumber.setText(gearDecrease);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            mouseDown = true;
            throttleButton.setIcon(new ImageIcon("pedalY.png"));
            initThread();
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
        shiftFeedback.setForeground(Color.red);
        shiftFeedback.setFont(new Font("Courier", Font.BOLD, 24));
        shiftFeedback.setText("You blew your engine! Let the RPM drop more before downshifting");
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

public double calcFuel() {
    return speedNum/(x/(currentGear*200));    
}

public double calcDist() {
    return distCovered += (speedNum/36000);    
}

public boolean isRaceDone() {
    if (distCovered >= .25) {
        //race done, you used 'fuelUsed' units of fuel
        return true;
    }
    return false;
}

public void changeGearImage() {
    shiftUpButton.setIcon(new ImageIcon(getClass().getResource(Integer.toString(currentGear)+".png")));
}

public void shiftTell(int x)
{
    if(!isEconomic)
    {
        if(x >= PerfLowerBound && x <= PerfUpperBound)
        {
            rpmGauge.setLedColor(LedColor.GREEN_LED);
            //shiftTell.setText("Shift Up");
        }
        else{
            rpmGauge.setLedColor(LedColor.RED_LED);
            //shiftTell.setText("");
        }
    }
    else
    {
        if(x >= EcoLowerBound && x <= EcoUpperBound)
        {
            rpmGauge.setLedColor(LedColor.GREEN_LED);
            //shiftTell.setText("Shift Up");
        }
        else{
            rpmGauge.setLedColor(LedColor.RED_LED);
            //shiftTell.setText("");
        }
    }
}
    public static final int EcoUpperBound = 2500;
    public static final int EcoLowerBound = 1800;
    public static final int PerfLowerBound = 8500;
    public static final int PerfUpperBound = 9200;


private void checkShift(int x, boolean eco){
    
    if(x <= EcoLowerBound && eco){
        //checkShiftLabel.setText("Early shift.");
        shiftFeedback.setForeground(Color.red);
        shiftFeedback.setText("Shift Feedback: Early shift!");
    }
    else if(x >= EcoLowerBound && x <= EcoUpperBound && eco){
        //checkShiftLabel.setText("Good economic shift!");
        shiftFeedback.setForeground(Color.green);
        shiftFeedback.setText("Shift Feedback: Good economic shift!");
    }
    else if (x >= EcoUpperBound && eco){
        //checkShiftLabel.setText("Late shift.");
        shiftFeedback.setForeground(Color.red);
        shiftFeedback.setText("Shift Feedback: Late shift!");
    }
    if(x <= PerfLowerBound && !eco){
         //checkShiftLabel.setText("Early shift. (Too soon junior!)");
        shiftFeedback.setForeground(Color.red);
        shiftFeedback.setText("Shift Feedback: Early shift (too soon junior)!");
    }
    if(x >= PerfLowerBound && x <= PerfUpperBound && !eco){
         //checkShiftLabel.setText("Good performance shift!");
        shiftFeedback.setForeground(Color.green);
        shiftFeedback.setText("Shift Feedback: Good performance shift!");
    }

}
    
    
    
    
}
