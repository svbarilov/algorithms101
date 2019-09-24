package challenges.leetCode.BinaryTree;


public class TreeNode {
    int key;
    String value;
    TreeNode left, right;

    public TreeNode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static TreeNode setupBalanceTree() {
        TreeNode root = new TreeNode(5, "e");
        insertItem(root, 3, "c");
        insertItem(root, 2, "b");
        insertItem(root, 4, "d");
        insertItem(root, 7, "g");
        insertItem(root, 6, "f");
        insertItem(root, 8, "h");
        return root;
    }

    public static TreeNode setupUnbalanceTree() {
        TreeNode root = new TreeNode(15, "e");
        insertItem(root, 11, "c");
        insertItem(root, 13, "b");
        insertItem(root, 9, "d");
        insertItem(root, 16, "g");
        insertItem(root, 8, "h");
        insertItem(root, 10, "u");
//        insertItem(root, 0, "k");
        return root;
    }

    public static TreeNode insertItem(TreeNode node, int key, String value) {
        if (node == null) {
            node = new TreeNode(key, value);;
            return node;
        }
        if (key < node.key) {
            node.left = insertItem(node.left, key, value);
        } if (key > node.key) {
            node.right = insertItem(node.right, key, value);
        }
        return node;
    }

    public static void prettyPrint(TreeNode root) {
        int rootLeftKey = root.left == null ? 0 : root.left.key;
        int rootRightKey = root.right == null ? 0 : root.right.key;
        int rootLeftLeftKey = 0;
        int rootLeftRightKey = 0;
        if (root.left != null) {
            rootLeftLeftKey = root.left.left == null ? 0 : root.left.left.key;
            rootLeftRightKey = root.left.right == null ? 0 : root.left.right.key;
        }
        int rootRightLeftKey = 0;
        int rootRightRightKey = 0;

        if (root.right != null) {
            rootRightLeftKey = root.right.left == null ? 0 : root.right.left.key;
            rootRightRightKey = root.right.right == null ? 0 : root.right.right.key;
        }
        System.out.println("     " + root.key);
        System.out.println("   /  \\");
        System.out.println("  " + rootLeftKey + "    " + rootRightKey);
        System.out.println(" / \\  / \\");
        System.out.println(rootLeftLeftKey + "  " + rootLeftRightKey + " " + rootRightLeftKey + "   " + rootRightRightKey);
    }



} // end class

