import java.util.*;

public class StackB {

   public static void pushAtBottom(Stack<Integer> s , int data){
    if(s.isEmpty()){
        s.push(data);
        return ;
    }
    int top = s.pop();
    pushAtBottom(s, data);
    s.push(top);
   
   }

   public static String reverseString(String str){
    Stack<Character> s = new Stack<>();
    int idx = 0;
    while(idx < str.length()){
        s.push(str.charAt(idx));
        idx++;
    }

    StringBuilder result = new StringBuilder("");
    while(!s.isEmpty()){
        char curr = s.pop();
        result.append(curr);

    }
    return  result.toString();
   }

   public static void revStack(Stack<Integer> s){
   if(s.isEmpty()){
    return ;
   }

  int top =  s.pop();
  revStack(s);
   pushAtBottom(s, top);

   }

   public static void printStack(Stack<Integer> s){
    while(!s.isEmpty()){
        System.out.println(s.pop());
    }
   }

   //Stock span problem asked in amazon, flipkart, adobe , microsoft , paytm
   public static void stockSpan(int stocks[], int span[]){
    Stack<Integer> s = new Stack<>();
    span[0] = 1;
    s.push(0);

    for(int i=1; i<stocks.length; i++){
        int currPrice = stocks[i];
        while(!s.isEmpty() && currPrice > stocks[s.peek()]){
            s.pop();

        }
        if(s.isEmpty()){
            span[i]= i+1;
        }else{
            int prevHigh = s.peek();
            span[i] = i - prevHigh;
        }
        s.push(i);
    }
   }
    public static void main(String args[]){
            int stocks [] = { 100, 80, 60, 70, 60 , 85 ,100};
            int span [] = new int[stocks.length];
            stockSpan(stocks ,span );

       for(int i=0; i<span.length; i++){
        System.out.println(span[i]+" ");
       }
    }
}