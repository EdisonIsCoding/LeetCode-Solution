import java.util.List;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal
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

    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null)
        {
            return result;
        }

        queue.addLast(root);

        while (!queue.isEmpty())
        {
            LinkedList<Integer> levelResult = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode cur = queue.removeFirst();
                levelResult.add(cur.val);
                if (cur.left != null)
                {
                    queue.addLast(cur.left);
                }
                if (cur.right != null)
                {
                    queue.addLast(cur.right);
                }
            }
            result.addFirst(levelResult);
        }

        return result;
    }
}
