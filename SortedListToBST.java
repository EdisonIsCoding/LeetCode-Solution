public class SortedListToBST
{
    public class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head)
    {
        if (head == null)
        {
            return null;
        }

        ListNode current = head;
        int count = 0;
        while (current != null)
        {
            count++;
            current = current.next;
        }

        return sortedListToBST(head, count);
    }

    private TreeNode sortedListToBST(ListNode head, int length)
    {
        if (head == null || length == 0)
        {
            return null;
        }

        if (length == 1)
        {
            return new TreeNode(head.val);
        }

        ListNode middle = head;
        int middleIndex = length >> 1;
        if (length % 2 == 1)
        {
            middleIndex += 1;
        }
        for (int i = 1; i < middleIndex; i++)
        {
            middle = middle.next;
        }

        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(head, middleIndex - 1);
        root.right = sortedListToBST(middle.next, length - middleIndex);
        return root;
    }
}
