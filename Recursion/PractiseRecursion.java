
public class PractiseRecursion {

    static String digits[] = {"zero", "one ", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    //1st try alot , but done with solution 
    public static void allOccurence(int[] arr, int key, int i) {
        if (i == arr.length) {
            return;
        }

        if (arr[i] == key) {
            System.out.print(i + " ");
        }

        allOccurence(arr, key, i + 1);
    }

    //2nd question solution 
    public static void printDigits(int n) {
        if (n == 0) {
            return;
        }
        int lastDigits = n % 10;
        printDigits(n / 10);
        System.out.print(digits[lastDigits] + " ");
    }

    //find length of a string (done by own)
    public static int StringLength(int n) {
        String str = "Vivek";
        if (n == str.length()) {
            return n;
        }

        return StringLength(n + 1);
    }

    //Counting Substrings (solved by the solution but , I tryed alot then see the solution)
    public static int countSubstrings(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }

        if (n <= 0) {
            return 0;
        }

        int res = countSubstrings(str, i + 1, j, n - 1) + countSubstrings(str, i, j - 1, n - 1) - countSubstrings(str, i + 1, j - 1, n - 2);

        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;

    }

    //Tower of hanoi 
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("transfer disk" + " " + n + " " + "from" + " " + src + " to " + dest);
            return;
        }

        //transfer top n-1 from src to helper using dest as "helper"
        towerOfHanoi(n - 1, src, dest, helper);

        //transfer nth from src to dest 
        System.out.println("transfer disk" + " " + n + " " + "from" + " " + src + " to " + dest);
        //transfer n-1 from helper to dest using src as 'helper'
        towerOfHanoi(n - 1, helper, src, dest);
    }

    //Practise question of Divide & Conquer Question
    public static void printArr(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void mergeSort(String[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String[] arr, int si, int mid, int ei) {
        String[] temp = new String[ei - si + 1];
        int i = si, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    //Practise Question 2
    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private static int majorityElementRec(int[] nums, int lo, int hi) {
        // base case: only element is the majority
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves
        int mid = lo + (hi - lo) / 2;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if both halves agree, return it
        if (left == right) {
            return left;
        }

        // otherwise count each candidate in this range
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

public static int countInversion(int[] arr, int si, int ei, int mid) {
    int count = 0;
    int temp[] = new int[ei - si + 1];
    int i = si, j = mid + 1, k = 0;

    // Merge step — count cross inversions
    while (i <= mid && j <= ei) {
        if (arr[i] <= arr[j]) { // use <= for stable merge
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
            count += (mid - i + 1); // ✅ correctly counts remaining elements on left
        }
    }

    // Copy remaining elements from left half
    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    // Copy remaining elements from right half
    while (j <= ei) {
        temp[k++] = arr[j++];
    }

    // Copy merged elements back to original array
    for (k = 0, i = si; k < temp.length; k++, i++) {
        arr[i] = temp[k];
    }

    return count;
}

public static int inversionCount(int[] arr, int si, int ei) {
    int count = 0;
    if (si >= ei) return 0; // base case

    int mid = si + (ei - si) / 2;

    count += inversionCount(arr, si, mid);      // left part
    count += inversionCount(arr, mid + 1, ei);  // right part
    count += countInversion(arr, si, ei, mid);  // merge + cross count

    return count;
}

public static int getInversions(int arr[]) {
    return inversionCount(arr, 0, arr.length - 1);
}

public static void main(String[] args) {
    int arr[] = {5,5,5};
    System.out.println("Inversion count = " + getInversions(arr));
}

   
}
