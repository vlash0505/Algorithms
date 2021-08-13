/*
* Java class to represent main functionality of the
* Linked List data structure. (traversing, inserting
* an element, deleting an element, detecting and
* deleting a loop, reversing a linked list)
*/

public class LinkedList {

    Node head;

    /*
    * Nested class to represent a node of a linked
    * list.
    */

    static class Node {
        int data;
        Node next;

        /*
        * Constructor to create a new node in a linked
        * list.
        *
        * @param value - data to be stored in a new node.
        */

        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    /*
    * Driver function to represent and test main functionality
    * of a LinkedList class.
    */

    public static void main(String[] args) {
        LinkedList example1 = new LinkedList();
        LinkedList example2 = new LinkedList();
        /*
        * Your code here.
        */
    }

    /*
    * Method for a linked list traversal.
    *
    * @param head - head of a given linked list.
    */

    public static void traverse(Node head) {
        Node current = head;
        while (current!= null) {
            System.out.println(current.data);           //display traversed nodes
            current = current.next;
        }
    }

    /*
     * Method to get the node at a given index.
     * A position of 0 indicates head.
     *
     * @param head - head of a given linked list.
     * @param i - index of a node we have to found.
     *
     * @return node at a given index, if no nodes
     * found - return null.
     */

    public static Node getNodeAt(Node head, int i) {
        Node current = head;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == i) {
                return current;
            }
            current = current.next;
            currentIndex++;
        }
        return null;
    }

    /*
    * Method to reverse a linked list
    *
    * @param head - the head of a given list
    */

    public static Node reverse(Node head) {
        if (head.next == null)          { return head; }
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /*
     * Method to insert a new node at a given position
     * in a linked list. A position of 0 indicates head.
     *
     * @param head - head of a given linked list.
     * @param pos - position of a new value to be
     * inserted.
     * @param value - data that will be stored
     * in a new node.
     */

    public static void positionInsert(Node head, int pos, int value) {
        if(pos < 1) {
            System.out.println("Wrong Index");
            return;
        }
        if(pos == 1) {
            insertBeginning(head, value);
            return;
        }
        Node toInsert = new Node(value);
        Node current = head;
        for (int i = 0; i < pos - 2; i++) {
            current = current.next;
        }
        if(current == null) {
            System.out.println("Index is out of range");
            return;
        }
        toInsert.next = current.next;
        current.next = toInsert;
    }

    /*
    * Method to insert a new node at the end of a
    * linked list.
    *
    * @param head - head of a given linked list.
    * @param value - value that will be stored
    * in a new node.
    */

    public static void insertEnd(Node head, int value) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    /*
     * Method to insert a new node at the beginning
     * of a linked list. (another name - push)
     *
     * @param head - head of a given linked list.
     * @param value - value that will be stored
     * in a new node.
     */

    public static void insertBeginning(Node head, int value) {
        Node newHead = new Node(value);
        newHead.next = head;
        head = newHead;
    }

    /*
    * Method to detect a loop in a linked list.
    * This method is a part of the Floyd's algorithm
    * of a loop detection
    *
    * @param head - the head of a given linked list.
    *
    * @return node if there is a loop (may later be used
    * in deleteLoop method as a part of Floyd's loop detection
    * algorithm to remove the loop), null if there is no loop.
    */

    public static Node detectLoop(Node head) {
        Node p = head;
        Node q = head;
        while (p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) return p;
        }
        return null;
    }

    /*
     * Method to remove a loop in a linked list.
     * Continues the Floyd's loop detection algorithm.
     *
     * @param head - the head of a given linked list.
     * @param p - node received from detectLoop method.
     */

    public static void deleteLoop(Node head, Node p) {
        Node q = head;
        while(p.next != q) {
            p = p.next;
            q = q.next;
        }
        p.next = null;
    }

    /*
     * Method to remove a node at a given index.
     * A position of 0 indicates head.
     *
     * @param head - the head of a given linked list.
     * @param i - index of a node to be deleted.
     */

    public static void deleteAtIndex(Node head, int i) {
        if(head == null)        { return; }
        if(i == 0)              { head = head.next;    return; }
        int counter = 0;
        Node currentNode = head;
        while(counter < (i - 1)) {
            currentNode = currentNode.next;
            counter++;
        }
        if(currentNode.next == null)        {
            System.out.println("Index is out of range");
            return;
        }
        currentNode.next = currentNode.next.next;
    }

    /*
     * Method to delete a whole linked list.
     *
     * @param head - the head of a given linked list.
     */

    public static void deleteList(Node head)           { head = null; }

    /*
     * Method to swap nodes without changing it's data.
     *
     * @param head - the head of a given linked list.
     * @param p - key of the first node to be swapped.
     * @param q - key of the second node to be swapped.
     */

    public static void swapNodes(Node head, int x, int y) {
        if(x == y)      { return; }

        Node pX = head;
        Node prevX = null;
        while((pX != null) && (pX.data != x)) {
            prevX = pX;
            pX = pX.next;
        }

        Node pY = head;
        Node prevY = null;
        while((pY != null) && (pY.data != x)) {
            prevY = pY;
            pY = pY.next;
        }

        if((pX == null) || (pY == null))        { return; }

        Node temp = pY.next;
        pY.next = pX.next;
        pX.next = temp;

        if(prevX == null) {
            head = pY;
            pY.next = pX;
        } else if(prevY == null) {
            head = pX;
            pX.next = pY;
        } else {
            prevX.next = pY;
            prevY.next = pX;
        }
    }
}