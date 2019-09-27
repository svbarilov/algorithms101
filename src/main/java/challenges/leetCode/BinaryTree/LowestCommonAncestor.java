package challenges.leetCode.BinaryTree;

import java.util.*;

public class LowestCommonAncestor {


    public static void main(String[] args) {

//        TreeNode p = new TreeNode(15, "1");
//        TreeNode q = new TreeNode(19, "2");
//        TreeNode root = p;
//        root.left = q;

//        TreeNode root = new TreeNode(20, "3");
//        TreeNode p = new TreeNode(15, "5");
//        TreeNode q = new TreeNode(19, "4");
//        root.left = p;
//        root.left.left = new TreeNode(8, "6");
//        root.right = new TreeNode(25, "1");
//        root.right.right = new TreeNode(30, "8");
//        root.right.left = new TreeNode(22, "0");
//        root.left.right = new TreeNode(17, "2");
//        root.left.right.right = q;
//        root.left.right.left = new TreeNode(16, "7");

        TreeNode root = new TreeNode(20, "3");
        TreeNode p = new TreeNode(8, "6");
        TreeNode q = new TreeNode(19, "4");
        root.left = new TreeNode(15, "5");
        root.left.left = p;
        root.right = new TreeNode(25, "1");
        root.right.right = new TreeNode(30, "8");
        root.right.left = new TreeNode(22, "0");
        root.left.right = new TreeNode(17, "2");
        root.left.right.right = q; //
        root.left.right.left = new TreeNode(16, "7");

        TreeNode result = lowestCommonAncestor(root, p, q);
        TreeNode.prettyPrint(root);
    }


    // Recursive
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { return null; }
        if (root.equals(q) || root.equals(p)) { return root; }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) { return right; }
        if (right == null) { return left; }
        return root;
    }





    // Iterative
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // Stack for tree traversal
//        Deque<TreeNode> stack = new ArrayDeque<>();
//
//        // HashMap for parent pointers
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//
//        parent.put(root, null);
//        stack.push(root);
//
//        // Iterate until we find both the nodes p and q
//        while (!parent.containsKey(p) || !parent.containsKey(q)) {
//
//            TreeNode node = stack.pop();
//
//            // While traversing the tree, keep saving the parent pointers.
//            if (node.left != null) {
//                parent.put(node.left, node);
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                parent.put(node.right, node);
//                stack.push(node.right);
//            }
//        }
//
//        // Ancestors set() for node p.
//        Set<TreeNode> ancestors = new HashSet<>();
//
//        // Process all ancestors for node p using parent pointers.
//        while (p != null) {
//            ancestors.add(p);
//            p = parent.get(p);
//        }
//
//        // The first ancestor of q which appears in
//        // p's ancestor set() is their lowest common ancestor.
//        while (!ancestors.contains(q))
//            q = parent.get(q);
//        return q;
//    }



}
