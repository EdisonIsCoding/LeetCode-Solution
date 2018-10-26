public class RemoveNthNodeFromLinkedList
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

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (n <= 0 || head == null)
        {
            return head;
        }

        ListNode pioneer = head;
        for (int i = 0; i < n - 1; i++)
        {
            pioneer = pioneer.next;
            // n is greater than linked list length
            // do nothing and return head
            if (pioneer == null)
            {
                return head;
            }
        }

        ListNode chaser = head;
        ListNode postChaser = null;
        while(pioneer.next != null)
        {
            pioneer = pioneer.next;
            postChaser = chaser;
            chaser = chaser.next;
        }
        if (postChaser == null)
        {
            head = chaser.next;
        }
        else
        {
            postChaser.next = chaser.next;
        }

        return head;
    }
}
