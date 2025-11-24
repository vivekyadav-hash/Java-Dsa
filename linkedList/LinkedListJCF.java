import java.util.LinkedList;//Already optimized function



public class LinkedListJCF {
        public static class Node{
        int data ; 
        Node next ;

        public Node(int data){
            this.data =data;
            this.next =null;
        }
    }


    public static void main(String args[]){
    LinkedList<Integer> ll = new LinkedList<>();
    ll.addLast(1);
    ll.addFirst(0);
    ll.addLast(2);
   
    ll.removeFirst();
    ll.removeLast();
     System.out.println(ll);
    }
}
