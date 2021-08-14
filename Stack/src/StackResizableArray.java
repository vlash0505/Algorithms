/*
 * Stack implementation using resizable array.
 */

public class StackResizableArray {
    private int[] arrStack;
    private int N = 0;

    /*
    * Method to initialize the array that will be
    * used as stack.
    */

    public void newStack() {
        arrStack = new int[1];
    }

    /*
    * Method to resize the array. Strategy to use -
    * repeated doubling.
    *
    * @param newSize - size of the new resized array.
    */

    public void resizeArr(int newSize) {
        int[] newArr = new int[newSize];
        for (int i = 0; i < N; i++) {
            newArr[i] = arrStack[i];
        }
        arrStack = newArr;
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
     * Method to see the data stored in the first element
     * of the stack.
     */

    public void peek() {
        System.out.println(arrStack[N - 1]);
    }

    /*
     * Method to push a new element to the stack.
     *
     * @param data - information that will be stored
     * in the element we are going to push.
     */

    public void push(int data) {
        if(N == arrStack.length) { resizeArr(2 * N); }
        arrStack[N++] = data;
    }

    /*
     * Method to get the first element of the stack and
     * remove it from the stack.
     *
     * @return first Node taken from the stack.
     */

    public int pop() {
        int getElement = arrStack[--N];
        if(N > 0 && N == arrStack.length / 4) { resizeArr(N / 2); }
        return getElement;
    }
}
