package net.guillocrack.five;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import net.guillocrack.draw.RunningDraw;
import net.guillocrack.storage.GeneralStorage;
import net.guillocrack.update.RunningUpdate;

/**
 * Created by Guille on 9/4/15.
 */

//This class represents a letter buttons
public class Letter {

    public Sprite down_sprite, up_sprite;
    //1 going up         1 left
    public int position, position_played, movement, color, movement_side;
    public float separation_letter_1 = 0.43f, separation_letters_played_h = 0.6f, margin_left_played, separation_letters_played;
    public float origin_w, origin_h, h_moved, seconds = 0.3f, pixels_second, size, current_x, current_y, pixels_second_w, w_moved, seconds_w = 0.04f,
            up_sprite_size;
    public boolean played, gameover;
    public String letter = "", last_letter;


    public Letter(int p, boolean go){

        //If the letter is for the gameover
        gameover = go;

        h_moved = GeneralStorage.h * 0.01f;
        pixels_second = h_moved/seconds;
        w_moved = GeneralStorage.w * 0.03f;
        pixels_second_w = w_moved/seconds_w;

        movement = 1;
        played = false;

        position = p;
        size = GeneralStorage.h * 0.13f;



        //If the letter is not a gameovermenu letter
        if(!gameover) {

            position_played = -1;

            down_sprite = new Sprite(GeneralStorage.background_letter);
            down_sprite.setSize(size, size);

            up_sprite = new Sprite(GeneralStorage.background_letter);
            up_sprite.setSize(0, 0);


            margin_left_played = (GeneralStorage.w - down_sprite.getWidth()*4)/7*2;
            separation_letters_played = (GeneralStorage.w - down_sprite.getWidth()*4)/7;

            if(position==5){
                down_sprite.setPosition((GeneralStorage.w - down_sprite.getWidth())/2, GeneralStorage.h*separation_letter_1 - down_sprite.getWidth());

                origin_w = down_sprite.getX();
                origin_h = down_sprite.getY();

            }
        }

        //Gameovermenu letter
        else{

            position_played = position - 1;
            up_sprite = new Sprite(GeneralStorage.background_letter);

            separation_letters_played_h = 0.678f;

            up_sprite.setSize(GeneralStorage.h * 0.105f, GeneralStorage.h * 0.105f);
            margin_left_played = (GeneralStorage.w - up_sprite.getWidth()*5)/8*2;
            separation_letters_played = (GeneralStorage.w - up_sprite.getWidth()*5)/8;


            updatePosition();

        }




    }


    //Drawing the letter during the game (up and down sprites)
    public void draw(){

        positionSize();

        down_sprite.draw(GeneralStorage.batch);


        if(!RunningUpdate.pause)

            if (down_sprite.getWidth() == size)
                GeneralStorage.generalFont.draw(GeneralStorage.batch, letter,
                        down_sprite.getX() + (down_sprite.getWidth() - GeneralStorage.generalFont.getBounds(letter).width) / 2,
                        down_sprite.getY() + (down_sprite.getHeight() - GeneralStorage.generalFont.getBounds(letter).height) / 2 + GeneralStorage.generalFont.getBounds(letter).height);

            else {
                GeneralStorage.generalFontIncrease.draw(GeneralStorage.batch, letter,
                        down_sprite.getX() + (down_sprite.getWidth() - GeneralStorage.generalFontIncrease.getBounds(letter).width) / 2,
                        down_sprite.getY() + (down_sprite.getHeight() - GeneralStorage.generalFontIncrease.getBounds(letter).height) / 2 + GeneralStorage.generalFontIncrease.getBounds(letter).height);

            }



        if(up_sprite.getHeight() == up_sprite_size){
            up_sprite.draw(GeneralStorage.batch);


            if(!RunningUpdate.pause)
                GeneralStorage.generalFont.draw(GeneralStorage.batch, last_letter,
                        up_sprite.getX() + (up_sprite.getWidth() - GeneralStorage.generalFont.getBounds(last_letter).width) / 2,
                        up_sprite.getY() + (up_sprite.getHeight() - GeneralStorage.generalFont.getBounds(last_letter).height) / 2 + GeneralStorage.generalFont.getBounds(last_letter).height);

        }
        else if(up_sprite.getHeight()/up_sprite_size>0.5) {
            up_sprite.draw(GeneralStorage.batch);

            if(!RunningUpdate.pause)
                GeneralStorage.generalFontReduce.draw(GeneralStorage.batch, last_letter,
                        up_sprite.getX() + (up_sprite.getWidth() - GeneralStorage.generalFontReduce.getBounds(last_letter).width) / 2,
                        up_sprite.getY() + (up_sprite.getHeight() - GeneralStorage.generalFontReduce.getBounds(last_letter).height) / 2 + GeneralStorage.generalFontReduce.getBounds(last_letter).height);

        }

        else{
            RunningDraw.show_circles = true;
        }

    }

    //Checking if the letter has been pressed, up or down
    public boolean onClickListener(){

        if(Gdx.input.getX()>= down_sprite.getX() && Gdx.input.getX()<= down_sprite.getX() + down_sprite.getWidth()
                && Gdx.input.getY() >= GeneralStorage.h - down_sprite.getY() - down_sprite.getHeight()
                && Gdx.input.getY()<= GeneralStorage.h - down_sprite.getY()){


            //Letter is played now
            if(!played) {
                down_sprite.setTexture(GeneralStorage.up_texture);
                position_played = RunningUpdate.letters_played;
                RunningUpdate.letters_played++;
                played = true;
                if(RunningUpdate.letters==4)
                    up_sprite.setSize(size, size);
                else
                    up_sprite.setSize(GeneralStorage.h * 0.105f, GeneralStorage.h * 0.105f);
                up_sprite.setTexture(GeneralStorage.backgrounds_letters.get(color));
                updatePosition();

                current_x = up_sprite.getX();
                current_y = up_sprite.getY();


                RunningUpdate.letters_played_array.add(this);

                if(RunningUpdate.letters_played == RunningUpdate.letters){
                    RunningUpdate.check_word();
                }
            }


            //Letter is deleted from played letters
            else{

                down_sprite.setTexture(GeneralStorage.backgrounds_letters.get(color));
                RunningUpdate.letters_played--;
                played = false;
                up_sprite.setSize(0, 0);


                GeneralStorage.letter1.updatePositionPlayed(position_played);
                GeneralStorage.letter2.updatePositionPlayed(position_played);
                GeneralStorage.letter3.updatePositionPlayed(position_played);
                GeneralStorage.letter4.updatePositionPlayed(position_played);
                if(RunningUpdate.letters==5)
                    GeneralStorage.letter5.updatePositionPlayed(position_played);
                position_played = -1;

                RunningUpdate.letters_played_array.remove(this);
            }
            return true;
        }


        //Deleted letter from the up sprite
        else if(played && Gdx.input.getX()>= up_sprite.getX() && Gdx.input.getX()<= up_sprite.getX() + up_sprite.getWidth()
                && Gdx.input.getY() >= GeneralStorage.h - up_sprite.getY() - up_sprite.getHeight()
                && Gdx.input.getY()<= GeneralStorage.h - up_sprite.getY()){

            down_sprite.setTexture(GeneralStorage.backgrounds_letters.get(color));
            RunningUpdate.letters_played--;
            played = false;


            GeneralStorage.letter1.updatePositionPlayed(position_played);
            GeneralStorage.letter2.updatePositionPlayed(position_played);
            GeneralStorage.letter3.updatePositionPlayed(position_played);
            GeneralStorage.letter4.updatePositionPlayed(position_played);
            if(RunningUpdate.letters==5)
                GeneralStorage.letter5.updatePositionPlayed(position_played);
            position_played = -1;

            RunningUpdate.letters_played_array.remove(this);

            up_sprite.setSize(0, 0);


            return true;

        }

        return false;

    }


    //Changing the letter and restring the positions
    public void setLetter(String l, int c){

        down_sprite.setSize(size*0.4f, size*0.4f);

        last_letter = letter;
        letter = l;
        color = c;
        down_sprite.setTexture(GeneralStorage.backgrounds_letters.get(color));

        played = false;
        position_played = -1;






    }


    public void setLetters(String l){

        //down_sprite.setSize(size*0.4f, size*0.4f);

        letter = l;
       // down_sprite.setTexture(GeneralStorage.backgrounds_letters.get(color));

       // played = false;
       // position_played = -1;






    }

    //Updating the position when other letter played is deleted from the letters played
    public void updatePositionPlayed(int p){

        if(position_played>p) {
            position_played--;
            updatePosition();
        }


    }

    //Updating the position of the up_sprite when the letter is played
    public void updatePosition(){

        switch (position_played) {

            case 0:
                up_sprite.setPosition(margin_left_played, GeneralStorage.h * separation_letters_played_h);

                break;
            case 1:
                up_sprite.setPosition(margin_left_played + up_sprite.getWidth() + separation_letters_played,
                        GeneralStorage.h * separation_letters_played_h);
                break;
            case 2:
                up_sprite.setPosition(margin_left_played + up_sprite.getWidth() * 2 + separation_letters_played * 2,
                        GeneralStorage.h * separation_letters_played_h);
                break;
            case 3:
                up_sprite.setPosition(margin_left_played + up_sprite.getWidth() * 3 + separation_letters_played * 3,
                        GeneralStorage.h * separation_letters_played_h);
                break;
            case 4: up_sprite.setPosition(margin_left_played + up_sprite.getWidth() * 4 + separation_letters_played * 4,
                    GeneralStorage.h * separation_letters_played_h);
                break;


        }

        current_x = up_sprite.getX();
        current_y = up_sprite.getY();
        movement_side = 1;



    }

    //Restoring the original position
    public void restorePosition(){

        played = false;
        position_played = -1;
        down_sprite.setTexture(GeneralStorage.backgrounds_letters.get(color));
        up_sprite.setSize(0, 0);

    }


    //Moving the up_sprite when the letter is played
    public void move(){



        if(movement == 1){

            if(up_sprite.getY() + pixels_second*Gdx.graphics.getDeltaTime() >= GeneralStorage.h*separation_letters_played_h + h_moved) {
                up_sprite.setPosition(up_sprite.getX(), GeneralStorage.h * separation_letters_played_h + h_moved);
                movement = 2;
            }

            else up_sprite.setPosition(up_sprite.getX(), up_sprite.getY() + pixels_second*Gdx.graphics.getDeltaTime());

        }

        else{

            if(up_sprite.getY() - pixels_second*Gdx.graphics.getDeltaTime() <= GeneralStorage.h*separation_letters_played_h - h_moved) {
                up_sprite.setPosition(up_sprite.getX(), GeneralStorage.h * separation_letters_played_h - h_moved);
                movement = 1;
            }

            else up_sprite.setPosition(up_sprite.getX(), up_sprite.getY() - pixels_second*Gdx.graphics.getDeltaTime());

        }

    }


    //Positioning the buttons depending on the movement, situation, etc
    public void positionSize(){




        if(down_sprite.getWidth() != size){

            if(down_sprite.getWidth()*1.05f > size){
                down_sprite.setSize(size,size);

                if(position==1)

                    GeneralStorage.generalFontIncrease.setScale(GeneralStorage.generalFont.getScaleX(), GeneralStorage.generalFont.getScaleY());

            }

            else{
                down_sprite.setSize(down_sprite.getWidth()*1.05f, down_sprite.getHeight()*1.05f);

                if(position==1)
                    GeneralStorage.generalFontIncrease.setScale(GeneralStorage.generalFontIncrease.getScaleX()*1.05f,
                            GeneralStorage.generalFontIncrease.getScaleY()*1.05f);
            }

            down_sprite.setPosition(origin_w + (size - down_sprite.getWidth()) / 2, origin_h + (size - down_sprite.getWidth()) / 2);

        }



        if(!played && (up_sprite.getHeight()/up_sprite_size)>=0.5) {



            up_sprite.setSize(up_sprite.getWidth() * 0.975f, up_sprite.getHeight() * 0.975f);
            up_sprite.setPosition(current_x + (up_sprite_size - up_sprite.getWidth())/2, current_y + (up_sprite_size - up_sprite.getHeight())/2);
        }
        else{
            last_letter = letter;
        }

    }

    //Drawing in the gameover
    public void drawGameOver(boolean b){

        if(up_sprite.getHeight() == up_sprite_size){
            up_sprite.draw(GeneralStorage.batch);

            GeneralStorage.generalFont.draw(GeneralStorage.batch, last_letter,
                    up_sprite.getX() + (up_sprite.getWidth() - GeneralStorage.generalFont.getBounds(last_letter).width) / 2,
                    up_sprite.getY() + (up_sprite.getHeight() - GeneralStorage.generalFont.getBounds(last_letter).height) / 2 + GeneralStorage.generalFont.getBounds(last_letter).height);

        }

        if(b){

            down_sprite.draw(GeneralStorage.batch);

            GeneralStorage.generalFont.draw(GeneralStorage.batch, letter,
                    down_sprite.getX() + (down_sprite.getWidth() - GeneralStorage.generalFont.getBounds(letter).width)/2,
                    down_sprite.getY() + (down_sprite.getHeight() - GeneralStorage.generalFont.getBounds(letter).height)/2 + GeneralStorage.generalFont.getBounds(letter).height);

        }


    }

    //Drawing if it is a gameover menu letter
    public void drawGameOverMenu(){

        move();

        up_sprite.draw(GeneralStorage.batch);

        GeneralStorage.generalFont.draw(GeneralStorage.batch, letter,
                up_sprite.getX() + (up_sprite.getWidth() - GeneralStorage.generalFont.getBounds(letter).width) / 2,
                up_sprite.getY() + (up_sprite.getHeight() - GeneralStorage.generalFont.getBounds(letter).height) / 2 + GeneralStorage.generalFont.getBounds(letter).height);

    }


    //Moving from one side to other
    public void move_side(){

        //Left
        if(movement_side == 1){
            if(up_sprite.getX() - Gdx.graphics.getDeltaTime()*pixels_second_w <= current_x - w_moved) {
                up_sprite.setPosition(current_x - w_moved, up_sprite.getY());
                movement_side = 2;
            }
            else up_sprite.setPosition(up_sprite.getX() - Gdx.graphics.getDeltaTime()*pixels_second_w, up_sprite.getY());
        }

        //Right
        else{
            if(up_sprite.getX() + Gdx.graphics.getDeltaTime()*pixels_second_w - current_x >= w_moved) {
                up_sprite.setPosition(current_x + w_moved, up_sprite.getY());
                movement_side = 1;
            }
            else up_sprite.setPosition(up_sprite.getX() + Gdx.graphics.getDeltaTime()*pixels_second_w, up_sprite.getY());

        }


    }

    public void change_position(){


            if (position == 1)
                down_sprite.setPosition((GeneralStorage.w - size) / 2, GeneralStorage.h * separation_letter_1 + GeneralStorage.h * 0.01f);
            else if(position==2)
                down_sprite.setPosition((GeneralStorage.w - size) / 2 + size + GeneralStorage.h * 0.01f,
                        GeneralStorage.h * separation_letter_1 - size);

            else if(position==3)
                down_sprite.setPosition((GeneralStorage.w - size) / 2,
                        GeneralStorage.h * separation_letter_1 - size * 2 - GeneralStorage.h * 0.01f);

            else if(position==4){
                down_sprite.setPosition((GeneralStorage.w - size) / 2 - size - GeneralStorage.h * 0.01f,
                        GeneralStorage.h * separation_letter_1 - size);

            }



        origin_w = down_sprite.getX();
        origin_h = down_sprite.getY();

    }

    public void change_up_size(){

        if(RunningUpdate.letters==4){
            up_sprite_size = size;
            margin_left_played = (GeneralStorage.w - size*4)/7*2;
            separation_letters_played = (GeneralStorage.w - size*4)/7;

        }
        else {
            up_sprite_size = GeneralStorage.h * 0.105f;
            margin_left_played = (GeneralStorage.w - up_sprite_size*5)/8*2;
            separation_letters_played = (GeneralStorage.w - up_sprite_size*5)/8;
        }



    }




}
