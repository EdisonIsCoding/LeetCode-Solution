import java.util.List;
import java.util.LinkedList;

public class BinaryTreeZigzagOrderTraversal
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean isReverseOrder = false;

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
                if (isReverseOrder)
                {
                    levelResult.addFirst(cur.val);
                }
                else
                {
                    levelResult.addLast(cur.val);
                }

                if (cur.left != null)
                {
                    queue.addLast(cur.left);
                }

                if (cur.right != null)
                {
                    queue.addLast(cur.right);
                }
            }
            result.addLast(levelResult);
            isReverseOrder = !isReverseOrder;
        }
        return result;
    }
}
