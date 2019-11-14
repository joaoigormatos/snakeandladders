package br.quixada.ufc.snakeandladders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameLogic extends Game {
	SpriteBatch batch;
	Texture img;
	int screen_width;
	int screen_height;
	public GameLogic(int screen_width, int screen_height){
		this.screen_width = screen_width;
		this.screen_height = screen_height;
	}
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

	}
	//256
	//600
	//600 - 256 = 600 - 256 =

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 190, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
