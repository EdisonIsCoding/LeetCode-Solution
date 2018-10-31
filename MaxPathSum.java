public class MaxPathSum
{
    private int maxResult = Integer.MIN_VALUE;
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x)
        {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root)
    {
        maxNodeSum(root);
        return maxResult;
    }

    private int maxNodeSum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int left = maxNodeSum(root.left);
        int right = maxNodeSum(root.right);
        int leftSum = left + root.val;
        int rightSum = right + root.val;
        int totalSum = left + right + root.val;
        int max = Math.max(root.val, Math.max(leftSum, rightSum));
        maxResult = Math.max(Math.max(totalSum, max), maxResult);
        return max;
    }
}
