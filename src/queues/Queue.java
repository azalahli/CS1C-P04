package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of an abstact Queue data structure
 * @author Myron Pow 4/29/17
 */

public class Queue<E> implements Iterable<E> {
    /**
     *private Node class for implementation of abstract Queue
     */
    private class Node{
        Node next;
        E data;

        Node(E input){
            next = null;
            data = input;
        }
    }

    /**
     * private QueueIterator, which iterates through the Queue
     */
    private class QueueIterator implements Iterator<E>{
        protected Node currentTop = bot;

        /**
         * hasNext method, as iterator should continue until the stack is empty, only a null pointer would return false
         * @return boolean value of null Queue check
         */
        public boolean hasNext(){
            return (currentTop != null);
        }

        /**
         * returns value of top, iterates onto next element of stack
         * @return data of type E, which was encapsulated in top
         */
        public E next(){
            if(hasNext()){
                E data = currentTop.data;
                currentTop = currentTop.next;
                return data;
            }else{
                throw new NoSuchElementException();
            }
        }
    }

    /*
     * Beginning of Queue
     */
    /**
     * name of Queue
     */
    private String name;
    /**
     * node on the top(front) of the queue
     */
    private Node top;
    /**
     * node on the bottom(back) of the queue
     */
    private Node bot;
    /**
     * size of the queue
     */
    private int size;

    /**
     * Constructor for queue
     * @param newName, for the name of the queue
     */
    Queue(String newName){
        name = newName;
        top = null;
        bot = null;
        size = 0;
    }

    /**
     * Constructor that sets default values of empty queue
     */
    Queue(){
        name = "";
        top = null;
        bot = null;
        size = 0;
    }

    /**
     * generic push, takes data of type E and puts it on top of queue
     * @param input data to be added to top of queue
     */
    public void enqueue(E input){
        if(input == null){
            return;
        }

        Node secondBot = bot;
        bot = new Node(input);
        bot.next = null;
        if(isEmpty()){
            top = bot;
        }
        else{
            secondBot.next = bot;
        }
        size++;
    }

    /**
     * generic pop, takes node from top of stack
     * @return node from top of stack
     */
    public E dequeue(){
        if(isEmpty()){
            return null;
        }
        Node dequeueTop = top;
        top = top.next;
        dequeueTop.next = null;
        size--;
        return dequeueTop.data;

    }

    /**
     * Looks at the data of the top object
     * @return data stored in the top node
     */
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return top.data;
    }

    /**
     *Checks for Empty Stack
     * @return boolean value on stack state
     */
    public boolean isEmpty(){
        return (top == null);
    }

    /**
     *Returns size of stack
     * @return int = number of elements in stack
     */
    public int size(){
        return size;
    }

    /**
     *Iterates along stack, and takes all data into a string
     * @return one string for the entire stack
     */
    public String toString(){
        String output = name +": \n[\n";
        for( Node i = top; i != null; i = i.next){
            output += i.data + "\n";
        }
        output += "]";
        return output;
    }

    /**
     * Iterator call to stacklist iterator subclass
     * @return stack action(s)
     */
    public Iterator<E> iterator(){
        return new QueueIterator();
    }

    /**
     * Pops all values out of stack.
     */
    public void clear(){
        for(Node i = top; i != null; i = i.next){
            this.dequeue();
        }
    }

    /**
     * mutator for name field
     * @param input is the name of the stacklist
     */
    public void setName(String input){
        name = input;
    }

    /**
     * accessor for name field
     * @return the name of the queue
     */
    public String getName(){
        return name;
    }

}
