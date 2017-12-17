package com.simon.game;

import java.util.ArrayList;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class GameScreen extends ScreenAdapter{

	private SimonGame simonGame;
	private CheckPress checkPress;
	
    private static final Texture simonImg = new Texture("simon.jpg");
    private static final Texture greenImg = new Texture("green.jpg");
    private static final Texture redImg = new Texture("red.jpg");
    private static final Texture yellowImg = new Texture("yellow.jpg");
    private static final Texture blueImg = new Texture("blue.jpg");
    
    
    public ArrayList listAns = new ArrayList();
    
    public GameScreen(SimonGame simonGame){
       this.simonGame = simonGame;
    }
    
    
    
    public void render(float delta) {
    	SpriteBatch batch = simonGame.batch;
    	batch.begin();
    	
    	batch.draw(GameScreen.simonImg, 0,0);
    	
    	drawsimon();
    	
    	batch.end();
    }
    
    public void drawsimon() {
    	SpriteBatch batch = simonGame.batch;
    	
    	checkPress = new CheckPress();
    	
    	if(checkPress.iskeypressed() == 1) {
        	System.out.println("GREEN");
        	batch.draw(GameScreen.greenImg, 0,0);
        }
         
        if(checkPress.iskeypressed() == 2) {
        	System.out.println("RED");
        	batch.draw(GameScreen.redImg, 0,0);
        }
        if(checkPress.iskeypressed() == 3) {
        	System.out.println("YELLOW");
        	batch.draw(GameScreen.yellowImg, 0,0);
        }
        if(checkPress.iskeypressed() == 4) {
        	System.out.println("BLUE");
        	batch.draw(GameScreen.blueImg, 0,0);
        }
        
        if(checkPress.iskeypressed() != 0) {
        	listAns.add(checkPress.iskeypressed());
        }
        System.out.println(listAns);
        
       try {
		Thread.sleep(130);
       } 
       catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
       }
       checkPress.flash = 0;
    }
}



