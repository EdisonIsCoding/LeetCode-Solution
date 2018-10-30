public class SymmetricTree
{
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

    public boolean isSymmetric(TreeNode root)
    {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null)
        {
            return true;
        }

        if (root1 == null || root2 == null)
        {
            return false;
        }

        if (root1.val == root2.val)
        {
            return isSymmetric(root1.left, root2.right)
                && isSymmetric(root1.right, root2.left);
        }
        else
            return false;
    }
}
