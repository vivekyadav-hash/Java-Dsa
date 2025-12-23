import java.util.*;

public class hashSet {
    public static void main(String[] args) {
       HashSet <String> cities = new HashSet<>();
       cities.add("Delhi");
       cities.add("Mumbai");
       cities.add("Noida");
       cities.add("Bengaluru");
       System.out.println(cities);
       
    //   Iterator it = cities.iterator();
    //   while(it.hasNext()){
    //     System.out.println(it.next());
    //   }

    // for(String city : cities){
    //     System.out.println(city);
    // }

    TreeSet<String> ts = new TreeSet<>();
      ts.add("Delhi");
       ts.add("Mumbai");
       ts.add("Noida");
       ts.add("Bengaluru");
       System.out.println(ts);
    }
}
