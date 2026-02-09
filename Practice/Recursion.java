public class Recursion {
    public static void printDecreasingNum(int n) {
        System.out.println(n + " ");
        if (n == 1) {
            return;
        }
        printDecreasingNum(n - 1);
    }

    // print increasing num
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

    // calculate sum of n numbers
    public static int sum(int n) {
        if (n == 1) {
            return n;
        }
        return n + sum(n - 1);
    }

    // calculate nth fibonacci number
    public static int fibonacciNum(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciNum(n - 1) + fibonacciNum(n - 2);

    }

    // Check if a given array is sorted or not
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] <= arr[i + 1]) {
            return isSorted(arr, i + 1);
        }
        return false;
    }

    // first occurence of an element in an array
    public static int firstOccurence(int arr[], int i, int key) {

        if (arr[i] == key) {
            return i;
        }
        if (i == arr.length - 1) {
            return -1;
        }
        return firstOccurence(arr, i + 1, key);
    }

    //// last occurence of an element in an array
    public static int lastOccurence(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurence(arr, i + 1, key);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static int powerOfX(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * powerOfX(x, n - 1);
    }

    public static int optimizedPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPower(x, n / 2);

        int halfPowerSq = halfPower * halfPower;

        //////// if nis odd
        if (n % 2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String[] args) {
        int n = 5;
        // printDecreasingNum(n);
        // printIncreasingNum(n);
        // System.out.println(factorial(n));
        // System.out.println(sum(n));
        // System.out.println(fibonacciNum(2));

        // int num[] = { 1, 23, 34, 21, 353 };
        // int num1[] = { 1, 2, 3, 3, 4, 5 };
        // System.out.println(isSorted(num, 0));
        // System.out.println(isSorted(num1, 0));

        // System.out.println(firstOccurence(num1, 0, 30));
        // System.out.println(lastOccurence(num1, 0, 30));

        System.out.println(powerOfX(5, 1));
        System.out.println(optimizedPower(8, 2));
    }

}
