public class CopyRandomList
{
    class RandomListNode
    {
        int label;
        RandomListNode next, random;
        RandomListNode(int x)
        {
            this.label = x;
        }
    };

    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null)
        {
            return head;
        }

        copyList(head);
        copyRandomLink(head);
        return getRandomListHead(head);
    }

    private void copyList(RandomListNode head)
    {
        // copy nodes
        while (head != null)
        {
            RandomListNode copyNode = new RandomListNode(0);
            copyNode.label = head.label;
            copyNode.next = head.next;
            head.next = copyNode;
            head = copyNode.next;
        }
    }

    private void copyRandomLink(RandomListNode head)
    {
        RandomListNode copyNode = null;
        // copy random link
        while(head != null)
        {
            copyNode = head.next;
            if (head.random != null)
            {
                copyNode.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private RandomListNode getRandomListHead(RandomListNode head)
    {
        RandomListNode copyNode = head.next;
        RandomListNode copyHead = new RandomListNode(0);
        copyHead.next = copyNode;
        while (head != null)
        {
            head.next = copyNode.next;
            if (head.next != null)
            {
                copyNode.next = head.next.next;
            }
            head = head.next;
            copyNode = copyNode.next;
        }
        return copyHead.next;
    }
}
