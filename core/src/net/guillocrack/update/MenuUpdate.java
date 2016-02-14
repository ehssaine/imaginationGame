package net.guillocrack.update;

import com.badlogic.gdx.Gdx;

import net.guillocrack.five.GameScreen;
import net.guillocrack.storage.GeneralStorage;
import net.guillocrack.storage.MenuStorage;

import C.C;

public class MenuUpdate {

    public static boolean pressed, first=true;
    public static int first_x, first_y;

    public static void update() {


        //Storing if the screen is touched
        pressed = Gdx.input.isTouched();

        if (pressed && first == true) {
            //Getting where has been touched the screen
            first_x = Gdx.input.getX();
            first_y = Gdx.input.getY();
            first = false;

        }

        if (!pressed) {

            MenuStorage.play_button.sp.setTexture(GeneralStorage.play_texture);

            if (first == false) {

                //Play button onClick
                if (MenuStorage.play_button.isPressed()) {

                    if(GeneralStorage.prefs.getInteger("sound",1)==1)
                        GeneralStorage.click_button.play();

                    GameScreen.state = GameScreen.GameState.RUNNING;
                    RunningUpdate.initialize_game();

                }


                //Ranking button onClick
                if(MenuStorage.ranking_button.isPressed()){
                    if(GeneralStorage.prefs.getInteger("sound",1)==1)
                        GeneralStorage.click_button.play();

                    GameScreen.actionResolver.showScores();

                }

                //Sound button onClick
                else if(MenuStorage.sound_button.isPressed()){

                    if(GeneralStorage.prefs.getInteger("sound",1)==1){
                        GeneralStorage.prefs.putInteger("sound",0);
                        GeneralStorage.prefs.flush();
                        MenuStorage.sound_button.sp.setTexture(GeneralStorage.sound_off_button);

                        GeneralStorage.click_button.play();

                        if(C.BACKGROUND_MUSIC) {

                            GeneralStorage.background_music.pause();
                        }
                    }

                    else{
                        GeneralStorage.prefs.putInteger("sound",1);
                        GeneralStorage.prefs.flush();
                        MenuStorage.sound_button.sp.setTexture(GeneralStorage.sound_button);

                        if(C.BACKGROUND_MUSIC) {

                            GeneralStorage.background_music.play();
                        }
                    }

                }


                else if(MenuStorage.rate_button.isPressed()){


                    if(GeneralStorage.prefs.getInteger("sound",1)==1)
                        GeneralStorage.click_button.play();

                    GameScreen.actionResolver.rate();
                }

            }

            first = true;
        }

        else{

            first = false;

        }
    }

}
