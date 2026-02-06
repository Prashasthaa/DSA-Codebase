public class Recursion {
    public static void printDecreasingNum(int n) {
        System.out.println(n + " ");
        if (n == 1) {
            return;
        }
        printDecreasingNum(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        printDecreasingNum(n);
    }

}
