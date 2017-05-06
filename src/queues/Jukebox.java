package queues;
import java.io.*;
import java.util.Scanner;

import cs1c.*;

/**
 * Simulation of a Jukebox, implemented as a partially abstract Queue
 *@author Myron Pow 5/3/17
 */
public class Jukebox {
    /**
     * Queue containing favorite music
     */
    Queue<SongEntry> favoritePL = new Queue<SongEntry>("favorites");
    /**
     * Queue containing music for road trips
     */
    Queue<SongEntry> roadTripPL = new Queue<SongEntry>("road trip");
    /**
     * Queue containing music for lounging
     */
    Queue<SongEntry> loungePL = new Queue<SongEntry>("lounge");

    /**
     * Populates play list queues
     * @param requestFile file to be read, contains key value pairs separated by commas
     * @param allSongs  set of songs to input into song queues
     */
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
                        //System.out.println(tokens[1]);
                        if(tokens[0].equals("favorites")){
                            favoritePL.enqueue(allSongs[i]);
                            break;
                        }
                        if(tokens[0].equals("road trip")){
                            roadTripPL.enqueue(allSongs[i]);
                            break;
                        }
                        if(tokens[0].equals("lounge")){
                            loungePL.enqueue(allSongs[i]);
                            break;
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

    /**
     * Accessor method for favorite playlist
     * @return queue of favorite songs
     */

    public Queue<SongEntry> getFavoritePL(){
        return favoritePL;
}

    /**
     * Accessor method for road trip playlist
     * @return queue of songs for road trips
     */
    public Queue<SongEntry> getRoadTripPL(){
        return roadTripPL;
    }

    /**
     * Accessor method for lounge playlist
     * @return queue of songs for lounging
     */
    public Queue<SongEntry> getLoungePL(){
        return loungePL;
    }

}
