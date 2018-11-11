package manage;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import state.State;

public class GSM {
	private Stack<State> states;
	
	public GSM() {
		states = new Stack<State>();
	}
	
	public void push(State state) {
		states.push(state);
	}
	
	public void pop() {
		states.pop();
	}
	
	public void set(State state) {
		states.pop();
		states.push(state);
	}
	
	public void update(float dt) {
		states.peek().update(dt);
	}

	public void render(SpriteBatch sb) {
		states.peek().render(sb);
	}

	public void dispose() {
		// TODO Auto-generated method stub
		states.clear();
	}
	
}
