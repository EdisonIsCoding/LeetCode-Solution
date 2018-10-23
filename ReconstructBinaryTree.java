public class ReconstructBinaryTree
{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(final int[] preorder, final int[] inorder)
    {
        if (preorder == null || inorder == null || preorder.length == 0
            || inorder.length == 0 || preorder.length != inorder.length)
        {
            return null;
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1,
            inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode buildTree(final int[] preorder, final int preStart, final int preEnd,
        final int[] inorder, final int inStart, final int inEnd)
    {
        if (preStart > preEnd || inStart > inEnd)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int offset = preEnd - preStart;
        if (offset == 0)
        {
            return root;
        }

        int rootIndexInorder = inStart - 1;
        for (int i = inStart; i <= inEnd; i++)
        {
            if (inorder[i] == preorder[preStart])
            {
                rootIndexInorder = i;
                break;
            }
        }
        // index not found
        if (rootIndexInorder == inStart - 1)
        {
            return root;
        }

        int leftTreeSize = rootIndexInorder - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize,
            inorder, inStart, rootIndexInorder - 1);
        root.right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd,
            inorder, rootIndexInorder + 1, inEnd);
        return root;
    }
}
