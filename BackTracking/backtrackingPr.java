
public class backtrackingPr {


    // Function to print the solution matrix (tried alot but at the end go through the solution )
    public static void printSolution(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if x, y is valid index for maze
    public static boolean isSafe(int maze[][], int x, int y) {
        // Check boundaries and if the cell is open (1)
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    // Function to solve the maze using backtracking
    public static boolean solveMaze(int maze[][]) {
        int N = maze.length;
        int sol[][] = new int[N][N];

        if (solveMazeUntil(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    // Recursive utility function
    public static boolean solveMazeUntil(int maze[][], int x, int y, int sol[][]) {

        // Base case: reached destination
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            // If the cell is already part of the solution path
            if (sol[x][y] == 1) {
                return false;
            }

            // Mark x, y as part of the solution path
            sol[x][y] = 1;

            // Move forward in x direction (down)
            if (solveMazeUntil(maze, x + 1, y, sol)) {
                return true;
            }

            // Move forward in y direction (right)
            if (solveMazeUntil(maze, x, y + 1, sol)) {
                return true;
            }

            // If none of the above work, backtrack: unmark x, y
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    final static char[][]L  = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    //Keypad Combination
    public static void keypadCombination( String D){
   int len = D.length();
   //base Case
   if(len ==0){
    System.out.println("");
    return;
   }

   bfs(0, len,new StringBuilder() , D);//function call
    }

    // this is the main recursive function 
    public static void bfs(int pos ,int len , StringBuilder sb, String D){
        if(pos ==len){
            System.out.println(sb.toString());

        }
        else{
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
            for(int i=0; i<letters.length; i++){
                bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), D);//recursive call 
            }
        }
    }

   public static boolean cellSafe(int x, int y, int board[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

  // Print the solution matrix
    public static void printBoard(int board[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(board[x][y] + " ");
            System.out.println();
        }
    }

    // Main solver function
    public static boolean solveKT() {
        int board[][] = new int[N][N];

        // Initialize all cells as unvisited
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                board[x][y] = -1;

        // All possible moves for a Knight
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Starting from cell (0, 0)
        board[0][0] = 0;

        // Start recursive solving
        if (!solveKTUtil(0, 0, 1, board, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printBoard(board);
        }

        return true;
    }

    // Recursive utility to solve the Knight Tour problem
    public static boolean solveKTUtil(int x, int y, int movei, int board[][], int xMove[], int yMove[]) {
        int next_x, next_y;

        // Base case: all cells are visited
        if (movei == N * N)
            return true;

        // Try all 8 possible moves
        for (int k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];

            if (cellSafe(next_x, next_y, board)) {
                board[next_x][next_y] = movei;

                if (solveKTUtil(next_x, next_y, movei + 1, board, xMove, yMove))
                    return true;
                else
                    board[next_x][next_y] = -1; // Backtrack
            }
        }

        return false;
    }

    static int N = 8;
    public static void main(String args[]) {
        solveKT();

    }
}