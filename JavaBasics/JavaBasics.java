
public class  JavaBasics {

    public static void hollow_rectangle(int totRows , int totCols ){
        for ( int i=1; i <=totRows ; i++){
            for (int j=1; j <=totCols; j++){
                if(i ==1|| i==totRows || j== 1|| j==totCols){
                 System.out.print("*");
                } else{
                    System.out.print(" ");
                }
              
            }
            System.out.println();
        }
    }

    public static void half_Pyramid(int totRows){
   for (int i = 1; i <=totRows; i++) {
       for (int j=1; j<=totRows - i; j++ ){
         System.out.print(" ");
       }
       for ( int k = 1; k <=i; k++){
        System.out.print("*");
       }
       System.out.println();
   }
    }
    public static void inverted_Half_Pyramid(int n){
        for ( int i =1; i<=n; i++){
            for (int j = 1; j<=n-i+1; j++ ){
                System.out.print(j+" ");
            }
            System.out.println();
            
        }
    }

    public static void floyd_triangel(int n){
        int counter = 1;
        for ( int i = 1; i<=n; i++ ){
            for ( int j =1; j<=i; j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void  butterFly(int n){
        for ( int i=1; i<=n; i++){

            for (int j = 1; j<=i; j++){
                System.out.print("*");
            }

            for (int j=1 ; j<=2*(n-i); j++){
                System.out.print(" ");
            }

            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i =n; i >=1; i--){
            for (int j = 1; j<=i; j++){
                System.out.print("*");
            }

            for (int j = 1 ; j<=2*(n-i); j++){
                System.out.print(" ");
            }

            for (int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        }

        public static void solid_Rhombus(int n){
            for ( int i=1; i<=n; i++){
                for (int j=1; j<=(n-i); j++){
                    System.out.print(" ");
                }for ( int j=1; j<=n; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        public static void hollow_rhombus(int n){
            for (int i=1; i<=n; i++){
                for (int j=1;j<=(n-i); j++){
                    System.out.print(" ");
                }
                for (int j=1; j<=n; j++){
                    if (i==1 || i ==n|| j==1||j==n){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            }
        
            public static void diamond(int n){
                for (int i =1; i<=n; i++){
                    for (int j=1; j<=(n-i); j++){
                        System.out.print(" ");
                    }
                    for(int j=1; j<=(2*i-1); j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for (int i =n; i>=1; i--){
                    for (int j=1; j<=(n-i); j++){
                        System.out.print(" ");
                    }
                    for(int j=1; j<=(2*i-1); j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
    

 public static void main(String[] args){
    hollow_rectangle(3, 4);;
 }

}
