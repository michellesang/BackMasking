import java.util.EmptyStackException;

public class ArrayStack implements BKStack{
    public final int INITIAL_CAPACITY = 10;
    private double[] array;
    private int headIndex;

    public ArrayStack(){
        array = new double[INITIAL_CAPACITY];
        headIndex = -1;
    }

    //Returns false if the stack contains elements, and false otherwise
    public boolean isEmpty(){
        return (headIndex == -1);
    }

    //Returns the number of elements stored in the stack
    public int count(){
        int count = 0;
        for(int i = 0; i < array.length-1; i++){
            if(array[i] != 0D)
                count++;
        }
        return count;
    }

    //Resizes the array to be twice as large, with the same values
    public void resize(){
        double[] temp = new double[2*array.length];
        for(int i = 0; i < array.length; i++)
            temp[i] = array[i];
        array = temp;
    }

    //Pushes a value onto the stack Resizes the stack if it gets full
    public void push(double d){
        headIndex++;
        if(headIndex == array.length)
            resize();
        array[headIndex] = d;
    }

    //Pops an item from the stack, and returns it 
    //Throws EmptyStackException if the stack is empty
    public double pop(){
        if(isEmpty())
            throw new EmptyStackException();
            headIndex--;
        return array[headIndex + 1];
    }

    //Returns the item at the top of the stack 
    //Throws EmptyStackException if the stack is empty
    public double peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return array[headIndex];
    }
}