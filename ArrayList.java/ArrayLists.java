
import java.util.ArrayList;

public class ArrayLists {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    //optimize approach-O(n)
    public static int optimizeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(currWater, maxWater);

            //update ptr
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }
    //Brute force appraoch

    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int length = Math.min(height.get(i), height.get(j));
                int widht = j - i;
                int water = length * widht;
                maxWater = Math.max(maxWater, water);

            }

        }
        return maxWater;
    }

    //2 pointer approach  pair sum-1 time complexity is O(n)..
    public static boolean pairSumb(ArrayList<Integer> list, int target) {

        int lp = 0;
        int rp = list.size() - 1;

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    //pair sum-2 by the two pointer approach 
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size() - 1;
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            if (!(list.get(i) < list.get(i + 1))) {
                list.set(lp, i + 1);
                list.set(rp, i);
                while (lp != rp) {
                    if (list.get(lp) + list.get(rp) == target) {
                        return true;
                    } else if (list.get(lp) + list.get(rp) < target) {
                        lp = (lp + 1) % n;
                    } else {
                        rp = (n + rp - 1) % n;
                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;

        System.out.print(pairSum2(list, target));
    }
}
