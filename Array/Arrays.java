public class Arrays {
    public static void printPairs(int numbers[]){
        for (int i=0; i < numbers.length; i++){
            int curr= numbers[i];
            for(int j =i+1; j< numbers.length; j++){
                System.out.print("("+curr + "," + numbers[j]+ ")");
            }
            System.out.println();
        }
    }

    public static void binearySearch(int numbers [] ,int  key){
        int start = 0 ; int end = numbers.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(numbers[mid] == key){
                System.out.print("key is at :" + mid);
            }
            if (numbers[mid] < key){
                start = mid +1;
            }
            else{
                end =mid -1;

            }
        }
    }

    // Brute force approach
    public static void maxSubArrays(int numbers[]){
        int currSum =0; // This variable store the currSum 
        int maxSum = Integer.MIN_VALUE;// This variable store maxSum initial with negetive infinite
        // Its start is the index numbers[i]
        for(int i=0; i < numbers.length; i++){
            int start= i;
            // from here to iterate the end index
            for (int j=i; j<numbers.length; j++){
                int end =j;
                currSum = 0;
                // this loop will print the sub array from the start index and the end index 
                for(int k = start; k<=end; k++){
                currSum += numbers[k];
            
              }
              System.out.println(currSum);
            if(maxSum < currSum){
                    maxSum = currSum;
                }
          }  
       }
       
System.out.print("Max sum = " + maxSum);
    }


    // prefix method;
public static void prefixArrays(int numbers[]) {
    int start = 0;
     int end = numbers.length-1;
     int prefix[]=new int[numbers.length];
     int maxSum = Integer.MIN_VALUE;
     int currSum = 0;

     prefix[0] = numbers[0];
     for(int i=1; i<prefix.length; i++){
        prefix[i] = prefix[i-1] + numbers[i];
     }
for(int i=0; i<numbers.length-1; i++){
    start = i;
    for( int j=0; j<=end ; j++){
     end =j ;
     
     currSum = start ==0?prefix[end] : prefix[end] - prefix[start-1];
     if(maxSum < currSum) {
        maxSum = currSum;
     }
    }
}
}

//KADANE'S METHOD
public static void kadane(int numbers[]) {
    int cs = 0;
    int maxSum = Integer.MIN_VALUE;

    for(int i=0; i<numbers.length; i++){
       cs += numbers[i];
        if(cs < 0){
           cs =0;
        }
        maxSum = Math.max(cs , maxSum);
    }
    System.out.print("Max sum = " + maxSum);
} 

//Trapping Rainwater
public static int trappedRainwater(int height[] ){
    int n  = height.length;
    //calculate left max boundary -array 
    int leftMax [] = new int[n];
    leftMax[0] = height[0];
    for(int i=1; i<n; i++){
        leftMax[i] = Math.max(height[i], leftMax[i-1]);
    }

    //calculate right max boundary - array 
    int rightMax[] = new int [n];
    rightMax[n-1] = height[n -1 ];
    for(int i=n-2; i>=0; i--){
        rightMax[i] = Math.max(height[i], rightMax[i+1]);
    }

    int trappedRainwater = 0;
    //loop
    for(int i=0; i<n; i++){
        int waterLevel = Math.min(leftMax[i] , rightMax[i]);
        trappedRainwater += waterLevel - height[i];
    }
    
    return trappedRainwater; 
}

//profit or loss Calculator 
// this is my code 
// public static int profitCalculator(int prices[]) {
//     int profit = 0;
//     int n = prices.length;
//     int days[] = new int[n];

//     // Buying Price calculated
//     for (int i = 0; i < n; i++) {
//         int buyPrice = Math.min(prices[i], days[i]);
//         int sellPrice = prices[i];
//         profit = Math.max(sellPrice, buyPrice);

//         if (profit < buyPrice) {
//             profit = 0;
//         }
//     }
//     return profit;
// }

// code after the correction 
public static int profitCalculator(int prices[]){
    int n = prices.length;
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit =0;

    for(int i=0; i<n; i++){
      if (buyPrice < prices[i]) {
          int profit= prices[i] - buyPrice;
              maxProfit = Math.max(profit, maxProfit);
        }else {
            buyPrice = prices[i];
        }
    }
return maxProfit;

}
    public static void main(String[] args) {
int prices[] = {7,1,5,3,6,4};
System.out.print(profitCalculator(prices));

    }
}