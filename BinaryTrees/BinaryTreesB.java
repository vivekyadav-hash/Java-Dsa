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

        public static void preOrder(Node root) {// O(n) Time Complexity

            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);

        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order Traversal
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
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);

                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        // Calculating the height of the tree
        public static int heigth(Node root) {
            if (root == null) {
                return 0;
            }

            int lh = heigth(root.left);
            int rh = heigth(root.right);

            return Math.max(lh, rh) + 1;
        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }

            int Lcount = count(root.left);
            int Rcount = count(root.right);
            int treeCount = Lcount + Rcount + 1;

            return treeCount;
        }

        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sum(root.left);
            int rightSum = sum(root.right);

            return leftSum + rightSum + root.data;
        }

        public static int diameterTree(Node root) {
            if (root == null) {
                return 0;
            }

            int Ldia = diameterTree(root.left);
            int Lh = heigth(root.left);
            int Rdia = diameterTree(root.right);
            int Rh = heigth(root.right);

            int selfDia = Lh + Rh + 1;

            return Math.max(selfDia, Math.max(Lh, Rh));
        }

        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter2(Node root) {// O(n)
            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);

            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);
        }
    }

    public static boolean isIdentical(Node node, Node subtree) {
        if (node == null && subtree == null) {
            return true;
        } else if (node == null || subtree == null || node.data != subtree.data) {
            return false;
        }

        if (!isIdentical(node.left, subtree.left)) {
            return false;
        }

        if (!isIdentical(node.right, subtree.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subtree) {
        if (root == null) {
            return false;
        }

        if (root.data == subtree.data) {
            if (isIdentical(root, subtree)) {
                return true;
            }
        }

        return isSubtree(root.left, subtree) || isSubtree(root.right, subtree);

    }

    static class Info2{
        Node node;
        int hd;
        public Info2(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        //Level Order
        Queue<Info2> q = new LinkedList<>(); 
        HashMap<Integer , Node> map = new HashMap<>();


        int min = 0, max =0;

        q.add(new Info2(root, 0));
        q.add(null);// this will track the where the level ends 

        while(!q.isEmpty()){
            Info2 curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{

            if(!map.containsKey(curr.hd)){//first time my hd is occurring
                map.put(curr.hd , curr.node);
            }

            if(curr.node.left != null){
                q.add(new Info2(curr.node.left, curr.hd -1));
                min = Math.min(min , curr.hd-1);
            }

            if(curr.node.right != null){
                q.add(new Info2(curr.node.right , curr.hd +1));
                max = Math.max(max , curr.hd+1);
            }
        }
        }

        for(int i =min; i<= max; i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void Klevel(Node root, int level , int k){
        if(root == null){
            return ;
        }

        if(level == k ){
            System.out.print(root.data + " ");
            return ;
        }

        Klevel(root.left, level+1, k);
        Klevel(root.right, level+1, k);

    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root ==null){
            return false;
        }

        path.add(root);

        if(root.data ==n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root , int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root , n1, path1);
        getPath(root , n2 , path2);

        //last common ancestor
        int i =0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        //Last Equal node -> i-1th
        Node lca = path1.get(i-1);
        return lca;

    }

    public static Node lca2(Node root ,int n1, int n2){
   

        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = lca2(root.left , n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //leftLcaA=val rightLca = null
        if(rightLca == null){
            return leftLca;
        }

        //rightLca = val leftLca = null
        if(leftLca == null){
            return rightLca;
        }

        return root;
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        /*
         *   1
         *  / \
         *  2  3
         * / \ / \
         * 4 5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 4, n2 = 6;

        System.out.print(lca2(root, n1, n2).data);
    }
}