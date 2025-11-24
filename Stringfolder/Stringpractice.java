


public class Stringpractice {
    // count how many lower case vowels are used in the string entered by use
   
    // public static void main(String[] args) {
    
    //     // String str = "shradhaKhapra";
    //     // String str1 = "apnacollege";
    //     // String str2 = "shradhaKhapra";

    //     // System.out.println( str.equals(str1)+ " " +str.equals(str2));

    //     String str = "Apnacollege".replace("l","");
    //    System.out.println (str);

    // }

    public static void main(String[] args) {
        String str1 = "earth";
        String str2 = "heart";

        //Convert Strings to lowercase. Why? so that we don't have to check separately for a lower & uppercase.

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        //First check -if the lengths are the same 
        if (str1.length() == str2.length()){
            // convert strings into char array
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();
            //sort the char array
            java.util.Arrays.sort(str1charArray);
            java.util.Arrays.sort(str2charArray);

            boolean result = java.util.Arrays.equals(str1charArray, str2charArray);
            if (result) {
                System.out.println (str1 +" "+ "and " + str2 +" "+ "are anagrams of each others");
            }else {
                System.out.println(str1 +" "+ "and " + str2+" " +" are not anagrams to each other.");
            }
        }
    }
}
