/**
 * A generic stack implementation using a linked list.
 * Follows LIFO (Last-In-First-Out) ordering.
 * 
 * @param <T> the type of elements in this stack
 */
public class Stack<T> {

    private Node<T> head;

    /**
     * Constructs an empty stack.
     */
    public Stack () {
        this.head = null;
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack has no elements, false otherwise
     */
    public boolean isEmpty () {
        return head == null;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * 
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T peek () {
        if(isEmpty())
            throw new IllegalStateException("Can't peek an empty list.");

        return head.getData();
    }

    /**
     * Pushes an element onto the top of the stack.
     * Time complexity: O(1)
     * 
     * @param element the element to push
     */
    public void push (T element) {
        head = new Node<T>(element, head);
    }

    /**
     * Removes and returns the element at the top of the stack.
     * Time complexity: O(1)
     * 
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T pop () {
        if(isEmpty())
            throw new IllegalStateException("Can't pop an empty list.");

        T res = head.getData();
        head = head.getNext();
        return res;
    }
    
}
