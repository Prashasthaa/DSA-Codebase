import java.util.*;
import java.util.LinkedList;

public class StackB {
    static class StackArrayList {
        static ArrayList<Integer> list = new ArrayList<>();

        // isEmpty
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public void push(int data) {
            list.add(data);
        }

        // pop
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StackLinkedList {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        // push
        public static void push(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;

        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;

        }
    }

    static class StackQueue {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();

                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();

                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);

    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);

        }
    }

    public static void nextGreaterElement(int[] input, int[] output) {
        Stack<Integer> s = new Stack<>();

        for (int i = input.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && input[s.peek()] <= input[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                output[i] = -1;
            } else {
                output[i] = input[s.peek()];
            }
            s.push(i);
        }
    }

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // closing
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '[' && ch == ']')
                        || (s.peek() == '{' && ch == '}')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isDuplicate(String str) { // O(n)
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;// duplicate exists
                }
                s.pop();
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // next smaller left
        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // curr area: width=j-i-1 = nsr[i]-nsl[j]-1
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println("Maximum area: " + maxArea);

    }

    public static String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();

        String[] p = path.split("/");

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
            if (!s.isEmpty() && p[i].equals("..")) {
                s.pop();
            } else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")) {
                s.push(p[i]);
            }

        }
        if (s.isEmpty())
            return "/";
        while (!s.isEmpty()) {
            res.insert(0, s.pop()).insert(0, "/");
        }
        return res.toString();
    }

    public static int longestValidParentheses(String s) {
        int n = s.length();
        int index = -1;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        ans = Math.max(ans, i - stack.peek());
                    } else {
                        ans = Math.max(ans, i - index);
                    }
                } else {
                    index = i;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {

        // StackArrayList s = new StackArrayList();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // StackLinkedList s = new StackLinkedList();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // Stack<Integer> s = new Stack<>();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // pushAtBottom(s, 4);

        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // System.out.println(reverseString("hello"));

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // reverseStack(s);
        // printStack(s);

        // // Question 4 stock span problem
        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for (int i = 0; i < span.length; i++) {
        // System.out.println(span[i] + " ");
        // }

        // // Question 5 next greater element
        // int input[] = { 6, 8, 0, 1, 3 };
        // int output[] = new int[input.length];
        // nextGreaterElement(input, output);

        // for (int i = 0; i < output.length; i++) {
        // System.out.println(output[i] + " ");
        // }

        // // Question 6 => valid parenthness
        // String str = "({}[][)[]";
        // System.out.println(isValid(str));

        // // Question 7 => Duplicate parentheses
        // String str = "(((a+b)+(c+d)))";
        // System.out.println(isDuplicate(str));

        // // Question-8 => Max Rectangular Area in Histogram
        // int arr[] = { 12, 1, 5, 6, 2, 3 }; // heights of histogram
        // maxArea(arr);

        // Question-9 => simplfiy path

        // String path = "/home/user/Documents/../Pictures";
        // System.out.println(simplifyPath(path));

        // // Question -10 => longest valid parenthess lenght
        // String s = "(()";
        // System.out.println(longestValidParentheses(s));

        StackQueue s = new StackQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}