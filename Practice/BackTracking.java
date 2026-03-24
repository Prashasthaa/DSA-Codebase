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

    public static void main(String args[]) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        // String str = "abc";
        // findSubsets(str, "", 0);
        // findSubsetStringBuilder(str, new StringBuilder(), 0);

        // String str = "abc";
        // findPermutation(str, "");

        int n = 5;
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';

            }

        }

        nQueens(board, 0);
        System.out.println("total number of counts:" + count);

        // nKnights(board, 0);
    }
}
