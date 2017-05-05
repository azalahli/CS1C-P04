package queues;

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



    /**
     * Default constructor for a navigator object
     * Uses literals for the two stack names
     */
    Jukebox(){
        currentLink = "";
        backLinks = new Queue<String>();
        forwardLinks = new Queue<String>();
        backLinks.setName("BackLinks");
        forwardLinks.setName("ForwardLinks");
    }

    /**
     * Adds a string into the stack, and clears forward history
     * @param current the link to be added
     */
    public void setCurrentLink(String current){
        String tempLink = this.currentLink;
        this.currentLink = current;
        backLinks.push(tempLink);
        forwardLinks.clear();
    }

    /**
     * Moves back into broswer history, and adds it to forward stack
     */
    public void goBack(){
        if(backLinks.isEmpty()){
            System.out.println("WARNING: BACK LINK NOT FOUND");
        }
        if(!backLinks.isEmpty()){
            if(backLinks.size() == 1){
                lastString = currentLink;
            }
            forwardLinks.push(currentLink);
            this.currentLink = this.backLinks.peek();
            backLinks.pop();
            if(backLinks.size() <= 0){
                currentLink = lastString;
            }
        }
    }

    /**
     * Moves forward into history, and adds it to the backwards stack
     */
    public void goForward(){
        if(forwardLinks.isEmpty()){
            System.out.println("WARNING: FORWARD LINK NOT FOUND");
        }
        if(!forwardLinks.isEmpty()){
            if(forwardLinks.size() == 1){
                lastString = currentLink;
            }
            backLinks.push(currentLink);
            this.currentLink = this.forwardLinks.peek();
            forwardLinks.pop();
            }
        if(forwardLinks.size() <= 0){
            currentLink = lastString;
        }
    }


    /**
     * accessor method for the current link
     * @return the link that is currently being manipulated
     */
    public String getCurrentLink(){
        return currentLink;
    }

    /**
     * accessor method for the backwards stackList
     * @return the backwards stacklist
     */
    public Queue<String> getBackLinks(){
        return backLinks;
    }

    /**
     * accessor method for the forwards stackList
     * @return
     */
    public Queue<String> getForwardLinks(){
        return forwardLinks;
    }


}
