package net.guillocrack.draw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import net.guillocrack.storage.GeneralStorage;
import net.guillocrack.storage.MenuStorage;
import net.guillocrack.update.RunningUpdate;

import C.C;


public class RunningDraw {

    public static String text_posibilities, text_score;
    public static boolean show_circles = true;

    public static void draw(){

        GeneralStorage.batch.begin();

        Gdx.gl.glClearColor(255 / 255f, 255 / 255f, 255 / 255f, (float) 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);


        //Drawing white circles
        if(show_circles && RunningUpdate.time_side <= 0) {
            if (RunningUpdate.letters_played < 1)
                GeneralStorage.up_letter1.draw(GeneralStorage.batch);
            if (RunningUpdate.letters_played < 2)
                GeneralStorage.up_letter2.draw(GeneralStorage.batch);
            if (RunningUpdate.letters_played < 3)
                GeneralStorage.up_letter3.draw(GeneralStorage.batch);
            if (RunningUpdate.letters_played < 4)
                GeneralStorage.up_letter4.draw(GeneralStorage.batch);
            if (RunningUpdate.letters_played < 5)
                GeneralStorage.up_letter5.draw(GeneralStorage.batch);
        }
        else{
            GeneralStorage.generalFontReduce.setScale(GeneralStorage.generalFontReduce.getScaleX()*0.975f, GeneralStorage.generalFontReduce.getScaleY()*0.975f);
        }


        //Drawing timer
        GeneralStorage.timer.draw(GeneralStorage.batch);
        GeneralStorage.line_timer.draw(GeneralStorage.batch);

        //Drawing letter buttons
        GeneralStorage.letter1.draw();
        GeneralStorage.letter2.draw();
        GeneralStorage.letter3.draw();
        GeneralStorage.letter4.draw();
        GeneralStorage.letter5.draw();

        //Drawing text possible words
        text_posibilities = "YOU CAN FORM " + String.valueOf(RunningUpdate.posibilities) + " WORDS";
        GeneralStorage.posibilitiesFont.draw(GeneralStorage.batch, text_posibilities,
                (GeneralStorage.w - GeneralStorage.posibilitiesFont.getBounds(text_posibilities).width)/2,
                GeneralStorage.height_banner + GeneralStorage.h*0.015f + GeneralStorage.posibilitiesFont.getBounds(text_posibilities).height);

        text_score = "SCORE";


        //Drawing score text
        if(!RunningUpdate.pause){
            GeneralStorage.posibilitiesFont.draw(GeneralStorage.batch, text_score,
                    (GeneralStorage.w - GeneralStorage.posibilitiesFont.getBounds(text_score).width)/2,
                    GeneralStorage.h*0.965f);


            //Drawing score
            GeneralStorage.scoreFont.draw(GeneralStorage.batch, String.valueOf(RunningUpdate.score),
                    (GeneralStorage.w - GeneralStorage.scoreFont.getBounds(String.valueOf(RunningUpdate.score)).width) / 2,
                    GeneralStorage.h * 0.965f - GeneralStorage.posibilitiesFont.getBounds(text_score).height - GeneralStorage.h * 0.02f);
        }

        else{
            GeneralStorage.scoreFont.draw(GeneralStorage.batch, String.valueOf("PAUSE"),
                    (GeneralStorage.w - GeneralStorage.scoreFont.getBounds(String.valueOf("PAUSE")).width) / 2,
                    GeneralStorage.h * 0.965f - GeneralStorage.posibilitiesFont.getBounds(text_score).height - GeneralStorage.h * 0.02f);
        }

        //Drawing back button
        GeneralStorage.back_but.sp.draw(GeneralStorage.batch);


        //Drawing pause button
        if(C.PAUSE)
            GeneralStorage.pause_but.sp.draw(GeneralStorage.batch);


        GeneralStorage.batch.end();

    }


}
