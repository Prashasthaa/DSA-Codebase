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

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial((n - 1));
    }

    public static int sum(int n) {
        if (n == 1) {
            return n;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        // printDecreasingNum(n);
        // printIncreasingNum(n);
        System.out.println(factorial(n));
        System.out.println(sum(n));

    }

}
