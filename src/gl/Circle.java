package gl;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.geom.AffineTransform;
import eu.hansolo.steelseries.gauges.Radial;
import java.awt.Color;

//class for the circle
public class Circle extends JPanel implements ActionListener {

	double angle;
        int makeone;
        gaugeForm g;
	Timer timer;
        gauge d;
        int n = 0;
        //Image im = new Image();
        
	Circle() {
		super(null);
                gl.gaugeForm gauge = new gl.gaugeForm();
                gauge.setVisible(true);
                gauge.setBackground(Color.BLUE);
                gl.gauge g7 = new gl.gauge();
                //g7.setVisible(true);
                g7.createAndShowUI();
                //g7.button.doClick();
                d = g7;
                g = gauge;
		timer = new Timer(100, this);
		timer.start();
	}
        @Override
	public void actionPerformed(ActionEvent e) {
                
                angle += g.speedNum/100;
		if(angle > (2* Math.PI))
			angle = 0.0;
                
                d.mphGauge.setValue(g.speedNum);
                d.rpmGauge.setValue(g.x);
                d.boostGauge.setValue(g.boost);
                
		repaint();
                //d.mphGauge.setValueAnimated(g.speedNum);
                
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
                g.setColor(Color.red);
		int width = getWidth();
		int height = getHeight();
		int x = (int) (Math.cos(angle) * (width / 3) + (width / 2));
		int y = (int) (Math.sin(angle) * (height / 3) + (height / 2));
		//g.fillOval(x, y, 10, 10);
                
                BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File("carsprite.png"));
                    } catch (IOException e) {
                    }
                //double rotationRequired = Math.toRadians(135 + angle);
                ///if (x < 300){
                 //   rotationRequired = Math.toRadians(y);
                //}
                
                double locationX = img.getWidth() / 2;
                double locationY = img.getHeight() / 2;
               
                AffineTransform tx = AffineTransform.getRotateInstance(angle + Math.toRadians(135), locationX, locationY);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

                
                
                // Drawing the rotated image at the required drawing locations
                g.drawImage(op.filter(img, null), x, y, null);
                //g.drawImage(img, x, y, this);
	}
	
	
}
