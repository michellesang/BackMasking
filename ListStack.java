import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.ConcurrentModificationException;

public class ListStack implements BKStack, Iterable<Double>{
    // A ListStackNode object contains the items in the stack
    private static class ListStackNode{
        double item;
        ListStackNode next;
    }
    
    private ListStackNode head; // Points to the Node at the top of the stack

    // Returns true if the stack is empty, false if there at least one item on the stack
    public boolean isEmpty(){
        return (head == null);
    }
    
    // Pushes a value onto the stack
    public void push(double d){
        ListStackNode newNode; // A Node to hold the new item
        newNode = new ListStackNode();
        newNode.item = d; 
        newNode.next = head; 
        head = newNode; 
    }

    //Returns the number of elements stored in the stack
    public int count(){
         int counter = 0;
        for(Double node : this){
            counter++;
        }
        return counter;
    }
    
    // Remove the item at the top of the stack, then return it
    // Throws EmptyStackException if the stack is empty
    public double pop(){
        if (head == null)
            throw new EmptyStackException();
        double headItem = head.item; // The item that is being popped.
        head = head.next; // The previous second item is now on top.
        return headItem;
    }
    
    // Returns the item at the top of the stack
    public double peek(){
        if (head == null)
            throw new EmptyStackException();
        return head.item;
    }
    
    private int modCount = 0;
    
    public Iterator <Double> iterator(){
        return new StackIterator();
    }
    private class StackIterator implements Iterator<Double>{
        private ListStackNode current = head;
        private final int expectedModCount = modCount;

        // Returns true if there is an item at the next node
        // Throws ConcurrentModificationException if the current modification count
        // and correct mod count are out of sync
        public boolean hasNext(){
            if(expectedModCount != modCount)
                throw new ConcurrentModificationException();
            return current != null;
        }
        // Returns the data at the next node
        // Throws EmptyStackException if the stack is empty
        public Double next(){
            if(!hasNext())
                throw new EmptyStackException();
            double data = current.item;
            current = current.next;
            return data;
        }
    }
    
}