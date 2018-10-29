public class MergeKLists
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

    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists == null || isAllListsEmpty(lists))
        {
            return null;
        }

        int minIndex;
        ListNode head;
        minIndex = findMinInLists(lists);
        head = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        head.next = mergeKLists(lists);

        return head;
    }

    private boolean isAllListsEmpty(ListNode[] lists)
    {
        for (ListNode list: lists)
        {
            if (list != null)
            {
                return false;
            }
        }
        return true;
    }

    private int findMinInLists(ListNode[] lists)
    {
        int minIndex = lists.length;
        int firstNonNullList = lists.length;

        for (int i = 0; i < lists.length; i++)
        {
            if (lists[i] != null)
            {
                firstNonNullList = i;
                minIndex = i;
                break;
            }
        }

        for (int i = firstNonNullList; i < lists.length; i++)
        {
            if (lists[i] != null && lists[i].val < lists[minIndex].val)
            {
                minIndex = i;
            }
        }

        return minIndex;
    }
}
