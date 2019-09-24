package challenges.leetCode.BinaryTree;

//Given a binary tree, determine if it is height-balanced.
//
//        For this problem, a height-balanced binary tree is defined as:
//
//        a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//        Example 1:
//
//        Given the following tree [3,9,20,null,null,15,7]:
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        Return true.
//
//        Example 2:
//
//        Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//        1
//        / \
//        2   2
//        / \
//        3   3
//        / \
//        4   4
//        Return false.


public class IsBalanced {

    public static void main(String[] args) {
//        TreeNode root = TreeNode.setupBalanceTree();
        TreeNode root = TreeNode.setupUnbalanceTree();
        boolean result = isBalanced(root);
        System.out.println(result);
        TreeNode.prettyPrint(root);
    }




    public static class BalStat {
        boolean isBal;
        int height;
        public BalStat(boolean isBal, int height) {
            this.isBal = isBal;
            this.height = height;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return balanceHelper(root).isBal;
    }

    public static BalStat balanceHelper(TreeNode root) {
        if (root == null) {
            return new BalStat(true, -1);
        }
        BalStat left = balanceHelper(root.left);
        if (!left.isBal) {
            return left;
        }
        BalStat right = balanceHelper(root.right);
        if (!right.isBal) {
            return right;
        }
        boolean isBal = Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        return new BalStat(isBal, height);
    }


// My first solution, not so cool
//    public static boolean isBalance(TreeNode root) {
//        if (root == null) {
//            return false;
//        }
//        int height = getHeightAndBalanced(root);
//        if (height != -2) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static int getHeightAndBalanced(TreeNode root) {
//        if (root == null) {
//            return -1;
//        }
//        int leftH = getHeightAndBalanced(root.left);
//        if (leftH == -2) {
//            return -2;
//        }
//        int rightH = getHeightAndBalanced(root.right);
//        if (rightH == -2) {
//            return -2;
//        }
//        if (Math.abs(rightH - leftH) <= 1) {
//            return Math.abs(rightH - leftH) + 1;
//        }  else {
//            return -2;
//        }
//    }



}
