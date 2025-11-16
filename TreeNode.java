public class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;

    public TreeNode(T value) {
        data = value;
        children = new List<TreeNode<T>>();
    }

    public void addChild(TreeNode<T> child) {
        children.addAtEnd(child);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public T getValue() {
        return data;
    }
}
