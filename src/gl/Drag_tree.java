/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.Toolkit;

/**
 *
 * @author ottp
 * @version 1.0
 */
public class Drag_tree extends JFrame {
    
    private JLabel jLabel;
    Timer timer1;
    int count = 1;

    public static final String[] image_path = {
        "src\\gl\\Drag_tree1.png",
        "src\\gl\\Drag_tree2.png",
        "src\\gl\\Drag_tree3.png",
        "src\\gl\\Drag_tree4.png",
        "src\\gl\\Drag_tree5.png"
    };
    public Drag_tree() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        JPanel panel = new JPanel(new BorderLayout());
        jLabel = new JLabel(new ImageIcon("src\\gl\\Drag_tree.png"));
        panel.add(jLabel);
        
        timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            int loop = 1;
            
            public void run() {
                if (loop < 6) {
                    jLabel.setIcon(new ImageIcon("src\\gl\\Drag_tree"+Integer.toString(loop)+".png"));
                    loop++;
                } 
                else {
                    jLabel.setIcon(new ImageIcon("src\\gl\\Drag_tree5.png"));
                    timer1.cancel();
                }
            }
            
        }, 0, 5*100);
        this.getContentPane().add(panel);
        this.setVisible(true);
        
        
        /*
        for(int i = 1; i<6; i++) {      
            timer1 = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jLabel.setIcon(new ImageIcon("src\\gl\\Drag_tree"+Integer.toString(count)+".png"));            
                }
            });
            timer1.start();
            count++;
            this.getContentPane().add(panel);
            this.setVisible(true);
        } */   
    }
}

