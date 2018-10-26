public class MiddleOfList
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

    public ListNode middleNode(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode chaser = head;
        ListNode pioneer = head.next;
        while (pioneer != null)
        {
            chaser = chaser.next;
            pioneer = pioneer.next;
            if (pioneer != null)
            {
                pioneer = pioneer.next;
            }
            else
            {
                break;
            }
        }

        return chaser;
    }
}
