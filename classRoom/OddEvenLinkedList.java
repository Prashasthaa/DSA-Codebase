
/* Structure of a link list node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class OddEvenLinkedList {
    Node divide(Node head) {
        // code here

        if (head == null || head.next == null) {
            return head;
        }
        Node odd = new Node(-1);
        Node even = new Node(-1);

        Node ans = even;
        Node oddHead = odd;

        Node ptr = head;

        while (ptr != null) {
            if (ptr.data % 2 == 0) {
                even.next = ptr;
                even = even.next;
            } else {
                odd.next = ptr;
                odd = odd.next;
            }
            ptr = ptr.next;
        }

        even.next = null;
        odd.next = null;

        even.next = oddHead.next;

        return ans.next;
    }
}