public class TreeNode<T> {
    T value;
    List<TreeNode<T>> children;

    public TreeNode(T value) {
        this.value = value;
        this.children = new List<TreeNode<T>>();
    }

    public void addChild(TreeNode<T> child) {
        this.children.addOnHead(child);
    }

    public List<TreeNode<T>> getChildren() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }
}