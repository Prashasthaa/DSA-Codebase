
import java.util.*;

public class BinaryTreesB {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                System.out.println(-1);
                return;
            }
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                System.out.println(-1);
                return;
            }
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                // System.out.println(-1);
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.println(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        int height = Math.max(lh, rh) + 1;
        return height;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int lcount = count(root.left);
        int rcount = count(root.right);
        return lcount + rcount + 1;

    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int lsum = sum(root.left);
        int rsum = sum(root.right);
        return lsum + rsum + root.data;

    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiam = diameter(root.left);
        int rightDiam = diameter(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int selfDiam = leftHeight + rightHeight + 1;
        return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // // System.out.println(root.right.right.data);
        // // tree.preorder(root);
        // // tree.inorder(root);
        // // tree.postorder(root);
        // tree.levelOrder(root);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // root.right.right.right = new Node(7);

        System.out.println("Height= " + height(root));
        System.out.println("Count of NOdes= " + count(root));
        System.out.println("Sum=" + sum(root));
        System.out.println("Diameter=" + diameter(root));

    }
}
