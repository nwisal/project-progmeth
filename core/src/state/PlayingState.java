package state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.dnfb.game.Main;

import manage.GSM;
import sprite.Character1;
import sprite.Tube;
import sprite.Character;

public class PlayingState extends State {

	private static final int TUBE_SPACE = 150;
	private static final int TUBE_COUNT = 4;
	private static final int GROUND_HIGHT_OFFSET = -50;
	private Character ch;
	private Array<Tube> tubes;
	private Vector2 Posground1,Posground2;
	private Texture ground;
	
	public PlayingState(GSM gsm, Character choosenChar) {
		super(gsm);
		ch = choosenChar;
		tubes = new Array<Tube>();
		for(int i=0;i<TUBE_COUNT;i++) {
			tubes.add(new Tube("topTube.png", "botTube.png", 200+i*(TUBE_SPACE+Tube.TUBE_WIDTH)));
		}
		cam.setToOrtho(false, Main.WIDTH/2, Main.HEIGHT/2);
		ground = new Texture("ground.png");
		Posground1 = new Vector2(cam.position.x-cam.viewportWidth/2, GROUND_HIGHT_OFFSET);
		Posground2 = new Vector2((cam.position.x-cam.viewportWidth/2)+ground.getWidth(), GROUND_HIGHT_OFFSET);
	}

	@Override
	protected void handleInput() {
		if(Gdx.input.isTouched()) {
			ch.fly();
		}
	}

	@Override
	public void update(float dt) {
		handleInput();
		ch.update(dt);
		if(cam.position.x-(cam.viewportWidth/2)>Posground1.x+ground.getWidth()) {
			Posground1.add(ground.getWidth()*2,0);
		}
		if(cam.position.x-(cam.viewportWidth/2)>Posground2.x+ground.getWidth()) {
			Posground2.add(ground.getWidth()*2,0);
		}
		cam.position.x = ch.getPosition().x+80;
		for(Tube t:tubes) {
			if(cam.position.x-(cam.viewportWidth/2)>t.getPosTopTube().x+t.getTopTube().getWidth()) {
				t.rePos(t.getPosTopTube().x+(Tube.TUBE_WIDTH+TUBE_SPACE)*TUBE_COUNT);
			}
			if(t.collides(ch.getHitBox())) {
				gsm.set(new MenuState(gsm));
			}
		}
		if(ch.getPosition().y<=ground.getHeight()+GROUND_HIGHT_OFFSET) {
			gsm.set(new MenuState(gsm));
		}
		cam.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sb.draw(ch.getTexture(),ch.getPosition().x,ch.getPosition().y);
		for(Tube t:tubes) {
			sb.draw(t.getTopTube(),t.getPosTopTube().x,t.getPosTopTube().y);
			sb.draw(t.getBotTube(),t.getPosBotTube().x,t.getPosBotTube().y);
		}
		sb.draw(ground,Posground1.x,Posground1.y);
		sb.draw(ground,Posground2.x,Posground2.y);
		sb.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
