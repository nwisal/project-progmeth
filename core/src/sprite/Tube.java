package sprite;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tube {
	
	private static final int FLUCTUATION = 130;
	private static final int TUBE_GAP = 100;
	private static final int LOWEST_OPENING = 120;
	public static final int TUBE_WIDTH = 52;
	private Rectangle hitTop;
	private Rectangle hitBot;
	private Vector2 posTopTube,posBotTube;
	private Texture topTube,botTube;
	private Random rand;
	
	public Tube(String pathTop,String pathBot,float x) {
		topTube = new Texture(pathTop);
		botTube = new Texture(pathBot);
		rand = new Random();
		
		posTopTube = new Vector2(x ,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
		posBotTube = new Vector2(x, posTopTube.y-TUBE_GAP-botTube.getHeight());
		
		hitTop = new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth(),topTube.getHeight());
		hitBot = new Rectangle(posBotTube.x,posBotTube.y,botTube.getWidth(),botTube.getHeight());
	}
	
	public void rePos(float x) {
		posTopTube.set(x, rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
		posBotTube.set(x, posTopTube.y-TUBE_GAP-botTube.getHeight());
		hitTop.setPosition(posTopTube);
		hitBot.setPosition(posBotTube);
	}
	
	public boolean collides(Rectangle player) {
		return player.overlaps(hitTop)||player.overlaps(hitBot);
	}
	
	public Vector2 getPosTopTube() {
		return posTopTube;
	}

	public Vector2 getPosBotTube() {
		return posBotTube;
	}

	public Texture getTopTube() {
		return topTube;
	}

	public Texture getBotTube() {
		return botTube;
	}
}
