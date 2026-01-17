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

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = 3, m = 3;

        Scanner sc = new Scanner(System.in);

        // input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();

            }
        }

        // output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        search(matrix, 9);
    }

}
