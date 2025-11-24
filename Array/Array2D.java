



public class Array2D {
  // This code for Array2D representation..... 
    // public static boolean search(int matrix[][], int key){
    //     for ( int i=0; i<matrix.length; i++){
    //       for (int j=0; j<matrix[0].length; j++){
    //         if (matrix[i][j] == key){
    //             System.out.println("found at cell (" + i + ","+ j + ")");
    //             return true;
    //         }
    //       }
    //     }
    //     System.out.println("key not found");
    //     return false;
    // }

  
    // public static void main(String[] args) {
      
    //     int matrix[][] = new int[3][3];
    //     int n =matrix.length, m=matrix[0].length;
    //     Scanner sc = new Scanner(System.in);
 
    //     for (int i=0; i<n; i++){
    //        for ( int j=0; j<m; j++){
    //         matrix[i][j] = sc.nextInt();
    //         }
    //        }
    
        

    //     for (int i=0; i<n; i++){
    //         for ( int j=0; j<m; j++){
    //          System.out.print(matrix[i][j] + " ");
    //         }
    //         System.out.println();
           
    //      }
    //      sc.close();
    //      search(matrix, 9);
    //      largestNum(matrix);
        
      
    //      }

    //      public static int largestNum(int matrix[][]){
    //       int largest = Integer.MAX_VALUE;
          
          
    //       for(int i=0; i<matrix.length; i++){
    //         for (int j=0; j<matrix[0].length; j++){
    //           if (largest>matrix[i][j]){
    //             largest =  matrix[i][j];
    //             System.out.print(largest +" ");
    //             return largest;
    //           }
    //         }
           
    //       }
    //        System.out.print("their is not a largest number");
    //        return largest;
    //     }

    // public static void printSpiral(int matrix[][]){
    //   int startRow = 0;
    //   int startCol = 0;
    //   int endRow = matrix.length -1;
    //   int endCol = matrix[0].length -1;

    //   while(startRow<= endRow && startCol <= endCol){
    //     for (int j=startCol; j<=endCol; j++){
    //       System.out.print(matrix[startRow][j] +" ");
    //     }

    //     for (int i =startRow+1; i<=endRow; i++){
    //       System.out.print(matrix[i] [endCol]+" ");
    //     }
    //     for(int j =endCol-1; j>=startCol; j--){
    //       if (startRow == endRow){
    //         break;
    //       }
    //       System.out.print(matrix[endRow][j] +" ");

    //     }
    //     for (int i=endRow-1; i>=startRow+1; i--){
    //       if (startCol == endCol){
    //         break;
    //       }
    //       System.out.print(matrix[i][startCol]+ " ");
    //     }
    //     startCol++;
    //     startRow++;
    //     endCol--;
    //     endRow--;
    //   }
    //   System.out.println();
    // }

    public static int  diagonalSum(int matrix[] []){
      int sum  = 0;
      
      for (int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
          if(i==j){
            sum += matrix[i][j];
          }
          else if( i+j == matrix.length-1){
            sum += matrix[i][j];
          }
        }
      }
     return sum;
   
    }

    public static boolean  staircaseSearch(int matrix[][] ,int key){
    int row =0, col = matrix[0].length -1;

    while(row < matrix.length && col >= 0){
      if (matrix[row][col] == key){
        System.out.println("found key at " + "(" + row+ ","+ col +")");
        return true;
      }
      else if( key < matrix[row][col]){
        col--;
       
      }else {
        row ++;
      }
    }
    System.out.println ("key not found!");
    return false;
    
    }

    public static void countSearch(int matrix [][] , int target){
      int count =0;
     for (int i=0; i<matrix.length; i++){
      for (int j =0; j<matrix[0].length -1; j++){
        if ( matrix[i][j] == target){
          count ++;
          
        }
        }
        }
        System.out.println(count);
    }

   public static void transferMatrixArr( int matrix[][]){
  int row = matrix.length;
  int col = matrix[0].length;
  for (int i =0; i<row; i++){
    for (int j =0; j<col; j++){
      int temp = row;
      row =col;
      temp = col;
      
    }
  }
  System.out.print(matrix);
   }
    public static void main(String[] args) {
      
      int matrix[] [] ={{10,20,30,40,},
                       {15,25,20,45},
                     };
                     countSearch(matrix, 30);
                     
    //                  int sum =0;
    //                  for (int j = 0; j<matrix[0].length; j++){
    //                   sum += matrix[1][j];
    //                  }
    //    System.out.print("sum of second row element " + sum);
    }
  
}