public class LinkedListCycleII
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

    public ListNode detectCycle(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        ListNode nodeInCycle = findNodeInCycle(head);
        if (nodeInCycle == null)
        {
            return null;
        }

        ListNode pioneer = nodeInCycle.next;
        int count = 1;
        while (pioneer != nodeInCycle)
        {
            pioneer = pioneer.next;
            count++;
        }

        pioneer = head;
        for (int i = 0; i < count; i++)
        {
            pioneer = pioneer.next;
        }

        ListNode chaser = head;
        while (chaser != pioneer)
        {
            chaser = chaser.next;
            pioneer = pioneer.next;
        }

        return chaser;
    }

    public ListNode findNodeInCycle(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        ListNode pioneer = head.next;
        ListNode chaser = head;
        while (chaser != pioneer)
        {
            if (pioneer == null)
            {
                return null;
            }

            chaser = chaser.next;
            pioneer = pioneer.next;
            if (pioneer == null)
            {
                return null;
            }
            pioneer = pioneer.next;
        }

        return chaser;
    }
}
