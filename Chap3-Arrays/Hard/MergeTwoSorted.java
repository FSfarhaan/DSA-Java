// Without using extra spaces

import java.util.Arrays;

public class MergeTwoSorted {

    // Brute (With Extra Space) (TC -> 2(n + m), SC -> n + m);
    static void mergeArrays(int arr1[], int arr2[]) {
        int n = arr1.length, m = arr2.length;
        int arr3[] = new int[n + m];

        int left = 0, right = 0;
        int index = 0;

        while(left < n && right < m) {
            if(arr1[left] <= arr2[right]) {
                arr3[index++] = arr1[left++];
            } else {
                arr3[index++] = arr2[right++];
            }
        }

        // Remaining from arr1
        while (left < n) {
            arr3[index++] = arr1[left++];
        }

        // Remaining from arr2
        while (right < m) {
            arr3[index++] = arr2[right++];
        }

        // Arr3 now contains all the elements;

        for(int i = 0; i < n + m; i++) {
            if(i < n) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - n] = arr3[i];
            }
        }

        for(int j = 0; j < n; j++) {
            System.out.print(arr1[j] + " ");
        }
        System.out.println();
        for(int j = 0; j < m; j++) {
            System.out.print(arr2[j] + " ");
        }

    }
    
    // Optimal Approach 1 (TC -> mlogm + nlogn + min(m, n), SC -> 1);
    static void OptMerge(int arr1[], int arr2[]) {
        int n = arr1.length, m = arr2.length;
        int left = n - 1, right = 0;

        while(left > 0 && right < m) {
            if(arr1[left] >= arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp; 
                left--; right++;
            } else break;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int j = 0; j < n; j++) {
            System.out.print(arr1[j] + " ");
        }
        System.out.println();
        for(int j = 0; j < m; j++) {
            System.out.print(arr2[j] + " ");
        }
        
    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    // Optimal Approach 2 (TC -> (m+n)log2(n + m), SC -> 1);
    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }

        for(long num: arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(long num: arr2) {
            System.out.print(num+ " ");
        }
    }

    public static void main(String[] args) {
        long arr1[] = { 1, 4, 8, 10 };
        long arr2[] = { 2, 3, 9 };

        // mergeArrays(arr1, arr2);
        // OptMerge(arr1, arr2);
        merge(arr1, arr2, 4, 3);
    }
}
