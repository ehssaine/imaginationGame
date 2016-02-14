package net.guillocrack.draw;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import net.guillocrack.five.GameScreen;
import net.guillocrack.five.GameScreen.GameState;
import net.guillocrack.storage.GameOverMenuStorage;
import net.guillocrack.storage.GeneralStorage;
import net.guillocrack.storage.MenuStorage;
import net.guillocrack.storage.SplashStorage;
import net.guillocrack.storage.WordsStorage;
import net.guillocrack.update.RunningUpdate;

import C.C;

//This class draws the splash on the screen

public class SplashDraw {

	public static float time_acu_splash = 0;

	public static void draw(){


		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		GameScreen.batch.begin();

		//Drawing splash background
		SplashStorage.splash_sprite.draw(GameScreen.batch);

		//Storing time of splash
		time_acu_splash += Gdx.graphics.getDeltaTime();

		//After 0.8 seconds the game change to the menu
		if(time_acu_splash>=0.8){

			//Loading Game Variables
			GeneralStorage.load();
			GameScreen.actionResolver.initializeLeaderboard();
			MenuStorage.load();
			RunningUpdate.letters_played = 0;
			WordsStorage.load();
			GameOverMenuStorage.load();
			RunningUpdate.initialize_game();
			GameScreen.state = GameState.MENU;


			if(C.BACKGROUND_MUSIC) {
				if (GeneralStorage.prefs.getInteger("sound", 1) == 1)
					GeneralStorage.background_music.play();
			}




		}

		GameScreen.batch.end();
	}

}
