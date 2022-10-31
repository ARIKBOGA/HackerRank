public class SumOfLeftLeaves {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

class Solution {

    public static int sumOfLeftLeaves(SumOfLeftLeaves.TreeNode root) {
        return dfs(root, false);
    }

    public static int dfs(SumOfLeftLeaves.TreeNode root, boolean leftChild) {
        if (root == null)
            return 0;

        //just pass a boolean value to check weather the node is left or right :  during dfs.left pass true since the node we are going to traverse is left child
        if (root.left == null && root.right == null && leftChild)
            return root.val;

        int left = dfs(root.left, true);
        int right = dfs(root.right, false);

        return left + right;

    }
}
