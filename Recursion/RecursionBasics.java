public class RecursionBasics {
    public static void printDec(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.print(n +" ");
        printDec( n-1);
    }

    public static void printInc(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n +" ");
    }

    public static int  fact(int n){
        if(n==0){
            return 1;
        }

        int fnm1 = fact(n-1);
        int fn = n * fact(n-1);
        return fn;
    }

    public static int sum(int n ){
        if(n ==1){
            return 1;
        }
        int snm1 = sum(n-1);
        int sn = n + sum (n-1);
        return sn;
    }

    //Calculating nth term in fibonacci
    public static int fibonacci(int n ){
        if(n==0 || n==1){
            return n;
        }
        
        int fibnm1 = fibonacci( n-1);
        int fibnm2 = fibonacci(n-2);
        int fibn = fibnm1 + fibnm2;
        return fibn;
    }

    public static boolean isSorted(int arr[] , int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }

      return isSorted(arr , i+1);
    }

    public static int firstOccurence(int arr[] , int i , int key){
         if(i == arr.length-1){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }

        return firstOccurence(arr, i+1 ,key);
      
    }

    public static int lastOccurence(int arr[] , int key , int i){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound == -1 && arr[i] ==key){
            return i;
        }

        return isFound ;
    }

    //09-10-2025 practise question 

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        return x * power(x , n-1);
    }

    public static int optimizedPower(int a, int n){
        if(n ==0){
            return 1;
        }

        int halfPower = optimizedPower(a, n/2);
        int halfPowerSq = halfPower * halfPower;

        if(n%2 !=0){
            halfPowerSq = a * halfPowerSq;
        }

        return halfPowerSq;
    }


    //most asked question in amazon 
    public static int tallingProblem( int n ){// 2 x n (floor size)
        if(n==0 || n ==1){
            return 1;
        }
    
        // placing Vertical tiles
        int fnm1 = tallingProblem(n-1);

        //placing Horizontal tiles
        int fnm2 = tallingProblem(n-2);

        int totWays = fnm1 + fnm2 ;
        return totWays ;

        // compact form 
        // return tallingProblem(n-1) + tallingProblem(n-2);

    }

    //RemoveDuplicates 
    public static void removeDuplicates(String str, int idx, StringBuilder newStr , boolean map[]){
        if(idx == str.length()){
            System.out.print(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            removeDuplicates(str, idx+1, newStr, map);
        }else{
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1 , newStr.append(currChar), map);
        }
    }

    //10-10-2025 (Day 02 of 12 days challenage)

    public static int friendsPairing(int n){
        if(n==1 || n==2){
            return n ;

        }
 int fnm1 = friendsPairing(n-1);
  int fnm2 = friendsPairing(n-2);

  int pairWays = (n-1) * fnm2;

  int totWays = fnm1 + pairWays;

  return totWays;
        
    }

    //Binary strings question 
    public static void printBinaryStrings(int n , int lastPlace , String str ){
    if(n==0){
        System.out.println(str);
        return ;
    }

      printBinaryStrings(n-1, 0, str+"0");
      if(lastPlace == 0){
         printBinaryStrings(n-1, 1, str+"1");
      }
  

    }
    public static void main(String[] args) {
       printBinaryStrings(3,0, "");
      
    }
}
