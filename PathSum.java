import java.util.List;
import java.util.LinkedList;

public class PathSum
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

    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> paths = new LinkedList<>();
        if (root == null)
        {
            return paths;
        }
        LinkedList<Integer> curPath = new LinkedList<>();
        findPaths(root, sum, paths, curPath);

        return paths;
    }

    public void findPaths(TreeNode root, int sum,
        List<List<Integer>> paths, LinkedList<Integer> curPath)
    {
        if (root == null)
        {
            return;
        }

        curPath.addLast(root.val);
        if (root.left == null && root.right == null)
        {
            // reached leaf node
            if (root.val == sum)
            {
                paths.add(new LinkedList<Integer>(curPath));
            }
        }

        if (root.left != null)
        {
            findPaths(root.left, sum - root.val, paths, curPath);
        }
        if (root.right != null)
        {
            findPaths(root.right, sum - root.val, paths, curPath);
        }

        curPath.removeLast();
        return;
    }
}
