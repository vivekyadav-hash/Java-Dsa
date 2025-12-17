import java.util.*;

public class BSTAssignment {

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

    // Range sum

    public static int rangeSumBST(Node root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data >= L && curr.data <= R) {
                sum += curr.data;
            }

            if (curr.left != null && curr.data > L) {
                q.add(curr.left);
            }
            if (curr.right != null && curr.data < R) {
                q.add(curr.right);
            }
        }
        return sum;
    }

    // Optimized one and more efficient
    public static int rangeSumBST2(Node root, int L, int R) {
        if (root == null)
            return 0;

        if (root.data < L) {
            return rangeSumBST2(root.right, L, R);
        }
        if (root.data > R) {
            return rangeSumBST2(root.left, L, R);
        }

        return root.data
                + rangeSumBST2(root.left, L, R)
                + rangeSumBST2(root.right, L, R);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            // return newNode(data);
        }

        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Find the closest node to the kth value
    public static Node printClosest(Node root, int k) {

        Node curr = root;
        Node closest = root;

        while (curr != null) {
            if (Math.abs(curr.data - k) < Math.abs(closest.data - k)) {
                closest = curr;
            }
            if (k < curr.data) {
                curr = curr.left;
            } else if (k > curr.data) {
                curr = curr.right;
            } else {
                break;
            }
        }

        return closest;
    }

    // KTh smallest element in the BST
    static int count = 0;

    public static Node kSmallest(Node root, int k) {
        if (root == null) {
            return null;
        }

        Node left = kSmallest(root.left, k);

        if (left != null) {
            return left;

        }
        count++;
        if (count == k) {
            return root;
        }

        return kSmallest(root.right, k);
    }

    public static void kThSmallestElement(Node root, int k) {
        count = 0;
        Node res = kSmallest(root, k);

        if (res == null) {
            System.out.print("In the BST k nodes doesn't exist");
        } else {
            System.out.print("kTh smallest element found =" + res.data);
        }
    }

    // Two Sum BST my version
    public static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static int twoSumBST(Node root1, Node root2, int x) {
        int pair = 0;
        ArrayList<Integer> A = new ArrayList<>();
        inOrder(root1, A);
        int i = 0;

        ArrayList<Integer> B = new ArrayList<>();
        inOrder(root2, B);
        int j = B.size() - 1;

        while (i < A.size() && j < B.size()) {
            int sum = A.get(i) + B.get(j);
            if (sum == x) {
                pair++;
                i++;
                j--;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }
        return pair;
    }

    // two Sum BST solution and optimized version

    static Node root1;
    static Node root2;

    static int countPairs(Node root1, Node root2, int x) {
        if (root1 == null || root2 == null)
            return 0;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        Node top1, top2;
        int count = 0;

        while (true) {

            // Push left nodes of BST1
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }

            // Push right nodes of BST2
            while (root2 != null) {
                st2.push(root2);
                root2 = root2.right;
            }

            if (st1.isEmpty() || st2.isEmpty())
                break;

            top1 = st1.peek();
            top2 = st2.peek();

            int sum = top1.data + top2.data;

            if (sum == x) {
                count++;
                st1.pop();
                st2.pop();
                root1 = top1.right;
                root2 = top2.left;
            } else if (sum < x) {
                st1.pop();
                root1 = top1.right;
            } else { // sum > x
                st2.pop();
                root2 = top2.left;
            }
        }

        return count;
    }

    //Maximum sum BST in Binary Tree
  static class Info {
    int max;
    int min;
    boolean isBST;
    int sum;
    int currmax;

    Info(int max, int min, boolean isBST, int sum, int currmax) {
        this.max = max;
        this.min = min;
        this.isBST = isBST;
        this.sum = sum;
        this.currmax = currmax;
    }

    Info() {}
}

static class INT {
    int a;
}

static Info MaxSumBSTUtil(Node root, INT maxsum) {

    // Base case
    if (root == null) {
        return new Info(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            true,
            0,
            0
        );
    }

    // Leaf node
    if (root.left == null && root.right == null) {
        maxsum.a = Math.max(maxsum.a, root.data);
        return new Info(
            root.data,
            root.data,
            true,
            root.data,
            maxsum.a
        );
    }

    // Recurse
    Info L = MaxSumBSTUtil(root.left, maxsum);
    Info R = MaxSumBSTUtil(root.right, maxsum);

    Info curr = new Info();

    // Check BST condition
    if (L.isBST && R.isBST && L.max < root.data && R.min > root.data) {

        curr.isBST = true;
        curr.sum = L.sum + root.data + R.sum;

        curr.min = Math.min(root.data, L.min);
        curr.max = Math.max(root.data, R.max);

        maxsum.a = Math.max(maxsum.a, curr.sum);
        curr.currmax = maxsum.a;

        return curr;
    }

    // Not a BST
    curr.isBST = false;
    curr.sum = L.sum + root.data + R.sum;
    curr.currmax = maxsum.a;

    return curr;
}

static int MaxSumBST(Node root) {
    INT maxsum = new INT();
    maxsum.a = Integer.MIN_VALUE;

    MaxSumBSTUtil(root, maxsum);
    return maxsum.a;
}
     
    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.left.right = new Node(7);
        root.left.left.left = new Node(8);
        root.right.right = new Node(2);

       System.out.print(MaxSumBST(root));
       
    }
}