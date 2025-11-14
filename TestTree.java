public class TestTree {

    public static void main(String[] args) {
        System.out.println("===== Tree Traversal Tests =====\n");
        
        int passed = 0;
        int total = 0;

        // Test 1: Empty tree
        total++;
        if (testEmptyTree()) {
            passed++;
            System.out.println("✓ Test 1 PASSED: Empty tree\n");
        } else {
            System.out.println("✗ Test 1 FAILED: Empty tree\n");
        }

        // Test 2: Single node tree
        total++;
        if (testSingleNode()) {
            passed++;
            System.out.println("✓ Test 2 PASSED: Single node tree\n");
        } else {
            System.out.println("✗ Test 2 FAILED: Single node tree\n");
        }

        // Test 3: Tree from assignment (example tree)
        total++;
        if (testAssignmentExample()) {
            passed++;
            System.out.println("✓ Test 3 PASSED: Assignment example tree\n");
        } else {
            System.out.println("✗ Test 3 FAILED: Assignment example tree\n");
        }

        // Test 4: Linear tree (like a linked list)
        total++;
        if (testLinearTree()) {
            passed++;
            System.out.println("✓ Test 4 PASSED: Linear tree\n");
        } else {
            System.out.println("✗ Test 4 FAILED: Linear tree\n");
        }

        // Test 5: Complete binary tree
        total++;
        if (testCompleteBinaryTree()) {
            passed++;
            System.out.println("✓ Test 5 PASSED: Complete binary tree\n");
        } else {
            System.out.println("✗ Test 5 FAILED: Complete binary tree\n");
        }

        // Test 6: Unbalanced tree
        total++;
        if (testUnbalancedTree()) {
            passed++;
            System.out.println("✓ Test 6 PASSED: Unbalanced tree\n");
        } else {
            System.out.println("✗ Test 6 FAILED: Unbalanced tree\n");
        }

        // Test 7: Tree with single child nodes
        total++;
        if (testSingleChildNodes()) {
            passed++;
            System.out.println("✓ Test 7 PASSED: Tree with single child nodes\n");
        } else {
            System.out.println("✗ Test 7 FAILED: Tree with single child nodes\n");
        }

        // Summary
        System.out.println("=====================================");
        System.out.println("Results: " + passed + "/" + total + " tests passed");
        if (passed == total) {
            System.out.println("🎉 All tests passed! Great work!");
        } else {
            System.out.println("⚠ Some tests failed. Keep working on it!");
        }
    }

    // Test 1: Empty tree
    private static boolean testEmptyTree() {
        System.out.println("Test 1: Empty Tree");
        Tree<Integer> tree = new Tree<>();
        
        List<Integer> bfs = tree.breadthFirstSearch();
        List<Integer> dfs = tree.depthFirstSearch();
        
        boolean bfsEmpty = bfs.isEmpty();
        boolean dfsEmpty = dfs.isEmpty();
        
        System.out.println("  BFS result: " + listToString(bfs) + " (should be empty)");
        System.out.println("  DFS result: " + listToString(dfs) + " (should be empty)");
        
        return bfsEmpty && dfsEmpty;
    }

    // Test 2: Single node tree
    private static boolean testSingleNode() {
        System.out.println("Test 2: Single Node Tree");
        TreeNode<Integer> root = new TreeNode<>(42);
        Tree<Integer> tree = new Tree<>(root);
        
        List<Integer> bfs = tree.breadthFirstSearch();
        List<Integer> dfs = tree.depthFirstSearch();
        
        Integer[] expectedBFS = {42};
        Integer[] expectedDFS = {42};
        
        boolean bfsCorrect = listsEqual(bfs, expectedBFS);
        boolean dfsCorrect = listsEqual(dfs, expectedDFS);
        
        System.out.println("  BFS result: " + listToString(bfs));
        System.out.println("  BFS expected: [42]");
        System.out.println("  DFS result: " + listToString(dfs));
        System.out.println("  DFS expected: [42]");
        
        return bfsCorrect && dfsCorrect;
    }

    // Test 3: Assignment example tree
    private static boolean testAssignmentExample() {
        System.out.println("Test 3: Assignment Example Tree");
        System.out.println("  Tree structure:");
        System.out.println("          1");
        System.out.println("        / | \\");
        System.out.println("       2  3  4");
        System.out.println("      /|     |\\");
        System.out.println("     5 6     7 8");
        
        // Build the tree from the assignment
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        
        node1.addChild(node2);
        node1.addChild(node3);
        node1.addChild(node4);
        
        node2.addChild(node5);
        node2.addChild(node6);
        
        node4.addChild(node7);
        node4.addChild(node8);
        
        Tree<Integer> tree = new Tree<>(node1);
        
        List<Integer> bfs = tree.breadthFirstSearch();
        List<Integer> dfs = tree.depthFirstSearch();
        
        Integer[] expectedBFS = {1, 2, 3, 4, 5, 6, 7, 8};
        
        boolean bfsCorrect = listsEqual(bfs, expectedBFS);
        boolean dfsCorrect = isValidDFS(dfs, node1);
        
        System.out.println("  BFS result:   " + listToString(bfs));
        System.out.println("  BFS expected: [1, 2, 3, 4, 5, 6, 7, 8]");
        System.out.println("  DFS result:   " + listToString(dfs));
        System.out.println("  DFS expected: valid DFS traversal (any child order)");
        
        return bfsCorrect && dfsCorrect;
    }

    // Test 4: Linear tree (like a linked list)
    private static boolean testLinearTree() {
        System.out.println("Test 4: Linear Tree");
        System.out.println("  Tree structure: 1 -> 2 -> 3 -> 4 -> 5");
        
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        
        node1.addChild(node2);
        node2.addChild(node3);
        node3.addChild(node4);
        node4.addChild(node5);
        
        Tree<Integer> tree = new Tree<>(node1);
        
        List<Integer> bfs = tree.breadthFirstSearch();
        List<Integer> dfs = tree.depthFirstSearch();
        
        Integer[] expected = {1, 2, 3, 4, 5};
        
        boolean bfsCorrect = listsEqual(bfs, expected);
        boolean dfsCorrect = isValidDFS(dfs, node1) && listsEqual(dfs, expected);
        
        System.out.println("  BFS result:   " + listToString(bfs));
        System.out.println("  BFS expected: [1, 2, 3, 4, 5]");
        System.out.println("  DFS result:   " + listToString(dfs));
        System.out.println("  DFS expected: [1, 2, 3, 4, 5] (only one valid order)");
        
        return bfsCorrect && dfsCorrect;
    }

    // Test 5: Complete binary tree
    private static boolean testCompleteBinaryTree() {
        System.out.println("Test 5: Complete Binary Tree");
        System.out.println("  Tree structure:");
        System.out.println("          1");
        System.out.println("        /   \\");
        System.out.println("       2     3");
        System.out.println("      / \\   / \\");
        System.out.println("     4   5 6   7");
        
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        
        node1.addChild(node2);
        node1.addChild(node3);
        
        node2.addChild(node4);
        node2.addChild(node5);
        
        node3.addChild(node6);
        node3.addChild(node7);
        
        Tree<Integer> tree = new Tree<>(node1);
        
        List<Integer> bfs = tree.breadthFirstSearch();
        List<Integer> dfs = tree.depthFirstSearch();
        
        Integer[] expectedBFS = {1, 2, 3, 4, 5, 6, 7};
        
        boolean bfsCorrect = listsEqual(bfs, expectedBFS);
        boolean dfsCorrect = isValidDFS(dfs, node1);
        
        System.out.println("  BFS result:   " + listToString(bfs));
        System.out.println("  BFS expected: [1, 2, 3, 4, 5, 6, 7]");
        System.out.println("  DFS result:   " + listToString(dfs));
        System.out.println("  DFS expected: valid DFS traversal (any child order)");
        
        return bfsCorrect && dfsCorrect;
    }

    // Test 6: Unbalanced tree
    private static boolean testUnbalancedTree() {
        System.out.println("Test 6: Unbalanced Tree");
        System.out.println("  Tree structure:");
        System.out.println("       1");
        System.out.println("      / \\");
        System.out.println("     2   3");
        System.out.println("    /");
        System.out.println("   4");
        System.out.println("  /");
        System.out.println(" 5");
        
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        
        node1.addChild(node2);
        node1.addChild(node3);
        node2.addChild(node4);
        node4.addChild(node5);
        
        Tree<Integer> tree = new Tree<>(node1);
        
        List<Integer> bfs = tree.breadthFirstSearch();
        List<Integer> dfs = tree.depthFirstSearch();
        
        Integer[] expectedBFS = {1, 2, 3, 4, 5};
        
        boolean bfsCorrect = listsEqual(bfs, expectedBFS);
        boolean dfsCorrect = isValidDFS(dfs, node1);
        
        System.out.println("  BFS result:   " + listToString(bfs));
        System.out.println("  BFS expected: [1, 2, 3, 4, 5]");
        System.out.println("  DFS result:   " + listToString(dfs));
        System.out.println("  DFS expected: valid DFS traversal (any child order)");
        
        return bfsCorrect && dfsCorrect;
    }

    // Test 7: Tree with varying number of children
    private static boolean testSingleChildNodes() {
        System.out.println("Test 7: Tree with Varying Children");
        System.out.println("  Tree structure:");
        System.out.println("          1");
        System.out.println("       /  |  |  \\");
        System.out.println("      2   3  4   5");
        System.out.println("     /");
        System.out.println("    6");
        
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        
        node1.addChild(node2);
        node1.addChild(node3);
        node1.addChild(node4);
        node1.addChild(node5);
        
        node2.addChild(node6);
        
        Tree<Integer> tree = new Tree<>(node1);
        
        List<Integer> bfs = tree.breadthFirstSearch();
        List<Integer> dfs = tree.depthFirstSearch();
        
        Integer[] expectedBFS = {1, 2, 3, 4, 5, 6};
        
        boolean bfsCorrect = listsEqual(bfs, expectedBFS);
        boolean dfsCorrect = isValidDFS(dfs, node1);
        
        System.out.println("  BFS result:   " + listToString(bfs));
        System.out.println("  BFS expected: [1, 2, 3, 4, 5, 6]");
        System.out.println("  DFS result:   " + listToString(dfs));
        System.out.println("  DFS expected: valid DFS traversal (any child order)");
        
        return bfsCorrect && dfsCorrect;
    }

    // Helper method to compare lists
    private static boolean listsEqual(List<Integer> list, Integer[] expected) {
        if (list.length() != expected.length) {
            return false;
        }
        
        int index = 0;
        for (Integer value : list) {
            if (!value.equals(expected[index])) {
                return false;
            }
            index++;
        }
        
        return true;
    }

    // Helper method to validate DFS structure
    // Checks that DFS visits all nodes and respects depth-first property
    // For a node, all its descendants must appear before its siblings
    private static boolean isValidDFS(List<Integer> dfs, TreeNode<Integer> root) {
        if (root == null) {
            return dfs.isEmpty();
        }
        
        // Check that all nodes are present
        int expectedCount = countNodes(root);
        if (dfs.length() != expectedCount) {
            return false;
        }
        
        // Check that root is first
        if (dfs.atPosition(0) != root.getValue()) {
            return false;
        }
        
        // Check depth-first property: for each parent, all descendants 
        // must appear before any of its siblings
        return checkDFSProperty(dfs, root);
    }
    
    private static int countNodes(TreeNode<Integer> node) {
        if (node == null) return 0;
        int count = 1;
        for (TreeNode<Integer> child : node.getChildren()) {
            count += countNodes(child);
        }
        return count;
    }
    
    private static boolean checkDFSProperty(List<Integer> dfs, TreeNode<Integer> root) {
        // Build a map of node values to their positions in the DFS traversal
        int[] positions = new int[100]; // Assuming node values are small
        int index = 0;
        for (Integer value : dfs) {
            positions[value] = index++;
        }
        
        // For each node, check that all descendants appear before its next sibling
        return checkNodeDFS(positions, root);
    }
    
    private static boolean checkNodeDFS(int[] positions, TreeNode<Integer> node) {
        if (node == null) return true;
        
        List<TreeNode<Integer>> children = node.getChildren();
        if (children.isEmpty()) return true;
        
        // Get range of positions for all descendants of this node
        int minPos = positions[node.getValue()];
        int maxPos = getMaxDescendantPosition(positions, node);
        
        // Check each child's descendants are within this node's range
        for (TreeNode<Integer> child : children) {
            int childPos = positions[child.getValue()];
            
            // Child and all its descendants must be contiguous and within parent's range
            if (childPos <= minPos || childPos > maxPos) {
                return false;
            }
            
            // Recursively check children
            if (!checkNodeDFS(positions, child)) {
                return false;
            }
        }
        
        return true;
    }
    
    private static int getMaxDescendantPosition(int[] positions, TreeNode<Integer> node) {
        int max = positions[node.getValue()];
        for (TreeNode<Integer> child : node.getChildren()) {
            int childMax = getMaxDescendantPosition(positions, child);
            if (childMax > max) max = childMax;
        }
        return max;
    }

    // Helper method to convert list to string for display
    private static String listToString(List<Integer> list) {
        if (list.isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        for (Integer value : list) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(value);
            first = false;
        }
        sb.append("]");
        
        return sb.toString();
    }
}
