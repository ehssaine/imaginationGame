package net.guillocrack.update;

import net.guillocrack.five.GameScreen;
import net.guillocrack.storage.GameOverMenuStorage;
import net.guillocrack.storage.GeneralStorage;

import com.badlogic.gdx.Gdx;

public class GameOverMenuUpdate {
	
	public static boolean pressed, first=true;
	public static int first_x, first_y;
	
	public static void update(){
	
		//Storing if the screen is touched
				pressed = Gdx.input.isTouched();
				
				if(pressed && first==true){
					//Getting where has been touched the screen
						first_x = Gdx.input.getX();
						first_y = Gdx.input.getY();
						first=false;
					
				}
				
				
				if(!pressed) {

                    if (first == false) {

                        //Replay button onClick
                        if (GameOverMenuStorage.replay_button.isPressed()) {

                            if(GeneralStorage.prefs.getInteger("sound",1)==1)
                                GeneralStorage.click_button.play();

                            GameScreen.state = GameScreen.GameState.MENU;

                        }

                        //Share button onClick
                        else if(GameOverMenuStorage.share_button.isPressed()){

                            if(GeneralStorage.prefs.getInteger("sound",1)==1)
                                GeneralStorage.click_button.play();

                            GameScreen.actionResolver.share(RunningUpdate.score);

                        }

                        first = true;


                    }
                }
	}

}
