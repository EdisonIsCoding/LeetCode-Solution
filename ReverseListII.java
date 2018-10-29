public class ReverseListII
{
    private class ListNode
    {
        private int val;
        private ListNode next;
        public ListNode(int x)
        {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || head.next == null || m < 1 || m >= n)
        {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++)
        {
            pre = pre.next;
            if (pre == null)
            {
                // Invalid m, out of boundary
                return head;
            }
        }

        ListNode start = pre.next;
        if (start == null)
        {
            // Invalid m, out of boundary
            return head;
        }

        ListNode then = start.next;
        for (int i = 0; i < n - m; i++)
        {
            if (then == null)
            {
                // Invalid n, out of boundary
                return head;
            }
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
