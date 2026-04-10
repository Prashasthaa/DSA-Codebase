import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayLists {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static boolean isMonotonic(ArrayList<Integer> nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                isDecreasing = false;
            }
            if (nums.get(i) < nums.get(i - 1)) {
                isIncreasing = false;
            }
        }
        return isDecreasing || isIncreasing;
    }

    public static ArrayList<Integer> lonely(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {

            int prev = nums.get(i) - 1;
            int post = nums.get(i) + 1;

            if (!(nums.contains(prev) || nums.contains(post))) {
                System.out.println("ddf");
                result.add(nums.get(i));
            }
        }

        return result;
    }

    public static void main(String args[]) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // Time required to add is O(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(1, 8);

        System.out.println(list);

        // get operation :O(1);
        int element = list.get(3);
        System.out.println(element);

        // Remove an element :O(n);
        list.remove(2);
        System.out.println(list);

        // set :O(n);
        list.set(3, 6);
        System.out.println(list);

        // contains element:O(n);
        System.out.println(list.contains(2));
        System.out.println(list.contains(5));

        // size of arrayList
        System.out.println(list.size());

        // print arraylist
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // print reverse of arrayList
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

        // find maximum in an arrayList
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            // if (list.get(i) > max) {
            // max = list.get(i);
            // }

            max = Math.max(max, list.get(i));
        }
        System.out.println("Maximum value=" + max);

        // swaping 2 numbers
        System.out.println("before swap list= " + list);
        int idx1 = 1, idx2 = 3;
        swap(list, idx1, idx2);
        System.out.println("after swap list= " + list);

        // sorting in asscending order
        Collections.sort(list);
        System.out.println("Sorted arraylist in asscending order" + list);

        // sorting in descending order
        Collections.sort(list, Collections.reverseOrder());
        // Collections.reverseOrder() is a comparator

        System.out.println("Sorted arraylist in descending order" + list);

        // Multidimensional arrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);

        mainList.add(arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(4);
        arr2.add(6);
        arr2.add(8);
        mainList.add(arr2);

        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(3);
        arr3.add(6);
        arr3.add(9);
        arr3.add(12);
        mainList.add(arr3);

        System.out.println(mainList);

        // iterating the multi dememsional arrayList

        for (int i = 0; i < mainList.size(); i++) {
            // System.out.print("{");
            // for (int j = 0; j < mainList.get(i).size(); j++) {
            // System.out.print(mainList.get(i).get(j) + " ");
            // }
            // System.out.print("} ");

            ArrayList<Integer> currList = mainList.get(i);
            System.out.print("{ ");
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.print("} ");
        }

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        System.out.println(isMonotonic(nums));

        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(10);
        nums1.add(6);
        nums1.add(5);
        nums1.add(8);
        // System.out.println(nums1);
        System.out.println(lonely(nums1));
    }
}
