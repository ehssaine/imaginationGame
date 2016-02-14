package net.guillocrack.storage;





import net.guillocrack.five.But;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

//This class stores all the variables for Menu Screen

public class MenuStorage {
	
	
	
	public static Sprite best_sprite, title, circle_white, crown;

	
	public static But play_button, ranking_button, sound_button, rate_button;


	
	public static void load(){
		
		
		int height_buttons = (int) (GeneralStorage.h*0.12);

        int margin_left = (int) (GeneralStorage.w*0.05);
	
		int separation = (int) (GeneralStorage.w - margin_left*2 - height_buttons*3)/2;

        int margin_down =   (int) (GeneralStorage.h*0.15f);

        int central_separation = (int) (GeneralStorage.h - margin_down - height_buttons - (GeneralStorage.h - GeneralStorage.h*0.78f));

        int aux = (int) (central_separation - GeneralStorage.h*0.34f)/3;






		//PLAY BUTTON
		play_button = new But((int) (GeneralStorage.w-GeneralStorage.h*0.17f*1.516)/2,margin_down + height_buttons + aux,
                (int)  (GeneralStorage.h*0.17f*1.516f),(int)  (GeneralStorage.h*0.17f),  GeneralStorage.play_texture, GeneralStorage.w, GeneralStorage.h);


            //RATE BUTTON
            rate_button = new But(margin_left + height_buttons + separation,margin_down,
                    height_buttons, height_buttons,  GeneralStorage.rate_button, GeneralStorage.w, GeneralStorage.h);


            //RATE BUTTON
            ranking_button = new But(margin_left + height_buttons*2 + separation*2,margin_down,
                    height_buttons, height_buttons,  GeneralStorage.ranking_texture, GeneralStorage.w, GeneralStorage.h);






        //Title
        title = new Sprite(new Texture("menu_title.png"));
        title.setSize(GeneralStorage.w*0.9f, GeneralStorage.w*0.9f/4.11f);
        title.setPosition((GeneralStorage.w - title.getWidth())/2, GeneralStorage.h*0.78f);

		//SOUND BUTTON
		if(GeneralStorage.prefs.getInteger("sound",1)==1)

		sound_button = new But(margin_left, margin_down,
                height_buttons,  height_buttons, GeneralStorage.sound_button, GeneralStorage.w, GeneralStorage.h);

			else sound_button = new But(margin_left, margin_down,
                height_buttons, height_buttons, GeneralStorage.sound_off_button, GeneralStorage.w, GeneralStorage.h);





        float y = margin_down + height_buttons + aux * 2 + play_button.sp.getHeight();

        best_sprite = new Sprite(new Texture("corona_button.png"));
        best_sprite.setSize(GeneralStorage.h*0.13f, GeneralStorage.h*0.13f);
        best_sprite.setPosition((GeneralStorage.w - best_sprite.getWidth())/2,y);





    }

}
