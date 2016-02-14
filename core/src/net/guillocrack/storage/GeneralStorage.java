package net.guillocrack.storage;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import net.guillocrack.five.But;
import net.guillocrack.five.GameScreen;
import net.guillocrack.five.Letter;

import java.util.ArrayList;

import C.C;


public class GeneralStorage {

    public static Sprite up_letter1, up_letter2, up_letter3, up_letter4, up_letter5, timer, line_timer;
    public static BitmapFont generalFont, generalFontReduce, generalFontIncrease, posibilitiesFont, scoreFont, bestMenuFont, scoreMenuFont, timeUpFont,
            scoreGameOverMenu, scoreTextGameOverMenu;
    public static FreeTypeFontGenerator generator;
    public static int w, h, best, height_banner;
    public static float ratio, origin_scaleX, origin_scaleY, origin_scaleX2, origin_scaleY2;
    public static SpriteBatch batch;
    public static Preferences prefs;
    public static Music background_music;
    public static Sound click_button, correct_sound, error_sound, timeup;
    public static Texture background_letter, pixel, play_texture, ranking_texture, sound_button, sound_off_button,
            back_button, share_button, pause_texture, rate_button, play_square, up_texture;
    public static Letter letter1, letter2, letter3, letter4, letter5;
    public static ArrayList<Texture> backgrounds_letters, up_textures;
    public static FreeTypeFontParameter parameter;
    public static But back_but, pause_but;
    public static Color blue;

    public static void load(){

        height_banner = GameScreen.actionResolver.getBannerHeight();

        //Screen Sizes. DON'T CHANGE THEM!
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        height_banner = GameScreen.actionResolver.getBannerHeight();

        //Ratio is used for text size
        float ratio1 = (float) (w / 1080.0);
        float ratio2 = (float) (h / 1920.0);

        //The ratio is used for text size
        if (ratio1 > ratio2)
            ratio = ratio2;
        else
            ratio = ratio1;
        /////////////END SIZE VARIABLES DECLARATION////////////////////////


        //Batch for drawing on the screen
        batch = new SpriteBatch();

        //Preferences for store and get the best score
        prefs = Gdx.app.getPreferences("Prefs");

        if(C.BACKGROUND_MUSIC){
            //Background music
            background_music = Gdx.audio.newMusic(Gdx.files.internal("background_music.mp3"));
            background_music.setLooping(true);

        }

        //Sound
        click_button = Gdx.audio.newSound(Gdx.files.internal("click_button.mp3"));
        correct_sound = Gdx.audio.newSound(Gdx.files.internal("correct_sound.wav"));
        error_sound = Gdx.audio.newSound(Gdx.files.internal("error_sound.mp3"));
        timeup = Gdx.audio.newSound(Gdx.files.internal("timeup.wav"));





        //FONTS
        parameter = new FreeTypeFontParameter();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));

          parameter.characters = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVWYZabcçdefgğhıijklmnoöprsştuüvwyz0123456789";

        parameter.size = (int) (150*ratio);
        generalFont = generator.generateFont(parameter);




        Color color = new Color(0f, 102/255f, 204/255f, 1);


        parameter.size = (int) (80*ratio);
        posibilitiesFont = generator.generateFont(parameter);
        posibilitiesFont.setColor(color);


        bestMenuFont = generator.generateFont(parameter);
        bestMenuFont.setColor(color);

        parameter.size = (int) (160*ratio);
        scoreFont = generator.generateFont(parameter);
        scoreFont.setColor(color);

        parameter.size = (int) (130*ratio);
        scoreMenuFont = generator.generateFont(parameter);
        scoreMenuFont.setColor(color);

        parameter.size = (int) (150*ratio);
        generalFontReduce = generator.generateFont(parameter);


        parameter.size = (int) (60*ratio);
        generalFontIncrease = generator.generateFont(parameter);
        origin_scaleX = generalFontIncrease.getScaleX();
        origin_scaleY = generalFontIncrease.getScaleY();


        parameter.size = (int) (230*ratio);
        scoreGameOverMenu = generator.generateFont(parameter);
        scoreGameOverMenu.setColor(color);


        parameter.size = (int) (110*ratio);
        scoreTextGameOverMenu = generator.generateFont(parameter);
        scoreTextGameOverMenu.setColor(color);


        parameter.size = (int) (100*ratio);
        timeUpFont = generator.generateFont(parameter);
        timeUpFont.setColor(Color.RED);
        origin_scaleX2 = timeUpFont.getScaleX();
        origin_scaleY2 = timeUpFont.getScaleY();


        //End fonts



        //Loading texture from memory
        pixel = new Texture("pixel.png");





        backgrounds_letters = new ArrayList<Texture>();

        background_letter = new Texture("circle1.png");
        background_letter.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        backgrounds_letters.add(background_letter);

        background_letter = new Texture("circle2.png");
        background_letter.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        backgrounds_letters.add(background_letter);

        background_letter = new Texture("circle3.png");
        background_letter.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        backgrounds_letters.add(background_letter);

        background_letter = new Texture("circle4.png");
        background_letter.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        backgrounds_letters.add(background_letter);

        background_letter = new Texture("circle5.png");
        background_letter.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        backgrounds_letters.add(background_letter);


        play_texture = new Texture("play_button.png");
        pause_texture = new Texture("pause.png");
        ranking_texture = new Texture("ranking_button.png");
        sound_button = new Texture("sound_button.png");
        sound_off_button = new Texture("sound_off_button.png");
        back_button = new Texture("back_button.png");
//        red_texture = new Texture("red_background.png");
        share_button = new Texture("share_button.png");
        rate_button = new Texture("rate_button.png");
        play_square = new Texture("play_button_square.png");

        //End textures


        back_but = new But(GeneralStorage.w*0.03f, GeneralStorage.h*0.88f, GeneralStorage.h*0.08f, GeneralStorage.h*0.08f, GeneralStorage.back_button,
                GeneralStorage.w, GeneralStorage.h);

        pause_but = new But(GeneralStorage.w*0.97f - GeneralStorage.h*0.08f, GeneralStorage.h*0.88f, GeneralStorage.h*0.08f, GeneralStorage.h*0.08f,
                pause_texture, GeneralStorage.w, GeneralStorage.h);



        //Creating letters
        letter1 = new Letter(1, false);
        letter2 = new Letter(2, false);
        letter3 = new Letter(3, false);
        letter4 = new Letter(4, false);
        letter5 = new Letter(5, false);



        up_textures = new ArrayList<Texture>();

        up_texture = new Texture("square1.png");
        up_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        up_textures.add(up_texture);

        up_texture = new Texture("square2.png");
        up_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        up_textures.add(up_texture);

        up_texture = new Texture("square3.png");
        up_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        up_textures.add(up_texture);

        up_texture = new Texture("square4.png");
        up_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        up_textures.add(up_texture);

        up_texture = new Texture("square5.png");
        up_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        up_textures.add(up_texture);


        up_letter1 = new Sprite(up_texture);
        up_letter2 = new Sprite(up_texture);
        up_letter3 = new Sprite(up_texture);
        up_letter4 = new Sprite(up_texture);
        up_letter5 = new Sprite(up_texture);



        float size = GeneralStorage.h * 0.105f;
        float left_margin = (GeneralStorage.w - size*5)/8*2;
        float separation = (GeneralStorage.w - size*5)/8;

        up_letter1.setPosition(left_margin, GeneralStorage.h * 0.6f);
        up_letter1.setSize(size, size);
        up_letter2.setPosition(left_margin + size + separation, GeneralStorage.h * 0.6f);
        up_letter2.setSize(size, size);
        up_letter3.setPosition(left_margin + size * 2 + separation * 2, GeneralStorage.h * 0.6f);
        up_letter3.setSize(size, size);
        up_letter4.setPosition(left_margin + size * 3 + separation * 3, GeneralStorage.h * 0.6f);
        up_letter4.setSize(size, size);
        up_letter5.setPosition(left_margin + size * 4 + separation * 4, GeneralStorage.h * 0.6f);
        up_letter5.setSize(size, size);




        //Preferences to get get and store best score
        best = prefs.getInteger("best",0);

        //Color green for timer
        blue = new Color(0/255f, 102/255f, 204/255f, 1.0f);


        //Timer and background timer
        timer = new Sprite(pixel);
        timer.setColor(blue);

        line_timer = new Sprite(new Texture("line_timer.png"));
        line_timer.setSize(w*0.88f, h*0.07f);
        line_timer.setPosition(GeneralStorage.w*0.06f, GeneralStorage.h*0.76f);


    }

}
