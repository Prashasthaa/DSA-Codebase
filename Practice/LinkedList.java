public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        // step 1=> create new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step-2=>newNode next=head
        newNode.next = head;// link

        // step 3=head=new node
        head = newNode;
    }

    public void addLast(int data) {
        // step-1 create new node
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step-2 tail next=new node
        tail.next = newNode;

        // step-3 tail node =new node
        tail = newNode;
    }

    public void print() { // O(n)
        if (head == null) {
            System.out.println("Linked list is null");

            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.err.println("null");
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
    }
}
