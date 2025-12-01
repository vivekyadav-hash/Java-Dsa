import java.util.*;

public class Queues {
  static class Stack{
  static Queue<Integer> q1 = new LinkedList<>();
  static Queue<Integer> q2 = new LinkedList<>();

  public static boolean isEmpty(){
    return q1.isEmpty() && q2.isEmpty();
  }

  public static void push(int data){
    if(!q1.isEmpty()){
      q1.add(data);
    }else{
      q2.add(data);
    }
  }

  public static int pop(){
    if(isEmpty()){
      System.out.println("Stack is Empty");
      return -1;
    }

    int top =-1;

    //case 1
    if(!q1.isEmpty()){
   while(!q1.isEmpty()){
    top = q1.remove();
    if(q1.isEmpty()){
      break;
    }
    q2.add(top);
   }
    }else{//case 2
    while(!q2.isEmpty()){
    top = q2.remove();
    if(q2.isEmpty()){
      break;
    }
    q1.add(top);
  }
    }

    return top;
    }

    //peek
    public static int peek(){
       if(isEmpty()){
      System.out.println("Stack is Empty");
      return -1;
    }

    int top =-1;

    //case 1
    if(!q1.isEmpty()){
   while(!q1.isEmpty()){
    top = q1.remove();
    q2.add(top);
   }
    }else{//case 2
    while(!q2.isEmpty()){
    top = q2.remove();
    q1.add(top);
  }
    }

    return top;
    }
}

  // Question of Queue using 2 stack by the popO(n) approach
  // static class Queue {
  //   static Stack<Integer> s1 = new Stack<>();
  //   static Stack<Integer> s2 = new Stack<>();

  //   public static boolean isEmpty() {
  //     return s1.isEmpty() && s2.isEmpty();
  //   }

  //   // add - O(1)
  //   public static void add(int data) {

  //     s1.push(data);
  //   }

  //   // remove
  //   public static int remove() {
  //     if (s2.isEmpty()) {
  //       while (!s1.isEmpty()) {
  //         s2.push(s1.pop());
  //       }
  //     }
  //     return s2.pop();
  //   }

  //   // peek
  //   public static int peek() {
  //     if (isEmpty()) {
  //       System.out.println("queue empty");
  //       return -1;
  //     }
  //     if (s2.isEmpty()) {
  //       while (!s1.isEmpty()) {
  //         s2.push(s1.pop());
  //       }
  //     }

  //     return s2.peek();
  //   }
  // }

  public static void main(String args[]) {
    Stack s = new Stack();
   s.push(1);
   s.push(2);
   s.push(3);

    while (!s.isEmpty()) {
      System.out.println(s.peek());
      s.pop();
    }

  }
}

// Queue Implementation by using linkedlist
// static class Node{
// int data ;
// Node next;
// Node(int data){
// this.data = data;
// this.next = null;
// }

// }
// static class Queue{
// static Node head = null;
// static Node tail = null;

// public static boolean isEmpty(){
// return head ==null && tail == null;
// }

// //add
// public static void add(int data){
// Node newNode = new Node(data);
// if(head == null){
// head = tail = newNode;
// return ;
// }

// tail.next = newNode;
// tail =newNode;
// }

// //remove
// public static int remove(){
// if(isEmpty()){
// System.out.print("empty queues");
// return -1;
// }
// int front = head.data;
// if(tail == head){
// tail = head = null;
// }else{
// head = head.next;
// }
// return front;
// }

// //peek
// public static int peek(){
// if(isEmpty()){
// System.out.print("empty queues");
// return -1;
// }

// return head.data;
// }
// }
