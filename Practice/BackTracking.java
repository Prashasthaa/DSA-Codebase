public class BackTracking {

    public static void changeArr(int arr[], int i, int val) {
        // base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findSubsets(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");

            } else {
                System.out.println(ans);

            }
            return;
        }

        // recursion
        // Yes choice
        findSubsets(str, ans + str.charAt(i), i + 1);

        // No Choice
        findSubsets(str, ans, i + 1);

    }

    public static void findSubsetStringBuilder(String str, StringBuilder ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");

            } else {
                System.out.println(ans);

            }
            return;
        }

        // recursion
        // Yes choice
        ans.append(str.charAt(i));
        findSubsetStringBuilder(str, ans, i + 1);

        // No Choice
        ans.deleteCharAt(ans.length() - 1);
        findSubsetStringBuilder(str, ans, i + 1);

    }

    public static void findPermutation(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;

        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutation(newStr, ans + curr);

        }
    }

    public static void main(String args[]) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        // String str = "abc";
        // findSubsets(str, "", 0);
        // findSubsetStringBuilder(str, new StringBuilder(), 0);

        String str = "abc";
        findPermutation(str, "");

    }
}
