



public class JavaPatterns {  
public static void hollow_Rectangle (int rows,int cols){
    for (int i =1; i<=rows; i++){
for (int j=1; j<=cols; j++){
if (i==1 || i==rows || j == 1 || j==cols){
    System.out.print("*");
}else{
    System.out.print(" ");
}
}
System.out.println();
    }
}
public static void inverted_Half_Pyramid(int rows){
    for (int i =1; i<=rows; i++){
        for(int k = 1; k<=rows-i; k++){
            System.out.print(" ");
        }
        for (int j=1; j<=i; j++){
          System.out.print("*");
        }
         System.out.println();
    }
}

public static void half_Pyramid_Numbers(int n){
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n-i+1; j++){
            System.out.print(j);
        }
       
         System.out.println();
    }
   
}

public static void floyd_Triangle(int n){
    int num = 1;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            System.out.print(num +" ");
            num +=1;
        }
      
        System.out.println();
    }
}

public static void triangle_01(int n){
    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            if((i+j)%2==0){
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }
        }
        System.out.println();
    }
}


//ButterFly patterns
public static void butterFly(int n){
    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            System.out.print("*");
        }
        for(int k=1; k<=2*(n-i); k++){
            System.out.print(" ");
        }
            for(int j=1; j<=i; j++){
            System.out.print("*");
        }
        System.out.println();
    }
      for(int i=n; i>=1; i--){
        for(int j=1; j<=i; j++){
            System.out.print("*");
        }
        for(int k=1; k<=2*(n-i); k++){
            System.out.print(" ");
        }
            for(int j=1; j<=i; j++){
            System.out.print("*");
        }
        System.out.println();
    }
}

//Solid Rhombus patterns
public static void solid_Rhombus(int n){
    for(int i=1; i<=n; i++){
        for(int k=1; k<=n-i; k++){
            System.out.print(" ");
        }
        for(int j=1; j<=n; j++){
          System.out.print("*");
        }
        System.out.println();
    }
}

//hollow rhombus
public static void hollow_Rhombus( int n){
for(int i=1; i<=n; i++){
      for(int k=1; k<=n-i; k++){
            System.out.print(" ");
        }
for(int j=1; j<=n; j++){
    if(i==1 ||n == i || j==1 || j==n){
        System.out.print("*");
    }else{
        System.out.print(" ");
    }
}
System.out.println();
}

}

public static void diamond_pattern(int n){
    for(int i=1; i<=n; i++){
        for(int k=1; k<=n-i; k++){
            System.out.print(" ");
        }
        for(int j=1; j<=(2*i)-1; j++){
            System.out.print("*");
        }
        System.out.println();
    }

    // 2nd half
    for(int i=n; i>=1; i--){
        for(int k=1; k<=n-i; k++){
            System.out.print(" ");
        }
        for(int j=1; j<=(2*i)-1; j++){
            System.out.print("*");
        }
        System.out.println(); 
    }
}

public static int Product (int a , int b){
System.out.println(a*b);
return 1;
}

public static int Factorial(int n){
    int f = 1;
    for(int i=1; i<=n; i++){
        f *= i;
        }
     
     return f;
}

public static int binCoefficient(int n , int r){
  int fact_n = Factorial(n);
  int fact_r = Factorial(r);
  int fact_nmr = Factorial(n-r);

  int binCoefficient = fact_n/(fact_r*fact_nmr);
  return binCoefficient;
}

//Function Overloading....
public static int sum(int a , int b){
    return a+b;
}

public static float sum (float a, float b){
    return a+b;
}

//Prime or not 
public static boolean isPrime(int n){
    boolean isPrime = true;
    for(int i=2; i<=n-1; i++){
        if(n%i==0){
           isPrime = false;
        }
    }
return isPrime;
}

// finding the range of number is prime or not 
public static void primeNumber(int n){
    for(int i=2; i<=n-1; i++){
       if(isPrime(i)){
        System.out.print(i + " ");
       }
     }
     System.out.println();
}


//Binary to Decimal Converter
public static void binaryToDecimal(int binNum){
    int pw =0;
    int decNum = 0;
    while(binNum >0){
  int lastDigit = binNum % 10;
  decNum = decNum + (lastDigit * (int)Math.pow(2,pw));

  pw++;
  binNum = binNum/10;
    }
    System.out.print("Decimal of " + binNum + " = " + decNum);
}


//Decimal to Binary convertion....
public static void decimalToBinary(int decNum){
    int paw = 0;
    int rem = 0;
    int binNum = 0;
    while(decNum>0){
        rem = decNum % 2;
        binNum = binNum + ( rem * (int)Math.pow(10,paw ));
        paw ++;
        decNum = decNum / 2;
    }
    System.out.print("Binary number of " + decNum + "=" + binNum);
}
    public static void main(String[] args) {
diamond_pattern(4);

    }

   
}