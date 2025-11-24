
public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // step1 = create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2 = newNode next = head
        newNode.next = head;// link

        // step3 -head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;

        }

        // step 3
        tail.next = newNode;
        tail = newNode;

    }

    public void print() {
        // if(head == null){
        // System.out.println("LL is empty");
        // return;
        // }
        Node temp = head;
        while (temp != null) {// O(n)
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public void add(int idx, int data) {
        if (idx == 0) {// this is because addFirst is important to handle the tail & head as well for
                       // this
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeLast() {
        // Base cases
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;

        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev : i = size-2;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int searchIterative(int key, int idx) {// TC O(n)
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return idx;
            } else {
                idx++;
                temp = temp.next;
            }
        }
        return -1;
    }

    public int helper(Node head, int key) {// O(n) & space Complexity is also constant
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void revLinkedlist() {// TC O(n)

        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;

        }

        if (n == sz) {// removeFirst
            head = head.next;
            return;
        }

        // sz -n
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return ;
    }

    // check palindrome:-----------:Slow fast approach
    public Node findMid(Node head) {// helper
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

        }
        return slow; // slow is my midNode
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step - find mid
        Node midNode = findMid(head);
        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;// right half head
        Node left = head;
        // step3 - check left half & right equal
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;

        }

        return true;

    }

    // Check the given Linked list Cyclic or not
    public static boolean isCycle() {// Floyd's CFA
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;// Cycle exist
            }
        }
        return false; // Cycle doesn't exit
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;

        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find meeting point
        slow = head;

        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle -> last.next = null
        prev.next = null;
    }

    // mergeSort

    private Node getMid(Node head) {

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        //below are for the lefted node data
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;

        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public Node mergeSort(Node head) {// Time Complexity O(nlogn)
        if (head == null || head.next == null) {
            return head;
        }
        // Find mid
        Node mid = getMid(head);

        // Left & right ms
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }


    //Print ll in zig zag manner
    public void zigZag(){
        //find middle 
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        //Reverse second Half
        Node curr = mid.next;
        mid.next = null;

        Node prev =null;
        Node next ;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
           curr =next ;
        }

        Node left = head;
        Node right = prev;
        Node nextL , nextR ;

    
        //zig-zag merge
        while(left  != null && right != null){
         nextL = left.next;
         left.next = right;
         nextR = right.next;
         right.next = nextL;

         right = nextR;
         left = nextL;


        }
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
         ll.addLast(6);
        // ll.addFirst(6); //6->5->4->3->2->1->null;

        ll.print();
        ll.zigZag();

        ll.print();
    }
}
