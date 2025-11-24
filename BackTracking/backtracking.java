
class backtracking {

    public static void changeArr(int arr[], int n, int v) {
        if (n == arr.length) {
            printArr(arr);
            return;
        }
        arr[n] = v;
        changeArr(arr, n + 1, v + 1);
        arr[n] = arr[n] - 2;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findSubsets(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.print("null");
            } else {
                System.out.println(ans);
            }

            return;
        }

        //yes Choice
        findSubsets(str, ans + str.charAt(i), i + 1);
        //No Choice
        findSubsets(str, ans, i + 1);

    }

    public static void permutationStr(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i + 1);
            permutationStr(Newstr, ans + curr);
        }
    }

//N Queen Problem statement
    public static boolean isSafe(char board[][], int row, int col) {
        //vertical 
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueen(char board[][], int row) {
        if (row == board.length) {
            count++;
            return;
        }
        //column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueen(board, row + 1);//function call
                board[row][j] = 'x';//backtracking step 
            }

        }
    }

    //printing Board
    public static void printBoard(char board[][]) {
        System.out.println("----------chess board----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    //Grid way  problem 
    public static int gridWays(int i, int j, int n, int m) {
        //base case
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    //written by own 
    public static void subSets(String str, String ans, int i) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }

        subSets(str, ans + str.charAt(i), i + 1);
        subSets(str, ans, i + 1);
    }

// sudoku solution
    public static boolean setSafe(int sudoku[][], int row, int col, int digit) {
        // Column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) return false;
        }

        // Row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) return false;
        }


        // Grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) return false;
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base Case
        if (row == 9) {
            return true;
        }

        
        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

       
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        
        for (int digit = 1; digit <= 9; digit++) {
            if (setSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) return true;
                sudoku[row][col] = 0; // backtrack
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists ");
            printSudoku(sudoku);
        } else {
            System.out.println("No solution exists ");
        }
    }
}

