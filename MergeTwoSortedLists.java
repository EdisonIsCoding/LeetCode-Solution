public class MergeTwoSortedLists
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode list = new ListNode(0);
        ListNode listHead = list;

        while(true)
        {
            if (l1 == null)
            {
                list.next = l2;
                break;
            }
            if (l2 == null)
            {
                list.next = l1;
                break;
            }

            if (l1.val > l2.val)
            {
                list.next = l2;
                l2 = l2.next;
                list = list.next;
            }
            else
            {
                list.next = l1;
                l1 = l1.next;
                list = list.next;
            }
        }

        return listHead.next;
    }
}
