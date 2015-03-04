package gl;
//comment
import javax.swing.JFrame;

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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.add(new Circle());
	frame.setSize(500, 500);
	frame.setVisible(true);
    }
    
}
