public class Tree<T> {
    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public List<T> breadthFirstSearch() {
        List<T> result = new List<T>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.dequeue();
            result.addAtEnd(current.getValue());
            List<TreeNode<T>> children = current.getChildren();
            for (TreeNode<T> child : children) {
                queue.enqueue(child);
            }
        }
        return result;
    }

    public List<T> depthFirstSearch() {
        List<T> result = new List<T>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.pop();
            result.addAtEnd(current.getValue());
            List<TreeNode<T>> children = current.getChildren();
            for (TreeNode<T> child : children) {
                stack.push(child);
            }
        }
        return result;
    }
}
