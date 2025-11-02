/**
 * A generic node class for building linked data structures.
 * Each node contains data of type T and a reference to the next node.
 * 
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Constructs a node with specified data and next node.
     * 
     * @param data the data to store in this node
     * @param next the next node in the linked structure
     */
    public Node (T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructs a node with specified data and no next node.
     * 
     * @param data the data to store in this node
     */
    public Node (T data) {
        this(data, null);
    }

    /**
     * Sets the data stored in this node.
     * 
     * @param data the new data value
     */
    public void setData (T data) {
        this.data = data;
    }

    /**
     * Sets the next node in the linked structure.
     * 
     * @param next the node to follow this one
     */
    public void setNext (Node<T> next) {
        this.next = next;
    }

    /**
     * Returns the data stored in this node.
     * 
     * @return the data value
     */
    public T getData () {
        return data;
    }

    /**
     * Returns the next node in the linked structure.
     * 
     * @return the next node, or null if this is the last node
     */
    public Node<T> getNext () {
        return next;
    }
}