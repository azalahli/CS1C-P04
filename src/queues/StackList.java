package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of an abstact StackList data structure
 * @author Myron Pow 4/29/17
 */

public class StackList<E> implements Iterable<E> {
    /**
     *private Node class for implementation of abstract StackList
     */
    private class Node{
        Node next;
        E data;

        Node(E input){
            data = input;
        }
    }

    /**
     * private StackListIterator, which iterates through the stack
     */
    private class StackListIterator implements Iterator<E>{
        protected Node currentTop = top;

        /**
         * hasNext method, as iterator should continue until the stack is empty, only a null pointer would return false
         * @return boolean value of null stack check
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
     * Beginning of StackList
     */
    /**
     * name of stacklist
     */
    private String name;
    /**
     * node on the top of the stack
     */
    private Node top;
    /**
     * size of the stack
     */
    private int size;

    /**
     * Constructor that sets default values of empty stacklist
     */
    StackList(){
        name = "";
        top = null;
        size = 0;
    }

    /**
     * generic push, takes data of type E and puts it on top of stack
     * @param input data to be added to top of stack
     */
    public void push(E input){
        if(input == null){
            return;
        }

        Node newTop = new Node(input);
        newTop.next = top;
        top = newTop;
        size++;
    }

    /**
     * generic pop, takes node from top of stack
     * @return node from top of stack
     */
    public Node pop(){
        if(isEmpty()){
            return null;
        }
        Node popTop = top;
        top = top.next;
        size--;
        return popTop;

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
        String output = name +" contains " + size + " links [";
        for( Node i = top; i != null; i = i.next){
            output += i.data + " ";
        }
        output += "]";
        return output;
    }

    /**
     * Iterator call to stacklist iterator subclass
     * @return stack action(s)
     */
    public Iterator<E> iterator(){
        return new StackListIterator();
    }

    /**
     * Pops all values out of stack.
     */
    public void clear(){
        for(Node i = top; i != null; i = i.next){
            this.pop();
        }
    }

    /**
     * mutator for name field
     * @param input is the name of the stacklist
     */
    public void setName(String input){
        name = input;
    }

}
