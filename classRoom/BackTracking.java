
public class BackTracking {

    public static void changeArr(int arr[], int i, int val) {
        // base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findSubsets(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");

            } else {
                System.out.println(ans);

            }
            return;
        }

        // recursion
        // Yes choice
        findSubsets(str, ans + str.charAt(i), i + 1);

        // No Choice
        findSubsets(str, ans, i + 1);

    }

    public static void findSubsetStringBuilder(String str, StringBuilder ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");

            } else {
                System.out.println(ans);

            }
            return;
        }

        // recursion
        // Yes choice
        ans.append(str.charAt(i));
        findSubsetStringBuilder(str, ans, i + 1);

        // No Choice
        ans.deleteCharAt(ans.length() - 1);
        findSubsetStringBuilder(str, ans, i + 1);

    }

    public static void findPermutation(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;

        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutation(newStr, ans + curr);

        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("--------Chess Board---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }

    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right diagonal

        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

    public static void nQueens(char board[][], int row) {
        // base case
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    static int count = 0;

    public static boolean isSafeKnight(char board[][], int row, int col) {
        // top left
        if (row - 2 >= 0 && col - 1 >= 0) {
            if (board[row - 2][col - 1] == 'K') {
                return false;
            }
        }
        // top right

        if (row - 2 >= 0 && col + 1 < board.length) {
            if (board[row - 2][col + 1] == 'K') {
                return false;
            }
        }

        // side left
        if (row - 1 >= 0 && col - 2 >= 0) {
            if (board[row - 1][col - 2] == 'K') {
                return false;
            }
        }

        // side rigth
        if (row - 1 >= 0 && col + 2 < board.length) {
            if (board[row - 1][col + 2] == 'K') {
                return false;
            }
        }

        return true;

    }

    public static void nKnights(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafeKnight(board, row, j)) {
                board[row][j] = 'K';
                nKnights(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public static int gridWays(int i, int j, int n, int m) {

        // base case
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static void printBoard(int board[][]) {
        System.out.println("--------Sudoko---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }

    }

    public static boolean isSafeSudoku(int sudoko[][], int row, int col, int digit) {

        // column
        for (int i = 0; i <= 8; i++) {
            if (sudoko[i][col] == digit) {
                return false;
            }
        }

        // row
        for (int j = 0; j <= 8; j++) {
            if (sudoko[row][j] == digit) {
                return false;
            }
        }

        // grid

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoko[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokoSolver(int sudoko[][], int row, int col) {

        // basecase
        if (row == 9) {
            return true;
        }

        // recursion
        int newRow = row, newCol = col + 1;
        if (col + 1 == 9) {
            newRow = row + 1;
            newCol = 0;
        }

        if (sudoko[row][col] != 0) {
            return sudokoSolver(sudoko, newRow, newCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafeSudoku(sudoko, row, col, digit)) {
                sudoko[row][col] = digit;
                if (sudokoSolver(sudoko, newRow, newCol)) {
                    return true;
                }
                sudoko[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafeMaze(int maze[][], int row, int col) {
        return (row >= 0 && row < maze.length && col >= 0 && col < maze.length && maze[row][col] == 1);
    }

    public static boolean ratMaze(int maze[][], int newMaze[][], int row, int col) {

        if (row == maze.length - 1 && col == maze.length - 1 && maze[row][col] == 1) {

            printBoard(newMaze);
            return true;
        }

        if (isSafeMaze(maze, row, col) == true) {
            if (newMaze[row][col] == 1)
                return false;
            newMaze[row][col] = 1;

            if (ratMaze(maze, newMaze, row + 1, col))
                return true;
            if (ratMaze(maze, newMaze, row, col + 1))
                return true;
            newMaze[row][col] = 0;
            return false;
        }
        return false;

    }

    static int dr[] = { -1, 1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };
    static char dir[] = { 'U', 'D', 'L', 'R' };

    public static void rec(int[][] maze, int row, int col, String path, int n) {
        // base case
        // out of boundary
        if (row < 0 || col < 0 || row >= n || col >= n) {

            return;
        }

        // check whether visited or blocked
        if (maze[row][col] == -1 || maze[row][col] == 1) {
            return;
        }

        // reached target
        if (row == n - 1 && col == n - 1) {
            System.out.println(path);
            return;
        }

        // visited
        maze[row][col] = -1;

        for (int idx = 0; idx < 4; idx++) {
            int nr = row + dr[idx];
            int nc = col + dc[idx];
            rec(maze, nr, nc, path + dir[idx], n);
        }

        // make unvisited
        maze[row][col] = 0;

    }

    public static void main(String args[]) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        // String str = "abc";
        // findSubsets(str, "", 0);
        // findSubsetStringBuilder(str, new StringBuilder(), 0);

        // String str = "abc";
        // findPermutation(str, "");

        // int n = 5;
        // char board[][] = new char[n][n];

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // board[i][j] = '.';

        // }

        // }

        // nQueens(board, 0);
        // System.out.println("total number of counts:" + count);

        // nKnights(board, 0);

        // int n = 4, m = 4;
        // System.out.println("total grid ways = " + gridWays(0, 0, n, m));

        // int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
        // { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
        // { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
        // { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
        // { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
        // { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
        // { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
        // { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
        // { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

        // if (sudokoSolver(sudoku, 0, 0)) {
        // printBoard(sudoku);

        // } else {
        // System.out.println("Solution Does not exist ");
        // }

        // int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1
        // } };

        // int newMaze[][] = new int[maze.length][maze.length];
        // for (int i = 0; i < maze.length; i++) {
        // for (int j = 0; j < maze.length; j++) {
        // newMaze[i][j] = 0;
        // }
        // }
        // if (ratMaze(maze, newMaze, 0, 0)) {
        // System.out.println("solution exist");
        // } else {
        // System.out.println("Solution does not exist");
        // }

        int maze[][] = { { 0, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 1, 0, 0 } };

        rec(maze, 0, 0, "", maze.length);
    }
}
