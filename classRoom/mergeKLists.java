class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : list) {
            ListNode newNode = new ListNode(val);
            curr.next = newNode;
            curr = curr.next;
        }

        return dummy.next;

    }
}