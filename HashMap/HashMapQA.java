import java.util.*;

public class HashMapQA {

    public static void majorityElement(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
            // short hand
            // hm.put(num ,hm.getOrDefault(num , 0)+1);
        }
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }

    // isAnagram true or false
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> isAn = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            isAn.put(s.charAt(i), isAn.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (isAn.get(ch) != null) {
                if (isAn.get(ch) == 1) {
                    isAn.remove(ch);
                } else {
                    isAn.put(ch, isAn.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return isAn.isEmpty();
    }

    public static void main(String args[]) {
        String s = "race";
        String t = "care";
        System.out.print(isAnagram(s, t));
    }
}
