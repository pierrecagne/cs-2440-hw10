/**
 * A generic queue implementation using a linked list.
 * Follows FIFO (First-In-First-Out) ordering.
 * 
 * @param <T> the type of elements in this queue
 */
public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;

    /**
     * Constructs an empty queue.
     */
    public Queue () {
        head = null;
        tail = null;
    }

    /**
     * Checks if the queue is empty.
     * 
     * @return true if the queue has no elements, false otherwise
     */
    public boolean isEmpty () {
        return head == null;
    }

    /**
     * Adds an element to the end of the queue.
     * Time complexity: O(1)
     * 
     * @param element the element to add
     */
    public void enqueue (T element) {
        Node<T> newTail = new Node<T>(element);

        if (isEmpty()) {
            head = newTail;
        }
        else {
            tail.setNext(newTail);
        }
        
        tail = newTail;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * Time complexity: O(1)
     * 
     * @return the element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public T dequeue () {
        if(isEmpty())
            throw new IllegalStateException("Can't dequeue an empty queue");

        T data = head.getData();
        head = head.getNext();
        return data;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * 
     * @return the element at the front of the queue
     */
    public T peek () {
        return head.getData();
    }

    /**
     * Converts this queue to a List.
     * The order of elements in the list matches the queue order (front to back).
     * 
     * @return a List containing all elements of this queue
     */
    public List<T> toList () {
        return new List<T>(head);
    }

}