
public class LinkedList2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;

        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int data) {

        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void print() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node getIntersectionPoint(Node head1Node, Node head2Node) {// time complexity is O(n*m)

        while (head2Node != null) {
            Node temp = head1Node;
            while (temp != null) {
                if (temp == head2Node) {
                    return head2Node;
                }
                temp = temp.next;
            }
            head2Node = head2Node.next;
        }

        return null;
    }

    public void deleteNnodeafterMnode(int m, int n) {
        Node temp = head;

        while (temp != null) {
            for (int i = 1; i < m && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null)
                return;
            Node deleteStart = temp.next;

            for (int j = 1; j <= n && deleteStart != null; j++) {
                deleteStart = deleteStart.next;
            }

            temp.next = deleteStart;
            temp = deleteStart;
        }
    }

    // Swapping the Nodes;;
    public void swapGiven(int x, int y) {
        if (x == y) {
            return;
        }
        Node temp = head;
        int i = 1;
        while (i < x - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        Node prevX = temp;
        Node X = prevX.next;
        Node nextX = X.next;

        temp = head;
        int j = 1;
        while (j < y - 1 && temp != null) {
            temp = temp.next;
            j++;
        }
        Node prevY = temp;
        Node Y = prevY.next;
        Node nextY = Y.next;

        prevX.next = Y;
        prevY.next = X;

        Y.next = nextX;
        X.next = nextY;

    }

    public void everAndOdd() {
        if (head == null) {
            return;
        }

        Node temp = head;
        Node evenLL = null;
        Node evenTail = null;
        Node oddLL = null;
        Node oddTail = null;
        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (evenLL == null) {
                    evenLL = evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = evenTail.next;
                }

            } else {
                if (oddLL == null) {
                    oddLL = oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = oddTail.next;
                }
            }
            temp = temp.next;
        }

        // connect even list to odd list
        if (evenTail != null) {
            evenTail.next = oddLL;
            head = evenLL;
        } else {
            head = oddLL;
        }

        // last node should point to null
        if (oddTail != null)
            oddTail.next = null;
    }

    public static Node SortedMerge(Node a , Node b){
        Node result = null;
        if(a ==null){
            return b;
        }else if(b ==null)
            {
            return a;
        }
        if(a.data<= b.data){
            result = a;
            result.next = SortedMerge(a.next, b);
        }else{
            result = b;
            result.next = SortedMerge(a, b.next);
        }
        return result;
    }

    public static  Node mergeKLists(Node arr[] , int last){
        while(last !=0){
            int i =0; 
            int j = last;
            while (i < j){
                arr[i] = SortedMerge(arr[i], arr[j]);
                i++;
                j--;
                if(i>=j){
                    last = j;
                }
            }
        }
        return arr[0];
    }

    public static void  printList(Node node){
        while(node != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        int k = 3;
        int n = 4;
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
        Node head = mergeKLists(arr, k - 1);
        printList(head);

    }
}

// LinkedList2 ll = new LinkedList2(); this is the Intersection problem ;;
// Node head1Node = new Node(10);
// Node head2Node = new Node (3);

// Node newNode = new Node(6);
// head2Node.next = newNode;

// newNode = new Node(9);
// head2Node.next.next = newNode;

// newNode = new Node(15);
// head1Node.next = newNode;
// head2Node.next.next.next = newNode;

// newNode = new Node(30);
// head1Node.next.next = newNode;

// head1Node.next.next.next =null;

// Node intersectionPoint = ll.getIntersectionPoint(head1Node, head2Node);
// if(intersectionPoint ==null){
// System.out.print("Intersection Point doesn't exist");
// }
// else{
// System.out.println("Intersection exists" +" " + intersectionPoint.data);
// }