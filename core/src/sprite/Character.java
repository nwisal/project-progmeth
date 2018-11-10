package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Character {
	protected static final int GRAVITY = -11;
	protected Texture texture;
	protected Vector2 position;
	protected Rectangle hitBox;
	protected Vector2 velocity = new Vector2();
	
	public Character(int x, int y) {
		position = new Vector2(x, y);
	}
	
	public abstract void update(float dt);
	
	public Texture getTexture() {
		return texture;
	}

	public Vector2 getPosition() {
		return position;
	}
	
	public abstract Rectangle getHitBox();

	public void fly() {
		velocity.y=140;
	}

}
