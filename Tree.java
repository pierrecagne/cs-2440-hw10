public class Tree<T> {
    // TODO: Implement the unique field
    private TreeNode<T> root;

    public Tree() {
        // TODO: Initialize the tree
        root = null;
    }

    public Tree(TreeNode<T> root) {
        // TODO: Initialize the tree with a root
        this.root = root;
    }

    public void setRoot(TreeNode<T> root) {
        // TODO: Set the root node
        this.root = root;

    }

    public TreeNode<T> getRoot() {
        // TODO: Return the root node
        return root; // For compiling purposes only. TODO: Replace by adequate return
    }

    public List<T> breadthFirstSearch() {
        // TODO: Implement BFS
        List<T> R = new List<T> ();
        if (this.root == null) 
            return R;
        

        Queue<TreeNode<T>> C = new Queue<TreeNode<T>> ();
        C.enqueue(this.root);
        
        while (!C.isEmpty()) {
            TreeNode<T> curr = C.dequeue();
            R.addAtEnd(curr.getValue());

            List<TreeNode<T>> children = curr.getChildren();
            for (TreeNode<T> t : children) {
                C.enqueue(t);
            }
        }
        // Don't forget to transform your collection R into a list at the end (if it is not already)
        return R; // For compiling purposes only. TODO: Replace by adequate return
    }

    public List<T> depthFirstSearch() {
        // TODO: Implement DFS
        List<T> R = new List<T> ();
        if (this.root == null)
            return R;
        
        Stack<TreeNode<T>> C = new Stack<TreeNode<T>> ();
        C.push(this.root);

        while(!C.isEmpty()) {
            TreeNode<T> curr = C.pop();
            R.addAtEnd(curr.getValue());

            List<TreeNode<T>> children = curr.getChildren();
            for (TreeNode<T> t : children) {
                C.push(t);
            }
        }
        // Don't forget to transform your collection R into a list at the end (if it is not already)
        return R; // For compiling purposes only. TODO: Replace by adequate return
    }
}


