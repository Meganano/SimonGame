package com.simon.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class GameScreen extends ScreenAdapter{

	private SimonGame simonGame;
	private CheckPress checkPress;
	private RandomColour randomColour;
	
    private static final Texture simonImg = new Texture("simon.jpg");
    private static final Texture overImg = new Texture("simonover.jpg");
    private static final Texture greenImg = new Texture("green.jpg");
    private static final Texture redImg = new Texture("red.jpg");
    private static final Texture yellowImg = new Texture("yellow.jpg");
    private static final Texture blueImg = new Texture("blue.jpg");
    private static final Texture nextImg = new Texture("next.jpg");
    
    private int lengthQ; 
    private int count= 0;
    private int stage = 0;
    public ArrayList  listQ = new ArrayList();
    
    public BitmapFont font, next;
    public boolean gameover = false;
    public boolean waitinput = false;
    
    public GameScreen(SimonGame simonGame){
       this.simonGame = simonGame;
       checkPress = new CheckPress();
       randomColour = new RandomColour();
       font = new BitmapFont();
       next = new BitmapFont();
    }
    
    
    
    public void render(float delta) {
    	SpriteBatch batch = simonGame.batch;
    	batch.begin();
    	if(!gameover) {
    		batch.draw(GameScreen.simonImg, 0,0);
    		createStage();
    		font.draw(batch, "Stage: "+stage, 325, 350);
    		font.draw(batch, "Pressed: "+ count, 325, 325);
    		
    		
    	}
    	else {
    		batch.draw(GameScreen.overImg, 0,0);
    	}
    	batch.end();
    }
   
    
    public void checkAns() {
    	SpriteBatch batch = simonGame.batch;
    	checkPress = new CheckPress();
    	//System.out.println("Ans: "+listAns);
    	
	    int press = checkPress.iskeypressed();
	    drawsimon(press);
	    if(press != (Integer) listQ.get(count) && press != 0) {
	    	gameover = true;
	    }
	    else if (press == (Integer) listQ.get(count)) {
	    	//System.out.println("Check");
	    	if(count+1 == lengthQ) {
	    		System.out.println("Check");
	    		waitinput = false;
	    	}
	    	count++;
	    }
	    //System.out.println("Ans: "+press + "i2: "+count);
	    	
	    }	
    
    
    public void createStage() {
    	if(waitinput == false) {
    		count = 0;
	    	int num;
	    	SpriteBatch batch = simonGame.batch;
	    		
	    	num = randomColour.randomnum();
	    	listQ.add(num);
	    	//System.out.println(listQ);
	    		
	    	lengthQ = listQ.size();
	    	//System.out.println("length: "+lengthQ);
	    		
	    	int i = 0;
	    	while(i < lengthQ) {
	    		//System.out.println("i: "+i);
	    		//System.out.println("in Q : "+listQ.get(i));
	    		drawsimon((Integer) listQ.get(i));
	    			
	    		try {
	     		 	Thread.sleep(200);
	     		 } 
	    		catch (InterruptedException e) {
	     		 	// TODO Auto-generated catch block
	     		 	e.printStackTrace();
	     		 }
	    		i++;
	    	}
	    	stage++;
	    	
    	}
    	if(!Gdx.input.isKeyJustPressed(Keys.A) | !Gdx.input.isKeyJustPressed(Keys.S) | !Gdx.input.isKeyJustPressed(Keys.Z) | Gdx.input.isKeyJustPressed(Keys.X)) {
    		waitinput = true;
    		checkAns();
    	}

    
    	//System.out.println("+++++++++++++++++++");
    
    	try {
    		 Thread.sleep(200);
    	} 
    	catch (InterruptedException e) {
    		 // TODO Auto-generated catch block
    		 e.printStackTrace();
    	}
    }

    public void drawsimon(int colour) {
    	SpriteBatch batch = simonGame.batch;
    	
    	
    	if(colour == 1) {
        	//System.out.println("GREEN");
        	batch.draw(GameScreen.greenImg, 0,0);
        }
         
        if(colour == 2) {
        	//System.out.println("RED");
        	batch.draw(GameScreen.redImg, 0,0);
        }
        if(colour == 3) {
        	//System.out.println("YELLOW");
        	batch.draw(GameScreen.yellowImg, 0,0);
        }
        if(colour == 4) {
        	//System.out.println("BLUE");
        	batch.draw(GameScreen.blueImg, 0,0);
        }
    }
}



