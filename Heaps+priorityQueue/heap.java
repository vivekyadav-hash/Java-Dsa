import java.util.*;

public class heap {

  // This is the code for the maxHeap for minHeap just change greater then to
  // lessthen conditions
  static class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) {
      // add at last Index
      arr.add(data);

      int x = arr.size() - 1;// x is child index
      int par = (x - 1) / 2;// parent index

      while (arr.get(x) > arr.get(par)) {// O(logn)
        // swap
        int temp = arr.get(x);
        arr.set(x, arr.get(par));
        arr.set(par, temp);

        x = par;
        par = (x - 1) / 2;
      }
    }

    public int peek() {
      return arr.get(0);
    }

    private void heapify(int i) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int maxIdx = i;

      if (left < arr.size() && arr.get(left) > arr.get(maxIdx)) {
        maxIdx = left;
      }

      if (right < arr.size() && arr.get(right) > arr.get(maxIdx)) {
        maxIdx = right;
      }

      if (maxIdx != i) {
        // swap
        int temp = arr.get(i);
        arr.set(i, arr.get(maxIdx));
        arr.set(maxIdx, temp);

        heapify(maxIdx);
      }
    }

    public int remove() {
      int data = arr.get(0);

      // step1:swap first & last
      int temp = arr.get(0);
      arr.set(0, arr.get(arr.size() - 1));
      arr.set(arr.size() - 1, temp);

      // step2: remove the last element
      arr.remove(arr.size() - 1);

      // step3; heapify
      heapify(0);
      return data;

    }

    public boolean isEmpty() {
      return arr.size() == 0;
    }
  }

  // Heap sort

  public static void heapify2(int arr[], int i, int n) {
    int maxIdx = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[maxIdx]) {
      maxIdx = left;
    }

    if (right < n && arr[right] > arr[maxIdx]) {
      maxIdx = right;
    }

    if (maxIdx != i) {
      int temp = arr[i];
      arr[i] = arr[maxIdx];
      arr[maxIdx] = temp;

      heapify2(arr, maxIdx, n);
    }

  }

  public static void heapSort(int arr[]) {// O(nlogn)
    // step1 - build heapify
    int n = arr.length;
    for (int i = n / 2; i >= 0; i--) {
      heapify2(arr, i, n);
    }

    // step 2 - push largest at end
    for (int i = n - 1; i > 0; i--) {
      // swap
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify2(arr, 0, i);
    }
  }

  static class Point implements Comparable<Point> {
    int x;
    int y;
    int distSq;
    int idx;

    public Point(int x, int y, int distSq, int idx) {
      this.x = x;
      this.y = y;
      this.distSq = distSq;
      this.idx = idx;
    }

    @Override
    public int compareTo(Point p2) {
      return this.distSq - p2.distSq;
    }

  }

  public static void connectNRope(int ropes[]) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < ropes.length; i++) {
      pq.add(ropes[i]);
    }
    int cost = 0;

    while (pq.size() > 1) {
      int min = pq.remove();
      int min2 = pq.remove();
      cost += min + min2;
      pq.add(min + min2);
    }

    System.out.println("Cost of Connecting N ropes is = " + cost);
  }

  static class Row implements Comparable<Row>{
    int soldier;
    int idx;

    public Row (int soldier , int idx){
      this.soldier= soldier;
      this.idx = idx;
    }

    @Override
    public int compareTo(Row r2){
     if(this.soldier == r2.soldier){
      return this.idx - r2.idx;
     }else{
   return this.soldier - r2.soldier;
     }
    }
  }

  public static void weakSoldier(int arr[][] ,int k){
    PriorityQueue<Row> pq = new PriorityQueue<>();

    for(int i=0; i<arr.length; i++){
      int count = 0;
      for(int j =0; j<arr[0].length; j++){
      count +=  arr[i][j] == 1 ? 1:0;
      }
      pq.add(new Row(count, i));
    }

    for(int i=0; i<k; i++){
      System.out.println("R" + pq.remove().idx);
    }
  }

  //Maximum in the subArray
  static class Pair implements  Comparable<Pair>{
    int val;
    int idx;

    public Pair(int val ,int idx){
      this.val = val;
      this.idx = idx;

    }

    @Override
    public int compareTo(Pair p2){
      //descending
      return p2.val - this.val;
    }
  }

  public static void maxofSubArray(int arr[], int k , int res[]){//O(nlogn)
    PriorityQueue<Pair> pq = new PriorityQueue<>();

for(int i=0; i<k; i++){
  pq.add(new Pair(arr[i], i));
}

res[0] = pq.peek().val;

for(int i =k ; i<arr.length; i++){
while(pq.size() > 0 && pq.peek().idx <= i-k){
pq.remove();
}
pq.add(new Pair(arr[i], i));
res[i-k+1] = pq.peek().val;
}
  }


  public static void main(String[] args) {
  int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
  int k = 3;//window size
  int res[] = new int[arr.length-k+1];

  maxofSubArray(arr, k, res);
  for(int i=0; i<res.length; i++){
    System.out.print(res[i] + " ");
  }
  }
}

/*
 * nearby Cars
 * for(int i=0; i<pts.length; i++){
 * distSp = pts[i][0]*pts[i][0]+ pts[i][1]*pts[i][1]
 * pq.add(new Point(pts[i][0] , pts[i][1] , distSp , i))
 * }
 * 
 * for(int i=0; i<k; i++){
 * System.out.print(pq.remove(point).idx)
 * }
 */