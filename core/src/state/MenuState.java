package state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sprite.Character1;

public class MenuState extends State {
	private Texture background;
    private Texture char1;
    private Texture char2;
    private Texture choose;

    public MenuState(manage.GSM gsm) {
        super(gsm);
        background = new Texture("bg.png");
        char1 = new Texture("Balloon.png");
        char2 = new Texture("Plane.png");
        choose = new Texture("Choose-Your-Character.png");
        
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.getX() < (com.dnfb.game.Main.WIDTH/2)+(char1.getWidth()/2) 
        		&& Gdx.input.getX() > (com.dnfb.game.Main.WIDTH/2)-(char1.getWidth()/2)
        		&& Gdx.input.getY() < ((com.dnfb.game.Main.HEIGHT/8)*6) + char1.getHeight() 
        		&& Gdx.input.getY() > (com.dnfb.game.Main.HEIGHT/8)*6){
        	Character1 choosenChar = new Character1(300,50);
            gsm.set(new PlayingState(gsm, choosenChar));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
    handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, com.dnfb.game.Main.WIDTH, com.dnfb.game.Main.HEIGHT );
        sb.draw(choose, (com.dnfb.game.Main.WIDTH/2)-(choose.getWidth()/2), (com.dnfb.game.Main.HEIGHT/8)*6);
        sb.draw(char1, (com.dnfb.game.Main.WIDTH/4)-(char1.getWidth()/2), (com.dnfb.game.Main.HEIGHT/8)*5);
        sb.draw(char2, ((com.dnfb.game.Main.WIDTH/4)*3)-(char2.getWidth()/2), (com.dnfb.game.Main.HEIGHT/8)*5);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        choose.dispose();
        char1.dispose();
        char2.dispose();
    }

}
