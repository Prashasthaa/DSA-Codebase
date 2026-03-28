package NeetCode;

import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenNums = new HashSet<>();

        for (int num : nums) {
            if (seenNums.contains(num)) {
                return true;
            }
            seenNums.add(num);
        }
        return false;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 6, 4 };
        System.out.println(containsDuplicate(nums));
    }
}