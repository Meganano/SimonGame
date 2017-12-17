package com.simon.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class CheckPress {
	
	public int flash;
	
	public int iskeypressed() {
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
		return flash;
	}
}
