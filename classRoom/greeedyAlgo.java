import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class greeedyAlgo {

    public static void activitySelection(int[] start, int[] end) {
        // sorting
        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("max activities=" + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("A" + ans.get(i));
        }
    }

    public static void fractionalKnapsack(int[] val, int[] wieght, int capcity) {
        double ratio[][] = new double[val.length][2];
        // 0th col=>idx; 1st col=> ratio;

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) wieght[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int value = 0;
        int W = capcity;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (W >= wieght[idx]) {
                value += val[idx];
                W = W - wieght[idx];
            } else {
                // fractional item
                value += ratio[i][1] * W;
                W = 0;
                break;
            }
        }
        System.out.println(value);
    }

    public static void minumumSumAbsoluteDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            int diff = Math.abs(A[i] - B[i]);
            minDiff += diff;
        }
        System.out.println("minumum Sum Absolute Difference= " + minDiff);
    }

    public static void main(String[] args) {
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };

        // activitySelection(start, end);

        // int val[] = { 60, 100, 120 };
        // int wieght[] = { 10, 20, 30 };
        // int W = 50;
        // fractionalKnapsack(val, wieght, W);

        // minumum sum absolute difference
        int A[] = { 1, 2, 3 };
        int B[] = { 2, 1, 4 };
        minumumSumAbsoluteDifference(A, B);

    }
}
