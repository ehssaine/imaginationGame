package net.guillocrack.storage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by hssaineelmahdi on 02/02/16.
 */
public class Main {


    public Main(){


    }

    public ArrayList<String> getWordFromFile() {
        BufferedReader reader;
        FileInputStream is = null;
        ArrayList<String> lwords = null;
        try {
            //is = new FileInputStream("storage/newlist.txt");
            String line;
            InputStreamReader input = new InputStreamReader(this.getClass().getResourceAsStream("/net/guillocrack/storage/assets/newlist.txt"));
            System.out.println(input);
            reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/net/guillocrack/storage/assets/newlist.txt")));
            line = reader.readLine();
            lwords = new ArrayList<String>();
            while (line != null) {
                String[] wordsLine = line.split(" ");
                for (String word : wordsLine) {
                    lwords.add(word);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lwords;

    }
    public static void main(String args[]){
        Main m = new Main();
        System.out.print("hello world");
    }
}





