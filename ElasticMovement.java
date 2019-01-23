package elastic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ElasticMovement extends JPanel {
	Ball ball1 = new Ball(0,200,2,3,5,this);
//	Ball ball2 = new Ball(200,200,-2,0,5,this);
//	boolean collision () {
//		return ball1.getBounds().intersects(ball2.getBounds());
//	}
	private void move() {
//		if(collision()) {
//			ball1.vX = ((ball1.mass - ball2.mass)/(ball1.mass + ball2.mass))*ball1.vX + ((2*ball2.mass)/(ball1.mass + ball2.mass))*ball2.vX;
//			ball2.vX = ((ball2.mass - ball1.mass)/(ball1.mass + ball2.mass))*ball2.vX + ((2*ball1.mass)/(ball1.mass + ball2.mass))*ball1.vX;
//		}
		ball1.move();
//		ball2.move();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball1.paint(g2);
//		ball2.paint(g2);
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
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		  }
	}

}
