import java.util.Scanner;

public class JavaPractise {
    public static void averageofTriNum(int a , int b, int c){
        System.out.print((a + b + c) / 3);
    }

    public static boolean isEven (int a){
        boolean isEven = true;
        if(a % 2 !=0){
            isEven = false;
        }
        return isEven;
    }

    public static void palindromeNum (){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
          int original = n;
        int lastDigit = 0;
        int reverse = 0;
        while(n>0){
            lastDigit = n % 10;
            reverse = reverse*10 + lastDigit ;
            n = n/10;
      
        }
              if(original==reverse){
                System.out.print("this is palindrome");
            }else{
                System.out.println("This is not a palindrome");
            }
        
    }
    public static void main(String[] args) {
        palindromeNum();
    }
}
