package com.simon.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends ScreenAdapter {

    public SimonGame simonGame;
    public static final Texture simonImg = new Texture("simon.jpg");

    public GameScreen(SimonGame simonGame){
        this.simonGame = simonGame;
    }
    
    

}



