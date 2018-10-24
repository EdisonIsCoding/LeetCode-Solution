public class RemoveDupInLinkedList
{
    private class ListNode
    {
        private int val;
        private ListNode next;
        ListNode(final int x)
        {
            val = x;
        }
    }

    public ListNode deleteDuplicates(final ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode dumpHead = head;
        ListNode preHead = head.next;
        while(dumpHead.next != null)
        {
            if (dumpHead.val == preHead.val)
            {
                dumpHead.next = preHead.next;
            }
            else
            {
                dumpHead = preHead;
            }
            preHead = dumpHead.next;
        }

        return head;
    }
}
