package gl;
//comment

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;



//class for the circle
public class Circle extends JPanel implements ActionListener {

	double angle;
        int makeone;
        gaugeForm g;
	Timer timer;
	Circle() {
		super(null);
                gl.gaugeForm gauge = new gl.gaugeForm();
                gauge.setVisible(true);
                g = gauge;
		timer = new Timer(100, this);
		timer.start();
	}
        @Override
	public void actionPerformed(ActionEvent e) {
                angle += g.speedNum/100;
		if(angle > (2* Math.PI))
			angle = 0.0;
		repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int x = (int) (Math.cos(angle) * (width / 3) + (width / 2));
		int y = (int) (Math.sin(angle) * (height / 3) + (height / 2));
		g.fillOval(x, y, 10, 10);
	}
	
	
}
