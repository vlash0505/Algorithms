/*
* Queue implementation using a linked list.
*/

public class Queue {
    private Node head;
    private Node tail;

    /*
    * Nested class to represent a node of a
    * linked list.
    */

    private static class Node {
        final int data;
        Node next;

        /*
        * Constructor for a node.
        *
        * @param data - data to be stored in a node.
        */

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
    * Method to check whether queue is empty.
    *
    * @return true if queue is empty, otherwise -
    * false.
    */

    public boolean isEmpty() {
        return (head == null);
    }

    /*
    * Method
    */

    public void peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println(head.data);
        }
    }

    /*
     * Method to add element to the queue.
     *
     * @param data - information to be stored
     * in the new element of the queue.
     */

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if(head == null) {              //Special case for an empty queue.
            head = newNode;
            head = tail;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    /*
     * Method to get and remove element from the
     * queue.
     *
     * @return first node of the queue, null if
     * the queue is empty.
     */

    public Node dequeue() {
        if(isEmpty()) {                 //Special case for an empty queue.
            System.out.println("Queue is empty.");
            return null;
        }
        Node item = head;
        head = head.next;
        return item;
    }
}