package net.guillocrack.update;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;

import net.guillocrack.five.GameScreen;

import C.C;

public class GameOverUpdate {

    public static boolean pressed, first = true;
    public static int first_x, first_y;
    public static float time;


    public static void update() {

        time -= Gdx.graphics.getDeltaTime();

        if (time < 0) {
            GameScreen.state = GameScreen.GameState.GAMEOVER_MENU;

            //Showing the interstitial after 0.3 seconds
            if (RunningUpdate.randomNum(0, 101) <= C.interstitial_percentage) {


                //Showing interstitial
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        // Do your work
                        GameScreen.actionResolver.showOrLoadInterstital();
                    }
                }, (float) 0.3);

            }


        }

    }

}
