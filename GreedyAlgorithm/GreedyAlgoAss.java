import java.util.*;

public class GreedyAlgoAss {

    // Maximum Balanced String Partition
    public static void maxBalanceStrPart(String str) {// time Complexity O(n)
        if (str.length() == 0) {//This from solution sheet
            return;
        }

        int countL = 0;
        int countR = 0;

        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                countL++;
            } else if (str.charAt(i) == 'R') {
                countR++;
            }

            if (countL == countR) {
                ans++;
            }
        }

        System.out.print(ans);

    }

    //Kth largest odd Number in a given range
    public static int kthOdd(int [] range, int k){//Time complexity is O(1)
        if(k <=0){
            return 0;
        }

        int L = range[0];
        int R = range[1];

        if((R & 1) > 0){
            int Count = (int)Math.ceil((R-L +1)/2);
            if(k > Count){
                return 0;
            }else{
                return( R-2 * k + 2);
            }
        }else{
            int Count = (R-L +1)/2;
            if(k > Count){
                return 0;
            }
            else{
                return (R - 2*k +1);
            }
        }
    }

public static char[]  lexiSmallestS( int N , int K){
char arr[] = new char[N];

Arrays.fill(arr ,'a');
for(int i =N-1; i>=0; i--){
K -=i;
if(K >=0){
    if(K >=26){
        arr[i] = 'z';
        K -= 26;
    }else{
        arr[i] = (char)(K + 97 -1);
        K -= arr[i]- 'a' +1;
    }
}else{
    break;
    
}
K += i;
}  
return arr;
}

//Best Time to Buy and Sell Stock
public static void buySellStock(int [] prices){
int buy =0;

//Buy the stock
for(int i=1; i<prices.length; i++){
    if(prices[i] < prices[buy]){
        buy = i;
    }
}

int max_profit=0;
//Sell the stock
for(int i = buy+1 ; i<prices.length; i++){
max_profit = Math.max(max_profit, prices[i] - prices[buy]);
}

System.out.println(max_profit);
}

//Split the given array intok sub-array
public static void solve(int a[] , int n , int k , int index , int sum ,int maxsum){

    if(k ==1){
        maxsum = Math.max(maxsum, sum);
        sum =0;
        for(int i =index; i<n; i++){
            sum +=a[i];

        }
        maxsum =Math.max(maxsum, sum);
        ans = Math.min(ans, maxsum);
        return;
    }
    sum = 0;
    for(int i=index; i<n; i++){
        sum += a[i];
        maxsum = Math.max(maxsum, sum);
        solve(a, n, k-1, i+1, sum, maxsum);
    }
    
}
    public static void main(String args[]) {
       int arr[] = {1,2,3,4};
       int k = 3; //k Divisions
       int n = 4; //Size of Array
       solve(arr, n , k, 0,0,0);
       System.out.println(ans +"\n");
    }

    public static int ans = 10000000;
}