public class ReverseList
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

    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode bhind = null;
        ListNode current = head;
        ListNode ahead = head.next;
        while (ahead != null)
        {
            current.next = bhind;
            bhind = current;
            current = ahead;
            ahead = ahead.next;
        }
        current.next = bhind;

        return current;
    }
}
