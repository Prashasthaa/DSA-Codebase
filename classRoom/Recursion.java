
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

    public static int tilingProblem(int n) {// 2 X n {floor size}
        // base case
        if (n == 1 || n == 0) {
            return 1;
        }

        // kaam
        // vertical choice
        int fnm1 = tilingProblem(n - 1);

        // horizontal choice
        int fnm2 = tilingProblem(n - 2);

        int toWays = fnm1 + fnm2;
        return toWays;

        // single line code
        // return tilingProblem(n-1)+tilingProblem(n-2);
    }

    // Remove duplicates in a string
    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base Case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // work
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicate(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, newStr.append(currChar), map);
        }

    }

    public static int friendPairing(int n) {
        // base case
        if (n == 1 || n == 2) {
            return n;
        }

        // single
        int fnm1 = friendPairing(n - 1);

        // pair
        int fnm2 = friendPairing(n - 2);
        int pairways = (n - 1) * fnm2;

        // total ways
        int totalways = fnm1 + pairways;

        return totalways;

        // single line
        // return friendPairing(n - 1) + (n - 1) * friendPairing(n - 2);
    }

    public static void printBinaryString(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        printBinaryString(n - 1, 0, str + "0");

        if (lastPlace == 0) {
            printBinaryString(n - 1, 1, str + "1");
        }
    }

    public static void allOccurrence(int nums[], int key, int i) {
        if (nums.length == i) {
            return;
        }
        if (nums[i] == key) {
            System.out.print(i + " ");
        }
        allOccurrence(nums, key, i + 1);

    }

    public static void convertToString(int n) {
        if (n == 0) {
            return;
        }
        int digit = n % 10;
        convertToString(n / 10);
        printDigit(digit);

    }

    public static void printDigit(int n) {
        if (n == 0) {
            System.out.print("zero ");
        } else if (n == 1) {
            System.out.print("one ");

        } else if (n == 2) {
            System.out.print("two ");
        } else if (n == 3) {
            System.out.print("three ");

        } else if (n == 4) {
            System.out.print("four ");
        } else if (n == 5) {
            System.out.print("five ");

        } else if (n == 6) {
            System.out.print("six ");

        } else if (n == 7) {
            System.out.print("seven ");

        } else if (n == 8) {
            System.out.print("eight ");
        } else if (n == 9) {
            System.out.print("nine ");
        }
    }

    public static int lengthOfString(String str) {
        if (str == "") {
            return 0;
        }
        return 1 + lengthOfString(str.substring(1));
    }

    public static void main(String[] args) {
        // int n = 5;
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

        // System.out.println(powerOfX(5, 1));
        // System.out.println(optimizedPower(8, 2));

        // System.out.println(tilingProblem(4));

        // String str = "prashastha";
        // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendPairing(5));

        // printBinaryString(3, 0, "");

        // int nums[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        // allOccurrence(nums, 2, 0);

        // convertToString(4567);

        // System.out.println(lengthOfString("null"));
        // System.out.println(lengthOfString("0"));
    }

}
