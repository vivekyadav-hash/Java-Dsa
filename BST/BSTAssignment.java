import java.util.*;

public class BSTAssignment{

    static class Node{
        int data;
        Node left;
        Node right;
    }

          static Node newNode(int data){
            Node temp = new Node();
            temp.data = data;
            temp.left = null;
            temp.right = null;
            return temp;
        }

        static int sum = 0;
        public static int rangeSumBST(Node root , int L , int R){
            if(root == null){
                return 0;
            }
     
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            

            while(!q.isEmpty()){
                Node curr = q.poll();

                if(curr.data >= L && curr.data <= R){
                    sum += curr.data;
                }

                if( curr.left != null && curr.data > L){
                    q.add(curr.left);
                }
                if(curr.right != null && curr.data < R){
                    q.add(curr.right);
                }
            }
         return sum;
        }

public static Node insert(Node root , int data){
    if(root == null){
        return newNode(data);
    }
 
    if(data <= root.data){
      root.left = insert(root.left, data);
    }else{
        root.right = insert(root.right , data);
    }

    return root;
}
    public static void main(String args[]){

      Node root = null;
      root = insert(root,10);
      insert(root, 5);
      insert(root , 15);
      insert(root , 3);
      insert(root , 7);
      insert(root , 18);

      int L = 5 , R = 7;
      System.out.print(rangeSumBST(root, L, R));
    }
}