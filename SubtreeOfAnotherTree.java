public class SubtreeOfAnotherTree
{
    private class TreeNode
    {
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x)
        {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t)
    {
        if (s == null && t == null)
        {
            return true;
        }
        if (s == null && t != null)
        {
            return false;
        }

        if (isSame(s, t))
        {
            return true;
        }
        else
        {
            return isSubtree(s.right, t) || isSubtree(s.left, t);
        }
    }

    private boolean isSame(TreeNode s, TreeNode t)
    {
        if (s == null && t == null)
        {
            return true;
        }
        if(s != null ^ t != null)
        {
            return false;
        }
        if (s.val == t.val)
        {
            return isSame(s.right, t.right) && isSame(s.left, t.left);
        }
        else
            return false;
    }
}
