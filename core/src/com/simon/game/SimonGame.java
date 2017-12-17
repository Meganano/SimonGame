package com.simon.game;

import javax.swing.Timer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SimonGame extends Game{
	public SpriteBatch batch;
	public int flash;

	public void iskeypressed() {
		if (Gdx.input.isKeyJustPressed(Keys.A)) {
			flash = 1;
		}
		if (Gdx.input.isKeyJustPressed(Keys.S)) {
			flash = 2;
		}
		if (Gdx.input.isKeyJustPressed(Keys.Z)) {
			flash = 3;
		}
		if (Gdx.input.isKeyJustPressed(Keys.X)) {
			flash = 4;
		}
	}
	public void update() {
		iskeypressed();
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this)); 
	}
	
	
	@Override
	public void render() {
		batch.begin();
		update();
        batch.draw(GameScreen.simonImg, 0,0);
        if(flash == 1) {
        	System.out.println("GREEN");
        	batch.draw(GameScreen.greenImg, 0,0);
        }
         
        if(flash == 2) {
        	System.out.println("RED");
        	batch.draw(GameScreen.redImg, 0,0);
        }
        if(flash == 3) {
        	System.out.println("YELLOW");
        	batch.draw(GameScreen.yellowImg, 0,0);
        }
        if(flash == 4) {
        	System.out.println("BLUE");
        	batch.draw(GameScreen.blueImg, 0,0);
        }
       try {
		Thread.sleep(130);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       flash = 0;
       batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}	
}