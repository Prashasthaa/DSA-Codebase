
/* Queue using JCF */
import java.util.*;
// import java.util.LinkedList;
import java.util.LinkedList;

public class QueueB {
    /* Queue using 2 stacks */
    // static class Queue {
    // static Stack<Integer> s1 = new Stack<>();
    // static Stack<Integer> s2 = new Stack<>();

    // public static boolean isEmpty() {
    // return s1.isEmpty();
    // }

    // public static void add(int data) {
    // while (!s1.isEmpty()) {
    // s2.push(s1.pop());
    // }

    // s1.push(data);
    // while (!s2.isEmpty()) {
    // s1.push(s2.pop());
    // }
    // }

    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("Queue empty");
    // return -1;
    // }
    // return s1.pop();
    // }

    // public static int peek() {
    // if (isEmpty()) {
    // System.out.println("Queue empty");
    // return -1;
    // }
    // return s1.peek();
    // }

    // }
    /* Queue using linked list */
    // static class Node {
    // int data;
    // Node next;

    // Node(int data) {
    // this.data = data;
    // this.next = null;

    // }
    // }

    // static class Queue {

    // static Node head = null;
    // static Node tail = null;

    // public static boolean isEmpty() {
    // return head == null && tail == null;
    // }

    // // add
    // public static void add(int data) {
    // Node newNode = new Node(data);
    // if (head == null) {
    // head = tail = newNode;
    // return;
    // }
    // tail.next = newNode;
    // tail = newNode;
    // }

    // // remove
    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("empty queue");
    // return -1;
    // }
    // int front = head.data;
    // if (tail == head) {
    // tail = head = null;
    // } else {
    // head = head.next;
    // }
    // return front;

    // }

    // // peek
    // public static int peek() {

    // if (isEmpty()) {
    // System.out.println("empty queue");
    // return -1;
    // }
    // return head.data;
    // }
    // }
    /* Queue using array */
    // static class Queue {
    // static int arr[];
    // static int size;
    // static int rear;
    // static int front;

    // Queue(int n) {
    // arr = new int[n];
    // size = n;
    // rear = -1;
    // front = -1;
    // }

    // public static boolean isEmpty() {
    // return rear == -1 && front == -1;
    // }

    // public static boolean isFull() {
    // return (rear + 1) % size == front;
    // }

    // // add
    // public static void add(int data) {
    // if (isFull()) {
    // System.out.println("Queue is full");
    // return;
    // }
    // if (front == -1) {
    // front = 0;
    // }
    // rear = (rear + 1) % size;
    // arr[rear] = data;
    // }

    // // remove
    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("empty queue");
    // return -1;
    // }
    // int result = arr[front];
    // front = (front + 1) % size;
    // if (rear == front) {
    // rear = front = -1;
    // } else {
    // front = (front + 1) % size;
    // }
    // return result;

    // }

    // // peek
    // public static int peek() {

    // if (isEmpty()) {
    // System.out.println("empty queue");
    // return -1;
    // }
    // return arr[front];
    // }
    // }

    public static void printNonRepeating(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(q.peek());
            }
        }
    }

    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        // Queue q = new Queue();

        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        // Question 4
        String str = "aabccxb";
        printNonRepeating(str);

    }
}
