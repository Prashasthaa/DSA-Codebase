public class DividenConquer {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {

        // base Case
        if (si >= ei) {
            return;
        }

        int partIndex = parition(arr, si, ei);
        quickSort(arr, si, partIndex - 1);
        quickSort(arr, partIndex + 1, ei);

    }

    public static int parition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static int search(int arr[], int tar, int si, int ei) {

        // base Case
        if (si > ei) {
            return -1;
        }

        int mid = (ei + (ei - si)) / 2;

        if (arr[mid] == tar) {
            return mid;
        }

        // Case-1=> mid on L1
        if (arr[si] <= arr[mid]) {

            // case-a
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            }
            // case-b
            else {
                return search(arr, tar, mid + 1, ei);
            }
        }
        // case-2=> mid on L2
        else {
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                return search(arr, tar, si, mid - 1);
            }
        }

    }

    public static int searchRotatedArray(int arr[], int tar, int si, int ei) {

        while (ei >= si) {
            int mid = (ei + (ei - si)) / 2;

            if (arr[mid] == tar) {
                return mid;
            }

            // Case-1=> mid on L1
            if (arr[si] <= arr[mid]) {

                // case-a
                if (arr[si] <= tar && tar <= arr[mid]) {
                    ei = mid - 1;
                }
                // case-b
                else {
                    si = mid + 1;
                }
            }
            // case-2=> mid on L2
            else {
                if (arr[mid] <= tar && tar <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 5, 6, 7, 8, 1, 2, 3, 4 };
        // printArr(arr);
        // // mergeSort(arr, 0, arr.length - 1);
        // // quickSort(arr, 0, arr.length - 1);
        // printArr(arr);

        int target = 5;
        System.out.println(search(arr, target, 0, arr.length - 1));

        System.out.println(searchRotatedArray(arr, target, 0, arr.length - 1));
    }
}
