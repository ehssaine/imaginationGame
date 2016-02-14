package net.guillocrack.draw;


import net.guillocrack.storage.GeneralStorage;
import net.guillocrack.storage.MenuStorage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;



//This class draws the menu on the screen

public class MenuDraw {
	
	public static void draw(){		
		
		Gdx.gl.glClearColor(255 / 255f, 255 / 255f, 255 / 255f, (float) 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 Gdx.gl.glEnable(GL20.GL_BLEND);
		
		GeneralStorage.batch.begin();
		
		//Drawing title
        MenuStorage.title.draw(GeneralStorage.batch);


		 //Drawing menu buttons
		 MenuStorage.play_button.sp.draw(GeneralStorage.batch);
		MenuStorage.ranking_button.sp.draw(GeneralStorage.batch);
        MenuStorage.rate_button.sp.draw(GeneralStorage.batch);
        MenuStorage.best_sprite.draw(GeneralStorage.batch);
		 MenuStorage.sound_button.sp.draw(GeneralStorage.batch);



        //Dawing best score
        GeneralStorage.scoreMenuFont.draw(GeneralStorage.batch, String.valueOf(GeneralStorage.best),
                (GeneralStorage.w - GeneralStorage.scoreMenuFont.getBounds(String.valueOf(GeneralStorage.best)).width)/2,
                MenuStorage.best_sprite.getY() + GeneralStorage.scoreMenuFont.getBounds(String.valueOf(GeneralStorage.best)).height +
                        (GeneralStorage.h*0.13f - GeneralStorage.scoreMenuFont.getBounds(String.valueOf(GeneralStorage.best)).height)/2);




        GeneralStorage.batch.end();
		
	}

}
