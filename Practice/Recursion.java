public class Recursion {
    public static void printDecreasingNum(int n) {
        System.out.println(n + " ");
        if (n == 1) {
            return;
        }
        printDecreasingNum(n - 1);
    }

    public static void printIncreasingNum(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        printIncreasingNum(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 10;
        // printDecreasingNum(n);
        printIncreasingNum(n);

    }

}
