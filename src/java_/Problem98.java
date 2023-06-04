package java_;

    /*
        Given the root of a binary tree,

        determine if it is a valid binary search tree (BST).

        A valid BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.

        The right subtree of a node contains only nodes with keys greater than the node's key.

        Both the left and right subtrees must also be binary search trees.
     */


public class Problem98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
       return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        boolean left = isValid(root.left, min, root.val);
        if (left) {
            return isValid(root.right, root.val, max);
        }
        return false;
    }
}
