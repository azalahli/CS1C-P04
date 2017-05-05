package queues;
import java.io.*;
import java.util.Scanner;

import cs1c.*;

/**
 * Simulation of Browser navigation, implemented as a stackList
 *@author Myron Pow 4/29/17
 */
public class Jukebox {
    /**
     * stack containing all links in history
     */
    Queue<SongEntry> favoritePL = new Queue<SongEntry>("favorites");
    /**
     * stack containing links that back has been used on
     */
    Queue<SongEntry> roadTripPL = new Queue<SongEntry>("road trip");
    /**
     * stack containing links that back has been used on
     */
    Queue<SongEntry> loungePL = new Queue<SongEntry>("lounge");

    public void fillPlaylists(String requestFile, SongEntry[] allSongs){
        File parse = new File(requestFile);
        try{
            Scanner input = new Scanner(parse);
            String temp;
            while(input.hasNextLine()){
                temp = input.nextLine();
                String[] tokens = temp.split(",");
                for(int i = 0; i < allSongs.length; i++){
                    if(allSongs[i].getTitle().equals(tokens[1])){
                        if(tokens[0].equals("favorites")){
                            favoritePL.enqueue(allSongs[i]);
                        }
                        if(tokens[0].equals("road trip")){
                            roadTripPL.enqueue(allSongs[i]);
                        }
                        if(tokens[0].equals("lounge")){
                            loungePL.enqueue(allSongs[i]);
                        }
                }
                }
            }
            input.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public Queue<SongEntry> getFavoritePL(){
        return favoritePL;
}

    public Queue<SongEntry> getRoadTripPL(){
        return favoritePL;
    }

    public Queue<SongEntry> getLoungePL(){
        return favoritePL;
    }

}
