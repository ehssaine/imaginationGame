package net.guillocrack.five;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.guillocrack.draw.GameOverDraw;
import net.guillocrack.draw.GameOverMenuDraw;
import net.guillocrack.draw.MenuDraw;
import net.guillocrack.draw.RunningDraw;
import net.guillocrack.draw.SplashDraw;
import net.guillocrack.storage.SplashStorage;
import net.guillocrack.update.GameOverMenuUpdate;
import net.guillocrack.update.GameOverUpdate;
import net.guillocrack.update.MenuUpdate;
import net.guillocrack.update.RunningUpdate;

public class GameScreen extends ApplicationAdapter {

	public static int score, best;
	public static ActionResolver actionResolver;
	public enum GameState {
		SPLASH, RUNNING, GAMEOVER, MENU, GAMEOVER_MENU, PAUSE
	}
	public static GameState state;
	public static SpriteBatch batch;

	//The action resolver allows to call android methods
	public GameScreen(ActionResolver actionResolver) {
		this.actionResolver = actionResolver;
	}


	@Override
	public void create () {

		//The android begins with splash screen
		state = GameState.SPLASH;


		SplashDraw.time_acu_splash=0;

		//Batch for drawing on the screen
		batch = new SpriteBatch();

		SplashStorage.load();


	}

	@Override
	public void render () {

		switch(state){

			case SPLASH:

				SplashDraw.draw();

				break;

			case MENU:

				MenuUpdate.update();

				MenuDraw.draw();

				break;

			case RUNNING:

				RunningUpdate.update();

				RunningDraw.draw();

				break;

			case GAMEOVER:

				GameOverUpdate.update();

				GameOverDraw.draw();

				break;

			case GAMEOVER_MENU:

				GameOverMenuUpdate.update();

				GameOverMenuDraw.draw();

				break;


		}




	}
}
