package classRoom;

import java.util.Scanner;

public class Matrices {

    public static void search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("found key at cell ( " + i + " , " + j + " )");
                    return;

                }
            }
        }
        System.out.println("found key is not found");

    }

    // // Spiral Matrix

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startCol <= endCol && startRow <= endRow) {

            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " , ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " , ");

            }

            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " , ");

            }

            // left

            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " , ");

            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }

    // Diagonal Sum

    public static void diagonalSum(int matrix[][]) {
        int sum = 0;

        // brute force approach

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // if (i == j) {
        // sum += matrix[i][j];
        // } else if (i + j == matrix.length - 1) {
        // sum += matrix[i][j];
        // }
        // }
        // }
        for (int i = 0; i < matrix.length; i++) {
            // primary diagonal
            sum += matrix[i][i];

            // secondary diagonal
            if (i != matrix.length - 1 - i)
                sum += matrix[i][matrix.length - 1 - i];

        }

        System.out.println("Diagonal sum =" + sum);
    }

    // Search in sorted matrix
    // time compelxity=(n+m)
    public static void searchInSortedMatrix(int matrix[][], int key) {
        int col = matrix.length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length) {
            if (key == matrix[row][col]) {
                System.out.println("found key at ( " + row + " , " + col + " ) ");
                return;
            } else if (key > matrix[row][col]) {
                row++;
            } else if (key < matrix[row][col]) {
                col--;
            }
        }
        System.out.println("Key is not found");
    }

    // practice

    public static void count(int matrix[][], int num) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (num == matrix[i][j]) {
                    count += 1;
                }
            }
        }
        System.out.println("Count = " + count);
    }

    public static void sumOfRow(int matrix[][], int row) {
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[row][i];
        }
        System.out.println("sum of the row is " + sum);
    }

    public static void transpose(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int matrix1[][] = new int[3][3];
        int n = 3, m = 3;

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the matrix elements");

        // input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = sc.nextInt();

            }
        }

        // output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        transpose(matrix1);
        search(matrix1, 9);

        int matrix2[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        printSpiral(matrix2);

        diagonalSum(matrix2);

        int matrix3[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        int key = 33;
        searchInSortedMatrix(matrix3, key);

        int matrix5[][] = { { 4, 7, 9 }, { 8, 8, 7 } };
        int num = 7;
        count(matrix5, num);

        int[][] matrix6 = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        int row = 1;
        sumOfRow(matrix6, row);
    }

}
