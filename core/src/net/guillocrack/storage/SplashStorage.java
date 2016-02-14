package net.guillocrack.storage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SplashStorage {
	
	public static Sprite splash_sprite;
	
	public static void load(){
		
		//SPLASH BACKGROUND IMAGE
		splash_sprite = new Sprite(new Texture(Gdx.files.internal("splash.png")));
		splash_sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		splash_sprite.setPosition(0, 0);
		
	}

}
