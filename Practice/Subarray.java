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

    // bruteForce Apporach Max Subarray Sum
    // Time complexity=O(n^3)
    public static void MaxSubarrayBrute(int num[]) {
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

    // Prefix Sum => Maximum Subarray Sum
    // Time complexity=O(n^2)
    public static void MaxSubarrayPrefix(int num[]) {
        int curSum = 0;
        int MaxSum = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];

        prefix[0] = num[0];
        // calculalte prefix array
        for (int i = 1; i < prefix.length; i++) {

            prefix[i] = prefix[i - 1] + num[i];
        }

        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                curSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                if (curSum > MaxSum) {
                    MaxSum = curSum;
                }
            }

        }
        System.out.println("Maximum Subarray Sum = " + MaxSum);
    }

    public static void main(String args[]) {
        int numbers[] = { 2, 4, 6, 8, 10 };

        // printSubarrays(numbers);

        // MaxSubarrayBrute(numbers);

        MaxSubarrayPrefix(numbers);
    }
}