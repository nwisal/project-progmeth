package state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import manage.GSM;

public abstract class State {
	protected OrthographicCamera cam;
	protected Vector2 mouse;
	protected GSM gsm;
	
	public State(GSM gsm) {
		this.gsm=gsm;
		cam = new OrthographicCamera();
		mouse = new Vector2();
	}
	
	protected abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render(SpriteBatch sb);
	public abstract void dispose();
}
