// Check whether a number is greater than twice the other number

import java.util.ArrayList;

public class ReversePairs {

    // Merging
    static void merge(int arr[], int low, int mid, int high) {
        int left = low, right = mid + 1;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) arrayList.add(arr[left++]);
            else arrayList.add(arr[right++]);
        }

        while(left <= mid) arrayList.add(arr[left++]);
        while(right <= high) arrayList.add(arr[right++]);
        for(int i = low; i <= high; i ++) {
            arr[i] = arrayList.get(i - low);
        }
    }

    // Dividing
    static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if(low == high) return count;
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        count += countNumberOfPairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return count;
    }


    // Brute force (TC -> n2, SC -> 1)
    static void countPairs(int arr[]) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > 2 * arr[j]) count++;
            }   
        }

        System.out.println("The pairs are: " + count);
    }

    // To count the number of possible pairs
    static int countNumberOfPairs (int arr[], int low, int mid, int high) {

        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;

    }

    // Optimal Approach
    static void OptCountPairs(int arr[]) {
        int pairs = mergeSort(arr, 0, arr.length - 1);
        System.out.println("The pairs are: " + pairs);
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,3,1};
        // countPairs(arr);
        OptCountPairs(arr);        
    }
}
