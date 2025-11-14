public class Tree<T> {
    TreeNode<T> root;

    /**
     * New Tree.
     */
    public Tree() {
        this.root = null;
    }

    /**
     * New Tree with defined root.
     * @param root The TreeNode to set as the root.
     */
    public Tree(TreeNode<T> root) {
        setRoot(root);
    }

    /**
     * Set the Tree's root.
     * @param root The root TreeNode to set.
     */
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * Get the current root.
     * @return
     */
    public TreeNode<T> getRoot() {
        return this.root;
    }

    /**
     * Returns a breadth-first list of items in a given tree.
     * @return The breadth-first list.
     */
    public List<T> breadthFirstSearch() {
        List<T> R = new List<T>();
        if (this.root == null)
            return R;
        Queue<TreeNode<T>> C = new Queue<TreeNode<T>>();
        C.enqueue(this.root);
        while (!C.isEmpty()) {
            TreeNode<T> rem = C.dequeue();
            R.addAtEnd(rem.getValue());
            for (TreeNode<T> t : rem.children) {
                C.enqueue(t);
            }
        }
        return R;
    }

    /**
     * Returns a depth-first list of items in a given tree.
     * @return The depth-first list.
     */
    public List<T> depthFirstSearch() {
        List<T> R = new List<T>();
        if (this.root == null)
            return R;
        Stack<TreeNode<T>> C = new Stack<TreeNode<T>>();
        C.push(this.root);
        while (!C.isEmpty()) {
            TreeNode<T> rem = C.pop();
            R.addAtEnd(rem.getValue());
            for (TreeNode<T> t : rem.children) {
                C.push(t);
            }
        }
        return R;
    }

    /**
     * Return a string representation of a list.
     * @param list The list to parse.
     * @return The string out.
     */
    public static String printList(List list) {
        String out = "(";
        for (int i = 0; i < list.length(); i++) {
            out += list.atPosition(i);
            out += i < list.length() - 1 ? ", " : ")";
        }
        return out;
    }

    /**
     * Test it all.
     * @param args Console args.
     */
    public static void main(String[] args) {
        TreeNode<Integer> A = new TreeNode<Integer>(1);
        TreeNode<Integer> B = new TreeNode<Integer>(2);
        TreeNode<Integer> C = new TreeNode<Integer>(3);
        TreeNode<Integer> D = new TreeNode<Integer>(4);
        TreeNode<Integer> E = new TreeNode<Integer>(5);
        TreeNode<Integer> F = new TreeNode<Integer>(6);
        TreeNode<Integer> G = new TreeNode<Integer>(7);
        TreeNode<Integer> H = new TreeNode<Integer>(8);
        TreeNode<Integer> I = new TreeNode<Integer>(9);
        Tree<Integer> tree = new Tree<Integer>(A);
        A.addChild(B);
        A.addChild(C);
        A.addChild(D);
        B.addChild(E);
        B.addChild(F);
        D.addChild(G);
        D.addChild(H);
        D.addChild(I);
        List<Integer> breadthList = tree.breadthFirstSearch();
        System.out.println(printList(breadthList));
        List<Integer> depthList = tree.depthFirstSearch();
        System.out.println(printList(depthList));
    }
}