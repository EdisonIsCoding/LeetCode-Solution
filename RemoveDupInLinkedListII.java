public class RemoveDupInLinkedListII
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

    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null)
        {
            if (curNode.val == nextNode.val)
            {
                while (nextNode.next != null
                    && nextNode.val == nextNode.next.val)
                {
                    nextNode = nextNode.next;
                }
                if (preNode == null)
                {
                    head = nextNode.next;
                }
                else
                {
                    preNode.next = nextNode.next;
                }
                curNode = nextNode.next;
                if (curNode != null)
                {
                    nextNode = curNode.next;
                }
                else
                {
                    break;
                }
            }
            else
            {
                preNode = curNode;
                curNode = nextNode;
                nextNode = curNode.next;
            }
        }

        return head;
    }
}
