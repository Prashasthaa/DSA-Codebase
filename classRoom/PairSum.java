package classRoom;

import java.util.ArrayList;

public class PairSum {
    public static boolean pairSum(ArrayList<Integer> list, int target) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(i) + list.get(j)) == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // two pointerf
    public static boolean pairSum2(ArrayList<Integer> list, int target) {

        int lp = 0;
        int rp = list.size() - 1;

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSumII(ArrayList<Integer> list, int target) {

        int bp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        int rp = bp;
        int lp = bp + 1;

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) > target) {
                rp = (list.size() + rp - 1) % list.size();
            } else {
                lp = (lp + 1) % list.size();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;

        System.out.println(pairSum(list, target));
        System.out.println(pairSum2(list, target));

        ArrayList<Integer> list2 = new ArrayList<>();

        list2.add(11);
        list2.add(15);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(10);

        int target2 = 16;
        pairSumII(list2, target2);
    }
}
