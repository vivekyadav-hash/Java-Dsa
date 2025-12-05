import java.util.*;

public class GreedyApproach {

  public static void FracionalKnapsack(int val[], int weight[], int w) {
    double ratio[][] = new double[val.length][2];
    // 0th col => 1st col => ratio

    for (int i = 0; i < val.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = val[i] / (double) weight[i];

    }

    // Ascending order
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    int capacity = w;
    int finalVal = 0;
    for (int i = ratio.length - 1; i >= 0; i--) {
      int idx = (int) ratio[i][0];

      if (capacity >= weight[idx]) {// include full item
        finalVal += val[idx];
        capacity -= weight[idx];
      } else {
        // include fractional item
        finalVal += (ratio[i][1] * capacity);
        capacity = 0;
        break;
      }
    }

    System.out.println("final value will be = " + finalVal);
  }

  public static void minSumAbsDiffP(int A[], int B[]) {
    Arrays.sort(A);
    Arrays.sort(B);

    int minDiff = 0;

    for (int i = 0; i < A.length; i++) {
      minDiff += Math.abs(A[i] - B[i]);
    }

    System.out.println("min absolute diff of pairs = " + minDiff);
  }

  public static void maxLengthChOfPair(int pairs[][]) {// O(nlogn)

    // sorting according to the second arr

    Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    int ans = 1;

    int lastSelected = pairs[0][1];
    for (int i = 1; i < pairs.length; i++) {
      if (pairs[i][0] > lastSelected) {
        ans++;
        lastSelected = pairs[i][1];
      }
    }
    System.out.println("Maximum length of the chain = " + ans);

  }

  public static void indianCoin(Integer coin[], int amount) {
    Arrays.sort(coin, Comparator.reverseOrder());

    int count = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < coin.length; i++) {
      if (coin[i] <= amount) {
        while (coin[i] <= amount) {
          count++;
          ans.add(coin[i]);
          amount = amount - coin[i];
        }
      }
    }
    System.out.println("Total (min) coins used = " + count);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }

  }

  //Hard problem Named as Chocola problem 
public static void chocolaCost(int n , int m , Integer costVer[] , Integer costHor[]){

  Arrays.sort(costVer , Collections.reverseOrder());
  Arrays.sort(costHor , Collections.reverseOrder());

  int h =0 , v =0;
  int hp =1 , vp =1;
  int cost =0;

  while(h<costHor.length && v < costVer.length){
    //vertical cost < hor cost
    if(costVer[v] <= costHor[h]){
        cost += (costHor[h] * vp); //Through vertical pieces
        hp++;
        h++;
    }else{
      cost += (costVer[v] * hp);//Through horizontal pieces
      vp++;
      v++;
    }
  }

  while(h < costHor.length){
    cost += (costHor[h] * vp);
    hp++;
    h++;
  }

  while( v < costVer.length){
    cost += (costVer[v] * hp);
    vp++;
    v++;
  }

  System.out.println("min cost of cuts = " + cost);
}
  public static void main(String args[]) {
 int n =4 , m = 6;
 Integer costVer [] = {2,1,3,1,4}; //m-1
 Integer costHor[]= {4, 1, 2};// n-1
  
 chocolaCost(n, m, costVer, costHor);
  }

}


  

    //print seq
  //   System.out.println("max jobs = " + seq.size());
  //   for(int i=0; i<seq.size(); i++){
  //     System.out.print(seq.get(i) + " ");
  //   }
  // }

  // for job sequence
  // static class Job {
  //   int deadline;
  //   int profit;
  //   int id;

  //   public Job(int i, int d, int p) {
  //     id = i;
  //     deadline = d;
  //     profit = p;
  //   }
  //  int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

  //   ArrayList<Job> jobs = new ArrayList<>();

  //   for (int i = 0; i < jobsInfo.length; i++) {
  //     jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
  //   }

  //   Collections.sort(jobs, (a, b) -> b.profit - a.profit); // decending order of profit


  //   ArrayList<Integer> seq = new ArrayList<>();
  //   int time =0;
  //   for(int i=0; i<jobs.size(); i++){
  //    Job curr = jobs.get(i);
  //    if(curr.deadline > time){
  //      seq.add(curr.id);
  //      time++;
  //    }
// Solution of the Activity Selection
// int start[] = { 1, 3, 0, 5, 8, 5 };
// int end[] = { 2, 4, 6, 7, 9, 9 };

// // sorting
// int activities[][] = new int[start.length][3];

// for (int i = 0; i < start.length; i++) {
// activities[i][0] = i;
// activities[i][1] = start[i];
// activities[i][2] = end[i];
// }

// // lambda function -> ShortForm of function
// Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
// // if the array will give in the unsorted form then we replace the places of
// the
// // normal value to the activities values;

// // end Time basis Sorted Time Complexity O(n)
// int maxAct = 0;
// ArrayList<Integer> ans = new ArrayList<>();

// // 1st activity
// maxAct = 1;
// ans.add(activities[0][0]);
// int lastEnd = activities[0][2];

// for (int i = 1; i < end.length; i++) {
// if (activities[i][1] >= lastEnd) {
// // activity select
// maxAct++;
// ans.add(activities[i][0]);
// lastEnd = activities[i][2];
// }
// }

// System.out.println("max activities = " + maxAct);

// for (int i = 0; i < ans.size(); i++) {
// System.out.print("A" + ans.get(i) + " ");
// }