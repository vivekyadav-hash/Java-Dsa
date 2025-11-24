
import java.util.ArrayList;
import java.util.Collections;

class ArrayListsPr {
    public static  int mostFrequent(ArrayList<Integer> nums, int key) {
        int[] result=new int[1000];
        for(int i=0;i<nums.size()-1;i++){
            if(nums.get(i) ==key){
                result[nums.get(i+1)-1]++;
            }}
            int max=Integer.MIN_VALUE;
            int ans=0;
            for(int i=0;i<1000;i++){
                if(result[i] >max){
                    max=result[i];ans=i+1;
                }}
                return ans;}

    // Solution from the solution Page Time complexity is O(n)
    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {

        Collections.sort(nums);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i)
                    && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i));
            }
        }

        if (nums.size() == 1) {
            list.add(nums.get(0));
        }

        if (nums.size() > 1) {

            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }

            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }

        return list;
    }

    // This solution is writen by mee this is the brute force approach //O(n^2)
    public static ArrayList<Integer> lonelyNums(ArrayList<Integer> nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            int x = nums.get(i);
            int count = 0;
            for (int j = 0; j <= i; j++) {
                if (nums.get(j) == x) {
                    count++;
                }
                if (count > 1) {
                    continue;
                }
            }
            if (!nums.contains(x + 1) && !nums.contains(x - 1)) {
                ans.add(x);
            }
        }
        return ans;
    }

    public static boolean monotonicArrayList(ArrayList<Integer> nums) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) < nums.get(i + 1)) {
                dec = false;
            }
            if (nums.get(i) > nums.get(i + 1)) {
                inc = false;
            }
        }
        return inc || dec;
    }

    public static void main(String[] args) {
        int key =1;
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(100);
        nums.add(1);

      System.out.print(mostFrequent(nums, key));
        
    }
}
