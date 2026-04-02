package NeetCode;

public class twoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0;
        int rp = numbers.length - 1;
        while (lp != rp) {
            if (numbers[lp] + numbers[rp] == target) {
                break;
            } else if (numbers[lp] + numbers[rp] < target) {
                lp++;
            } else {
                rp--;
            }

        }
        int[] res = { lp + 1, rp + 1 };
        return res;
    }
}
