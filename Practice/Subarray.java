import java.util.*;

public class Subarray {
    public static void printSubarrays(int num[]) {
        int ts = 0;
        for (int i = 0; i < num.length; i++) {

            int start = i;
            for (int j = i; j < num.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " ");
                    sum += num[k];
                }
                ts++;
                System.out.print(" Sum = " + sum);
                System.out.println();
            }

        }
        System.out.println("Total Subarray = " + ts);
    }

    // bruteForce Apporach
    public static void MaxSubarray(int num[]) {
        int curSum = 0;
        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                curSum = 0;
                for (int k = i; k <= j; k++) {
                    curSum += num[k];
                    if (curSum > MAX) {
                        MAX = curSum;
                    }
                }

            }

        }
        System.out.println("Maximum Subarray Sum = " + MAX);
    }

    public static void main(String args[]) {
        int numbers[] = { 2, 4, 6, 8, 10 };

        printSubarrays(numbers);

        MaxSubarray(numbers);
    }
}