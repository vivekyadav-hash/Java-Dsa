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
   public static boolean isValid(String str) {//O(n)
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // Closing
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                            s.pop();
                } else {
                    return false;
                }

            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]) {
        String str = "{[]()}[]";
        System.out.print(isValid(str));
        int arr[] = {2,4,0,9,1,3};
Stack<Integer> s= new Stack<>();
int nextGreater[] = new int[arr.length];
for(int i = arr.length-1; i>=0; i--){
//1
while(!s.isEmpty()&& arr[s.peek()]<=arr[i]){
s.pop();
}
//2 if-else
if(s.empty()){
nextGreater[i] = -1;
}else{
nextGreater[i] = arr[s.peek()];
}

//3 push in s
s.push(i);
}
for(int i=0; i<arr.length; i++){
System.out.print(nextGreater[i] + " ");
}

// different way to ask some problem
    }
}

// next Greater value problem

// next Greater right
// next Greater left
// next smallest Right
// next smallest left