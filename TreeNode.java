public class TreeNode<T> {
    // TODO: Implement the two fields
    private T data;
    private Node<TreeNode<T>> head;

    public TreeNode(T value) {
        // TODO: Initialize the node
        this.data = value;
        this.head = null;
        // The resulting node contains `value` as data
        // and have an empty list of children.
    }

    public void addChild(TreeNode<T> child) {
        // TODO: Add a child to this node
        Node<TreeNode<T>> newNode = new Node<TreeNode<T>>(child);
        newNode.setNext(head);
        head = newNode;
        // You can choose *where* to add the child
        // but try to opt for the most time-efficient.
    }

    public List<TreeNode<T>> getChildren() {
        // TODO: Return the list of children
        List<TreeNode<T>> rev = new List<TreeNode<T>> ();
        
        Node<TreeNode<T>> curr = head;
        
        while (curr != null) {
            rev.addOnHead(curr.getData());
            curr = curr.getNext();
        }
        return rev;
            // For compiling purposes only. TODO: Replace by adequate return
    }

    public T getValue() {
        // TODO: Return the node's value
        return data; // For compiling purposes only. TODO: Replace by adequate return
    }
}

