

public class bitManipulation {
    public static void oddOrEven(int n){
        int bitMask =1;
        if((n & bitMask) == 0){
         System.out.println("even number");
                    
        }else{
            System.out.println("odd number");
        }
    }

    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if ((n & bitMask)==0){
            return 0;
        }else {
            return 1;
        }
    }

    public static int setIthBit(int n ,int i){
        int bitMask = 1<<i;
        return n | bitMask;
    }
    
    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    }
    public static int updateIthBit(int n , int i, int newBit){
        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }
    public static int clearLastIBits(int n , int i){
        int bitmask = (-1)<<i;
        return n & bitmask;
    }

    public static int clearIBit(int n ,int i, int j){
        int a = ((~0)<<(j+1));
        int b = ((1<<i)-1);
        int bitMask= a|b;
        return n & bitMask ;
    }

    public static boolean  powerOfTwo(int n){
    
        return (n&(n-1))== 0;
    }
    public static int countSetBits(int n){
        int count =0;
        while (n > 0){
            if (( n & 1) != 0){
           count ++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExpo(int a , int n){
        int ans = 1;
        while (n>0){
            if ((n & 1) != 0){
                ans = ans *a;
            }
            a =a *a;
            n =n>>1;
        }
        return ans;
    }


   
    public static void main(String[] args) {
    //  int x = 3, y = 4;
    //  System.out.println("before swapping the num" + x + " and" + y);
    //   x = x^ y;
    //   y = y^x;
    //   x = x^ y;
    //   System.out.println("After the Swap: x =" + x +"and y =" + y);
    // int x = 6;
    // System.out.println(x + "+" + 1 + "is" + -~x);
    // x = -4;
    // System.out.println(x + "+" + 1 + "is" + -~x);
    // x=0;
    // System.out.println(x + "+" + 1 + "is" + -~x);
    for(char ch = 'A'; ch <='Z'; ch++){
   System.out.println((char) (ch | ' '));
    }
}
}
