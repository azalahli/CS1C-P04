package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a partially abstact Queue data structure
 * @author Myron Pow 5/3/17
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
        protected Node currentHead = tail;

        /**
         * hasNext method, as iterator should continue until the stack is empty, only a null pointer would return false
         * @return boolean value of null Queue check
         */
        public boolean hasNext(){
            return (currentHead != null);
        }

        /**
         * returns value of head, iterates onto next element of stack
         * @return data of type E, which was encapsulated in head
         */
        public E next(){
            if(hasNext()){
                E data = currentHead.data;
                currentHead = currentHead.next;
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
     * node on the head(front) of the queue
     */
    private Node head;
    /**
     * node on the tail(back) of the queue
     */
    private Node tail;
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
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructor that sets default values of empty queue
     */
    Queue(){
        name = "";
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * enqueue, takes data of type E and puts it on head of queue
     * @param input data to be added to head of queue
     */
    public void enqueue(E input){
        if(input == null){
            return;
        }

        Node secondTail = tail;
        tail = new Node(input);
        tail.next = null;
        if(isEmpty()){
            head = tail;
        }
        else{
            secondTail.next = tail;
        }
        size++;
    }

    /**
     *  dequeue, takes node from head of queue
     * Done with the intent that the node should be popped, but client file demands a return of type E
     * If our nodes held more complex information this would result in much more problems
     * @return node.data from head of queue
     */
    public E dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node dequeueHead = head;
        head = head.next;
        dequeueHead.next = null;
        size--;
        return dequeueHead.data;

    }

    /**
     * Looks at the data of the head object
     * @return data stored in the head node
     */
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return head.data;
    }

    /**
     *Checks for Empty Queue
     * @return boolean value on queue state
     */
    public boolean isEmpty(){
        return (head == null);
    }

    /**
     *Returns size of queue
     * @return int = number of elements in queue
     */
    public int size(){
        return size;
    }

    /**
     *Iterates along queue, and takes all data into a string
     * @return one string for the entire queue
     */
    public String toString(){
        String output = name +": \n[\n";
        for( Node i = head; i != null; i = i.next){
            output += i.data + "\n";
        }
        output += "]";
        return output;
    }

    /**
     * Iterator call to queue iterator subclass
     * @return queue action(s)
     */
    public Iterator<E> iterator(){
        return new QueueIterator();
    }

    /**
     * removes all values out of queue.
     */
    public void clear(){
        for(Node i = head; i != null; i = i.next){
            this.dequeue();
        }
    }

    /**
     * mutator for name field
     * @param input is the name of the queue
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
