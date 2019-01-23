package elastic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ElasticMovement extends JPanel {
	//ball arguments:
	//x,y,speed of x,speed of y
	Ball ball1 = new Ball(40,200,2,3,this);
	Ball ball2 = new Ball(0,200,-4,4,this);
	boolean collision () {
		return ball1.getBounds().intersects(ball2.getBounds());
	}
	private void move() {
		if(collision()) {
			int a = ball1.vX;
			int b = ball1.vY;
			ball1.vX = ball2.vX;
			ball2.vX = a;
			ball1.vY = ball1.vY;
			ball2.vY = b;
		}
		ball1.move();
	ball2.move();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball1.paint(g2);
	ball2.paint(g2);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		  frame.setSize(500,400);
		  frame.setVisible(true);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 ElasticMovement el = new ElasticMovement();
		 frame.add(el);
		  while(true) {
			  el.move();
			  el.repaint();
			  try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		  }
	}

}
