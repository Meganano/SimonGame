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
    
    private int lengthQ; 
    public ArrayList listAns = new ArrayList();
    public ArrayList  listQ = new ArrayList();
    
    public BitmapFont font;
    public boolean gameover = false;
    public boolean waitinput = false;
    
    public GameScreen(SimonGame simonGame){
       this.simonGame = simonGame;
       checkPress = new CheckPress();
       randomColour = new RandomColour();
       
    }
    
    
    
    public void render(float delta) {
    	SpriteBatch batch = simonGame.batch;
    	batch.begin();
    	if(!gameover) {
    		batch.draw(GameScreen.simonImg, 0,0);
    		createStage();
    	}
    	else {
    		batch.draw(GameScreen.overImg, 0,0);
    	}
    	batch.end();
    }
   
    
    public void checkAns() {
    	SpriteBatch batch = simonGame.batch;
    	checkPress = new CheckPress();
    	//int press = checkPress.iskeypressed();
    	//drawsimon(press);
    	
    	listAns.clear();
    	//System.out.println("lengthQ: "+lengthQ);
    	
    	for(int i1 = 0; i1 < lengthQ ; i1++) {
    		int press = 0;
    		press = checkPress.iskeypressed();
        	drawsimon(press);
    		if(press != 0) {
    			listAns.add(press);
    		}
    	}
    	
    	//System.out.println("Ans: "+listAns);
    	
    	int lengthAns = listAns.size();
    	
    	if(lengthAns == lengthQ) {
    		System.out.println("Ans: "+listAns);
	    	for(int i2 = 0; i2 < lengthQ ; i2++) {
	    		if((Integer) listQ.get(i2) != (Integer) listAns.get(i2)) {
	    			gameover = true;
	    		}
	    		else {
	    			System.out.println("Check");
	    			waitinput = false;
	    		}
	    	}	
    	}
    }
    
    
    public void createStage() {
    	if(waitinput == false) {
	    	int num;
	    	SpriteBatch batch = simonGame.batch;
	    		
	    	num = randomColour.randomnum();
	    	listQ.add(num);
	    	System.out.println(listQ);
	    		
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
	    	//waitinput = true;
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



