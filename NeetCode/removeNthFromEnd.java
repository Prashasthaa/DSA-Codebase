package NeetCode;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return head;
        }

        int i = 1;
        int findNth = sz - n;
        ListNode prev = head;
        while (i < findNth) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;

        return head;
    }
}
