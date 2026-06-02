
public class DeleteNNodesAfterMNodesOfaLinkedList {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        Node curr = head;
        while (curr != null) {
            int counter = 0;
            Node prev = null;
            while (counter < m && curr != null) {
                counter++;
                prev = curr;
                curr = curr.next;
            }
            counter = 0;
            while (counter < n && curr != null) {
                counter++;
                curr = curr.next;
            }
            prev.next = curr;
        }

    }
}
