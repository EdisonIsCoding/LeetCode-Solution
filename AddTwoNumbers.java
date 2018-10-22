public class AddTwoNumbers
{
    private class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Method to add to number represented by two list
     *
     * @param l1 Linked list of first number
     * @param l2 Linked list of second number
     * @return null, if l1 and l2 are null; or sum represented by Linked list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode sum = new ListNode(0);
        ListNode pointer = sum;
        int carry = 0;
        while(l1 != null || l2 != null)
        {
            pointer.next = new ListNode(0);
            pointer = pointer.next;

            if (l1 == null)
            {
                pointer.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            }
            else if (l2 == null)
            {
                pointer.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            }
            else
            {
                pointer.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        if (carry != 0)
        {
            pointer.next = new ListNode(carry);
        }

        return sum.next;
    }
}
