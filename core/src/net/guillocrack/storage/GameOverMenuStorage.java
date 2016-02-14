package net.guillocrack.storage;





import net.guillocrack.five.But;
import net.guillocrack.five.Letter;

import java.util.ArrayList;

//This static class stores all the information about Game Over Menu Screen

public class GameOverMenuStorage {
	
	public static But replay_button, share_button;
	



    public static ArrayList<Letter> letters_gameover;
	
	public static void load(){
		


        //Gameover letters
        letters_gameover = new ArrayList<Letter>();
        letters_gameover.add(new Letter(1, true));
        letters_gameover.add(new Letter(2, true));
        letters_gameover.add(new Letter(3, true));
        letters_gameover.add(new Letter(4, true));
        letters_gameover.add(new Letter(5, true));



        //REPLAY BUTTON

		replay_button = new But(GeneralStorage.w*0.97f-GeneralStorage.h*0.13f, GeneralStorage.height_banner + GeneralStorage.h*0.015f,
                GeneralStorage.h*0.13f, GeneralStorage.h*0.13f, GeneralStorage.play_square, GeneralStorage.w, GeneralStorage.h);

        //SHARE BUTTON
        share_button = new But(GeneralStorage.w*0.03f, GeneralStorage.height_banner + GeneralStorage.h*0.015f,
                GeneralStorage.h*0.13f, GeneralStorage.h*0.13f, GeneralStorage.share_button, GeneralStorage.w, GeneralStorage.h);


	
	}

}
