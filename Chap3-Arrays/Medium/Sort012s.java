public class Sort012s {

    // Brute force (TC -> nlogn, SC -> 1 or n)
    static void sortArray(int arr[]) {
        // Quick sort or Merge Sort
    }

    // Better (TC -> 2N, SC -> 1)
    static void BetSortArray(int arr[]) {
        int zCount = 0, oCount = 0;
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) zCount++;
            else if(arr[i] == 1) oCount++;
        }

        // 0, 1 -> 0
        for(int j = 0; j < zCount; j++) {
            arr[j] = 0;
        }

        // 2 -> 3 => 2, 3, 4
        for(int j = zCount; j < oCount + zCount; j++) {
            arr[j] = 1;
        }

        for(int j = oCount + zCount; j < n; j++) {
            arr[j] = 2;
        }

        for(int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
    }


    // Optimal Approach (Dutch National flag algorithm.) (TC -> n, SC -> 1)
    // Intuition:

    // This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:
    // arr[0….low-1] contains 0. [Extreme left part]
    // arr[low….mid-1] contains 1.
    // arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
    // The middle part i.e. arr[mid….high] is the unsorted segment.

    static void OptiSortArray(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if(arr[mid] == 0) {
                // Swap with the low;
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++; mid++;
            }
            else if(arr[mid] == 1) {
                mid++;
            }
            else {
                // Swap with the high;
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

        for(int n: arr) {
            System.out.print(n + " ");
        }

    }
    public static void main(String[] args) {
        int arr[] = {0, 2, 1, 2, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 0, 0, 0, 0, 1};
        BetSortArray(arr);
    }
}
