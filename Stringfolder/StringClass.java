


public class StringClass{

    public static void printLetter(String fullName){
        for(int i = 0; i<fullName.length(); i++){
            System.out.print(fullName.charAt(i)+" ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String str){//O(n) time complexity
        
        for (int i=0; i<str.length()/2; i++){
            int n = str.length();
            if (str.charAt(i)!= str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }

    // Give an route containing four direction (N,S,E,W) Find the shortest path to the reach destination WNEENESENNN

    public static float getShortestPath(String path){//timr complexity is O(n)
         int x =0 , y=0;
         for (int i = 0; i<path.length(); i++){
            char dir = path.charAt(i);
            if(dir == 'S'){
                y--;
            }
             else if(dir == 'N'){
                y++;
            }
            else if(dir == 'W'){
                x--;
            }
            else {
                x++;
            }
         }

         int X2 = x*x;
         int Y2 = y*y;
         return (float)Math.sqrt(X2 + Y2);
    }

    //Substring 
    public static String subStringStr( String str , int si , int ei){
  String substr = "";
  for (int i= si ; i<ei; i++){
    substr += str.charAt(i);
  }
  return substr;
    }

    // for a given string convert each the first letter of each word to uppercase.
 public static String toUpperCase(String str){
    StringBuilder sb = new StringBuilder("");

    char ch = Character.toUpperCase(str.charAt(0));
    sb.append(ch);

    for (int i =1; i<str.length(); i++){
        if (str.charAt(i) == ' ' && i<str.length()-1){
        sb.append(str.charAt(i));
        i++;
        sb.append(Character.toUpperCase(str.charAt(i)));
    }else {
        sb.append (str.charAt(i));
     }
    }
    return sb.toString();
 }

 public static String compress(String str){
    StringBuilder sb = new StringBuilder("");
    for(int i = 0; i<str.length(); i++){
        Integer count = 1;
        while (i<str.length ()-1 && str.charAt(i) == str.charAt(i+1)){
            count ++;
         i++;
        }
        sb.append(str.charAt(i));
        if (count > 1) {
            sb.append(count.toString());
        }
    }
 return sb.toString();
 }
    public static void main(String args[]){
    // String fruits[] = {"apple", "mango", "banana"};   
    
    // String largest = fruits[0];
    // for (int i =0; i <fruits.length; i++){
    //    if ( largest.compareTo(fruits[i]) <0){
    // largest = fruits[i];
    //    }
    // }
    // System.out.println(largest);

    // StringBuilder sb = new StringBuilder("");
    // for ( char ch = 'a'; ch <='z' ; ch++){
    //     sb.append(ch);
    // }
    // // time complexity of this builder O(26)
    // System.out.println (sb);

    String str = "aaabbbcccdd";
    System.out.println(compress(str));
    }
}