package challenges.leetCode.BinaryTree;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
//
//
//        But the following [1,2,2,null,3,null,3] is not:
//
//        1
//        / \
//        2   2
//        \   \
//        3    3
//
//
//        Note:
//        Bonus points if you could solve it both recursively and iteratively.


public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.setupSymmetricTree();
//        TreeNode root = TreeNode.setupAssymetricTree();
        boolean result = isSymmetric(root);
        System.out.println(result);
        TreeNode.prettyPrint(root);
    }


// recursive solution
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSym(root.left, root.right);
    }

    public static boolean checkSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            return left.value == right.value && checkSym(left.left, right.right)
                    && checkSym(left.right, right.left);
        } else {
            return false;
        }
    }


}
