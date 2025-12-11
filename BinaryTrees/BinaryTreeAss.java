import java.util.*;

public class BinaryTreeAss {

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

    Node root;

    public static boolean univaluedTree(Node root) { // O(n)
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.data != root.data) {
            return false;
        }

        if (root.right != null && root.right.data != root.data) {
            return false;
        }

        return univaluedTree(root.left) && univaluedTree(root.right);
    }

    void mirror() {
        root = mirror(root);
    }

    Node mirror(Node node) {
        if (node == null)
            return node;

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    // void inOrder() {
    // inOrder(root);
    // }

    // code for the checking a tree are inverted or not
    public static boolean isMirror(Node n1, Node n2) {
        if (n1 == null && n2 == null)
            return true;
        if (n1 == null || n2 == null)
            return false;
        return (n1.data == n2.data) &&
                isMirror(n1.left, n2.right) &&
                isMirror(n1.right, n2.left);
    }

    public static Node delLeafNode(Node root, int target) {
        if (root == null) {
            return null;
        }

        root.left = delLeafNode(root.left, target);
        root.right = delLeafNode(root.right, target);

        if (root.left == null && root.right == null && root.data == target) {
            return null;
        }

        return root;
    }

    static Node newNode(int data) {
        Node newNode = new Node(data);
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return (newNode);
    }

    static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static HashMap<String, Integer> m;

    // Find all the Duplicates
    public static String inorder(Node root) {
        if (root == null) {
            return "";
        }

        String str = "(";
        str += inorder(root.left);
        str += Integer.toString(root.data);
        str += inorder(root.right);
        str += ")";

        if (m.get(str) != null && m.get(str) == 1) {
            System.out.print(root.data + " ");

        }

        if (m.containsKey(str)) {
            m.put(str, m.get(str) + 1);
        } else {
            m.put(str, 1);
        }
        return str;
    }

    public static void printAllDuplicate(Node root) {
        m = new HashMap<>();
        inorder(root);
    }

    static class Info2 {
        Node node;
        int hd;

        public Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Bottom view of the tree
    public static void bottomView(Node root) {
        // Level Order
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.add(new Info2(root, 0));
        q.add(null);// this will track the where the level ends

        while (!q.isEmpty()) {
            Info2 curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {

                if (map.containsKey(curr.hd)) {// first time my hd is occurring
                    map.put(curr.hd, curr.node);
                } else {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info2(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info2(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    // Maximum sum of the binary tree
    // Wrapper class to store global maximum
    static class MaxSum {
        int val;
    }

    public static int maxPathUtil(Node root, MaxSum res) {
        if (root == null)
            return 0;

        int left = maxPathUtil(root.left, res);
        int right = maxPathUtil(root.right, res);

        // Case 1: max path using only one child + current node
        int max_single = Math.max(Math.max(left, right) + root.data, root.data);

        // Case 2: max path passing through current node (left + root + right)
        int max_top = Math.max(max_single, left + right + root.data);

        // Update global result
        res.val = Math.max(res.val, max_top);

        return max_single;
    }

    // Main function to call
    public static int maxPathSum(Node root) {
        MaxSum res = new MaxSum();
        res.val = Integer.MIN_VALUE;

        maxPathUtil(root, res);

        return res.val;
    }

    public static void main(String[] args) {

       Node root = new Node(10);
       root.left = new Node(2);
       root.right = new Node(10);
       root.left.left = new Node(20);
       root.left.right = new Node(1);
       root.right.right = new Node(-25);
       root.right.right.right = new Node(3);
       root.right.right.left = new Node(4);
System.out.println("maximum path sum = " + maxPathSum(root));
    }
}
