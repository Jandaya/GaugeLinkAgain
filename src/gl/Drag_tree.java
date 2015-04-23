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
import javax.swing.Timer;

/**
 *
 * @author ottp
 * @version 1.0
 */
public class Drag_tree extends JFrame {

    private JLabel jLabel;
    private Timer timer1;
    private Timer timer2;
    private Timer timer3;
    private Timer timer4;
    private Timer timer5;

    public Drag_tree() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        JPanel panel = new JPanel(new BorderLayout());
        jLabel = new JLabel(new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\GaugeLinkAgain\\src\\gl\\Drag_tree.png"));

        panel.add(jLabel);
        timer1 = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\GaugeLinkAgain\\src\\gl\\Drag_tree1.png"));
                timer2 = new Timer(500, new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jLabel.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\GaugeLinkAgain\\src\\gl\\Drag_tree2.png"));
                        timer3 = new Timer(500, new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                jLabel.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\GaugeLinkAgain\\src\\gl\\Drag_tree3.png"));
                                timer4 = new Timer(500, new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jLabel.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\GaugeLinkAgain\\src\\gl\\Drag_tree4.png"));
                                        timer5 = new Timer(500, new ActionListener() {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                jLabel.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\GaugeLinkAgain\\src\\gl\\Drag_tree5.png"));
                                            }
                                        });
                                        timer5.start();
                                    }
                                });
                                timer4.start();
                            }
                        });
                        timer3.start();
                    }
                });
                timer2.start();
            }
        });
        timer1.start();

        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}

