import java.util.Arrays;
import java.util.Collections;

public class BasicSorting {

    public static void printArray(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            int swap = 0;
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }

            }
            if (swap == 0) {
                return;
            }
        }
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;

        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // finding the correct pos to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = curr;
        }

    }

    public static void main(String[] args) {
        // int arr[] = { 5, 4, 1, 3, 2 };
        Integer arr[] = { 5, 4, 1, 3, 2 };
        // int arr[] = { 1, 2, 3, 4, 5 };
        printArray(arr);
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // Arrays.sort(arr);
        // Arrays.sort(arr, 0, 3);
        Arrays.sort(arr, Collections.reverseOrder());
        printArray(arr);
    }

}
