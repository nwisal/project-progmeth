package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Character1 extends Character {
	private static final float MOVEMENT = 80;
	
	public Character1(int x, int y) {
		super(x, y);
		texture = new Texture("CharTest.png");
		hitBox = new Rectangle(x+(texture.getWidth()/2)-14,y+(texture.getHeight()/2)-14,28,28);
	}

	@Override
	public void update(float dt) {
		velocity.add(0,GRAVITY);
		velocity.scl(dt);
		position.add(velocity);
		position.add(MOVEMENT*dt,velocity.y);
		velocity.scl(1/dt);
		if(position.y<-12) {
			position.y=-12;
		}
		hitBox.setPosition(position.x+(texture.getWidth()/2)-14,position.y+(texture.getHeight()/2)-14);
	}

	public Rectangle getHitBox() {
		return hitBox;
	}
	
}
