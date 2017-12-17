package com.simon.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends ScreenAdapter {

	public SimonGame simonGame;
    public static final Texture simonImg = new Texture("simon.jpg");
    public static final Texture greenImg = new Texture("green.jpg");
    public static final Texture redImg = new Texture("red.jpg");
    public static final Texture yellowImg = new Texture("yellow.jpg");
    public static final Texture blueImg = new Texture("blue.jpg");

    public GameScreen(SimonGame simonGame){
       this.simonGame = simonGame;
    }
    
    

}



