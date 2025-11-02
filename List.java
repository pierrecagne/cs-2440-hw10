import java.util.Iterator;

/**
 * A generic singly-linked list implementation.
 * Supports standard list operations including adding, removing, searching, and iterating.
 * 
 * @param <T> the type of elements in this list
 */
public class List<T> implements Iterable<T> {
    
    private Node<T> head;

    /**
     * Constructs a list with the specified head node.
     * 
     * @param head the first node of the list
     */
    public List (Node<T> head) {
        this.head = head;
    }

    /**
     * Constructs an empty list.
     */
    public List () {
        this(null);
    }

    /**
     * Returns the number of elements in this list.
     * 
     * @return the length of the list
     */
    public int length () {
        int l = 0;

        Node<T> current = head;
        while(current != null) {
            current = current.getNext();
            l++;
        }

        return l;
    }

    /**
     * Checks if the specified item is in this list.
     * 
     * @param item the item to search for
     * @return true if the item is found, false otherwise
     */
    public boolean isIn (T item) {
        for (T data : this) {
            if (data.equals(item)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a new list containing all elements except the first.
     * 
     * @return the tail of this list
     * @throws IllegalStateException if the list is empty
     */
    public List<T> tail () {
        if(isEmpty()) {
            throw new IllegalStateException("Empty lists don't have tails.");
        }

        return new List<T>(head.getNext());
    }

    /**
     * Adds an item to the beginning of the list.
     * Time complexity: O(1)
     * 
     * @param item the item to add
     */
    public void addOnHead (T item) {
        Node<T> newHead = new Node<T>(item, head);
        this.head = newHead;
    }

    /**
     * Checks if the list is empty.
     * 
     * @return true if the list has no elements, false otherwise
     */
    public boolean isEmpty () {
        return head == null;
    }

    /**
     * Adds an item to the end of the list.
     * Time complexity: O(n)
     * 
     * @param item the item to add
     */
    public void addAtEnd (T item) {
        Node<T> newEnd = new Node<T>(item);
  
        if(isEmpty()) {
            head = newEnd;
        }
        else {
            Node<T> current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newEnd);
        }
    }

    /**
     * Removes the specified node from the list.
     * 
     * @param toRemove the node to remove
     */
    public void remove (Node<T> toRemove) {
        if(toRemove == head) {
            head = head.getNext();
        }
        else {
            Node<T> current = head;
            while(current.getNext() != toRemove) {
                current = current.getNext();
            }
            current.setNext(toRemove.getNext());
        }
    }

    /**
     * Searches for a node containing the specified item.
     * 
     * @param item the item to search for
     * @return the first node containing the item, or null if not found
     */
    public Node<T> search (T item) {
        for (Node<T> current = head; current != null; current = current.getNext()) {
            if(current.getData().equals(item)) {
                return current;
            }
        }

        return null;
    }

    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index the index of the element to return (0-based)
     * @return the element at the specified position
     * @throws IllegalStateException if the list is empty
     */
    public T atPosition (int index) {
        if(isEmpty()) {
            throw new IllegalStateException("Can't access elements of an empty list.");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Creates and returns a shallow copy of this list.
     * 
     * @return a clone of this list
     */
    public List<T> clone() {
        List<T> newList = new List<T> ();

        if(isEmpty())
            return newList;

        Node<T> curr = head;
        while (curr != null) {
            newList.addAtEnd(curr.getData());
            curr = curr.getNext();
        }
        return newList;

    }

    /**
     * Returns an iterator over the elements in this list.
     * 
     * @return an iterator for this list
     */
    public Iterator<T> iterator () {
        return new ListIterator();
    }

    /**
     * Iterator implementation for the List class.
     */
    public class ListIterator implements Iterator<T> {
        private Node<T> nextNode;

        public ListIterator () {
            nextNode = head;
        }

        public boolean hasNext () {
            return nextNode != null;
        }

        public T next() {
            T data = nextNode.getData();
            nextNode = nextNode.getNext();
            return data;
        }
    }

    /**
     * Concatenates two lists by appending list2 to the end of list1.
     * Note: This modifies list1 in place.
     * 
     * @param <E> the type of elements in the lists
     * @param list1 the first list (will be modified)
     * @param list2 the second list to append
     * @return list1 with list2 appended
     */
    public static <E> List<E> concat (List<E> list1, List<E> list2) {
        Node<E> current = list1.head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(list2.head);
        return list1;
    }
}
