import java.util.*;


public class hashMap {
    public static void main(String args[]){
        //create hashMap
        HashMap<String,Integer> HP = new HashMap<>();
        HP.put("India", 100);
        HP.put("china", 120);
       HP.put("australia", 80);

       
        // System.out.println(HP);
       
        //Remove
        // System.out.println(HP.remove("India"));
        // System.out.println(HP);

        // HP.clear();
        // System.out.print(HP.isEmpty());

        //Iterate
        Set<String> keys = HP.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key = " + k+ ", value = " +HP.get(k));
        }
    }
}
