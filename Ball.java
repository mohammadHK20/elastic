	package elastic;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	   int x,y;
	   int vX,vY;
	  private ElasticMovement elasticMovement;
	  
	  public Ball(int x,int y,int vX,int vY,ElasticMovement elasticMovement) {
		this.x = x;
		this.y = y;
		this.vX = vX;
		this.vY = vY;
		this.elasticMovement = elasticMovement;
	  }
	  
	  public void move() {
		  if (x + vX < 0)
				vX = -vX;
			if (x + vX > elasticMovement.getWidth() - 30)
				vX = -vX;
			if (y + vY < 0)
				vY = -vY;
			if (y + vY > elasticMovement.getHeight() - 30)
				vY = -vY;
			x += vX;
			y += vY;
	  }
	  
		public void paint(Graphics2D g) {
			g.fillOval(x,y,30,30);
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x,y,30,30);
		}
}
