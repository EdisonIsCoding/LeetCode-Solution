public class LinkedListCycle
{
    private class ListNode
    {
        private int val;
        private ListNode next;
        public ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return false;
        }

        ListNode chaser = head;
        ListNode pioneer = head.next;
        while (chaser != pioneer)
        {
            if (pioneer == null)
            {
                return false;
            }
            chaser = chaser.next;
            pioneer = pioneer.next;
            if (pioneer == null)
            {
                return false;
            }
            pioneer = pioneer.next;
        }

        return true;
    }
}
