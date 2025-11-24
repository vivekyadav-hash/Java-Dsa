public class DoublyLL {
    public class Node {
        int data;
        Node next ;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head ;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data){
        Node newNode = new Node(data);
       size++;
        if(head == null){
           head = tail = newNode;
           return ;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //addLast 
    public  void addLast(int data){//Home Work done!
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return ;
        }


        newNode.prev = tail;
        tail.next = newNode;
        newNode.next = null;
        tail = newNode;
        


    }

    //remove
    public int  removeFirst(){
        if(head == null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
         
    }

    public int removeLast(){//Home Work done!
        if(head == null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;

        }else if(size == 1){
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public void revDll(){


Node curr = head;
Node prev = null;
Node next;

while(curr !=null){
    next = curr.next;
    curr.next = prev;
    curr.prev = next;
    prev = curr;
    curr = next;
}

head = prev;

    }


    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);

        dll.print();
        System.out.println(dll.size);
        
        dll.revDll();
        dll.print();
        System.out.println(dll.size);


    }
}
