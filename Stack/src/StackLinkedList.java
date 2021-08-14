/*
* Implementation of stack using a Linked List.
*/

public class StackLinkedList {
    private Node first = null;

    /*
    * Nested class to represent Node of a linked list.
    */

    private static class Node {
        int data;
        Node next;

        /*
        * Constructor for a Node.
        *
        * @param data - information to be stored in a
        * Node.
        */

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
    * Method to check whether the stack is empty.
    *
    * @return true if the stack is empty, otherwise -
    * false.
    */

    public boolean isEmpty()        { return (first == null); }

    /*
     * Method to see the data stored in the first element
     * of the stack.
     */

    public void peek()      { System.out.println(first.data); }

    /*
    * Method to push a new element to the stack.
    *
    * @param data - information that will be stored
    * in the element we are going to push.
    */

    public void push(int data) {
        Node newFirst = new Node(data);
        newFirst.next = first;
        first = newFirst;
    }

    /*
     * Method to get the first element of the stack and
     * remove it from the stack.
     *
     * @return first Node taken from the stack.
     */

    public Node pop() {
        Node result = first;
        first = first.next;
        return result;
    }

    /*
     * Method to calculate number of elements in the stack
     * by traversing the linked list.
     *
     * @return the size of a stack.
     */

    public int size() {
        int size = 0;
        Node current = first;
        while(current != null) {
            current = current.next;
            size++;
        }
        return size;
    }
}