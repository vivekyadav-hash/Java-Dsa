import java.util.*;

public class BST {
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

    public static Node buildBST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = buildBST(root.left, val);
        } else {
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean searchBST(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.data) {
            return true;
        }

        if (key < root.data) {
            return searchBST(root.left, key);
        }

        else {
            return searchBST(root.right, key);
        }

    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {// voila case
            // case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 - single Child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 - both children
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    // helper function
    public static Node findInOrderSuccessor(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    };

    // print in Range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);

        } else {
            printInRange(root.right, k1, k2);

        }
    }

    // Print Root To Leaf Path
    public static void printRoot2leafPath(Node root, ArrayList<Integer> Path) {
        if (root == null) {
            return;
        }

        Path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(Path);
        }

        printRoot2leafPath(root.left, Path);

        printRoot2leafPath(root.right, Path);

        Path.remove(Path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> Path) {
        for (int i = 0; i < Path.size(); i++) {
            System.out.print(Path.get(i) + "-");
        }
        System.out.println("Null");
    }

    // Is Valid Binary Search Tree Yes / No
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // Mirror a BST (This is not satisfy the BST condition)
    public static Node mirrorBST(Node root) {
        if (root == null) {
            return root;
        }

        Node left = mirrorBST(root.left);
        Node right = mirrorBST(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBST(int val[], int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(val[mid]);
        root.left = createBST(val, st, mid - 1);
        root.right = createBST(val, mid + 1, end);

        return root;
    }

    // from the unbalanced bst to balanced bst
    public static void getInOrder(Node root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }

        getInOrder(root.left, inOrder);
        inOrder.add(root.data);
        getInOrder(root.right, inOrder);
    }

    public static Node balanceCreateBST(ArrayList<Integer> inOrder, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(inOrder.get(mid));
        root.left = balanceCreateBST(inOrder, st, mid - 1);
        root.right = balanceCreateBST(inOrder, mid + 1, end);

        return root;

    }

    public static Node balanceBST(Node root) {
        // Inorder seq
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);

        // sorted inorder -> balanced BST
        root = balanceCreateBST(inOrder, 0, inOrder.size() - 1);

        return root;
    }

    // Size of Largest BST in BT

    static class Info {
        boolean isBst;
        int size;
        int min;
        int max;

        public Info(boolean isBst, int size, int min, int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxSize = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBst && rightInfo.isBst) {
            maxSize = Math.max(maxSize, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    // merge 2 bst

    public static Node createBalancedBST(ArrayList<Integer> finalArr , int st , int end){
      if(st > end){
        return null;
      }
      int mid = (st + end)/ 2;

      Node root = new Node(finalArr.get(mid));
        
      root.left = createBalancedBST(finalArr, st, mid -1);
      root.right = createBalancedBST(finalArr, mid+1, end);
      
      return root;
    }
    public static Node mergeBST(Node root1, Node root2) {
        // step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);

        // merge
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }

         while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        //sorted Arr - balanced BST
       return  createBalancedBST(finalArr , 0 , finalArr.size()-1);
    }

    public static void main(String args[]) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

      Node root =  mergeBST(root1, root2);

      preOrder(root);

    }

}
