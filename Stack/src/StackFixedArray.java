/*
* Stack implementation using an array of fixed
* size.
*/

public class StackFixedArray {
    private int[] arrStack;
    private int N = 0;

    /*
    * Method to initialize an array of fixed size
    * which will be used as a stack.
    *
    * @param size - size of an array.
    */

    public void fixedArraySize(int size) {
        arrStack = new int[size];
    }

    /*
    * Method to check whether the stack is empty.
    *
    * @return true if the stack is empty, otherwise -
    * false.
    */

    public boolean isEmpty() {
        return (N == 0);
    }

    /*
    * Method that displays the data stored in the
    * first element of the stack.
    */

    public void peek() {
        System.out.println(arrStack[N]);
    }

    /*
    * Method to add element to the stack.
    *
    * @param data - data that will be stored in the
    * new element of a stack.
    */

    public void push(int data) {
        arrStack[N++] = data;
    }

    /*
     * Method to get the first element of the stack and
     * remove it from the stack.
     *
     * @return first Node taken from the stack.
     */

    public int pop() {
        return arrStack[--N];
    }

    /*
     * Method to get the number of elements in a stack.
     *
     * @return the size of a stack.
     */

    public int size() {
        return N;
    }
}