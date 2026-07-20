import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public static int findLongestChain(int[][] pairs) { // O(nlogn)

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int lastEnd = pairs[0][1];
        int length = 1;

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {
                length = length + 1;
                lastEnd = pairs[i][1];
            }
        }
        return length;

    }

    public static void coinChange(Integer[] coins, int amount) {
        Arrays.sort(coins, Comparator.reverseOrder());
        int count = 0;
        for (int i = 0; i < coins.length && amount != 0; i++) {
            // if (coins[i] <= amount) {
            while (coins[i] <= amount) {
                count = count + 1;
                amount = amount - coins[i];
                // }
            }
        }
        System.out.println(count);
    }

    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = 1;
            deadline = d;
            profit = p;
        }

    }

    public static void main(String[] args) {
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };

        // activitySelection(start, end);

        // int val[] = { 60, 100, 120 };
        // int wieght[] = { 10, 20, 30 };
        // int W = 50;
        // fractionalKnapsack(val, wieght, W);

        // // minumum sum absolute difference
        // int A[] = { 1, 2, 3 };
        // int B[] = { 2, 1, 4 };
        // minumumSumAbsoluteDifference(A, B);

        // // 646. Maximum Length of Pair Chain
        // int[][] pairs = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
        // System.out.println(findLongestChain(pairs));

        // // Minimum number of Coins
        // Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000, 2000 };
        // int amount = 591;
        // coinChange(coins, amount);

        // // Maximum Profit in Job Scheduling
        // int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        // ArrayList<Job> jobs = new ArrayList<>();

        // for (int i = 0; i < jobsInfo.length; i++) {
        // jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        // }

        // Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);//
        // descending order

        // ArrayList<Integer> seq = new ArrayList<>();
        // int time = 0;
        // for (int i = 0; i < jobs.size(); i++) {
        // Job curr = jobs.get(i);
        // if (curr.deadline > time) {
        // seq.add(curr.id);
        // time++;
        // }
        // }

        // // print seq
        // System.out.println(" max jobs = " + seq.size());
        // for (int i = 0; i < seq.size(); i++) {
        // System.out.println(seq.get(i) + " ");
        // }
        // System.out.println();

        // Chocolate problem
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }

        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }
        System.out.println("minimum cost of cut: " + cost);
    }
}
