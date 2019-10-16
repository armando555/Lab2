package src;

public class Node {
    private char data;
    private Node next;
    private Node prev;

    /**
     * this function make a new node for use on the linked list
     * @param data
     * @param next
     * @param prev
     */
    public Node(char data, Node next,Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public Node() {

    }

    /**
     * this function return the data of some specific node
     * @return
     */
    public char getData() {
        return data;
    }

    /**
     * this functiom can fix the data of some specific node
     * @param data
     */
    public void setData(char data) {
        this.data = data;
    }

    /**
     * this function can fix the next node of some specific node
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * this function can get the data from some specific node
     * @return
     */
    public Node getNext() {
        return next;
    }

    /**
     * this funcion can get the prev node from some specific node
     * @return
     */
    public Node getPrev(){ return prev;}

    /**
     * this function can fix the prev node of some specific node
     * @param prev
     */
    public void setPrev(Node prev){ this.prev=prev;}

}

