

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST( Node root ,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
      
        if(root.data > val){
            root.left = buildBST(root.left, val);
        }else{
            root.right = buildBST(root.right , val);
        }
     
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

  public static boolean searchBST(Node root, int key){
if(root == null){
    return false;
}

if(key == root.data){
    return true;
}

if(key < root.data){
 return  searchBST(root.left, key);
}

else{
    return  searchBST(root.right, key);
}

}


public static Node delete(Node root , int val){
    if(root.data < val){
        root.right = delete(root.right, val);
    }
    if(root.data > val ){
        root.left = delete(root.left , val);
    }

    else{//voila case
    //case 1 - leaf node
    if(root.left == null && root.right == null){
        return null;
    }    

    //case 2 - single Child
    if(root.left == null){
        return root.right;
    }
    else if(root.right == null){
        return  root.left;
    }

    //case 3 - both children
    Node IS = findInOrderSuccessor(root.right);
    root.data = IS.data;
    root.right = delete(root.right , IS.data);
    }

    return root;
}

public static Node findInOrderSuccessor(Node root){

    while(root.left != null){
        root = root.left;
    }

    return root;
};
    public static void main(String args[]){
       Node root = null;
        int val[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
    
        for(int i=0; i<val.length; i++){
            root = buildBST(root , val[i]);
        }

        inOrder(root);
        System.out.println();

        root = delete(root, 1);

        inOrder(root);
    }

}
